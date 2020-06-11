package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SocketEliminarAlumno {

	Socket cliente;
	ObjectInputStream mensajeEntrada;
	ObjectOutputStream mensajeSalida;

	public SocketEliminarAlumno() {
		this.eliminarAlumno();
	}

	private void eliminarAlumno() {
		SocketBuscarActualizarAlumno.vistaBuscarAlumno.btnEliminarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				try {
					if (SocketBuscarActualizarAlumno.vistaBuscarAlumno.getTableAlumno().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Necesitas seleccionar algún registro en la tabla.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este registro?", "Confimar",
								1) == 0) {
							cliente = new Socket("localhost", 5026);

							mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());

							mensajeSalida.writeObject(
									SocketBuscarActualizarAlumno.vistaBuscarAlumno.getTextMatriculaAlumno().getText());

							mensajeEntrada = new ObjectInputStream(cliente.getInputStream());
							if (mensajeEntrada.readObject().equals("Elimino")) {
								JOptionPane.showMessageDialog(null,
										"Eliminado satisfactoriamente, esta ventana se reiniciará para guardar los cambios.",
										"Exito", JOptionPane.INFORMATION_MESSAGE,
										new ImageIcon("src/imagenes/Correcto.png"));

								SocketBuscarActualizarAlumno.vistaBuscarAlumno.dispose();
								SocketBuscarActualizarAlumno actualizarAlumno = new SocketBuscarActualizarAlumno();
								SocketBuscarActualizarAlumno.cliente.close();
							} else {
								JOptionPane.showMessageDialog(null, "Error al eliminar alumno.", "Error",
										JOptionPane.ERROR_MESSAGE);
								SocketBuscarActualizarAlumno.vistaBuscarAlumno.dispose();
								SocketBuscarActualizarAlumno actualizarAlumno = new SocketBuscarActualizarAlumno();
								SocketBuscarActualizarAlumno.cliente.close();
							}
							cliente.close();
						}
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,
							"Error en SocketEliminarAlumno metodo eliminarAlumno: " + e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null,
							"Error en SocketEliminarAlumno metodo eliminarAlumno: " + e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
