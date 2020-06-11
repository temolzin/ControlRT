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
import vista.BuscarAdministrador;

public class SocketBuscarActualizarAdministrador {
	public static BuscarAdministrador vistaBuscarAdministrador;
	public static Socket cliente;
	private ObjectInputStream mensajeEntrada;
	private ObjectOutputStream mensajeSalida;
	private DefaultTableModel modelo;
	private int filaSeleccionada;
	private String matricula, nombreAdministrador, ap_pat, ap_mat, correo, telefono;
	@SuppressWarnings("unused")
	private SocketEliminarAdministrador eliminar;

	public SocketBuscarActualizarAdministrador() {
		SocketBuscarActualizarAdministrador.vistaBuscarAdministrador = new BuscarAdministrador();
		SocketBuscarActualizarAdministrador.vistaBuscarAdministrador.getTextFieldBuscarAdmin().setEditable(false);
		SocketBuscarActualizarAdministrador.vistaBuscarAdministrador.setVisible(true);
		this.eliminar = new SocketEliminarAdministrador();

		this.consultarAdministrador();
		this.editarAdministrador();
		this.mostrarAdministrador();
		this.buscarAdministradorporNombre();

		try {
			if (SocketBuscarActualizarAdministrador.cliente != null) {
				SocketBuscarActualizarAdministrador.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}

	private void consultarAdministrador() {
		SocketBuscarActualizarAdministrador.vistaBuscarAdministrador.btnBuscarAdmin
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							cliente = new Socket("localhost", 5010);
							mensajeEntrada = new ObjectInputStream(cliente.getInputStream());

							modelo = (DefaultTableModel) mensajeEntrada.readObject();

							vistaBuscarAdministrador.getTableAdmin().setModel(modelo);
							vistaBuscarAdministrador.getTextFieldBuscarAdmin().setEditable(true);
							vistaBuscarAdministrador.btnBuscarAdmin.setEnabled(false);
						} catch (IOException e1) {
							System.err.println("Error en el SocketBuscarActualizarAdministrador: " + e1.getMessage());
						} catch (ClassNotFoundException e1) {
							System.err.println("Error en el SocketBuscarActualizarAdministrador: " + e1.getMessage());
						}
					}
				});
	}

	private void editarAdministrador() {
		SocketBuscarActualizarAdministrador.vistaBuscarAdministrador.btnEditarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (SocketBuscarActualizarAdministrador.vistaBuscarAdministrador.getTableAdmin().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Necesitas seleccionar algún registro en la tabla.",
						"Error", JOptionPane.ERROR_MESSAGE);
						} else {
							if (SocketBuscarActualizarAdministrador.vistaBuscarAdministrador.validarEditarAdministrador() == true) {
							
							mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());
							mensajeSalida.writeObject(vistaBuscarAdministrador.getTextFieldMatriculaAdmin().getText());
							mensajeSalida.writeObject(vistaBuscarAdministrador.getTextFieldNombreAdmin().getText());
							mensajeSalida.writeObject(vistaBuscarAdministrador.getTextFieldPaternoAdmin().getText());
							mensajeSalida.writeObject(vistaBuscarAdministrador.getTextFieldMaternoAdmin().getText());
							mensajeSalida.writeObject(vistaBuscarAdministrador.getTextFieldTelefonoAdmin().getText());
							mensajeSalida.writeObject(vistaBuscarAdministrador.getTextFieldCorreoAdmin().getText());
								if (mensajeEntrada.readObject().equals("Entro")) {
									JOptionPane.showMessageDialog(null,"Registro actualizado satisfactoriamente, esta ventana se reiniciará para guardar los cambios.",
									"Exito", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/imagenes/Correcto.png"));
									vistaBuscarAdministrador.dispose();
									new SocketBuscarActualizarAdministrador();
									cliente.close();
								} else {
									JOptionPane.showMessageDialog(null,"Error al actualizar los datos, consulte al programador.", "Error",JOptionPane.ERROR_MESSAGE);
									vistaBuscarAdministrador.dispose();
									new SocketBuscarActualizarAdministrador();
									cliente.close();
								}
							  }
							}
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null,
									"Error en SocketBuscarActualizarAdministrador: " + e1.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (ClassNotFoundException e1) {
							JOptionPane.showMessageDialog(null,
									"Error en SocketBuscarActualizarAdministrador: " + e1.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
	}

	private void mostrarAdministrador() {
		SocketBuscarActualizarAdministrador.vistaBuscarAdministrador.getTableAdmin()
				.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						filaSeleccionada = vistaBuscarAdministrador.getTableAdmin().getSelectedRow();
						matricula = (String) vistaBuscarAdministrador.getTableAdmin().getValueAt(filaSeleccionada, 0);
						nombreAdministrador = (String) vistaBuscarAdministrador.getTableAdmin()
								.getValueAt(filaSeleccionada, 1);
						ap_pat = (String) vistaBuscarAdministrador.getTableAdmin().getValueAt(filaSeleccionada, 2);
						ap_mat = (String) vistaBuscarAdministrador.getTableAdmin().getValueAt(filaSeleccionada, 3);
						correo = (String) vistaBuscarAdministrador.getTableAdmin().getValueAt(filaSeleccionada, 4);
						telefono = (String) vistaBuscarAdministrador.getTableAdmin().getValueAt(filaSeleccionada, 5);

						vistaBuscarAdministrador.getTextFieldMatriculaAdmin().setText(matricula);
						vistaBuscarAdministrador.getTextFieldNombreAdmin().setText(nombreAdministrador);
						vistaBuscarAdministrador.getTextFieldPaternoAdmin().setText(ap_pat);
						vistaBuscarAdministrador.getTextFieldMaternoAdmin().setText(ap_mat);
						vistaBuscarAdministrador.getTextFieldCorreoAdmin().setText(correo);
						vistaBuscarAdministrador.getTextFieldTelefonoAdmin().setText(telefono);
					}
				});
	}

	private void buscarAdministradorporNombre() {
		SocketBuscarActualizarAdministrador.vistaBuscarAdministrador.getTextFieldBuscarAdmin()
				.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						TableRowSorter<TableModel> trsFiltro = new TableRowSorter<TableModel>(modelo);
						vistaBuscarAdministrador.getTableAdmin().setRowSorter(trsFiltro);
						trsFiltro.setRowFilter(
								RowFilter.regexFilter(vistaBuscarAdministrador.getTextFieldBuscarAdmin().getText(), 1));

					}
				});
	}

}
