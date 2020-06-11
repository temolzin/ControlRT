package funcionamiento;
/**
 * Clase que inserta en la base de datos un nuevo Administrador.
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

public class SocketServidorInsertarAdministrador extends Usuario implements Runnable {
	Socket cliente;
	ServerSocket servidor;
	Thread hilo;
	ConexionPost conex;
	String cadena;
	DataInputStream mensajeEntrada;
	DataOutputStream mensajeSalida;

	public SocketServidorInsertarAdministrador() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
			this.servidor = new ServerSocket(5006, 50);

			while (true) {

				this.cliente = this.servidor.accept();
				this.mensajeEntrada = new DataInputStream(this.cliente.getInputStream());
				Main.vistaServer.setTextArea("El cliente: " + this.cliente.getInetAddress().getHostName() +" está registrando Administradores \n");
				super.setMatricula(this.mensajeEntrada.readUTF());
				super.setNombre(this.mensajeEntrada.readUTF());
				super.setAp_pat(this.mensajeEntrada.readUTF());
				super.setAp_mat(this.mensajeEntrada.readUTF());
				super.setPassword(this.mensajeEntrada.readUTF());
				super.setTelefono(this.mensajeEntrada.readUTF());
				super.setCorreo(this.mensajeEntrada.readUTF());
				
				this.conex = ConexionPost.getInstance();
				this.cadena = "insert into admin values (" + super.getMatricula() + ", '" + super.getNombre() + "' , " + 
				"'" + super.getAp_pat() + "' , " + "'" + super.getAp_mat() + "' , " + "'" + super.getPassword() + "' , " + super.getTelefono() + ", "
						+ "'" + super.getCorreo() + "')";
				
				this.mensajeSalida = new DataOutputStream(this.cliente.getOutputStream());
				if(this.conex.ejecutar(this.cadena) == true) {
					this.mensajeSalida.writeUTF("Entro");
					Main.vistaServer.setTextArea("El cliente:"  + this.cliente.getInetAddress() +" registro un administrador satisfactoriamente. \n");
				} else {
					this.mensajeSalida.writeUTF("Error");
				}
			}
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en RUN en SocketInsertarAdministrador IOException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en RUN en SocketInsertarAdministrador: " + e.getMessage());
		}
	}
}
