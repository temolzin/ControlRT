package funcionamiento;

/**
 * Esta clase envía la matricula al servidor, para consultar
 * los datos del alumno, y así mostrarlo en la vista: ObservacionesAsesorAca.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

import vista.ObservacionesAcademico;

public class SocketObservacionesAsesorAcaConsultarAlumno {
	public static ObservacionesAcademico vistaObservacionesAcademico;
	public Socket cliente;
	private DataInputStream mensajeEntrada;
	private DataOutputStream mensajeSalida;
	private String matricula, nombreAlumno, ap_pat, ap_mat;
	@SuppressWarnings("unused")
	private SocketInsertarObservacionAcademico insertarObservacion;
	@SuppressWarnings("unused")
	private SocketInsertarEvaluacionAcademico insertarEvaluacion;

	public SocketObservacionesAsesorAcaConsultarAlumno() {
		SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico = new ObservacionesAcademico();
		SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico.setVisible(true);
		this.insertarObservacion = new SocketInsertarObservacionAcademico();
		this.insertarEvaluacion = new SocketInsertarEvaluacionAcademico();
		this.cliente = null;
		this.mensajeEntrada = null;
		this.mensajeSalida = null;
		this.matricula = null;
		this.nombreAlumno = null;
		this.ap_pat = null;
		this.ap_mat = null;

		this.consultarAlumno();
		try {
			if (this.cliente != null) {
				this.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}

	private void consultarAlumno() {
		SocketObservacionesAsesorAcaConsultarAlumno.vistaObservacionesAcademico.btnBuscarAlumno
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							cliente = new Socket("localhost", 5014);
							mensajeSalida = new DataOutputStream(cliente.getOutputStream());
							mensajeEntrada = new DataInputStream(cliente.getInputStream());

							vistaObservacionesAcademico.getLblMatricula()
									.setText(vistaObservacionesAcademico.getTextBuscarAlumno().getText());
							matricula = vistaObservacionesAcademico.getLblMatricula().getText();
							if (matricula.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Debes ingresar la matricula del alumno", "ERROR",
										JOptionPane.ERROR_MESSAGE);
								vistaObservacionesAcademico.getTextBuscarAlumno().requestFocus();
							} else {
								mensajeSalida.writeUTF(matricula);

								if (mensajeEntrada.readUTF().equals("Entro")) {
									nombreAlumno = mensajeEntrada.readUTF();
									ap_pat = mensajeEntrada.readUTF();
									ap_mat = mensajeEntrada.readUTF();
									vistaObservacionesAcademico.getTextNombreAlumno().setText(nombreAlumno);
									vistaObservacionesAcademico.getTextPaternoAlumno().setText(ap_pat);
									vistaObservacionesAcademico.getTextMaternoAlumno().setText(ap_mat);
								} else {
									JOptionPane.showMessageDialog(null,
											"La matricula: " + matricula + " no existe revisa de nuevo.", "ERROR",
											JOptionPane.ERROR_MESSAGE);
									vistaObservacionesAcademico.getTextNombreAlumno().setText("");
									vistaObservacionesAcademico.getTextPaternoAlumno().setText("");
									vistaObservacionesAcademico.getTextMaternoAlumno().setText("");
									vistaObservacionesAcademico.getTextBuscarAlumno().setText("");
								}
							}
							cliente.close();
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "Error, en consultar Alumno: " + e.getMessage(),
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
	}
}
