package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SocketInsertarObservacionIndustrial {
	private Socket cliente;
	private String matricula, observacion, noSemana;
	private DataInputStream mensajeEntrada;
	private DataOutputStream mensajeSalida;
	
	public SocketInsertarObservacionIndustrial() {
		this.cliente = null;
		this.matricula = null;
		this.observacion = null;
		this.noSemana = null;
		this.mensajeEntrada = null;
		this.mensajeSalida = null;
		
		this.insertarObervaciones();
	}
	
	private void insertarObervaciones() {
		SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.btnAgregarObservacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.validarObservaciones() == true) {
					try {
						cliente = new Socket("localhost", 5019);
						mensajeSalida = new DataOutputStream(cliente.getOutputStream());
						matricula = SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getLblMatricula().getText();
						noSemana = (String) SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getComboNumeroSemana().getSelectedItem();
						observacion = SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getTextAreaObservacionAcademico().getText();
						
						mensajeSalida.writeUTF(matricula);
						mensajeSalida.writeUTF(noSemana);
						mensajeSalida.writeUTF(observacion);
						
						mensajeEntrada = new DataInputStream(cliente.getInputStream());
						if(mensajeEntrada.readUTF().equals("Entro")) {
							JOptionPane.showMessageDialog(null,
									"Las Observaciones han sido guardados satisfactoriamente",
									"Datos Insertados Correctamente", JOptionPane.INFORMATION_MESSAGE,
									new ImageIcon("src/imagenes/Correcto.png"));
							SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.limpiarCajas();
						} else {
							JOptionPane.showMessageDialog(null, "Error al insertar esta observación, esta semana: " 
									+ SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getComboNumeroSemana().getSelectedItem() 
									+ " ya ha sido registrada.", "Error",JOptionPane.ERROR_MESSAGE);
							SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.limpiarCajas();
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"Error, en consultar Alumno: " + e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	
}
