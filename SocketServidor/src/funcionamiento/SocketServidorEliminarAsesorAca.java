package funcionamiento;
/**
 * Clase que elimina asesores Academicos.
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

public class SocketServidorEliminarAsesorAca extends Usuario implements Runnable {
	Thread hilo;
	ServerSocket servidor;
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;
	ConexionPost conex;
	
	public SocketServidorEliminarAsesorAca() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
		this.servidor = new ServerSocket(5007, 50);

		while (true) {
			this.cliente = this.servidor.accept();

			this.conex = ConexionPost.getInstance();

			this.eliminarAsesorAca();

			this.cliente.close();
		}
		} catch(IOException e) {
			Main.vistaServer.setTextArea("Error en RUN SocketServerElimnarAsesorAca: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en RUN SocketServerElimnarAsesorAca: " + e.getMessage());
		}
	}
	
	/**
	 * Metodo que elimina en la base de datos asesores Académicos.
	 */
	private void eliminarAsesorAca() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());
			super.setMatricula((String) this.mensajeEntrada.readObject());

			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			if (this.conex.ejecutar("delete from asesorAca where matricula = " + super.getMatricula()) == true) {
				this.mensajeSalida.writeObject("Elimino");
			} else {
				this.mensajeSalida.writeObject("Error");
			}
		} catch (ClassNotFoundException | IOException e) {
			Main.vistaServer
					.setTextArea("Error en SocketServidorEliminarAsesorAca IOException metodo eliminar: "
							+ e.getMessage() + "\n");
		}

	}
}
