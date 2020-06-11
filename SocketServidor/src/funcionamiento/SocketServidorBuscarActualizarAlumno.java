package funcionamiento;
/**
 * Clase que Busca y actualiza los datos del alumno, en la base de datos..
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

public class SocketServidorBuscarActualizarAlumno extends Usuario implements Runnable {
	ServerSocket servidor;
	String proyecto, division, carrera, periodoCuatrimestre, idAsesorInd, idAsesorAca;
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;
	ConexionPost conex;
	ResultSet administador;
	Object[] valoresConsulta;
	DefaultTableModel modelo;
	String cadenaActualizar;
	Thread hilo;

	public SocketServidorBuscarActualizarAlumno() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {

			this.servidor = new ServerSocket(5025, 50);

			while (true) {
				this.cliente = this.servidor.accept();
				this.conex = ConexionPost.getInstance();

				this.consultarAlumnos();
				this.actualizarAlumnos();

				this.cliente.close();
			}
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAlumno ClassNot: " + e.getMessage() + "\n");
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAlumno IOException: " + e.getMessage() + "\n");
		}
	}
	
	/**
	 * Método que consulta a todos los alumnos registrados en la base de datos.
	 */
	private void consultarAlumnos() {
		this.administador = conex.consultar("select * from alumno;");
		this.valoresConsulta = new Object[13];

		modelo = new DefaultTableModel();
		modelo.addColumn("Matricula");
		modelo.addColumn("Nombre(s)");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Contraseña");
		modelo.addColumn("Teléfono");
		modelo.addColumn("Correo");
		modelo.addColumn("Proyecto");
		modelo.addColumn("División");
		modelo.addColumn("Carrera");
		modelo.addColumn("Periodo Cuatrimestre");
		modelo.addColumn("Asesor Industrial");
		modelo.addColumn("Asesor Academico");
		
		try {
			while (this.administador.next()) {
				this.valoresConsulta[0] = this.administador.getString("matricula");
				this.valoresConsulta[1] = this.administador.getString("nombre");
				this.valoresConsulta[2] = this.administador.getString("ap_pat");
				this.valoresConsulta[3] = this.administador.getString("ap_mat");
				this.valoresConsulta[4] = this.administador.getString("password");
				this.valoresConsulta[5] = this.administador.getString("telefono");
				this.valoresConsulta[6] = this.administador.getString("correo");
				this.valoresConsulta[7] = this.administador.getString("proyecto");
				this.valoresConsulta[8] = this.administador.getString("division");
				this.valoresConsulta[9] = this.administador.getString("carrera");
				this.valoresConsulta[10] = this.administador.getString("periodocuatrimestral");
				this.valoresConsulta[11] = this.administador.getString("id_asesorInd");
				this.valoresConsulta[12] = this.administador.getString("id_asesorAca");

				modelo.addRow(this.valoresConsulta);
			}
			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			this.mensajeSalida.writeObject(modelo);
		} catch (SQLException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAlumno SQLException: " + e.getMessage() + "\n");
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAlumno IOException: " + e.getMessage() + "\n");
		}
	}
	
	/**
	 * Método que actualiza Alumnos en la base de datos.
	 */
	private void actualizarAlumnos() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());

			if (mensajeEntrada != null) {
				super.setMatricula((String) this.mensajeEntrada.readObject());
				super.setNombre((String) this.mensajeEntrada.readObject());
				super.setAp_pat((String) this.mensajeEntrada.readObject());
				super.setAp_mat((String) this.mensajeEntrada.readObject());
				super.setPassword((String) this.mensajeEntrada.readObject());
				super.setTelefono((String) this.mensajeEntrada.readObject());
				super.setCorreo((String) this.mensajeEntrada.readObject());
				this.proyecto = (String) this.mensajeEntrada.readObject();
				this.division = (String) this.mensajeEntrada.readObject();
				this.carrera = (String) this.mensajeEntrada.readObject();
				this.periodoCuatrimestre = (String) this.mensajeEntrada.readObject();
				this.idAsesorInd = (String) this.mensajeEntrada.readObject();
				this.idAsesorAca = (String) this.mensajeEntrada.readObject();

				this.cadenaActualizar = "update alumno set nombre = '" + super.getNombre() + "' , ap_pat = '"
						+ super.getAp_pat() + "' , ap_mat = '" + super.getAp_mat() + "' ,password = '"+ super.getPassword() + "' ,correo = '"
						+ super.getCorreo() + "' , telefono = " + super.getTelefono() + ", proyecto =  '" + this.proyecto + "'"
						+ " , division = '" + this.division + "', carrera = '" + this.carrera + "', periodocuatrimestral = '" + this.periodoCuatrimestre + "'"
						+ ", id_asesorInd = " + this.idAsesorInd + ", id_asesorAca = " + this.idAsesorAca + "where matricula = " + super.getMatricula();
	
				if (this.conex.ejecutar(this.cadenaActualizar) == true) {
					this.mensajeSalida.writeObject("Entro");
				} else {
					this.mensajeSalida.writeObject("Error");
				}
			}
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAlumno metodo actualizar IOException: "+ e.getMessage() + "\n");
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBuscarActualizarAlumno ClassNot metodo Actualizar: "+ e.getMessage() + "\n");
		}
	}

}
