package funcionamiento;
/**
 * Clase que registra en la base de datos un nuevo Asesor Industrial.
 * @author TemolzinItzae
 * @author TaniaCitlali
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

public class SocketServidorInsertarAsesorInd extends Usuario implements Runnable{
	
	String empresa;
	String cadena;
	ConexionPost conex;
	DataOutputStream mensajeSalida;
	DataInputStream mensajeEntrada;
	ResultSet idAsesorInd;
	Socket cliente;
	ServerSocket servidor;
	
	public SocketServidorInsertarAsesorInd() {
		Thread hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		try {
			this.servidor = new ServerSocket(5003, 50);
			
			while (true) {
				
				this.cliente = this.servidor.accept();
				Main.vistaServer.setTextArea("El cliente: " + cliente.getInetAddress().getHostName() + " se conecto satisfactoriamente. \n");
				
				this.mensajeEntrada = new DataInputStream(this.cliente.getInputStream());
				this.mensajeSalida = new DataOutputStream(cliente.getOutputStream());
				
				super.setNombre(this.mensajeEntrada.readUTF());
				super.setAp_pat(this.mensajeEntrada.readUTF());
				super.setAp_mat(this.mensajeEntrada.readUTF());
				super.setCorreo(this.mensajeEntrada.readUTF());
				super.setTelefono(this.mensajeEntrada.readUTF());
				super.setPassword(this.mensajeEntrada.readUTF());
				this.empresa = this.mensajeEntrada.readUTF();
				
				this.conex = ConexionPost.getInstance();
				this.cadena = "INSERT INTO asesorind (nombre, ap_pat, ap_mat, empresa, correo, telefono, password) "
						+ "VALUES ('" + super.getNombre() + "', '" + super.getAp_pat() + "', '" + super.getAp_mat() + "', '" + this.empresa + "', "
								+ "'" + super.getCorreo() + "', '" + super.getTelefono() + "', '" + super.getPassword() + "')";
				
				if (conex.ejecutar(cadena) == true) {
					this.idAsesorInd = this.conex.consultar("SELECT id_asesorind FROM asesorind WHERE nombre = '" + super.getNombre() + "' and empresa = '" + this.empresa + "'" );
					this.idAsesorInd.next();
					this.idAsesorInd.getString(1);
					this.mensajeSalida.writeUTF(this.idAsesorInd.getString(1));
					Main.vistaServer.setTextArea("El cliente: " + this.cliente.getInetAddress().getHostName() + " Registró un Asesor Industrial. \n\n");
				} else {
					mensajeSalida.writeUTF("Error");
				}

				this.cliente.close();
			}
			
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en RUN en SocketServidorInsertarAsesorIndIOException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Error en RUN en SocketServidorInsertarAsesorInd ClassNotFound: " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
