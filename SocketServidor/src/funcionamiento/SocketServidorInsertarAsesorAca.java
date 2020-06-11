package funcionamiento;
/**
 * Clase que inserta en la base de datos un nuevo Asesor Académico.
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

public class SocketServidorInsertarAsesorAca extends Usuario implements Runnable{
	
	String cadena;
	ConexionPost conex;
	DataOutputStream mensajeSalida;
	DataInputStream mensajeEntrada;
	Socket cliente;
	ServerSocket servidor;
	
	public SocketServidorInsertarAsesorAca() {
		Thread hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		try {
			this.servidor = new ServerSocket(5001, 50);
			
			while (true) {
				
				this.cliente = this.servidor.accept();
				Main.vistaServer.setTextArea("El cliente: " + cliente.getInetAddress().getHostName() + " se conecto satisfactoriamente. \n");
				
				this.mensajeEntrada = new DataInputStream(this.cliente.getInputStream());
				this.mensajeSalida = new DataOutputStream(cliente.getOutputStream());
				
				super.setMatricula(this.mensajeEntrada.readUTF());
				super.setNombre(this.mensajeEntrada.readUTF());
				super.setAp_pat(this.mensajeEntrada.readUTF());
				super.setAp_mat(this.mensajeEntrada.readUTF());
				super.setCorreo(this.mensajeEntrada.readUTF());
				super.setTelefono(this.mensajeEntrada.readUTF());
				super.setPassword(this.mensajeEntrada.readUTF());
				
				this.conex = ConexionPost.getInstance();
				this.cadena = "insert into asesorAca values(" + super.getMatricula() + ", '" + super.getNombre() + "' , '" + super.getAp_pat() + "' , '"
						+ super.getAp_mat() + "' , " + " '" + super.getCorreo() + "' , " + super.getTelefono() + " , '" + super.getPassword() + "' );";
								
				if (conex.ejecutar(cadena) == true) {
					this.mensajeSalida.writeUTF("Entro");
					Main.vistaServer.setTextArea("El cliente: " + this.cliente.getInetAddress().getHostName() + " Registró un Asesor Acádemico. \n\n");
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
