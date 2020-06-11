package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vista.RegistrarIndustrial;

public class SocketInsertarAsesorInd {

	Socket cliente;
	DataOutputStream mensajeSalida;
	DataInputStream mensajeEntrada;
	String respuestaServer;
	RegistrarIndustrial vistaAsesorInd;

	public SocketInsertarAsesorInd() {

			this.vistaAsesorInd = new RegistrarIndustrial();
			this.vistaAsesorInd.setVisible(true);

			this.vistaAsesorInd.btnRegistrarAdministrador.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					try {
						if (vistaAsesorInd.validarRegistroIndustrial() == true) {
							cliente = new Socket("localhost", 5003);
							mensajeSalida = new DataOutputStream(cliente.getOutputStream());
							mensajeSalida.writeUTF(vistaAsesorInd.getTextNombreIndustrial().getText());
							mensajeSalida.writeUTF(vistaAsesorInd.getTextPaternoIndustrial().getText());
							mensajeSalida.writeUTF(vistaAsesorInd.getTextMaternoIndustrial().getText());
							mensajeSalida.writeUTF(vistaAsesorInd.getTextCorreoIndustrial().getText());
							mensajeSalida.writeUTF(vistaAsesorInd.getTextTelefonoIndustrial().getText());
							mensajeSalida.writeUTF(vistaAsesorInd.getPasswordIndustrial().getText());
							mensajeSalida.writeUTF(vistaAsesorInd.getTextEmpresa().getText());

							mensajeEntrada = new DataInputStream(cliente.getInputStream());
							respuestaServer = mensajeEntrada.readUTF();

							if (respuestaServer.equals("Error")) {
								JOptionPane.showMessageDialog(null, "Error al insertar los datos, esta matricula: "
										+ respuestaServer + "ya ha sido registrada", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null,
										"La matricula asignada al Asesor Industrial es: " + respuestaServer
												+ " , con esta matricula el Asesor Industrial tendrá acceso al sistema.",
										"Datos Insertados Correctamente", JOptionPane.INFORMATION_MESSAGE,
										new ImageIcon("src/imagenes/Correcto.png"));
								vistaAsesorInd.limpiarCajas();
							}
							cliente.close();
						}
					} catch (IOException e1) {
						System.err.println("Error en InsertarAsesorInd en el cliente: " + e1.getMessage());
					}
				}
			});

	}
}
