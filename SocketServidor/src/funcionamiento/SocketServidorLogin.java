package funcionamiento;
/**
 * Clase que consulta la matricula y contraseña recibida del cliente,
 * y revisa que tipo de usuario es, e inicia sesión.
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

public class SocketServidorLogin extends Login implements Runnable{
	Socket cliente;
	ServerSocket servidor;
	ObjectInputStream mensajeEntrada;
	ConexionPost conex;
	ObjectOutputStream mensajeSalida;
	String nombreUser;
	String nombreProyecto;
	String asesorAca;
	String asesorInd;
	ResultSet alumno;
	ResultSet administrador;
	ResultSet reasesorAca;
	ResultSet reasesorInd;
	Object[] valoresConsulta;
	DefaultTableModel modelo;
	Thread hilo;

	public SocketServidorLogin() {
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {
			this.servidor = new ServerSocket(5000, 50);
		} catch (IOException e) {
			System.err.println("Error en RUN en SocketServidor IOException: " + e.getMessage());
		}
		while (true) {
			this.realizarLogin();
		}

	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}

	public ServerSocket getServidor() {
		return servidor;
	}

	public void setServidor(ServerSocket servidor) {
		this.servidor = servidor;
	}
	
	/**
	 * Metodo que se encarga de hacer la consulta a la base de datos y evalua que tipo de usuario es.
	 */
	private void realizarLogin() {
		try {
			this.cliente = this.servidor.accept();
			Main.vistaServer.setTextArea("El cliente: " + cliente.getInetAddress().getHostName() + " se conecto satisfactoriamente. \n");
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());
			Login.setPassword((String) this.mensajeEntrada.readObject());
			Login.setMatricula((String) this.mensajeEntrada.readObject());
			
			Main.vistaServer.setTextArea("Matricula: " + Login.getMatricula() + "\n");
			Main.vistaServer.setTextArea("Password: " + Login.getPassword() + "\n");
			
			this.conex = ConexionPost.getInstance();
			this.mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());
			this.alumno = conex.consultar("SELECT * FROM alumno where matricula = " + Login.getMatricula() + " and " + "password = " + "'" + Login.getPassword() + "'");
			this.administrador = conex.consultar("SELECT * FROM admin where matricula = " + Login.getMatricula() + " and " + "password = " + "'" + Login.getPassword() + "'");
			this.reasesorAca = conex.consultar("SELECT * FROM asesoraca WHERE matricula = " + Login.getMatricula() + " and password = '" + Login.getPassword() + "'");
			this.reasesorInd = conex.consultar("SELECT * FROM asesorind WHERE id_asesorind = " + Login.getMatricula() + " and password = '" + Login.getPassword() + "'");
			
			if (this.alumno.next()) {
				Login.setTipoUsuario("Alumno");
				this.mensajeSalida.writeObject("Alumno");
				this.nombreUser = alumno.getString("nombre") + " " + alumno.getString("ap_pat") + " " + alumno.getString("ap_mat");
				this.mensajeSalida.writeObject(nombreUser);
				this.nombreProyecto = alumno.getString("proyecto");
				this.mensajeSalida.writeObject(nombreProyecto);
				
				this.reasesorAca = conex.consultar("SELECT * FROM asesoraca where matricula = " + alumno.getInt("id_asesoraca"));
				this.reasesorAca.next();
				this.asesorAca = reasesorAca.getString("nombre") + " " + reasesorAca.getString("ap_pat") + " "  + reasesorAca.getString("ap_mat");
				this.mensajeSalida.writeObject(this.asesorAca);
				
				this.reasesorInd = conex.consultar("SELECT * FROM asesorind where id_asesorind = " + alumno.getInt("id_asesorind"));
				this.reasesorInd.next();
				this.asesorInd = reasesorInd.getString("nombre") + " " + reasesorInd.getString("ap_pat") + " "  + reasesorInd.getString("ap_mat");
				this.mensajeSalida.writeObject(this.asesorInd);
				
				Main.vistaServer.setTextArea("El cliente ingreso como alumno. \n \n");	
				
			} else if(this.administrador.next()) {
				Login.setTipoUsuario("Administrador");
				this.mensajeSalida.writeObject("Administrador");
				this.nombreUser = administrador.getString("nombre") + " " + administrador.getString("ap_pat") + " " + administrador.getString("ap_mat");
				this.mensajeSalida.writeObject(nombreUser);
				Main.vistaServer.setTextArea("El cliente ingreso como administrador. \n \n");	
	
			} else if(this.reasesorAca.next()) {
				Login.setTipoUsuario("Academico");
				this.mensajeSalida.writeObject("Academico");
				this.nombreUser = this.reasesorAca.getString("nombre") + " " + this.reasesorAca.getString("ap_pat") + " " + this.reasesorAca.getString("ap_mat");
				this.mensajeSalida.writeObject(nombreUser);	
				
				this.valoresConsulta = new Object[9];
	
				modelo = new DefaultTableModel();
				modelo.addColumn("Matricula");
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido Paterno");
				modelo.addColumn("Apellido Materno");
				modelo.addColumn("Teléfono");
				modelo.addColumn("Correo");
				modelo.addColumn("Proyecto");
				modelo.addColumn("Carrera");
				this.alumno = conex.consultar("select * from alumno where id_asesorAca = " + Login.getMatricula());
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
				this.mensajeSalida.writeObject(this.modelo);
				Main.vistaServer.setTextArea("El cliente ingreso como Asesor Industrial. \n \n");		
				} else if(this.reasesorInd.next()) {
					Login.setTipoUsuario("Industrial");
					this.mensajeSalida.writeObject("Industrial");
					this.nombreUser = this.reasesorInd.getString("nombre") + " " + this.reasesorInd.getString("ap_pat") + " " + this.reasesorInd.getString("ap_mat");
					this.mensajeSalida.writeObject(nombreUser);
					
					this.valoresConsulta = new Object[8];
		
					modelo = new DefaultTableModel();
					modelo.addColumn("Matricula");
					modelo.addColumn("Nombre");
					modelo.addColumn("Apellido Paterno");
					modelo.addColumn("Apellido Materno");
					modelo.addColumn("Teléfono");
					modelo.addColumn("Correo");
					modelo.addColumn("Proyecto");
					modelo.addColumn("Carrera");
					this.alumno = conex.consultar("select * from alumno where id_asesorInd = " + Login.getMatricula());
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
					this.mensajeSalida.writeObject(this.modelo);
					Main.vistaServer.setTextArea("El cliente ingreso como Asesor Industrial. \n \n");
					
			}else {
				Main.vistaServer.setTextArea("El cliente tuvo un error al iniciar Sesión. \n \n");
				this.mensajeSalida.writeObject("Error");	
			}
			
		this.cliente.close();
		} catch (IOException | SQLException | ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en el SocketServidorLogin metodo realizarLogin(): " + e.getMessage());
		}
	}
}
