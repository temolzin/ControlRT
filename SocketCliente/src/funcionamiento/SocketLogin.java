package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import main.Main;
import vista.Administrador;
import vista.Alumno;
import vista.AsesorAcademico;
import vista.AsesorIndustrial;

public class SocketLogin {
	Socket cliente;
	ObjectOutputStream mensajeSalida;
	ObjectInputStream mensajeEntrada;
	String respuestaServer;
	String nombreUser;
	String nombreAsesorInd;
	String nombreAsesorAca;
	String nombreProyecto;
	DefaultTableModel modelo;
	public static Alumno vistaAlumno;
	public static Administrador vistaAdmin;
	public static AsesorAcademico vistaAsesorAca;
	public static AsesorIndustrial vistaAsesorInd;
	
	public SocketLogin() {
		this.iniciarSesion();
	}
	/**
	 * Metodo que manda la matricula y el password al servidor por medio del puerto 5000,
	 * y evalua la respuesta del servidor e inicia sesión.
	 */
	private void iniciarSesion() {
		Main.frameSesion.btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event) {
				try {
					cliente = new Socket("localhost", 5000);
					mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());
					mensajeSalida.writeObject(Main.frameSesion.getPasswordUsuario().getText());
					mensajeSalida.writeObject(Main.frameSesion.getTextMatricula().getText());

					mensajeEntrada = new ObjectInputStream(cliente.getInputStream());
					respuestaServer = (String) mensajeEntrada.readObject();

					if (respuestaServer.equals("Alumno")) {
						nombreUser = (String) mensajeEntrada.readObject();
						nombreProyecto = (String) mensajeEntrada.readObject();
						nombreAsesorAca = (String) mensajeEntrada.readObject();
						nombreAsesorInd = (String) mensajeEntrada.readObject();
						SocketLogin.vistaAlumno = new Alumno();
						SocketLogin.vistaAlumno.getJlbNombreAlumno().setText(nombreUser);
						SocketLogin.vistaAlumno.getLblNombeAsesorAcademico().setText(nombreAsesorAca);
						SocketLogin.vistaAlumno.getLblNombreAsesorIndustrial().setText(nombreAsesorInd);
						SocketLogin.vistaAlumno.getLblNombreProyecto().setText(nombreProyecto);
						SocketLogin.vistaAlumno.setVisible(true);
						Main.frameSesion.dispose();
						Main.frameSesion.getTextMatricula().setText("");
						Main.frameSesion.getPasswordUsuario().setText("");

					} else if (respuestaServer.equals("Administrador")) {

						nombreUser = (String) mensajeEntrada.readObject();
						vistaAdmin = new Administrador();
						vistaAdmin.getJlbNombreAdmin().setText(nombreUser);
						vistaAdmin.setVisible(true);
						Main.frameSesion.dispose();
						Main.frameSesion.getTextMatricula().setText("");
						Main.frameSesion.getPasswordUsuario().setText("");

					} else if(respuestaServer.equals("Academico")) {
						nombreUser = (String) mensajeEntrada.readObject();
						vistaAsesorAca = new AsesorAcademico();
						vistaAsesorAca.getJlbNombreAcademico().setText(nombreUser);
						vistaAsesorAca.setVisible(true);
						Main.frameSesion.dispose();
						Main.frameSesion.getTextMatricula().setText("");
						Main.frameSesion.getPasswordUsuario().setText("");
					
						modelo = (DefaultTableModel) mensajeEntrada.readObject();
						vistaAsesorAca.getTableAlumnosAca().setModel(modelo);
						buscarAlumnoporNombreAcademico();
						
					} else if(respuestaServer.equals("Industrial")) {
						nombreUser = (String) mensajeEntrada.readObject();
						vistaAsesorInd = new AsesorIndustrial();
						vistaAsesorInd.getJlbNombreIndustrial().setText(nombreUser);
						vistaAsesorInd.setVisible(true);
						Main.frameSesion.dispose();
						Main.frameSesion.getTextMatricula().setText("");
						Main.frameSesion.getPasswordUsuario().setText("");
						
						modelo = (DefaultTableModel) mensajeEntrada.readObject();
						vistaAsesorInd.getTableAlumnosIndu().setModel(modelo);
						buscarAlumnoporNombreIndustrial();
						
					} else if (respuestaServer.equals("Error")) {
						JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña Incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
						Main.frameSesion.getTextMatricula().setText("");
						Main.frameSesion.getPasswordUsuario().setText("");
					}

					cliente.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(Main.frameSesion.btnEntrar,
							"Error el servidor a cerrado sesión: " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
					System.err.println("Error en el socket cliente: " + e.getMessage());
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(Main.frameSesion.btnEntrar,
							"Error el servidor a cerrado sesión: " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
					System.err.println("Error en el socket cliente: " + e.getMessage());
				}
			}
		});
	}
	
	/**
	 * Metodo para buscar Alumnos cuando el Asesor Académico ha iniciado sesión
	 */
	private void buscarAlumnoporNombreAcademico() {
		vistaAsesorAca.getTextBuscarAlumnoAca().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				TableRowSorter<TableModel> trsFiltro = new TableRowSorter<TableModel>(modelo);
				vistaAsesorAca.getTableAlumnosAca().setRowSorter(trsFiltro);
				trsFiltro.setRowFilter(
						RowFilter.regexFilter(vistaAsesorAca.getTextBuscarAlumnoAca().getText(), 1));
			}
		});
	}
	
	/**
	 * Metodo para buscar Alumnos cuando el Asesor Industrial ha iniciado sesión
	 */
	private void buscarAlumnoporNombreIndustrial() {
		vistaAsesorInd.getTextBuscarAlumnoIndu().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				TableRowSorter<TableModel> trsFiltro = new TableRowSorter<TableModel>(modelo);
				vistaAsesorInd.getTableAlumnosIndu().setRowSorter(trsFiltro);
				trsFiltro.setRowFilter(
						RowFilter.regexFilter(vistaAsesorInd.getTextBuscarAlumnoIndu().getText(), 1));
			}
		});
	}
}
