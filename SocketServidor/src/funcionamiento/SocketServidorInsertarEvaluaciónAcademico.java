package funcionamiento;
/**
 * Clase que inserta en la base de datos las evaluaciones del Asesor Academico.
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

public class SocketServidorInsertarEvaluaciónAcademico implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	DataInputStream mensajeEntrada;
	DataOutputStream mensajeSalida;
	ConexionPost conex;
	ResultSet alumno;
	String cadena, matricula, parcial, ser, saber, hacer;
	Thread hilo;

	public SocketServidorInsertarEvaluaciónAcademico() {
		try {
			this.servidor = new ServerSocket(5016, 50);
			this.conex = ConexionPost.getInstance();
		} catch (IOException | ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorInsertarEvaluaciónAcademico: " + e.getMessage() + "\n");
		}
		this.cliente = null;
		this.mensajeEntrada = null;
		this.mensajeSalida = null;
		this.alumno = null;
		this.cadena = null;
		this.matricula = null;
		this.ser = null;
		this.saber = null;
		this.hacer = null;
		this.parcial = null;
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
				.setTextArea("Error en SocketServidorObservacionesAcademico metodo RUN: " + e.getMessage() + "\n");
			}
			this.insertarEvaluacion();
		}
	}
	
	/**
	 * Metodo que inserta en la base de datos las evaluaciones del Asesor Académico.
	 */
	private void insertarEvaluacion() {
		try {
			
			this.matricula = this.mensajeEntrada.readUTF();
			this.parcial = this.mensajeEntrada.readUTF();
			this.ser = this.mensajeEntrada.readUTF();
			this.saber = this.mensajeEntrada.readUTF();
			this.hacer = this.mensajeEntrada.readUTF();
			
			this.cadena = "INSERT INTO evaluacionaca (matriculaalumno, id_asesoraca, parcial, saber, hacer, ser) VALUES (" + this.matricula + ","
					+ Login.getMatricula() + ", '" +  this.parcial + "' , " + this.saber + ", " + this.hacer + ", " + this.ser + ");";
			if(this.conex.ejecutar(this.cadena) == true) {
				this.mensajeSalida.writeUTF("Entro");
				Main.vistaServer.setTextArea("El cliente: " + cliente.getInetAddress().getHostName() + " con matricula: " + Login.getMatricula() + " registró una evaluación. \n");
			} else {
				this.mensajeSalida.writeUTF("Error");
			}
			
			this.cliente.close();

		} catch (IOException e) {
			Main.vistaServer
					.setTextArea("Error en SocketServidorInsertarEvaluacionAcademico metodo insertarEvaluacion: " + e.getMessage() + "\n");
		}
	}
}
