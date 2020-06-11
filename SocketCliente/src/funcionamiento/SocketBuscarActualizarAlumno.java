package funcionamiento;
/**
 * Clase que muestra los datos del alumno y los edita.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import vista.BuscarAlumno;

public class SocketBuscarActualizarAlumno {
	public static BuscarAlumno vistaBuscarAlumno;
	public static Socket cliente;
	private ObjectInputStream mensajeEntrada;
	private ObjectOutputStream mensajeSalida;
	private DefaultTableModel modelo;
	private int filaSeleccionada;
	private String matricula, nombreAlumno, ap_pat, ap_mat, correo, telefono, password, proyecto, division, carrera, periodoCuatrimestre;
	private String asesorInd, asesorAca;
	private SocketEliminarAlumno eliminar;

	public SocketBuscarActualizarAlumno() {
		SocketBuscarActualizarAlumno.vistaBuscarAlumno = new BuscarAlumno();
		SocketBuscarActualizarAlumno.vistaBuscarAlumno.getTextFieldBuscarAlumno().setEditable(false);
		SocketBuscarActualizarAlumno.vistaBuscarAlumno.setVisible(true);
		this.eliminar = new SocketEliminarAlumno();

		this.consultarAlumno();
		this.editarAlumno();
		this.mostrarAlumno();
		this.buscarAlumnoporNombre();

		try {
			if (SocketBuscarActualizarAlumno.cliente != null) {
				SocketBuscarActualizarAlumno.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}
	
	public ObjectInputStream getMensajeEntrada() {
		return mensajeEntrada;
	}

	public void setMensajeEntrada(ObjectInputStream mensajeEntrada) {
		this.mensajeEntrada = mensajeEntrada;
	}

	public ObjectOutputStream getMensajeSalida() {
		return mensajeSalida;
	}

	public void setMensajeSalida(ObjectOutputStream mensajeSalida) {
		this.mensajeSalida = mensajeSalida;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public int getFilaSeleccionada() {
		return filaSeleccionada;
	}

	public void setFilaSeleccionada(int filaSeleccionada) {
		this.filaSeleccionada = filaSeleccionada;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getAp_pat() {
		return ap_pat;
	}

	public void setAp_pat(String ap_pat) {
		this.ap_pat = ap_pat;
	}

	public String getAp_mat() {
		return ap_mat;
	}

	public void setAp_mat(String ap_mat) {
		this.ap_mat = ap_mat;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getPeriodoCuatrimestre() {
		return periodoCuatrimestre;
	}

	public void setPeriodoCuatrimestre(String periodoCuatrimestre) {
		this.periodoCuatrimestre = periodoCuatrimestre;
	}

	public String getAsesorInd() {
		return asesorInd;
	}

	public void setAsesorInd(String asesorInd) {
		this.asesorInd = asesorInd;
	}

	public String getAsesorAca() {
		return asesorAca;
	}

	public void setAsesorAca(String asesorAca) {
		this.asesorAca = asesorAca;
	}

	public SocketEliminarAlumno getEliminar() {
		return eliminar;
	}

	public void setEliminar(SocketEliminarAlumno eliminar) {
		this.eliminar = eliminar;
	}

	/**
	 * Metodo que se conecta al servidor por medio del puerto 5025,
	 * para mostrar los datos del alumno en la tabla de la clase BuscarAlumno.
	 */
	private void consultarAlumno() {
		SocketBuscarActualizarAlumno.vistaBuscarAlumno.btnBuscarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente = new Socket("localhost", 5025);
					mensajeEntrada = new ObjectInputStream(cliente.getInputStream());

					modelo = (DefaultTableModel) mensajeEntrada.readObject();

					vistaBuscarAlumno.getTableAlumno().setModel(modelo);
					vistaBuscarAlumno.getTextFieldBuscarAlumno().setEditable(true);
					vistaBuscarAlumno.btnBuscarAlumno.setEnabled(false);
				} catch (IOException e1) {
					System.err.println("Error en el SocketBuscarActualizarAlumno: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					System.err.println("Error en el SocketBuscarActualizarAlumno: " + e1.getMessage());
				}
			}
		});
	}
	/**
	 * Método que envia los datos de la vista al servidor para ser editados.
	 */
	private void editarAlumno() {
		SocketBuscarActualizarAlumno.vistaBuscarAlumno.btnEditarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if(SocketBuscarActualizarAlumno.vistaBuscarAlumno.getTableAlumno().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Necesitas seleccionar algún registro en la tabla.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						if (SocketBuscarActualizarAlumno.vistaBuscarAlumno.validarEditarAlumno() == true) {
							mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());

							mensajeSalida.writeObject(vistaBuscarAlumno.getTextMatriculaAlumno().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getTextNombreAlumno().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getTextPaternoAlumno().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getTextMaternoAlumno().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getPasswordAlumno().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getTextTelefonoAlumno().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getTextCorreoAlumno().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getTextProyectoAlumno().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getComboDivision().getSelectedItem());
							mensajeSalida.writeObject(vistaBuscarAlumno.getComboCarrera().getSelectedItem());
							mensajeSalida.writeObject(vistaBuscarAlumno.getComboCuatrimestre().getSelectedItem());
							mensajeSalida.writeObject(vistaBuscarAlumno.getJtfAsesorInd().getText());
							mensajeSalida.writeObject(vistaBuscarAlumno.getJtfAsesorAca().getText());

							if (mensajeEntrada.readObject().equals("Entro")) {
								JOptionPane.showMessageDialog(null,
										"Registro actualizado satisfactoriamente, esta ventana se reiniciará para guardar los cambios.",
										"Exito", JOptionPane.INFORMATION_MESSAGE,
										new ImageIcon("src/imagenes/Correcto.png"));
								vistaBuscarAlumno.dispose();
								new SocketBuscarActualizarAlumno();
								cliente.close();
							} else {
								JOptionPane.showMessageDialog(null,
										"Error al actualizar, alguna matricula de los asesores, no existe en la base de datos, revisa de nuevo", "Error",
										JOptionPane.ERROR_MESSAGE);
								vistaBuscarAlumno.dispose();
								new SocketBuscarActualizarAlumno();
								cliente.close();
							}
						}
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error en SocketBuscarActualizarAlumno: " + e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Error en SocketBuscarActualizarAlumno: " + e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	/**
	 * Metodo que al seleccionar una fila en la tabla de clase BuscarAlumno,
	 * muestra todos los datos de la selección en JtextField y ComboBox.
	 */
	private void mostrarAlumno() {
		SocketBuscarActualizarAlumno.vistaBuscarAlumno.getTableAlumno().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				filaSeleccionada = vistaBuscarAlumno.getTableAlumno().getSelectedRow();
				
				matricula = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 0);
				nombreAlumno = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 1);
				ap_pat = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 2);
				ap_mat = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 3);
				password = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 4);
				telefono = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 5);
				correo = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 6);
				proyecto = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 7);
				division = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 8);
				carrera = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 9);
				periodoCuatrimestre = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 10);
				asesorInd = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 11);
				asesorAca = (String) vistaBuscarAlumno.getTableAlumno().getValueAt(filaSeleccionada, 12);

				vistaBuscarAlumno.getTextMatriculaAlumno().setText(matricula);
				vistaBuscarAlumno.getTextNombreAlumno().setText(nombreAlumno);
				vistaBuscarAlumno.getTextPaternoAlumno().setText(ap_pat);
				vistaBuscarAlumno.getTextMaternoAlumno().setText(ap_mat);
				vistaBuscarAlumno.getPasswordAlumno().setText(password);
				vistaBuscarAlumno.getTextTelefonoAlumno().setText(telefono);
				vistaBuscarAlumno.getTextCorreoAlumno().setText(correo);
				vistaBuscarAlumno.getTextProyectoAlumno().setText(proyecto);
				vistaBuscarAlumno.getComboDivision().setSelectedItem(division);
				vistaBuscarAlumno.getComboCarrera().setSelectedItem(carrera);
				vistaBuscarAlumno.getComboCuatrimestre().setSelectedItem(periodoCuatrimestre);
				vistaBuscarAlumno.getJtfAsesorInd().setText(asesorInd);
				vistaBuscarAlumno.getJtfAsesorAca().setText(asesorAca);
			}
		});
	}
	/**
	 * Metodo que consulta al escribir en un JtextField, los valores de la tabla de la clase BuscarAlumno.
	 */
	private void buscarAlumnoporNombre() {
		SocketBuscarActualizarAlumno.vistaBuscarAlumno.getTextFieldBuscarAlumno().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				TableRowSorter<TableModel> trsFiltro = new TableRowSorter<TableModel>(modelo);
				SocketBuscarActualizarAlumno.vistaBuscarAlumno.getTableAlumno().setRowSorter(trsFiltro);
				trsFiltro.setRowFilter(
						RowFilter.regexFilter(SocketBuscarActualizarAlumno.vistaBuscarAlumno.getTextFieldBuscarAlumno().getText(), 1));

			}
		});
	}

}
