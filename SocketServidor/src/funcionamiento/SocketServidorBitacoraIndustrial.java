package funcionamiento;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import conexion.ConexionPost;
import main.Main;

public class SocketServidorBitacoraIndustrial extends Usuario implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;
	ConexionPost conex;
	ResultSet alumno;
	Object[] valoresConsulta;
	DefaultTableModel modelo;
	String cadenaActualizar;
	Thread hilo;

	public SocketServidorBitacoraIndustrial() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {

			this.servidor = new ServerSocket(5023, 50);

			while (true) {
				this.cliente = this.servidor.accept();
				this.conex = ConexionPost.getInstance();

				this.consultarAlumno();

				this.cliente.close();
			}
		} catch (ClassNotFoundException e) {
			Main.vistaServer
					.setTextArea("Error en SocketServidorBitacoraIndustrial ClassNot: " + e.getMessage() + "\n");
		} catch (IOException e) {
			Main.vistaServer.setTextArea(
					"Error en SocketServidorBitacoraIndustrial IOException: " + e.getMessage() + "\n");
		}
	}

	private void consultarAlumno() {
		this.alumno = conex.consultar("select * from alumno where id_asesorInd = " + Login.getMatricula() + "");
		this.valoresConsulta = new Object[8];

		modelo = new DefaultTableModel();
		modelo.addColumn("Matricula");
		modelo.addColumn("Nombre(s)");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Teléfono");
		modelo.addColumn("Correo");
		modelo.addColumn("Proyecto");
		modelo.addColumn("Carrera");
		try {
			while (this.alumno.next()) {
				this.valoresConsulta[0] = this.alumno.getString("matricula");
				this.valoresConsulta[1] = this.alumno.getString("nombre");
				this.valoresConsulta[2] = this.alumno.getString("ap_pat");
				this.valoresConsulta[3] = this.alumno.getString("ap_mat");
				this.valoresConsulta[4] = this.alumno.getString("telefono");
				this.valoresConsulta[5] = this.alumno.getString("correo");
				this.valoresConsulta[6] = this.alumno.getString("proyecto");
				this.valoresConsulta[7] = this.alumno.getString("carrera");
				modelo.addRow(this.valoresConsulta);
			}
			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			this.mensajeSalida.writeObject(modelo);
		} catch (SQLException e) {
			Main.vistaServer.setTextArea(
					"Error en SocketServidorBitacoraIndustrial SQLException: " + e.getMessage() + "\n");
		} catch (IOException e) {
			Main.vistaServer.setTextArea(
					"Error en SocketServidorBitacoraIndustrial IOException: " + e.getMessage() + "\n");
		}
	}

}
