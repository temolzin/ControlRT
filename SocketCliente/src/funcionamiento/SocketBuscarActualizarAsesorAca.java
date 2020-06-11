package funcionamiento;

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

import vista.BuscarAcademico;

public class SocketBuscarActualizarAsesorAca {
	public static BuscarAcademico vistaBuscarAcademico;
	public static Socket cliente;
	private ObjectInputStream mensajeEntrada;
	private ObjectOutputStream mensajeSalida;
	private DefaultTableModel modelo;
	private int filaSeleccionada;
	private String matricula, nombreAcademico, ap_pat, ap_mat, correo, telefono, password;
	@SuppressWarnings("unused")
	private SocketEliminarAsesorAca eliminar;

	public SocketBuscarActualizarAsesorAca() {
		SocketBuscarActualizarAsesorAca.vistaBuscarAcademico = new BuscarAcademico();
		SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.getTextBuscarAcademico().setEditable(false);
		SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.setVisible(true);
		this.eliminar = new SocketEliminarAsesorAca();

		this.consultarAsesoresAca();
		this.editarAsesorAca();
		this.mostrarAsesorAca();
		this.buscarAsesorAcaporNombre();

		try {
			if (SocketBuscarActualizarAsesorAca.cliente != null) {
				SocketBuscarActualizarAsesorAca.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}

	private void consultarAsesoresAca() {
		SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.btnBuscarAcademico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente = new Socket("localhost", 5004);
					mensajeEntrada = new ObjectInputStream(cliente.getInputStream());

					modelo = (DefaultTableModel) mensajeEntrada.readObject();

					vistaBuscarAcademico.getTableAcademico().setModel(modelo);
					vistaBuscarAcademico.getTextBuscarAcademico().setEditable(true);
					vistaBuscarAcademico.btnBuscarAcademico.setEnabled(false);
				} catch (IOException e1) {
					System.err.println("Error en el SocketBuscarActualizarAsesorAca: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					System.err.println("Error en el SocketBuscarActualizarAsesorAca: " + e1.getMessage());
				}
			}
		});
	}

	private void editarAsesorAca() {
		SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.btnEditarAcademico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.getTableAcademico()
							.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Necesitas seleccionar algún registro en la tabla.",
								"Error", JOptionPane.ERROR_MESSAGE);

					} else {
						if (SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.validarEditarAcademico() == true) {
						mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());

						mensajeSalida.writeObject(vistaBuscarAcademico.getTextFieldMatriculaAcademico().getText());
						mensajeSalida.writeObject(vistaBuscarAcademico.getTextFieldNombreAcademico().getText());
						mensajeSalida.writeObject(vistaBuscarAcademico.getTextFieldPaternoAcademico().getText());
						mensajeSalida.writeObject(vistaBuscarAcademico.getTextFieldMaternoAcademico().getText());
						mensajeSalida.writeObject(vistaBuscarAcademico.getTextFieldCorreoAcademico().getText());
						mensajeSalida.writeObject(vistaBuscarAcademico.getTextFieldTelefonoAcademico().getText());
						mensajeSalida.writeObject(vistaBuscarAcademico.getJtfPassword().getText());

						if (mensajeEntrada.readObject().equals("Entro")) {
							JOptionPane.showMessageDialog(null,
									"Registro actualizado satisfactoriamente, esta ventana se reiniciará para guardar los cambios.",
									"Exito", JOptionPane.INFORMATION_MESSAGE,
									new ImageIcon("src/imagenes/Correcto.png"));
							vistaBuscarAcademico.dispose();
							new SocketBuscarActualizarAsesorAca();
							cliente.close();
						} else {
							JOptionPane.showMessageDialog(null,
									"Error al actualizar los datos, consulte al programador.", "Error",
									JOptionPane.ERROR_MESSAGE);
							vistaBuscarAcademico.dispose();
							new SocketBuscarActualizarAsesorAca();
							cliente.close();
						}
						}
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error en SocketBuscarActualizarAsesorAca: " + e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Error en SocketBuscarActualizarAsesorAca: " + e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private void mostrarAsesorAca() {
		SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.getTableAcademico().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				filaSeleccionada = vistaBuscarAcademico.getTableAcademico().getSelectedRow();
				matricula = (String) vistaBuscarAcademico.getTableAcademico().getValueAt(filaSeleccionada, 0);
				nombreAcademico = (String) vistaBuscarAcademico.getTableAcademico().getValueAt(filaSeleccionada, 1);
				ap_pat = (String) vistaBuscarAcademico.getTableAcademico().getValueAt(filaSeleccionada, 2);
				ap_mat = (String) vistaBuscarAcademico.getTableAcademico().getValueAt(filaSeleccionada, 3);
				correo = (String) vistaBuscarAcademico.getTableAcademico().getValueAt(filaSeleccionada, 4);
				telefono = (String) vistaBuscarAcademico.getTableAcademico().getValueAt(filaSeleccionada, 5);
				password = (String) vistaBuscarAcademico.getTableAcademico().getValueAt(filaSeleccionada, 6);

				vistaBuscarAcademico.getTextFieldMatriculaAcademico().setText(matricula);
				vistaBuscarAcademico.getTextFieldNombreAcademico().setText(nombreAcademico);
				vistaBuscarAcademico.getTextFieldPaternoAcademico().setText(ap_pat);
				vistaBuscarAcademico.getTextFieldMaternoAcademico().setText(ap_mat);
				vistaBuscarAcademico.getTextFieldCorreoAcademico().setText(correo);
				vistaBuscarAcademico.getTextFieldTelefonoAcademico().setText(telefono);
				vistaBuscarAcademico.getJtfPassword().setText(password);
			}
		});
	}

	private void buscarAsesorAcaporNombre() {
		SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.getTextBuscarAcademico().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				TableRowSorter<TableModel> trsFiltro = new TableRowSorter<TableModel>(modelo);
				vistaBuscarAcademico.getTableAcademico().setRowSorter(trsFiltro);
				trsFiltro.setRowFilter(
						RowFilter.regexFilter(vistaBuscarAcademico.getTextBuscarAcademico().getText(), 1));

			}
		});
	}

}
