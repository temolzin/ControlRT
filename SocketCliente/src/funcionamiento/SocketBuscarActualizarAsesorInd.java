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
import vista.BuscarIndustrial;

public class SocketBuscarActualizarAsesorInd {
	public static BuscarIndustrial vistaBuscarIndustrial;
	public static Socket cliente;
	private ObjectInputStream mensajeEntrada;
	private ObjectOutputStream mensajeSalida;
	private DefaultTableModel modelo;
	private int filaSeleccionada;
	private String matricula, nombreIndustrial, ap_pat, ap_mat, correo, telefono, password, empresa;
	@SuppressWarnings("unused")
	private SocketEliminarAsesorInd eliminar;

	public SocketBuscarActualizarAsesorInd() {
		SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial = new BuscarIndustrial();
		SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.getTextFieldBuscarIndustrial().setEditable(false);
		SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.setVisible(true);
		this.eliminar = new SocketEliminarAsesorInd();

		this.consultarAsesoresInd();
		this.editarAsesorInd();
		this.mostrarAsesorInd();
		this.buscarAsesorIndporNombre();
		
		try {
			if (SocketBuscarActualizarAsesorInd.cliente != null) {
				SocketBuscarActualizarAsesorInd.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}

	private void consultarAsesoresInd() {
		SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.btnBuscarIndustrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente = new Socket("localhost", 5008);
					mensajeEntrada = new ObjectInputStream(cliente.getInputStream());

					modelo = (DefaultTableModel) mensajeEntrada.readObject();

					vistaBuscarIndustrial.getTableIndustrial().setModel(modelo);
					vistaBuscarIndustrial.getTextFieldBuscarIndustrial().setEditable(true);
					vistaBuscarIndustrial.btnBuscarIndustrial.setEnabled(false);
				} catch (IOException e1) {
					System.err.println("Error en el SocketBuscarActualizarAsesorAca: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					System.err.println("Error en el SocketBuscarActualizarAsesorAca: " + e1.getMessage());
				}
			}
		});
	}

	private void editarAsesorInd() {
		SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.btnEditarIndustrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if(SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.getTableIndustrial().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Necesitas seleccionar algún registro en la tabla.",
								"Error", JOptionPane.ERROR_MESSAGE);
					
					} else {
						mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());
	
						mensajeSalida.writeObject(vistaBuscarIndustrial.getTextFieldMatriculaIndustrial().getText());
						mensajeSalida.writeObject(vistaBuscarIndustrial.getTextFieldNombreIndustrial().getText());
						mensajeSalida.writeObject(vistaBuscarIndustrial.getTextFieldPaternoIndustrial().getText());
						mensajeSalida.writeObject(vistaBuscarIndustrial.getTextFieldMaternoIndustrial().getText());
						mensajeSalida.writeObject(vistaBuscarIndustrial.getTextFieldEmpresa().getText());
						mensajeSalida.writeObject(vistaBuscarIndustrial.getTextFieldCorreo().getText());
						mensajeSalida.writeObject(vistaBuscarIndustrial.getTextFieldTelefonoIndustrial().getText());
						mensajeSalida.writeObject(vistaBuscarIndustrial.getJtfPassword().getText());
	
						if (mensajeEntrada.readObject().equals("Entro")) {
							JOptionPane.showMessageDialog(null,
									"Registro actualizado satisfactoriamente, esta ventana se reiniciará para guardar los cambios.",
									"Exito", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/Correcto.png"));
							vistaBuscarIndustrial.dispose();
							new SocketBuscarActualizarAsesorInd();
							cliente.close();
						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar los datos, consulte al programador.",
									"Error", JOptionPane.ERROR_MESSAGE);
							vistaBuscarIndustrial.dispose();
							new SocketBuscarActualizarAsesorInd();
							cliente.close();
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

	private void mostrarAsesorInd() {
		SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.getTableIndustrial().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				filaSeleccionada = vistaBuscarIndustrial.getTableIndustrial().getSelectedRow();
				
				matricula = (String) vistaBuscarIndustrial.getTableIndustrial().getValueAt(filaSeleccionada, 0);
				nombreIndustrial = (String) vistaBuscarIndustrial.getTableIndustrial().getValueAt(filaSeleccionada, 1);
				ap_pat = (String) vistaBuscarIndustrial.getTableIndustrial().getValueAt(filaSeleccionada, 2);
				ap_mat = (String) vistaBuscarIndustrial.getTableIndustrial().getValueAt(filaSeleccionada, 3);
				empresa = (String) vistaBuscarIndustrial.getTableIndustrial().getValueAt(filaSeleccionada, 4);
				correo = (String) vistaBuscarIndustrial.getTableIndustrial().getValueAt(filaSeleccionada, 5);
				telefono = (String) vistaBuscarIndustrial.getTableIndustrial().getValueAt(filaSeleccionada, 6);
				password = (String) vistaBuscarIndustrial.getTableIndustrial().getValueAt(filaSeleccionada, 7);

				vistaBuscarIndustrial.getTextFieldMatriculaIndustrial().setText(matricula);
				vistaBuscarIndustrial.getTextFieldNombreIndustrial().setText(nombreIndustrial);
				vistaBuscarIndustrial.getTextFieldPaternoIndustrial().setText(ap_pat);
				vistaBuscarIndustrial.getTextFieldMaternoIndustrial().setText(ap_mat);
				vistaBuscarIndustrial.getTextFieldEmpresa().setText(empresa);
				vistaBuscarIndustrial.getTextFieldCorreo().setText(correo);
				vistaBuscarIndustrial.getTextFieldTelefonoIndustrial().setText(telefono);
				vistaBuscarIndustrial.getJtfPassword().setText(password);
			}
		});
	}

	private void buscarAsesorIndporNombre() {
		SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.getTextFieldBuscarIndustrial().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				TableRowSorter<TableModel> trsFiltro = new TableRowSorter<TableModel>(modelo);
				vistaBuscarIndustrial.getTableIndustrial().setRowSorter(trsFiltro);
				trsFiltro.setRowFilter(
						RowFilter.regexFilter(vistaBuscarIndustrial.getTextFieldBuscarIndustrial().getText(), 1));

			}
		});
	}

}

