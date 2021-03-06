package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SocketInsertarEvaluacionIndustrial {
	private Socket cliente;
	private String matricula, parcial, ser, saber, hacer;
	private DataInputStream mensajeEntrada;
	private DataOutputStream mensajeSalida;
	
	public SocketInsertarEvaluacionIndustrial() {
		this.cliente = null;
		this.matricula = null;
		this.parcial = null;
		this.ser = null;
		this.saber = null;
		this.hacer = null;
		this.mensajeEntrada = null;
		this.mensajeSalida = null;
		
		this.insertarEvaluacion();
	}
	
	private void insertarEvaluacion() {
		SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.btnAgregarCalif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.validarEvaluacion() == true) {
					try {
						cliente = new Socket("localhost", 5018);
						mensajeSalida = new DataOutputStream(cliente.getOutputStream());
						matricula = SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getLblMatricula().getText();
						parcial = (String) SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getComboParciales().getSelectedItem();
						ser = (String) SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getComboSer().getSelectedItem();
						saber = (String) SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getComboSaber().getSelectedItem();
						hacer = (String) SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.getComboHacer().getSelectedItem();
						
						mensajeSalida.writeUTF(matricula);
						mensajeSalida.writeUTF(parcial);
						mensajeSalida.writeUTF(ser);
						mensajeSalida.writeUTF(saber);
						mensajeSalida.writeUTF(hacer);
						
						mensajeEntrada = new DataInputStream(cliente.getInputStream());
						if(mensajeEntrada.readUTF().equals("Entro")) {
							JOptionPane.showMessageDialog(null,
									"La evaluación se ha guardado correctamente.",
									"Datos Insertados Correctamente", JOptionPane.INFORMATION_MESSAGE,
									new ImageIcon("src/imagenes/Correcto.png"));
							SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.limpiarCajas();
						} else {
							JOptionPane.showMessageDialog(null,"Error al registrar esta evaluación, este parcial: " + parcial + " ya ha sido evaluado.","Error", JOptionPane.ERROR_MESSAGE);
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
