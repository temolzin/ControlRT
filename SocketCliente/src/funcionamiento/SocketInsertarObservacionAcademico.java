package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SocketInsertarObservacionAcademico {
	private Socket cliente;
	private String matricula, observacion, noSemana;
	private DataInputStream mensajeEntrada;
	private DataOutputStream mensajeSalida;

	public SocketInsertarObservacionAcademico() {
		this.cliente = null;
		this.matricula = null;
		this.observacion = null;
		this.noSemana = null;
		this.mensajeEntrada = null;
		this.mensajeSalida = null;

		this.insertarObervaciones();
	}

	private void insertarObervaciones() {
		SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico.btnAgregarObservacion
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico
								.validarObservaciones() == true) {
							try {
								cliente = new Socket("localhost", 5015);
								mensajeSalida = new DataOutputStream(cliente.getOutputStream());
								matricula = SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico
										.getLblMatricula().getText();
								noSemana = (String) SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico
										.getComboNumeroSemana().getSelectedItem();
								observacion = SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico
										.getTextAreaObservacionAcademico().getText();

								mensajeSalida.writeUTF(matricula);
								mensajeSalida.writeUTF(noSemana);
								mensajeSalida.writeUTF(observacion);

								mensajeEntrada = new DataInputStream(cliente.getInputStream());
								if (mensajeEntrada.readUTF().equals("Entro")) {
									JOptionPane.showMessageDialog(null,
											"Las Observaciones han sido guardados satisfactoriamente",
											"Datos Insertados Correctamente", JOptionPane.INFORMATION_MESSAGE,
											new ImageIcon("src/imagenes/Correcto.png"));
									SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico
											.limpiarCajas();
								} else {
									JOptionPane.showMessageDialog(null, "Error al insertar esta observación, esta semana: " 
											+ SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico.getComboNumeroSemana().getSelectedItem() 
											+ " ya ha sido registrada.", "Error",JOptionPane.ERROR_MESSAGE);
									SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico.limpiarCajas();
								}
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(null, "Error, en consultar Alumno: " + e1.getMessage(),
										"ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				});
	}

}
