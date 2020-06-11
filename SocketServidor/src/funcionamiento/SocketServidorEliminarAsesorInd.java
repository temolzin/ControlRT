package funcionamiento;
/**
 * Clase que elimina asesores Industriales.
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

public class SocketServidorEliminarAsesorInd extends Usuario implements Runnable {
	Thread hilo;
	ServerSocket servidor;
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;
	ConexionPost conex;
	
	public SocketServidorEliminarAsesorInd() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
		this.servidor = new ServerSocket(5009, 50);

		while (true) {
			this.cliente = this.servidor.accept();

			this.conex = ConexionPost.getInstance();

			this.eliminarAsesorInd();

			this.cliente.close();
		}
		} catch(IOException e) {
			Main.vistaServer.setTextArea("Error en RUN SocketServerElimnarAsesorInd: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en RUN SocketServerElimnarAsesorInd: " + e.getMessage());
		}
	}
	
	/**
	 * Metodo que elimina en la base de datos administradores industriales
	 */
	private void eliminarAsesorInd() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());
			super.setMatricula((String) this.mensajeEntrada.readObject());

			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			if (this.conex.ejecutar("delete from asesorInd where id_asesorInd = " + super.getMatricula()) == true) {
				this.mensajeSalida.writeObject("Elimino");
			} else {
				this.mensajeSalida.writeObject("Error");
			}
		} catch (ClassNotFoundException | IOException e) {
			Main.vistaServer
					.setTextArea("Error en SocketServidorEliminarAsesorInd IOException metodo eliminar: "
							+ e.getMessage() + "\n");
		}

	}
}
