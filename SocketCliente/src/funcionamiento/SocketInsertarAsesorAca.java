package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vista.RegistrarAcademico;

public class SocketInsertarAsesorAca {

	Socket cliente;
	DataOutputStream mensajeSalida;
	DataInputStream mensajeEntrada;
	String respuestaServer;
	RegistrarAcademico vistaAsesorAca;

	public SocketInsertarAsesorAca() {

		this.vistaAsesorAca = new RegistrarAcademico();
		this.vistaAsesorAca.setVisible(true);

		this.vistaAsesorAca.btnRegistrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					if (vistaAsesorAca.validarRegistroAcademico() == true) {
						cliente = new Socket("localhost", 5001);
						mensajeSalida = new DataOutputStream(cliente.getOutputStream());
						mensajeSalida.writeUTF(vistaAsesorAca.getTextMatriculaAcademico().getText());
						mensajeSalida.writeUTF(vistaAsesorAca.getTextNombreAcademico().getText());
						mensajeSalida.writeUTF(vistaAsesorAca.getTextPaternoAcademico().getText());
						mensajeSalida.writeUTF(vistaAsesorAca.getTextMaternoAcademico().getText());
						mensajeSalida.writeUTF(vistaAsesorAca.getTextCorreoAcademico().getText());
						mensajeSalida.writeUTF(vistaAsesorAca.getTextTelefonoAcademico().getText());
						mensajeSalida.writeUTF(vistaAsesorAca.getPasswordAcademico().getText());

						mensajeEntrada = new DataInputStream(cliente.getInputStream());
						respuestaServer = mensajeEntrada.readUTF();

						if (respuestaServer.equals("Entro")) {
							JOptionPane.showMessageDialog(null, "Datos insertados Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/Correcto.png"));
							vistaAsesorAca.limpiarCajas();
						} else {
							JOptionPane.showMessageDialog(null,
									"Error al insertar los datos, esta matricula: "
											+ vistaAsesorAca.getTextMatriculaAcademico().getText()
											+ "ya ha sido registrada",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						cliente.close();
					}
				} catch (IOException e1) {
					System.err.println("Error en el SocketInsertarAsesorAca: " + e1.getMessage());
				}
			}
		});
	}
}
