package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SocketEliminarAsesorInd {
	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;

	public SocketEliminarAsesorInd() {
		this.eliminarAsesorAca();
	}

	private void eliminarAsesorAca() {
		SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.btnEliminarIndustrial
				.addActionListener(new ActionListener() {
					@SuppressWarnings("unused")
					public void actionPerformed(ActionEvent e) {
						try {
							if (SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.getTableIndustrial().getSelectedRow() == -1) {
								JOptionPane.showMessageDialog(null, "Necesitas seleccionar algún registro en la tabla.",
										"Error", JOptionPane.ERROR_MESSAGE);
							} else {
								if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este registro?",
										"Confimar", 1) == 0) {
									cliente = new Socket("localhost", 5009);

									mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());

									mensajeSalida.writeObject(SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial
											.getTextFieldMatriculaIndustrial().getText());

									mensajeEntrada = new ObjectInputStream(cliente.getInputStream());
									if (mensajeEntrada.readObject().equals("Elimino")) {
										JOptionPane.showMessageDialog(null,
												"Eliminado satisfactoriamente, esta ventana se reiniciará para guardar los cambios.",
												"Exito", JOptionPane.INFORMATION_MESSAGE,
												new ImageIcon("src/imagenes/Correcto.png"));

										SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.dispose();
										SocketBuscarActualizarAsesorInd actualizarAsesorInd = new SocketBuscarActualizarAsesorInd();
										SocketBuscarActualizarAsesorInd.cliente.close();
									} else {
										JOptionPane.showMessageDialog(null,
												"Error al eliminar, porque este Asesor Acádemico esta vinculado a uno o varios alumnos.",
												"Error", JOptionPane.ERROR_MESSAGE);
										SocketBuscarActualizarAsesorInd.vistaBuscarIndustrial.dispose();
										SocketBuscarActualizarAsesorInd actualizarAsesorInd = new SocketBuscarActualizarAsesorInd();
										SocketBuscarActualizarAsesorInd.cliente.close();
									}
									cliente.close();
								}
							}
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null,
									"Error en SocketEliminarAsesorInd metodo eliminarAsesorIndustrial: "
											+ e1.getMessage(),
									"Error", JOptionPane.ERROR_MESSAGE);
						} catch (ClassNotFoundException e1) {
							JOptionPane.showMessageDialog(null,
									"Error en SocketEliminarAsesorAca metodo eliminarAsesorIndustrial: "
											+ e1.getMessage(),
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
	}
}
