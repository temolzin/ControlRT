package funcionamiento;
/**
 * Clase que busca y actualiza los datos del Asesor Industrial
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

public class SocketServidorBuscarActualizarAsesorInd extends Usuario implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;
	ConexionPost conex;
	ResultSet asesorInd;
	Object[] valoresConsulta;
	DefaultTableModel modelo;
	String cadenaActualizar, empresa;
	Thread hilo;

	public SocketServidorBuscarActualizarAsesorInd() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
			
			this.servidor = new ServerSocket(5008, 50);
			
			while (true) {
				this.cliente = this.servidor.accept();
				this.conex = ConexionPost.getInstance();
				
				this.consultarAsesorInd();
				this.actualizarAsesorInd();
				
				this.cliente.close();
			}
			
		} catch (ClassNotFoundException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorInd ClassNot: " + e.getMessage() + "\n");
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorInd IOException: " + e.getMessage() + "\n");
		}
	}

	/**
	 * Método que consulta en la base de datos a los asesores Industriales Registrados en el sistema.
	 */
	private void consultarAsesorInd() {
		this.asesorInd = conex.consultar("select * from asesorInd;");
		this.valoresConsulta = new Object[8];

		modelo = new DefaultTableModel();
		modelo.addColumn("Matricula");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Empresa");
		modelo.addColumn("Correo");
		modelo.addColumn("Teléfono");
		modelo.addColumn("Contraseña");
		try {
			while (this.asesorInd.next()) {
				this.valoresConsulta[0] = this.asesorInd.getString("id_asesorInd");
				this.valoresConsulta[1] = this.asesorInd.getString("nombre");
				this.valoresConsulta[2] = this.asesorInd.getString("ap_pat");
				this.valoresConsulta[3] = this.asesorInd.getString("ap_mat");
				this.valoresConsulta[4] = this.asesorInd.getString("empresa");
				this.valoresConsulta[5] = this.asesorInd.getString("correo");
				this.valoresConsulta[6] = this.asesorInd.getString("telefono");
				this.valoresConsulta[7] = this.asesorInd.getString("password");

				modelo.addRow(this.valoresConsulta);
			}
			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			this.mensajeSalida.writeObject(modelo);
		} catch (SQLException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorInd SQLException: " + e.getMessage() + "\n");
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorInd IOException: " + e.getMessage() + "\n");
		}
	}

	/**
	 * Método que recibe datos del cliente y actualiza Asesor Industrial en la base de datos.
	 */
	private void actualizarAsesorInd() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());

			if (mensajeEntrada != null) {
				super.setMatricula((String) this.mensajeEntrada.readObject());
				super.setNombre((String) this.mensajeEntrada.readObject());
				super.setAp_pat((String) this.mensajeEntrada.readObject());
				super.setAp_mat((String) this.mensajeEntrada.readObject());
				this.empresa = (String) this.mensajeEntrada.readObject();
				super.setCorreo((String) this.mensajeEntrada.readObject());
				super.setTelefono((String) this.mensajeEntrada.readObject());
				super.setPassword((String) this.mensajeEntrada.readObject());

				this.cadenaActualizar = "update asesorInd set nombre = '" + super.getNombre() + "' , ap_pat = '"
						+ super.getAp_pat() + "' , ap_mat = '" + super.getAp_mat() + "' , empresa = '" + this.empresa + "' , correo = '"
						+ super.getCorreo() + "' , telefono = " + super.getTelefono() + ", password = '"
						+ super.getPassword() + "' where id_asesorInd = " + super.getMatricula();

				if (this.conex.ejecutar(this.cadenaActualizar) == true) {
					this.mensajeSalida.writeObject("Entro");
				} else {
					this.mensajeSalida.writeObject("Error");
				}
			}
		} catch (IOException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorInd metodo actualizar IOException: "+ e.getMessage() + "\n");
		} catch (ClassNotFoundException e) {
			//Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAsesorInd ClassNot metodo Actualizar: "+ e.getMessage() + "\n");
		}
	}

}
