package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SocketEliminarAsesorAca {

	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;

	public SocketEliminarAsesorAca() {
		this.eliminarAsesorAca();
	}

	private void eliminarAsesorAca() {
		SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.btnEliminarAcademico
				.addActionListener(new ActionListener() {
					@SuppressWarnings({ "unused" })
					public void actionPerformed(ActionEvent e) {
						try {
							if (SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.getTableAcademico().getSelectedRow() == -1) {
								JOptionPane.showMessageDialog(null, "Necesitas seleccionar algún registro en la tabla.",
										"Error", JOptionPane.ERROR_MESSAGE);
							} else {
								if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este registro?",
										"Confimar", 1) == 0) {
									cliente = new Socket("localhost", 5007);

									mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());

									mensajeSalida.writeObject(SocketBuscarActualizarAsesorAca.vistaBuscarAcademico
											.getTextFieldMatriculaAcademico().getText());

									mensajeEntrada = new ObjectInputStream(cliente.getInputStream());
									if (mensajeEntrada.readObject().equals("Elimino")) {
										JOptionPane.showMessageDialog(null,
												"Eliminado satisfactoriamente, esta ventana se reiniciará para guardar los cambios.",
												"Exito", JOptionPane.INFORMATION_MESSAGE,
												new ImageIcon("src/imagenes/Correcto.png"));

										SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.dispose();
										SocketBuscarActualizarAsesorAca actualizarAsesorAca = new SocketBuscarActualizarAsesorAca();
										SocketBuscarActualizarAsesorAca.cliente.close();
									} else {
										JOptionPane.showMessageDialog(null,
												"Error al eliminar, porque este Asesor Acádemico esta vinculado a uno o varios alumnos.",
												"Error", JOptionPane.ERROR_MESSAGE);
										SocketBuscarActualizarAsesorAca.vistaBuscarAcademico.dispose();
										SocketBuscarActualizarAsesorAca actualizarAsesorAca = new SocketBuscarActualizarAsesorAca();
										SocketBuscarActualizarAsesorAca.cliente.close();
									}
									cliente.close();
								}
							}
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null,
									"Error en SocketEliminarAsesorAca metodo eliminarAsesorAcademico: "
											+ e1.getMessage(),
									"Error", JOptionPane.ERROR_MESSAGE);
						} catch (ClassNotFoundException e1) {
							JOptionPane.showMessageDialog(null,
									"Error en SocketEliminarAsesorAca metodo eliminarAsesorAcademico: "
											+ e1.getMessage(),
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
	}
}
