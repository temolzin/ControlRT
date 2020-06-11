package funcionamiento;
/**
 * Clase que actualiza la contrase�a de cualquier usuario en la base de datos.
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

public class SocketServidorCambiarContrase�a extends Login implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	DataInputStream mensajeEntrada;
	DataOutputStream mensajeSalida;
	ConexionPost conex;
	Thread hilo;
	String cadenaActualizar;
	
	public SocketServidorCambiarContrase�a() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
			this.servidor = new ServerSocket(5012, 50);
			while (true) {
				this.cliente = this.servidor.accept();
				this.cambiarContrase�a();
				this.cliente.close();
			}
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorCambiarContrase�a: " + e.getMessage());
		}

	}

	/**
	 * M�todo que actualiza en la base de datos la contrase�a de cualquier Usuario Logueado
	 */
	private void cambiarContrase�a() {
		try {
			this.conex = ConexionPost.getInstance();
			this.mensajeEntrada = new DataInputStream(cliente.getInputStream());
			
			Login.setPassword(this.mensajeEntrada.readUTF());
			
			this.mensajeSalida = new DataOutputStream(this.cliente.getOutputStream());
			
			if (Login.getTipoUsuario().equals("Administrador")) {
				this.cadenaActualizar = "update admin set password = '" + Login.getPassword() + "' where matricula = "
						+ Login.getMatricula();
				if (this.conex.ejecutar(this.cadenaActualizar) == true) {
					mensajeSalida.writeUTF("Correcto");
				} else {
					mensajeSalida.writeUTF("Error");
				}
			} else if (Login.getTipoUsuario().equals("Alumno")) {
				this.cadenaActualizar = "update alumno set password = '" + Login.getPassword() + "' where matricula = "
						+ Login.getMatricula();
				if (this.conex.ejecutar(this.cadenaActualizar) == true) {
					mensajeSalida.writeUTF("Correcto");
				} else {
					mensajeSalida.writeUTF("Error");
				}
			} else if (Login.getTipoUsuario().equals("Academico")) {
				this.cadenaActualizar = "update asesorAca set password = '" + Login.getPassword()
						+ "' where matricula = " + Login.getMatricula();
				if (this.conex.ejecutar(this.cadenaActualizar) == true) {
					mensajeSalida.writeUTF("Correcto");
				} else {
					mensajeSalida.writeUTF("Error");
				}
			} else if (Login.getTipoUsuario().equals("Industrial")) {
				this.cadenaActualizar = "update asesorInd set password = '" + Login.getPassword()
						+ "' where id_asesorInd = " + Login.getMatricula();
				if (this.conex.ejecutar(this.cadenaActualizar) == true) {
					mensajeSalida.writeUTF("Correcto");
				} else {
					mensajeSalida.writeUTF("Error");
				}
			}
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorCambiarContrase�a: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorCambiarContrase�a: " + e.getMessage());
		}
	}
}
