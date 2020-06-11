package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vista.Avances;

public class SocketInsertarAvanceAlumno {
	Socket cliente;
	DataOutputStream mensajeSalida;
	DataInputStream mensajeEntrada;
	String respuestaServer;
	Avances vistaAvances;

	public SocketInsertarAvanceAlumno() {
		
			this.vistaAvances = new Avances();
			this.vistaAvances.setVisible(true);

			this.vistaAvances.btnRegistrarAvance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						cliente = new Socket("localhost", 5013);
						mensajeSalida = new DataOutputStream(cliente.getOutputStream());

						if (vistaAvances.validarAvances() == true) {
							
							mensajeSalida.writeUTF(vistaAvances.getTextAreaAvance().getText());
							mensajeSalida.writeUTF((String) vistaAvances.getComboSemana().getSelectedItem());

							mensajeEntrada = new DataInputStream(cliente.getInputStream());
							respuestaServer = mensajeEntrada.readUTF();

							if (respuestaServer.equals("Error")) {
								JOptionPane.showMessageDialog(null, "Error al insertar el avance, consulte al administrador", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null,
										"Los avances han sido guardados satisfactoriamente",
										"Datos Insertados Correctamente", JOptionPane.INFORMATION_MESSAGE,
										new ImageIcon("src/imagenes/Correcto.png"));
								vistaAvances.getTextAreaAvance().setText("");
								vistaAvances.getComboSemana().setSelectedItem("");
							}
						}
						cliente.close();
					} catch (IOException e1) {
						System.err.println("Error en InsertarAsesorInd en el cliente: " + e1.getMessage());
					}
				}
			});

	}
}
