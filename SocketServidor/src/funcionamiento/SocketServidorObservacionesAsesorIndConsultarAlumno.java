package funcionamiento;
/**
 * Esta clase consulta los datos del alumno a la base de datos,
 * por medio de su matricula, para mandarselo a al cliente. 
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionPost;
import main.Main;

public class SocketServidorObservacionesAsesorIndConsultarAlumno implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	DataInputStream mensajeEntrada;
	DataOutputStream mensajeSalida;
	ConexionPost conex;
	ResultSet alumno;
	String cadena, matricula, nombreAlumno, ap_patAlumno, ap_matAlumno, noSemana, observacion;
	Thread hilo;

	public SocketServidorObservacionesAsesorIndConsultarAlumno() {
		try {
			this.servidor = new ServerSocket(5017, 50);
			this.conex = ConexionPost.getInstance();
		} catch (IOException | ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorObservacionesIndustrial: " + e.getMessage() + "\n");
		}
		this.cliente = null;
		this.mensajeEntrada = null;
		this.mensajeSalida = null;
		this.alumno = null;
		this.cadena = null;
		this.matricula = null;
		this.ap_matAlumno = null;
		this.ap_patAlumno = null;
		this.nombreAlumno = null;
		this.noSemana = null;
		this.observacion = null;
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.cliente = this.servidor.accept();
				this.consultarAlumno();
			} catch (IOException e) {
				Main.vistaServer
				.setTextArea("Error en SocketServidorObservacionesIndustrial metodo RUN: " + e.getMessage() + "\n");
			}
		}
	}

	private void consultarAlumno() {
		try {
			this.mensajeEntrada = new DataInputStream(this.cliente.getInputStream());
			this.matricula = this.mensajeEntrada.readUTF();

			this.cadena = "select * from alumno where matricula = " + this.matricula + " and id_asesorInd = " + Login.getMatricula();
			this.alumno = this.conex.consultar(this.cadena);
			this.mensajeSalida = new DataOutputStream(this.cliente.getOutputStream());
			if (this.alumno.next()) {
				this.nombreAlumno = this.alumno.getString("nombre");
				this.ap_patAlumno = this.alumno.getString("ap_pat");
				this.ap_matAlumno = this.alumno.getString("ap_mat");
				this.mensajeSalida.writeUTF("Entro");
				this.mensajeSalida.writeUTF(this.nombreAlumno);
				this.mensajeSalida.writeUTF(this.ap_patAlumno);
				this.mensajeSalida.writeUTF(this.ap_matAlumno);
			} else {
				this.mensajeSalida.writeUTF("Nada");
			}
		} catch (IOException | SQLException e) {
			Main.vistaServer
					.setTextArea("Error en SocketServidorObservacionesIndustrial metodo consultarAlumno: " + e.getMessage() + "\n");
		}
	}
}
