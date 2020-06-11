package funcionamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import vista.RegistrarAdministrador;

public class SocketInsertarAdministrador {
	RegistrarAdministrador vistaAdministrador;
	Socket cliente;
	DataInputStream mensajeEntrada;
	DataOutputStream mensajeSalida;
	
	public SocketInsertarAdministrador() {
		this.vistaAdministrador = new RegistrarAdministrador();
		this.vistaAdministrador.setVisible(true);
		
		this.vistaAdministrador.btnRegistrarAdministrador.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(vistaAdministrador.validarRegistroAcademico() == true) {
					try {
						cliente =  new Socket("localhost", 5006);
						mensajeSalida = new DataOutputStream(cliente.getOutputStream());
						
						mensajeSalida.writeUTF(vistaAdministrador.getTextMatriculaAdministrador().getText());
						mensajeSalida.writeUTF(vistaAdministrador.getTextNombreAdmin().getText());
						mensajeSalida.writeUTF(vistaAdministrador.getTextPaternoAdmin().getText());
						mensajeSalida.writeUTF(vistaAdministrador.getTextMaternoAdmin().getText());
						mensajeSalida.writeUTF(vistaAdministrador.getPasswordAdministrador().getText());
						mensajeSalida.writeUTF(vistaAdministrador.getTextTelefonoAdmin().getText());
						mensajeSalida.writeUTF(vistaAdministrador.getTextCorreoAdmin().getText());
						
						mensajeEntrada = new DataInputStream(cliente.getInputStream());
						if(mensajeEntrada.readUTF().equals("Entro")) {
							JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/Correcto.png"));
							vistaAdministrador.limpiarCajas();
						} else {
							JOptionPane.showMessageDialog(null, "Error, La matricula: " + vistaAdministrador.getTextMatriculaAdministrador().getText() + " ya ha sido registrada anteriormente.", 
									"Error" , JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
		});
	}
}
