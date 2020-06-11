package funcionamiento;

import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionPost;
import main.Main;

public class SocketServidorCargarAsesores implements Runnable {
	String proyecto, division, carrera, periodoCuatrimestre, cadena, id_asesorInd, id_asesorAca;
	String[] nombreAsesorInd;
	String[] nombreAsesorAca;
	ConexionPost conex;
	ResultSet asesorAca;
	ResultSet asesorInd;
	Socket cliente;
	ServerSocket server;
	String nombreCompletoAsesorAca;
	String nombreCompletoAsesorInd;
	List listaAsesorAca;
	List listaAsesorInd;
	ObjectOutputStream mensajeSalida;
	ObjectInputStream mensajeEntrada;
	Thread hilo;

	public SocketServidorCargarAsesores() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
			this.server = new ServerSocket(5002, 50);
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorCargarAsesores IOException: " + e.getMessage());
		}
		while (true) {
			this.cargarAsesores();
		}

	}

	private void cargarAsesores() {
		try {
			this.cliente = this.server.accept();
			this.listaAsesorAca = new List();
			this.listaAsesorInd = new List();

			this.conex = ConexionPost.getInstance();
			this.asesorAca = conex.consultar("select * from asesoraca");
			while (this.asesorAca.next()) {
				this.nombreCompletoAsesorAca = this.asesorAca.getString("matricula") + " "
						+ this.asesorAca.getString("nombre") + " " + this.asesorAca.getString("ap_pat") + " "
						+ this.asesorAca.getString("ap_mat");
				this.listaAsesorAca.add(this.nombreCompletoAsesorAca);
			}
			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			this.mensajeSalida.writeObject(listaAsesorAca);

			this.asesorInd = conex.consultar("select * from asesorind");
			while (this.asesorInd.next()) {
				this.nombreCompletoAsesorInd = this.asesorInd.getString("id_asesorInd") + " "
						+ this.asesorInd.getString("nombre") + " " + this.asesorInd.getString("ap_pat") + " "
						+ this.asesorInd.getString("ap_mat");
				this.listaAsesorInd.add(this.nombreCompletoAsesorInd);
			}
			this.mensajeSalida.writeObject(listaAsesorInd);

			this.cliente.close();
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorCargarAsesores IOException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorCargarAsesores ClassNotFound: " + e.getMessage());
		} catch (SQLException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorCargarAsesores Sql: " + e.getMessage());
		}
	}
}
