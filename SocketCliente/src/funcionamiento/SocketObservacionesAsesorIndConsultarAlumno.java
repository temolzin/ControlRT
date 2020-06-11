package funcionamiento;

/**
 * Esta clase envía la matricula al servidor, para consultar
 * los datos del alumno, y así mostrarlo en la vista: ObservacionesIndustrial.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import vista.ObservacionesIndustrial;

public class SocketObservacionesAsesorIndConsultarAlumno {
	public static ObservacionesIndustrial vistaObservacionesIndustrial;
	private Socket cliente;
	private DataInputStream mensajeEntrada;
	private DataOutputStream mensajeSalida;
	private String matricula, nombreAlumno, ap_pat, ap_mat;

	private SocketInsertarObservacionIndustrial insertarObservacion;
	private SocketInsertarEvaluacionIndustrial insertarEvaluacion;

	public SocketObservacionesAsesorIndConsultarAlumno() {
		SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial = new ObservacionesIndustrial();
		SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.setVisible(true);
		this.insertarObservacion = new SocketInsertarObservacionIndustrial();
		this.insertarEvaluacion = new SocketInsertarEvaluacionIndustrial();
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
	
	public static ObservacionesIndustrial getVistaObservacionesIndustrial() {
		return vistaObservacionesIndustrial;
	}

	public static void setVistaObservacionesIndustrial(ObservacionesIndustrial vistaObservacionesIndustrial) {
		SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial = vistaObservacionesIndustrial;
	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}

	public DataInputStream getMensajeEntrada() {
		return mensajeEntrada;
	}

	public void setMensajeEntrada(DataInputStream mensajeEntrada) {
		this.mensajeEntrada = mensajeEntrada;
	}

	public DataOutputStream getMensajeSalida() {
		return mensajeSalida;
	}

	public void setMensajeSalida(DataOutputStream mensajeSalida) {
		this.mensajeSalida = mensajeSalida;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getAp_pat() {
		return ap_pat;
	}

	public void setAp_pat(String ap_pat) {
		this.ap_pat = ap_pat;
	}

	public String getAp_mat() {
		return ap_mat;
	}

	public void setAp_mat(String ap_mat) {
		this.ap_mat = ap_mat;
	}

	public SocketInsertarObservacionIndustrial getInsertarObservacion() {
		return insertarObservacion;
	}

	public void setInsertarObservacion(SocketInsertarObservacionIndustrial insertarObservacion) {
		this.insertarObservacion = insertarObservacion;
	}

	public SocketInsertarEvaluacionIndustrial getInsertarEvaluacion() {
		return insertarEvaluacion;
	}

	public void setInsertarEvaluacion(SocketInsertarEvaluacionIndustrial insertarEvaluacion) {
		this.insertarEvaluacion = insertarEvaluacion;
	}

	private void consultarAlumno() {
		SocketObservacionesAsesorIndConsultarAlumno.vistaObservacionesIndustrial.btnBuscarAlumno
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							cliente = new Socket("localhost", 5017);
							mensajeSalida = new DataOutputStream(cliente.getOutputStream());
							mensajeEntrada = new DataInputStream(cliente.getInputStream());

							vistaObservacionesIndustrial.getLblMatricula()
									.setText(vistaObservacionesIndustrial.getTextBuscarAlumno().getText());
							matricula = vistaObservacionesIndustrial.getLblMatricula().getText();
							if (matricula.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Debes ingresar la matricula del alumno", "ERROR",
										JOptionPane.ERROR_MESSAGE);
								vistaObservacionesIndustrial.getTextBuscarAlumno().requestFocus();
							} else {
								mensajeSalida.writeUTF(matricula);

								if (mensajeEntrada.readUTF().equals("Entro")) {
									nombreAlumno = mensajeEntrada.readUTF();
									ap_pat = mensajeEntrada.readUTF();
									ap_mat = mensajeEntrada.readUTF();

									vistaObservacionesIndustrial.getTextNombreAlumno().setText(nombreAlumno);
									vistaObservacionesIndustrial.getTextPaternoAlumno().setText(ap_pat);
									vistaObservacionesIndustrial.getTextMaternoAlumno().setText(ap_mat);
								} else {
									JOptionPane.showMessageDialog(null,
											"La matricula: " + matricula + " no existe revisa de nuevo.", "ERROR",
											JOptionPane.ERROR_MESSAGE);
									vistaObservacionesIndustrial.getTextNombreAlumno().setText("");
									vistaObservacionesIndustrial.getTextPaternoAlumno().setText("");
									vistaObservacionesIndustrial.getTextMaternoAlumno().setText("");
									vistaObservacionesIndustrial.getTextBuscarAlumno().setText("");
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
