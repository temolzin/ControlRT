package vista;
/**
 * Esta Clase es una vista que muestra el formulario para cambiar contraseña.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CambiarContraseña extends JFrame {
	
	private JPasswordField passwordAdmin;
	private JPasswordField passwordConfimAdmin;
	public JButton btnActualizar;
	private JLabel label;
	private JLabel label_1;
	private JButton btnCancelar;

	public CambiarContraseña() {
		
		super("Control RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/cambiar.png"));
		setIconImage(icon);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblCambiarContrasea = new JLabel("CAMBIAR CONTRASE\u00D1A");
		lblCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 17));
		lblCambiarContrasea.setBounds(172, 11, 208, 49);
		getContentPane().add(lblCambiarContrasea);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNuevaContrasea.setBounds(54, 85, 127, 18);
		getContentPane().add(lblNuevaContrasea);
		
		JLabel lblConfirmarNuevaContrasea = new JLabel("Confirmar nueva contrase\u00F1a");
		lblConfirmarNuevaContrasea.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConfirmarNuevaContrasea.setBounds(54, 158, 193, 26);
		getContentPane().add(lblConfirmarNuevaContrasea);
		
		passwordAdmin = new JPasswordField();
		passwordAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordAdmin.setBounds(172, 114, 228, 27);
		getContentPane().add(passwordAdmin);
		
		passwordConfimAdmin = new JPasswordField();
		passwordConfimAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordConfimAdmin.setBounds(172, 189, 228, 27);
		getContentPane().add(passwordConfimAdmin);
		
		btnActualizar = new JButton("Cambiar");

		btnActualizar.setBackground(new Color(0, 102, 153));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 15));
		btnActualizar.setBounds(94, 246, 145, 37);
		getContentPane().add(btnActualizar);
		
		label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBounds(172, 87, 15, 14);
		getContentPane().add(label);
		
		label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Arial", Font.BOLD, 15));
		label_1.setBounds(240, 158, 55, 20);
		getContentPane().add(label_1);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(178, 34, 34));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancelar.setBounds(270, 246, 145, 37);
		getContentPane().add(btnCancelar);
		setBounds(100, 100, 512, 345);
		setLocationRelativeTo(null);
		
	}

	public JPasswordField getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(JPasswordField passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean validarContraseña() {
		 if(passwordAdmin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Debes ingresar una nueva contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
				passwordAdmin.requestFocus();
				return false;
			}else if(passwordConfimAdmin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Debes confirmar la nueva contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
				passwordConfimAdmin.requestFocus();
				return false;
			}else if(passwordAdmin.getText().equals(passwordConfimAdmin.getText())) {
				return true;
			}else {
				JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales", "ERROR", JOptionPane.ERROR_MESSAGE);
				passwordAdmin.setText("");
				passwordConfimAdmin.setText("");
				passwordAdmin.requestFocus();
				return false;
			}
	}
	
}
