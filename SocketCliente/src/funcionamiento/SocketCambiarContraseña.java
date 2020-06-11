package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import vista.CambiarContrase�a;

public class SocketCambiarContrase�a {
	CambiarContrase�a vistaCambiarContrase�a;
	Socket cliente;
	DataInputStream mensajeEntrada;
	DataOutputStream mensajeSalida;

	public SocketCambiarContrase�a() {
		this.vistaCambiarContrase�a = new CambiarContrase�a();
		this.vistaCambiarContrase�a.setVisible(true);
		this.cambiarContrase�a();
	}

	private void cambiarContrase�a() {

		this.vistaCambiarContrase�a.btnActualizar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (vistaCambiarContrase�a.validarContrase�a() == true) {
					try {
						cliente = new Socket("localhost", 5012);
						mensajeSalida = new DataOutputStream(cliente.getOutputStream());
						mensajeSalida.writeUTF(vistaCambiarContrase�a.getPasswordAdmin().getText());

						mensajeEntrada = new DataInputStream(cliente.getInputStream());
						if (mensajeEntrada.readUTF().equals("Correcto")) {
							JOptionPane.showMessageDialog(null, "Contrase�a actualizada correctamente", "Exito",
									JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/Correcto.png"));
							vistaCambiarContrase�a.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Error al cambiar contrase�a, contacte al programador.",
									"Error", JOptionPane.ERROR_MESSAGE);
							vistaCambiarContrase�a.dispose();
						}
						cliente.close();
					} catch (IOException e1) {
						System.err.println("Error al cambiar contrase�a: " + e1.getMessage());
					}
				}
			}
		});

	}

}
