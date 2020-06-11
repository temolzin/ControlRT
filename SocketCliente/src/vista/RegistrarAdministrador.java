package vista;
/**
 * Esta Clase es una vista que muestra el formulario para registrar un Administrador.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funcionamiento.SocketBuscarActualizarAdministrador;
import funcionamiento.SocketBuscarActualizarAlumno;
import funcionamiento.SocketBuscarActualizarAsesorAca;
import funcionamiento.SocketBuscarActualizarAsesorInd;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketCargarAsesores;
import funcionamiento.SocketInsertarAsesorAca;
import funcionamiento.SocketInsertarAsesorInd;
import funcionamiento.SocketLogin;
import main.Main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class RegistrarAdministrador extends JFrame {

	private JTextField textMatriculaAdministrador;
	private JTextField textNombreAdmin;
	private JTextField textPaternoAdmin;
	private JTextField textMaternoAdmin;
	private JTextField textTelefonoAdmin;
	private JTextField textCorreoAdmin;
	private JPasswordField passwordAdministrador;
	private JPasswordField passwordAdministrador_1;
	public JButton btnRegistrarAdministrador;
	private char letras;
	
	public RegistrarAdministrador() {
		
		super("Control RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/admin.png"));
		setIconImage(icon);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 728);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.setBackground(new Color(0, 102, 153));
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		JMenu mnIncio = new JMenu("Inicio");
		mnIncio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SocketLogin.vistaAdmin.setVisible(true);
				RegistrarAdministrador.this.dispose();
			}
		});
		mnIncio.setForeground(Color.WHITE);
		mnIncio.setFont(new Font("Arial", Font.BOLD, 15));
		mnIncio.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/inicio.png")));
		menuBar.add(mnIncio);
		
		JMenu mnAsesores = new JMenu("Asesores");
		mnAsesores.setForeground(new Color(255, 255, 255));
		mnAsesores.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesores.setBackground(new Color(0, 102, 153));
		mnAsesores.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/asesores.png")));
		menuBar.add(mnAsesores);
		
		JMenu mnAsesorAcademico = new JMenu("Asesor acad\u00E9mico");
		mnAsesorAcademico.setBackground(new Color(0, 102, 153));
		mnAsesorAcademico.setForeground(new Color(0, 0, 0));
		mnAsesorAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorAcademico.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/academico.png")));
		mnAsesores.add(mnAsesorAcademico);
		
		JMenuItem mntmBuscarAcademico = new JMenuItem("Buscar");
		mntmBuscarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorAca buscarAsesorAca = new SocketBuscarActualizarAsesorAca();
				RegistrarAdministrador.this.dispose();
			}
		});
		mntmBuscarAcademico.setBackground(new Color(0, 102, 153));
		mntmBuscarAcademico.setForeground(new Color(255, 255, 255));
		mntmBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAcademico.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/buscar.png")));
		mnAsesorAcademico.add(mntmBuscarAcademico);
		
		JMenuItem mntmAgregarAcademico = new JMenuItem("Registrar");
		mntmAgregarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorAca asesorAca = new SocketInsertarAsesorAca();
				RegistrarAdministrador.this.dispose();
			}
		});
		mntmAgregarAcademico.setBackground(new Color(0, 102, 153));
		mntmAgregarAcademico.setForeground(new Color(255, 255, 255));
		mntmAgregarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAcademico.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/registrar.png")));
		mnAsesorAcademico.add(mntmAgregarAcademico);
		
		JMenu mnAsesorIndustrial = new JMenu("Asesor industrial");
		mnAsesorIndustrial.setBackground(new Color(0, 102, 153));
		mnAsesorIndustrial.setForeground(new Color(0, 0, 0));
		mnAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorIndustrial.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/asesor industrial.png")));
		mnAsesores.add(mnAsesorIndustrial);
		
		JMenuItem mntmBuscarIndustrial = new JMenuItem("Buscar");
		mntmBuscarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorInd asesorInd = new SocketBuscarActualizarAsesorInd();
				RegistrarAdministrador.this.dispose();
			}
		});
		mntmBuscarIndustrial.setBackground(new Color(0, 102, 153));
		mntmBuscarIndustrial.setForeground(new Color(255, 255, 255));
		mntmBuscarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarIndustrial.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/buscar.png")));
		mnAsesorIndustrial.add(mntmBuscarIndustrial);
		
		JMenuItem mntmRegistrarIndustrial = new JMenuItem("Registrar");
		mntmRegistrarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorInd asesorInd = new SocketInsertarAsesorInd();
				RegistrarAdministrador.this.dispose();
			}
		});
		mntmRegistrarIndustrial.setBackground(new Color(0, 102, 153));
		mntmRegistrarIndustrial.setForeground(new Color(255, 255, 255));
		mntmRegistrarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrarIndustrial.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/registrar.png")));
		mnAsesorIndustrial.add(mntmRegistrarIndustrial);
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setFont(new Font("Arial", Font.BOLD, 15));
		mnAlumnos.setForeground(new Color(255, 255, 255));
		mnAlumnos.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/alumno.png")));
		menuBar.add(mnAlumnos);
		
		JMenuItem mntmBuscarAlumno = new JMenuItem("Buscar");
		mntmBuscarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketBuscarActualizarAlumno alumno = new SocketBuscarActualizarAlumno();
				RegistrarAdministrador.this.dispose();
			}
		});
		mntmBuscarAlumno.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/buscar.png")));
		mntmBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAlumno.setBackground(new Color(0, 102, 153));
		mntmBuscarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmBuscarAlumno);
		
		JMenuItem mntmAgregarAlumno = new JMenuItem("Registrar");
		mntmAgregarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketCargarAsesores cargarAsesores = new SocketCargarAsesores();
				RegistrarAdministrador.this.dispose();
			}
		});
		mntmAgregarAlumno.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/registrar.png")));
		mntmAgregarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAlumno.setBackground(new Color(0, 102, 153));
		mntmAgregarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmAgregarAlumno);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		mnAdministrador.setForeground(Color.WHITE);
		mnAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mnAdministrador.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/admin.png")));
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmBuscaAdministrador = new JMenuItem("Buscar");
		mntmBuscaAdministrador.setBackground(new Color(0, 102, 153));
		mntmBuscaAdministrador.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAdministrador administrador = new SocketBuscarActualizarAdministrador();
				RegistrarAdministrador.this.dispose();
			}
		});
		mntmBuscaAdministrador.setForeground(Color.WHITE);
		mntmBuscaAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscaAdministrador.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/buscar.png")));
		mnAdministrador.add(mntmBuscaAdministrador);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.setBackground(new Color(0, 102, 153));

		mntmRegistrar_1.setForeground(Color.WHITE);
		mntmRegistrar_1.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrar_1.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/registrar.png")));
		mnAdministrador.add(mntmRegistrar_1);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					RegistrarAdministrador.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/cerrar.png")));
		mntmCerrarSesion.setFont(new Font("Arial", Font.BOLD, 15));
		mntmCerrarSesion.setForeground(Color.WHITE);
		mnNewMenu.add(mntmCerrarSesion);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				SocketCambiarContraseña cambiarContraseña = new SocketCambiarContraseña();
			}
		});
		mntmCambiarContrasea.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 0, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblRegistrarAdministrador = new JLabel("REGISTRAR ADMINISTRADOR");
		lblRegistrarAdministrador.setFont(new Font("Arial", Font.BOLD, 26));
		lblRegistrarAdministrador.setBounds(557, 28, 399, 100);
		getContentPane().add(lblRegistrarAdministrador);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatricula.setBounds(138, 189, 67, 31);
		getContentPane().add(lblMatricula);
		
		JLabel lblNombre = new JLabel("Nombre (s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(486, 189, 92, 31);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(821, 195, 147, 18);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(138, 317, 134, 18);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 17));
		lblContrasea.setBounds(138, 492, 92, 14);
		getContentPane().add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrasea.setFont(new Font("Arial", Font.PLAIN, 17));
		lblConfirmarContrasea.setBounds(486, 492, 181, 14);
		getContentPane().add(lblConfirmarContrasea);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(486, 319, 67, 14);
		getContentPane().add(lblTelfono);
		
		JLabel lblCorreoAcademico = new JLabel("Correo");
		lblCorreoAcademico.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreoAcademico.setBounds(821, 315, 81, 22);
		getContentPane().add(lblCorreoAcademico);
		
		textMatriculaAdministrador = new JTextField();
		textMatriculaAdministrador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		textMatriculaAdministrador.setFont(new Font("Arial", Font.PLAIN, 15));
		textMatriculaAdministrador.setBounds(167, 231, 228, 27);
		getContentPane().add(textMatriculaAdministrador);
		textMatriculaAdministrador.setColumns(10);
		
		textNombreAdmin = new JTextField();
		textNombreAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				letras = e.getKeyChar();
				if((letras < 'a' || letras > 'z') && (letras < 'A' || letras > 'Z') && (letras != (char)KeyEvent.VK_BACK_SPACE) 
						&& (letras != (char) KeyEvent.VK_SPACE) && Character.isDigit(letras)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null,"Solo se admiten letras", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textNombreAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textNombreAdmin.setBounds(520, 231, 228, 27);
		getContentPane().add(textNombreAdmin);
		textNombreAdmin.setColumns(10);
		
		textPaternoAdmin = new JTextField();
		textPaternoAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				letras = e.getKeyChar();
				if((letras < 'a' || letras > 'z') && (letras < 'A' || letras > 'Z') && (letras != (char)KeyEvent.VK_BACK_SPACE) 
						&& (letras != (char) KeyEvent.VK_SPACE) && Character.isDigit(letras)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null,"Solo se admiten letras", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textPaternoAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaternoAdmin.setBounds(870, 231, 228, 27);
		getContentPane().add(textPaternoAdmin);
		textPaternoAdmin.setColumns(10);
		
		textMaternoAdmin = new JTextField();
		textMaternoAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				letras = e.getKeyChar();
				if((letras < 'a' || letras > 'z') && (letras < 'A' || letras > 'Z') && (letras != (char)KeyEvent.VK_BACK_SPACE) 
						&& (letras != (char) KeyEvent.VK_SPACE) && Character.isDigit(letras)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null,"Solo se admiten letras", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textMaternoAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textMaternoAdmin.setBounds(167, 363, 228, 27);
		getContentPane().add(textMaternoAdmin);
		textMaternoAdmin.setColumns(10);
		
		textTelefonoAdmin = new JTextField();
		textTelefonoAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		textTelefonoAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textTelefonoAdmin.setBounds(520, 363, 228, 27);
		getContentPane().add(textTelefonoAdmin);
		textTelefonoAdmin.setColumns(10);
		
		textCorreoAdmin = new JTextField();
		textCorreoAdmin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(validarCorreo(textCorreoAdmin.getText())) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Verifica si ingresaste correctamente el correo electrónico","Error", JOptionPane.ERROR_MESSAGE);
					textCorreoAdmin.requestFocus();
				}
			}
		});
		textCorreoAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textCorreoAdmin.setBounds(870, 363, 228, 27);
		getContentPane().add(textCorreoAdmin);
		textCorreoAdmin.setColumns(10);
		
		btnRegistrarAdministrador = new JButton("Registrar");
		
		btnRegistrarAdministrador.setIcon(new ImageIcon(RegistrarAdministrador.class.getResource("/imagenes/guardar.png")));
		btnRegistrarAdministrador.setBackground(new Color(0, 102, 153));
		btnRegistrarAdministrador.setForeground(SystemColor.text);
		btnRegistrarAdministrador.setFont(new Font("Arial", Font.BOLD, 17));
		btnRegistrarAdministrador.setBounds(913, 516, 174, 66);
		getContentPane().add(btnRegistrarAdministrador);
		
		passwordAdministrador = new JPasswordField();
		passwordAdministrador.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordAdministrador.setBounds(167, 537, 228, 27);
		getContentPane().add(passwordAdministrador);
		
		passwordAdministrador_1 = new JPasswordField();
		passwordAdministrador_1.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordAdministrador_1.setBounds(520, 537, 228, 27);
		getContentPane().add(passwordAdministrador_1);
		
		JLabel label_1 = new JLabel("*");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setForeground(Color.RED);
		label_1.setBounds(207, 195, 9, 18);
		getContentPane().add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(138, 173, 973, 2);
		getContentPane().add(separator);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDatosPersonales.setBounds(140, 131, 174, 31);
		getContentPane().add(lblDatosPersonales);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(138, 479, 632, 2);
		getContentPane().add(separator_1);
		
		JLabel lblOtorgarContrasea = new JLabel("Otorgar contrase\u00F1a");
		lblOtorgarContrasea.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOtorgarContrasea.setBounds(138, 446, 176, 22);
		getContentPane().add(lblOtorgarContrasea);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(569, 189, 9, 18);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(937, 189, 9, 18);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(879, 317, 9, 18);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(557, 317, 9, 18);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(265, 315, 9, 18);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(232, 494, 9, 18);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(649, 494, 9, 18);
		getContentPane().add(label_8);
	}
	
	
	
	public JTextField getTextMatriculaAdministrador() {
		return textMatriculaAdministrador;
	}
	public void setTextMatriculaAdministrador(JTextField textMatriculaAdministrador) {
		this.textMatriculaAdministrador = textMatriculaAdministrador;
	}

	public JTextField getTextNombreAdmin() {
		return textNombreAdmin;
	}
	public void setTextNombreAdmin(JTextField textNombreAdmin) {
		this.textNombreAdmin = textNombreAdmin;
	}

	public JTextField getTextPaternoAdmin() {
		return textPaternoAdmin;
	}
	public void setTextPaternoAdmin(JTextField textPaternoAdmin) {
		this.textPaternoAdmin = textPaternoAdmin;
	}

	public JTextField getTextMaternoAdmin() {
		return textMaternoAdmin;
	}
	public void setTextMaternoAdmin(JTextField textMaternoAdmin) {
		this.textMaternoAdmin = textMaternoAdmin;
	}

	public JTextField getTextTelefonoAdmin() {
		return textTelefonoAdmin;
	}
	public void setTextTelefonoAdmin(JTextField textTelefonoAdmin) {
		this.textTelefonoAdmin = textTelefonoAdmin;
	}

	public JTextField getTextCorreoAdmin() {
		return textCorreoAdmin;
	}
	public void setTextCorreoAdmin(JTextField textCorreoAdmin) {
		this.textCorreoAdmin = textCorreoAdmin;
	}

	public JPasswordField getPasswordAdministrador() {
		return passwordAdministrador;
	}
	public void setPasswordAdministrador(JPasswordField passwordAdministrador) {
		this.passwordAdministrador = passwordAdministrador;
	}

	public void limpiarCajas() {
		textMatriculaAdministrador.setText("");
		textNombreAdmin.setText("");
		textPaternoAdmin.setText("");
		textMaternoAdmin.setText("");
		textTelefonoAdmin.setText("");
		textCorreoAdmin.setText("");
		passwordAdministrador.setText("");
		passwordAdministrador_1.setText("");
	}
	
	private boolean validarCorreo(String correo) {
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		mat = pat.matcher(correo);
		if(mat.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean validarRegistroAcademico() {
		
		if(textMatriculaAdministrador.getText().isEmpty() && textNombreAdmin.getText().isEmpty() && textPaternoAdmin.getText().isEmpty() &&
				textMaternoAdmin.getText().isEmpty() && textTelefonoAdmin.getText().isEmpty() && textCorreoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Todos los datos con asterisco (*) son obligatorios", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMatriculaAdministrador.requestFocus();
			return false;
		}else if(textMatriculaAdministrador.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la matricula del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMatriculaAdministrador.requestFocus();
			return false;
		}else if(textNombreAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el nombre del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textNombreAdmin.requestFocus();
			return false;
		}else if(textPaternoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido paterno del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textPaternoAdmin.requestFocus();
			return false;
		}else if(textMaternoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido materno del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMaternoAdmin.requestFocus();
			return false;
		}else if(textTelefonoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el número telefonico del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textTelefonoAdmin.requestFocus();
			return false;
		}else if(textCorreoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el correo del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textCorreoAdmin.requestFocus();
			return false;
		}else if(passwordAdministrador.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Debes ingresar una contraseña para el administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordAdministrador.requestFocus();
			return false;
		}else if(passwordAdministrador_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la confimación de la contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordAdministrador_1.requestFocus();
			return false;
		}else if(passwordAdministrador.getText().equals(passwordAdministrador_1.getText())) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordAdministrador.setText("");
			passwordAdministrador_1.setText("");
			passwordAdministrador.requestFocus();
			return false;
		}
	}
}
