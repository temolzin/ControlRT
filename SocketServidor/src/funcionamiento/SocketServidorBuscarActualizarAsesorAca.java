package funcionamiento;
/**
 * Clase que busca y actualiza datos del Asesor Académico en la base de datos.
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
//import main.Main;

public class SocketServidorBuscarActualizarAsesorAca extends Usuario implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;
	ConexionPost conex;
	ResultSet asesorAca;
	Object[] valoresConsulta;
	DefaultTableModel modelo;
	String cadenaActualizar;
	Thread hilo;

	public SocketServidorBuscarActualizarAsesorAca() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {

			this.servidor = new ServerSocket(5004, 50);

			while (true) {
				this.cliente = this.servidor.accept();
				this.conex = ConexionPost.getInstance();

				this.consultarAsesorAca();
				this.actualizarAsesorAca();

				this.cliente.close();
			}
		} catch (ClassNotFoundException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorAca ClassNot: " + e.getMessage() + "\n");
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorAca IOException: " + e.getMessage() + "\n");
		}
	}
	
	/**
	 * Método que consulta en la base de datos los Asesores Académicos registrados en el sistema.
	 */
	private void consultarAsesorAca() {
		this.asesorAca = conex.consultar("select * from asesorAca;");
		this.valoresConsulta = new Object[7];

		modelo = new DefaultTableModel();
		modelo.addColumn("Matricula");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Correo");
		modelo.addColumn("Telefono");
		modelo.addColumn("Password");
		try {
			while (this.asesorAca.next()) {
				this.valoresConsulta[0] = this.asesorAca.getString("matricula");
				this.valoresConsulta[1] = this.asesorAca.getString("nombre");
				this.valoresConsulta[2] = this.asesorAca.getString("ap_pat");
				this.valoresConsulta[3] = this.asesorAca.getString("ap_mat");
				this.valoresConsulta[4] = this.asesorAca.getString("correo");
				this.valoresConsulta[5] = this.asesorAca.getString("telefono");
				this.valoresConsulta[6] = this.asesorAca.getString("password");

				modelo.addRow(this.valoresConsulta);
			}
			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			this.mensajeSalida.writeObject(modelo);
		} catch (SQLException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorAca SQLException: " + e.getMessage() + "\n");
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorAca IOException: " + e.getMessage() + "\n");
		}
	}

	/**
	 * Método que recibe datos del cliente y actualiza Asesor Académico en la base de datos.
	 */
	private void actualizarAsesorAca() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());

			if (mensajeEntrada != null) {
				super.setMatricula((String) this.mensajeEntrada.readObject());
				super.setNombre((String) this.mensajeEntrada.readObject());
				super.setAp_pat((String) this.mensajeEntrada.readObject());
				super.setAp_mat((String) this.mensajeEntrada.readObject());
				super.setCorreo((String) this.mensajeEntrada.readObject());
				super.setTelefono((String) this.mensajeEntrada.readObject());
				super.setPassword((String) this.mensajeEntrada.readObject());

				this.cadenaActualizar = "update asesorAca set nombre = '" + super.getNombre() + "' , ap_pat = '"
						+ super.getAp_pat() + "' , ap_mat = '" + super.getAp_mat() + "' , correo = '"
						+ super.getCorreo() + "' , telefono = " + super.getTelefono() + ", password = '"
						+ super.getPassword() + "' where matricula = " + super.getMatricula();

				if (this.conex.ejecutar(this.cadenaActualizar) == true) {
					this.mensajeSalida.writeObject("Entro");
				} else {
					this.mensajeSalida.writeObject("Error");
				}
			}
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorAca metodo actualizar IOException: " + e.getMessage() + "\n");
		} catch (ClassNotFoundException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorAca ClassNot metodo Actualizar: "+ e.getMessage() + "\n");
		}
	}

}
