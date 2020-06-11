package funcionamiento;
/**
 * Clase que inserta en la base de datos las observaciones del Asesor Industrial.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;

import conexion.ConexionPost;
import main.Main;

public class SocketServidorInsertarObservacionesIndustrial implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	DataInputStream mensajeEntrada;
	DataOutputStream mensajeSalida;
	ConexionPost conex;
	ResultSet alumno;
	String cadena, matricula, noSemana, observacion;
	Thread hilo;

	public SocketServidorInsertarObservacionesIndustrial() {
		try {
			this.servidor = new ServerSocket(5019, 50);
			this.conex = ConexionPost.getInstance();
		} catch (IOException | ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorInsertarObservacionesIndustrial: " + e.getMessage() + "\n");
		}
		this.cliente = null;
		this.mensajeEntrada = null;
		this.mensajeSalida = null;
		this.alumno = null;
		this.cadena = null;
		this.matricula = null;
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
				this.mensajeEntrada = new DataInputStream(this.cliente.getInputStream());
				this.mensajeSalida = new DataOutputStream(this.cliente.getOutputStream());
			} catch (IOException e) {
				Main.vistaServer
				.setTextArea("Error en SocketServidorInsertarObservacionesIndustrial metodo RUN: " + e.getMessage() + "\n");
			}
			this.insertarObservacion();
		}
	}
	
	/**
	 * Metodo que inserta las observaciones del Asesor Industrial a la base de datos.
	 */
	private void insertarObservacion() {
		try {
			
			this.matricula = this.mensajeEntrada.readUTF();
			this.noSemana = this.mensajeEntrada.readUTF();
			this.observacion = this.mensajeEntrada.readUTF();
			
			this.cadena = "INSERT INTO observacionesind (matriculaalumno, id_asesorind, nosemana,observacionind) VALUES (" + this.matricula + ","
					+ Login.getMatricula() + "," +  this.noSemana + ", '" + this.observacion + "');";
			if(this.conex.ejecutar(this.cadena) == true) {
				this.mensajeSalida.writeUTF("Entro");
				Main.vistaServer.setTextArea("El cliente: " + cliente.getInetAddress().getHostName() + " con matricula: " + Login.getMatricula() + " registró una observación. \n");
			} else {
				this.mensajeSalida.writeUTF("Error");
			}
			
			this.cliente.close();

		} catch (IOException e) {
			Main.vistaServer
					.setTextArea("Error en SocketServidorInsertarObservacionesIndustrial metodo insertarObservación: " + e.getMessage() + "\n");
		}
	}
}
