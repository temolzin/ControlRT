package funcionamiento;
/**
 * Clase que carga en los JComboBox de la vista RegistrarAlumno
 * los asesores registrados en la base de datos. 
 * @see SocketInsertarAlumnos
 * @author TemolzinItzae
 */
import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import vista.RegistrarAlumno;

public class SocketCargarAsesores {
	private ObjectInputStream mensajeEntrada;
	private List listaAsesorAca;
	private List listaAsesorInd;
	private Socket cliente;
	private Object objetoEntrada;
	SocketInsertarAlumnos insertarAlumno;
	public static RegistrarAlumno vistaAlumno;

	public SocketCargarAsesores() {
		SocketCargarAsesores.vistaAlumno = new RegistrarAlumno();
		SocketCargarAsesores.vistaAlumno.setVisible(true);
		insertarAlumno = new SocketInsertarAlumnos();
		try {
			this.cliente = new Socket("localhost", 5002);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.cargarAsesores();
	}

	/**
	 * Método para cargar a los Asesores Acádemicos en los jComboBox de
	 * RegistrarAlumno.
	 */
	@SuppressWarnings("unchecked")
	private void cargarAsesores() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());
			
			// Uso del patrón de diseño MARKER INTERFACE
			this.objetoEntrada = this.mensajeEntrada.readObject();
			if (this.objetoEntrada instanceof List) {
				this.listaAsesorAca = (List) this.objetoEntrada;
				
				for (int i = 0; i <= this.listaAsesorAca.getItemCount() - 1; i++) {
					SocketCargarAsesores.vistaAlumno.getComboAcademico().addItem(this.listaAsesorAca.getItem(i));
				}

				this.listaAsesorInd = (List) mensajeEntrada.readObject();
				for (int i = 0; i <= this.listaAsesorInd.getItemCount() - 1; i++) {
					SocketCargarAsesores.vistaAlumno.getComboIndustrial().addItem(this.listaAsesorInd.getItem(i));
				}
			this.cliente.close();	
			} else {
				System.err.println("El objeto no es de tipo List: " + objetoEntrada);
			}
		} catch (IOException e) {
			System.err.println("Error en SocketInsertarAlumno: " + e.getMessage());
		} catch (ClassNotFoundException e1) {
			System.err.println("Error en SocketInsertarAlumno: " + e1.getMessage());
		}
	}
}
