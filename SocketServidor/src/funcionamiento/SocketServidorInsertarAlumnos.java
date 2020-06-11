package funcionamiento;

/**
 * Clase que inserta en la base de datos un nuevo alumno
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;

import conexion.ConexionPost;
import main.Main;

public class SocketServidorInsertarAlumnos extends Usuario implements Runnable {
	String proyecto, division, carrera, periodoCuatrimestre, cadena, id_asesorInd, id_asesorAca;
	String[] nombreAsesorInd;
	String[] nombreAsesorAca;
	ConexionPost conex;
	ResultSet asesorAca;
	ResultSet asesorInd;
	Socket cliente;
	ServerSocket server;
	String nombreCompletoAsesorAca;
	String nombreCompletoAsesorInd;
	List listaAsesorAca;
	List listaAsesorInd;
	ObjectOutputStream mensajeSalida;
	ObjectInputStream mensajeEntrada;
	Thread hilo;

	public SocketServidorInsertarAlumnos() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
			this.server = new ServerSocket(4999, 50);
			this.conex = ConexionPost.getInstance();
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorInsertarAlumnos IOException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorInsertarAlumnos ClassNotFound: " + e.getMessage());
		}
		while (true) {
			this.insertarAlumno();
		}
	}

	private void insertarAlumno() {
		try {
			this.cliente = this.server.accept();
			Main.vistaServer.setTextArea(
					"El cliente: " + cliente.getInetAddress().getHostName() + " esta registrando alumnos. \n");
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());
			super.setMatricula((String) this.mensajeEntrada.readObject());
			super.setNombre((String) this.mensajeEntrada.readObject());
			super.setAp_pat((String) this.mensajeEntrada.readObject());
			super.setAp_mat((String) this.mensajeEntrada.readObject());
			super.setPassword((String) this.mensajeEntrada.readObject());
			super.setTelefono((String) this.mensajeEntrada.readObject());
			super.setCorreo((String) this.mensajeEntrada.readObject());
			this.proyecto = (String) this.mensajeEntrada.readObject();
			this.division = (String) this.mensajeEntrada.readObject();
			this.carrera = (String) this.mensajeEntrada.readObject();
			this.periodoCuatrimestre = (String) this.mensajeEntrada.readObject();
			this.nombreAsesorAca = (String[]) this.mensajeEntrada.readObject();
			this.nombreAsesorInd = (String[]) this.mensajeEntrada.readObject();
			this.id_asesorAca = this.nombreAsesorAca[0];
			this.id_asesorInd = this.nombreAsesorInd[0];

			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			this.cadena = "insert into alumno values(" + super.getMatricula() + ", '" + super.getNombre() + "' , '"
					+ super.getAp_pat() + "' , '" + super.getAp_mat() + "' , " + " '" + super.getPassword() + "' , "
					+ super.getTelefono() + " , '" + super.getCorreo() + "' , '" + proyecto + "' , '" + division + "' ,"
					+ " '" + carrera + "' , '" + this.periodoCuatrimestre + "' , " + this.id_asesorInd + " , "
					+ this.id_asesorAca + " );";

			if (conex.ejecutar(this.cadena) == true) {
				this.mensajeSalida.writeObject("Entro");
				Main.vistaServer.setTextArea(
						"El cliente: " + this.cliente.getInetAddress().getHostName() + " Registró un Alumno. \n\n");
			} else {
				this.mensajeSalida.writeObject("Error");
			}
			this.cliente.close();
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorInsertarAlumnos IOException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorInsertarAlumnos ClassNotFound: " + e.getMessage());
		}
	}

}
