package funcionamiento;
/**
 * Clase que inserta en la base de datos los avances del alumno.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import conexion.ConexionPost;
import main.Main;

public class SocketServidorInsertarAvancesAlumno implements Runnable{
	
	String cadena;
	ConexionPost conex;
	DataOutputStream mensajeSalida;
	DataInputStream mensajeEntrada;
	Socket cliente;
	String avance, noSemana;
	ServerSocket servidor;
	Thread hilo;
	
	public SocketServidorInsertarAvancesAlumno() {
		this.cadena = null;
		this.conex = null;
		this.mensajeEntrada = null;
		this.mensajeSalida = null;
		this.cliente = null;
		this.cliente = null;
		this.avance = null;
		this.noSemana = null;
		try {
			this.servidor = new ServerSocket(5013, 50);
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en el constructor en SocketInsertarAsesorAca IOException: " + e.getMessage());
		}
		
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
			
			
			while (true) {
				
				this.cliente = this.servidor.accept();
				Main.vistaServer.setTextArea("El cliente: " + cliente.getInetAddress().getHostName() + " se conecto satisfactoriamente. \n");
				
				this.mensajeEntrada = new DataInputStream(this.cliente.getInputStream());
				
				this.avance = this.mensajeEntrada.readUTF();
				this.noSemana = this.mensajeEntrada.readUTF();
				
				this.conex = ConexionPost.getInstance();
				this.cadena = "insert into avancesalumno (matriculaAlumno, noSemana, avance) values(" + Login.getMatricula() + ", " + noSemana + ", '" + avance + "');";
						
				this.mensajeSalida = new DataOutputStream(cliente.getOutputStream());
				if (conex.ejecutar(cadena) == true) {
					this.mensajeSalida.writeUTF("Entro");
					Main.vistaServer.setTextArea("El cliente: " + this.cliente.getInetAddress().getHostName() + " Registro un avance cómo alumno. \n\n");
				} else {
					this.mensajeSalida.writeUTF("Error");
				}

				this.cliente.close();
			}
			
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en RUN en SocketInsertarAsesorAca IOException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Error en RUN en SocketServidor ClassNotFound: " + e.getMessage());
		} 
	}
}
