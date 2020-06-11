package funcionamiento;
/**
 * Clase que manda datos al servidor para agregar un nuevo Alumno
 * a la base de datos.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SocketInsertarAlumnos {
	private String proyecto, matricula, nombreAlumno, ap_pat, ap_mat, password, division, telefono, carrera, periodoCuatrimestre,
	correo;
	private String[] nombreAsesorInd;
	private String[] nombreAsesorAca;
	private ObjectOutputStream mensajeSalida;
	private ObjectInputStream mensajeEntrada;
	private Socket cliente;

	public SocketInsertarAlumnos() {

		this.insertarAlumno();
	}
	
	/**
	 * Metodo que envia los datos al servidor por medio del puerto 4999
	 * para que inserte un nuevo Alumno
	 */
	private void insertarAlumno() {
		SocketCargarAsesores.vistaAlumno.btnRegistrarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (SocketCargarAsesores.vistaAlumno.validadRegistroAlumno() == true) {
					try {
						cliente = new Socket("localhost", 4999);
						matricula = SocketCargarAsesores.vistaAlumno.getTextMatriculaAlumno().getText();
						nombreAlumno = SocketCargarAsesores.vistaAlumno.getTextNombreAlumno().getText();
						ap_pat = SocketCargarAsesores.vistaAlumno.getTextPaternoAlumno().getText();
						ap_mat = SocketCargarAsesores.vistaAlumno.getTextMaternoAlumno().getText();
						password = SocketCargarAsesores.vistaAlumno.getPasswordAlumno().getText();
						telefono = SocketCargarAsesores.vistaAlumno.getTextTelefonoAlumno().getText();
						correo = SocketCargarAsesores.vistaAlumno.getTextCorreoAlumno().getText();
						proyecto = SocketCargarAsesores.vistaAlumno.getTextProyecto().getText();
						division = SocketCargarAsesores.vistaAlumno.getComboDivision().getSelectedItem().toString();
						carrera = SocketCargarAsesores.vistaAlumno.getComboCarrera().getSelectedItem().toString();
						periodoCuatrimestre = SocketCargarAsesores.vistaAlumno.getComboCuatrimestre().getSelectedItem().toString();
						nombreAsesorAca = SocketCargarAsesores.vistaAlumno.getComboAcademico().getSelectedItem().toString().split(" ");
						nombreAsesorInd = SocketCargarAsesores.vistaAlumno.getComboIndustrial().getSelectedItem().toString().split(" ");

						mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());
						mensajeSalida.writeObject(matricula);
						mensajeSalida.writeObject(nombreAlumno);
						mensajeSalida.writeObject(ap_pat);
						mensajeSalida.writeObject(ap_mat);
						mensajeSalida.writeObject(password);
						mensajeSalida.writeObject(telefono);
						mensajeSalida.writeObject(correo);
						mensajeSalida.writeObject(proyecto);
						mensajeSalida.writeObject(division);
						mensajeSalida.writeObject(carrera);
						mensajeSalida.writeObject(periodoCuatrimestre);
						mensajeSalida.writeObject(nombreAsesorAca);
						mensajeSalida.writeObject(nombreAsesorInd);

						mensajeEntrada = new ObjectInputStream(cliente.getInputStream());
						if (mensajeEntrada.readObject().equals("Entro")) {
							JOptionPane.showMessageDialog(null, "Registro exitoso", "Alerta",
									JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/Correcto.png"));
							SocketCargarAsesores.vistaAlumno.limpiarCajas();
						} else {
							JOptionPane.showMessageDialog(null, "Error, La matricula: " + matricula + " ya ha sido registrada anteriormente.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						cliente.close();
					} catch (IOException e1) {
						System.err.println("Error en el metodo InsertarAlumno: " + e1.getMessage());
					} catch (ClassNotFoundException e1) {
						System.err.println("Error en el metodo InsertarAlumno: " + e1.getMessage());
					}
				}
			}
		});

	}
}
