package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import vista.CambiarContraseña;

public class SocketCambiarContraseña {
	CambiarContraseña vistaCambiarContraseña;
	Socket cliente;
	DataInputStream mensajeEntrada;
	DataOutputStream mensajeSalida;

	public SocketCambiarContraseña() {
		this.vistaCambiarContraseña = new CambiarContraseña();
		this.vistaCambiarContraseña.setVisible(true);
		this.cambiarContraseña();
	}

	private void cambiarContraseña() {

		this.vistaCambiarContraseña.btnActualizar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (vistaCambiarContraseña.validarContraseña() == true) {
					try {
						cliente = new Socket("localhost", 5012);
						mensajeSalida = new DataOutputStream(cliente.getOutputStream());
						mensajeSalida.writeUTF(vistaCambiarContraseña.getPasswordAdmin().getText());

						mensajeEntrada = new DataInputStream(cliente.getInputStream());
						if (mensajeEntrada.readUTF().equals("Correcto")) {
							JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente", "Exito",
									JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/Correcto.png"));
							vistaCambiarContraseña.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Error al cambiar contraseña, contacte al programador.",
									"Error", JOptionPane.ERROR_MESSAGE);
							vistaCambiarContraseña.dispose();
						}
						cliente.close();
					} catch (IOException e1) {
						System.err.println("Error al cambiar contraseña: " + e1.getMessage());
					}
				}
			}
		});

	}

}
