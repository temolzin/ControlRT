package funcionamiento;
/**
 * Clase que envia al cliente todos los datos de la tabla alumno en la base de datos.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
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

public class SocketServidorBitacoraAcademico extends Usuario implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;
	ConexionPost conex;
	ResultSet administador;
	Object[] valoresConsulta;
	DefaultTableModel modelo;
	String cadenaActualizar;
	Thread hilo;

	public SocketServidorBitacoraAcademico() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {

			this.servidor = new ServerSocket(5021, 50);

			while (true) {
				this.cliente = this.servidor.accept();
				this.conex = ConexionPost.getInstance();

				this.consultarAlumno();

				this.cliente.close();
			}
		} catch (ClassNotFoundException e) {
			Main.vistaServer
					.setTextArea("Error en SocketServidorBitacoraAcademico ClassNot: " + e.getMessage() + "\n");
		} catch (IOException e) {
			Main.vistaServer.setTextArea(
					"Error en SocketServidorBitacoraAcademico IOException: " + e.getMessage() + "\n");
		}
	}
	
	/**
	 * Metodo que consulta en la base de datos a los alumnos asesorados por el Asesor Academico.
	 */
	private void consultarAlumno() {
		this.administador = conex.consultar("select * from alumno where id_asesorAca = " + Login.getMatricula() + "");
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
			while (this.administador.next()) {
				this.valoresConsulta[0] = this.administador.getString("matricula");
				this.valoresConsulta[1] = this.administador.getString("nombre");
				this.valoresConsulta[2] = this.administador.getString("ap_pat");
				this.valoresConsulta[3] = this.administador.getString("ap_mat");
				this.valoresConsulta[4] = this.administador.getString("telefono");
				this.valoresConsulta[5] = this.administador.getString("correo");
				this.valoresConsulta[6] = this.administador.getString("proyecto");
				this.valoresConsulta[7] = this.administador.getString("carrera");
				modelo.addRow(this.valoresConsulta);
			}
			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			this.mensajeSalida.writeObject(modelo);
		} catch (SQLException e) {
			Main.vistaServer.setTextArea(
					"Error en SocketServidorBitacoraAcademico SQLException: " + e.getMessage() + "\n");
		} catch (IOException e) {
			Main.vistaServer.setTextArea(
					"Error en SocketServidorBitacoraAcademico IOException: " + e.getMessage() + "\n");
		}
	}

}
