package funcionamiento;
/**
 * Clase que elimina Administradores en la base de datos.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import conexion.ConexionPost;
import main.Main;

public class SocketServidorEliminarAdministrador extends Usuario implements Runnable {
	Thread hilo;
	ServerSocket servidor;
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;
	ConexionPost conex;
	
	public SocketServidorEliminarAdministrador() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
		this.servidor = new ServerSocket(5011, 50);

		while (true) {
			this.cliente = this.servidor.accept();

			this.conex = ConexionPost.getInstance();

			this.eliminarAdministrador();

			this.cliente.close();
		}
		} catch(IOException e) {
			Main.vistaServer.setTextArea("Error en RUN SocketServerElimnarAdministrador: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en RUN SocketServerElimnarAdministrador: " + e.getMessage());
		}
	}
	
	/**
	 * Método que elimina Administradores en la base de datos.
	 */
	private void eliminarAdministrador() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());
			super.setMatricula((String) this.mensajeEntrada.readObject());

			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			if (this.conex.ejecutar("delete from admin where matricula = " + super.getMatricula()) == true) {
				this.mensajeSalida.writeObject("Elimino");
			} else {
				this.mensajeSalida.writeObject("Error");
			}
		} catch (ClassNotFoundException | IOException e) {
			Main.vistaServer
					.setTextArea("Error en SocketServidorEliminarAdministrador IOException metodo eliminar: "
							+ e.getMessage() + "\n");
		}

	}
}
