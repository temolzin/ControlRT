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
//import main.Main;

public class SocketServidorBuscarActualizarAdministrador extends Usuario implements Runnable {
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

	public SocketServidorBuscarActualizarAdministrador() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {

			this.servidor = new ServerSocket(5010, 50);

			while (true) {
				this.cliente = this.servidor.accept();
				this.conex = ConexionPost.getInstance();

				this.consultarAsesorAca();
				this.actualizarAsesorAca();

				this.cliente.close();
			}
		} catch (ClassNotFoundException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAdministrador ClassNot: " + e.getMessage() + "\n");
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAdministrador IOException: " + e.getMessage() + "\n");
		}
	}

	private void consultarAsesorAca() {
		this.administador = conex.consultar("select * from admin;");
		this.valoresConsulta = new Object[6];

		modelo = new DefaultTableModel();
		modelo.addColumn("Matricula");
		modelo.addColumn("Nombre(s)");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Correo");
		modelo.addColumn("Teléfono");
		try {
			while (this.administador.next()) {
				this.valoresConsulta[0] = this.administador.getString("matricula");
				this.valoresConsulta[1] = this.administador.getString("nombre");
				this.valoresConsulta[2] = this.administador.getString("ap_pat");
				this.valoresConsulta[3] = this.administador.getString("ap_mat");
				this.valoresConsulta[4] = this.administador.getString("correo");
				this.valoresConsulta[5] = this.administador.getString("telefono");

				modelo.addRow(this.valoresConsulta);
			}
			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			this.mensajeSalida.writeObject(modelo);
		} catch (SQLException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAdministrador SQLException: " + e.getMessage() + "\n");
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAdministrador IOException: " + e.getMessage() + "\n");
		}
	}

	private void actualizarAsesorAca() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());

			if (mensajeEntrada != null) {
				super.setMatricula((String) this.mensajeEntrada.readObject());
				super.setNombre((String) this.mensajeEntrada.readObject());
				super.setAp_pat((String) this.mensajeEntrada.readObject());
				super.setAp_mat((String) this.mensajeEntrada.readObject());
				super.setTelefono((String) this.mensajeEntrada.readObject());
				super.setCorreo((String) this.mensajeEntrada.readObject());

				this.cadenaActualizar = "update admin set nombre = '" + super.getNombre() + "' , ap_pat = '"
						+ super.getAp_pat() + "' , ap_mat = '" + super.getAp_mat() + "' , correo = '"
						+ super.getCorreo() + "' , telefono = " + super.getTelefono() + " where matricula = " + super.getMatricula();

				if (this.conex.ejecutar(this.cadenaActualizar) == true) {
					this.mensajeSalida.writeObject("Entro");
				} else {
					this.mensajeSalida.writeObject("Error");
				}
			}
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAdministrador metodo actualizar IOException: "+ e.getMessage() + "\n");
		} catch (ClassNotFoundException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAdministrador ClassNot metodo Actualizar: "+ e.getMessage() + "\n");
		}
	}

}
