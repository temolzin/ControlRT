package vista;
/**
 * Esta Clase es una vista que muestra la ventana para iniciar sesión en el Sistema.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class Sesion extends JFrame {
	
	private JTextField textMatricula;
	private JPasswordField passwordUsuario;
	public JButton btnEntrar;
	private JLabel lblUttec;
	private JLabel lblLogo;

	public Sesion() {
		
		super("Control RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icono.png"));
		setIconImage(icon);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 728);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Matricula");
		lblUsuario.setIcon(new ImageIcon(Sesion.class.getResource("/imagenes/usuario.png")));
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 17));
		lblUsuario.setBounds(472, 287, 142, 64);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setIcon(new ImageIcon(Sesion.class.getResource("/imagenes/contrase\u00F1a.png")));
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 17));
		lblContrasea.setBounds(471, 422, 163, 64);
		getContentPane().add(lblContrasea);
		
		textMatricula = new JTextField();
		textMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		textMatricula.setFont(new Font("Arial", Font.PLAIN, 15));
		textMatricula.setBounds(681, 304, 240, 32);
		getContentPane().add(textMatricula);
		textMatricula.setColumns(10);
		
		passwordUsuario = new JPasswordField();
		passwordUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordUsuario.setBounds(681, 439, 240, 32);
		getContentPane().add(passwordUsuario);
		
		btnEntrar = new JButton("  Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarInicioSesion();
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(0, 102, 153));
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 17));
		btnEntrar.setIcon(new ImageIcon(Sesion.class.getResource("/imagenes/entrar.png")));
		btnEntrar.setBounds(553, 556, 291, 73);
		getContentPane().add(btnEntrar);
		
		lblUttec = new JLabel("");
		lblUttec.setIcon(new ImageIcon(Sesion.class.getResource("/imagenes/Uttec.jpg")));
		lblUttec.setBounds(23, 11, 320, 110);
		getContentPane().add(lblUttec);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Sesion.class.getResource("/imagenes/logo.png")));
		lblLogo.setBounds(1184, 11, 159, 110);
		getContentPane().add(lblLogo);
		
		JLabel lblInciarSesion = new JLabel("INICIAR SESION");
		lblInciarSesion.setFont(new Font("Arial", Font.BOLD, 26));
		lblInciarSesion.setBounds(612, 53, 222, 61);
		getContentPane().add(lblInciarSesion);
	}
	
	public void Cerrar() {
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					confirmarSalida();
				}
			});
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void confirmarSalida() {
		int valor = JOptionPane.showConfirmDialog(this, "Esta seguro de cerrar la aplicacion", "Advertencia", JOptionPane.YES_NO_OPTION);
		if(valor == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracias por utilizar la aplicación Control RT","Gracias",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	@SuppressWarnings("deprecation")
	private void validarInicioSesion() {
		if(textMatricula.getText().isEmpty() && passwordUsuario.getText().isEmpty()) {
			textMatricula.requestFocus();
		} else if(textMatricula.getText().isEmpty()) {
			textMatricula.requestFocus();
		} else if(passwordUsuario.getText().isEmpty()) {
			passwordUsuario.requestFocus();
		}
	}

	public JTextField getTextMatricula() {
		return textMatricula;
	}

	public void setTextMatricula(JTextField textMatricula) {
		this.textMatricula = textMatricula;
	}

	public JPasswordField getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(JPasswordField passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
	
	
}
