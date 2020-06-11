package vista;
/**
 * Esta Clase es una vista que muestra el formulario para registrar un Alumno.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.*;

import javax.swing.*;

import funcionamiento.SocketBuscarActualizarAdministrador;
import funcionamiento.SocketBuscarActualizarAlumno;
import funcionamiento.SocketBuscarActualizarAsesorAca;
import funcionamiento.SocketBuscarActualizarAsesorInd;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketInsertarAdministrador;
import funcionamiento.SocketInsertarAsesorAca;
import funcionamiento.SocketInsertarAsesorInd;
import funcionamiento.SocketLogin;
import main.Main;

import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class RegistrarAlumno extends JFrame {
	
	private JTextField textNombreAlumno;
	private JTextField textPaternoAlumno;
	private JTextField textMaternoAlumno;
	private JTextField textTelefonoAlumno;
	private JTextField textCorreoAlumno;
	private JTextField textProyecto;
	private JTextField textMatriculaAlumno;
	private JPasswordField passwordAlumno;
	private JPasswordField passwordFAlumno_1;
	public JButton btnRegistrarAlumno;
	@SuppressWarnings("rawtypes")
	private JComboBox comboDivision;
	@SuppressWarnings("rawtypes")
	private JComboBox comboCarrera;
	@SuppressWarnings("rawtypes")
	private JComboBox comboAcademico;
	@SuppressWarnings("rawtypes")
	private JComboBox comboIndustrial;
	@SuppressWarnings("rawtypes")
	private JComboBox comboCuatrimestre;
	private char letras;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RegistrarAlumno() {
		
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
				RegistrarAlumno.this.dispose();
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
		mnAsesores.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/asesores.png")));
		menuBar.add(mnAsesores);
		
		JMenu mnAsesorAcademico = new JMenu("Asesor acad\u00E9mico");
		mnAsesorAcademico.setBackground(new Color(0, 102, 153));
		mnAsesorAcademico.setForeground(new Color(0, 0, 0));
		mnAsesorAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorAcademico.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/academico.png")));
		mnAsesores.add(mnAsesorAcademico);
		
		JMenuItem mntmBuscarAcademico = new JMenuItem("Buscar");
		mntmBuscarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorAca buscarAsesorAca = new SocketBuscarActualizarAsesorAca();
				RegistrarAlumno.this.dispose();
			}
		});
		mntmBuscarAcademico.setBackground(new Color(0, 102, 153));
		mntmBuscarAcademico.setForeground(new Color(255, 255, 255));
		mntmBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAcademico.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mnAsesorAcademico.add(mntmBuscarAcademico);
		
		JMenuItem mntmAgregarAcademico = new JMenuItem("Registrar");
		mntmAgregarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorAca asesorAca = new SocketInsertarAsesorAca();
				RegistrarAlumno.this.dispose();
			}
		});
		mntmAgregarAcademico.setBackground(new Color(0, 102, 153));
		mntmAgregarAcademico.setForeground(new Color(255, 255, 255));
		mntmAgregarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAcademico.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/registrar.png")));
		mnAsesorAcademico.add(mntmAgregarAcademico);
		
		JMenu mnAsesorIndustrial = new JMenu("Asesor industrial");
		mnAsesorIndustrial.setBackground(new Color(0, 102, 153));
		mnAsesorIndustrial.setForeground(new Color(0, 0, 0));
		mnAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorIndustrial.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/asesor industrial.png")));
		mnAsesores.add(mnAsesorIndustrial);
		
		JMenuItem mntmBuscarIndustrial = new JMenuItem("Buscar");
		mntmBuscarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorInd asesorInd = new SocketBuscarActualizarAsesorInd();
				RegistrarAlumno.this.dispose();
			}
		});
		mntmBuscarIndustrial.setBackground(new Color(0, 102, 153));
		mntmBuscarIndustrial.setForeground(new Color(255, 255, 255));
		mntmBuscarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarIndustrial.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mnAsesorIndustrial.add(mntmBuscarIndustrial);
		
		
		JMenuItem mntmRegistrarIndustrial = new JMenuItem("Registrar");
		mntmRegistrarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorInd asesorInd = new SocketInsertarAsesorInd();
				RegistrarAlumno.this.dispose();
			}
		});
		mntmRegistrarIndustrial.setBackground(new Color(0, 102, 153));
		mntmRegistrarIndustrial.setForeground(new Color(255, 255, 255));
		mntmRegistrarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrarIndustrial.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/registrar.png")));
		mnAsesorIndustrial.add(mntmRegistrarIndustrial);
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setFont(new Font("Arial", Font.BOLD, 15));
		mnAlumnos.setForeground(new Color(255, 255, 255));
		mnAlumnos.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/alumno.png")));
		menuBar.add(mnAlumnos);
		
		JMenuItem mntmBuscarAlumno = new JMenuItem("Buscar");
		mntmBuscarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAlumno alumno = new SocketBuscarActualizarAlumno();
				RegistrarAlumno.this.dispose();
			}
		});
		mntmBuscarAlumno.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mntmBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAlumno.setBackground(new Color(0, 102, 153));
		mntmBuscarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmBuscarAlumno);
		
		JMenuItem mntmAgregarAlumno = new JMenuItem("Registrar");
		mntmAgregarAlumno.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/registrar.png")));
		mntmAgregarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAlumno.setBackground(new Color(0, 102, 153));
		mntmAgregarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmAgregarAlumno);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		mnAdministrador.setForeground(Color.WHITE);
		mnAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mnAdministrador.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/admin.png")));
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmBuscaAdministrador = new JMenuItem("Buscar");
		mntmBuscaAdministrador.setBackground(new Color(0, 102, 153));
		mntmBuscaAdministrador.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAdministrador administrador = new SocketBuscarActualizarAdministrador();
				RegistrarAlumno.this.dispose();
			}
		});
		mntmBuscaAdministrador.setForeground(Color.WHITE);
		mntmBuscaAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscaAdministrador.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mnAdministrador.add(mntmBuscaAdministrador);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.setBackground(new Color(0, 102, 153));
		mntmRegistrar_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				SocketInsertarAdministrador insertarAdmin = new SocketInsertarAdministrador();
				RegistrarAlumno.this.dispose();
			}
		});
		mntmRegistrar_1.setForeground(Color.WHITE);
		mntmRegistrar_1.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrar_1.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/registrar.png")));
		mnAdministrador.add(mntmRegistrar_1);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					RegistrarAlumno.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/cerrar.png")));
		mntmCerrarSesion.setFont(new Font("Arial", Font.BOLD, 15));
		mntmCerrarSesion.setForeground(Color.WHITE);
		mnNewMenu.add(mntmCerrarSesion);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				SocketCambiarContraseña cambiarContraseña = new SocketCambiarContraseña();
			}
		});
		mntmCambiarContrasea.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblRegistrarAsesorIndustrial = new JLabel("REGISTRAR ALUMNO");
		lblRegistrarAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 26));
		lblRegistrarAsesorIndustrial.setBounds(549, 28, 280, 100);
		getContentPane().add(lblRegistrarAsesorIndustrial);
		
		JLabel lblNombre = new JLabel("Nombre (s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(396, 200, 92, 31);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(711, 206, 136, 18);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(1015, 206, 136, 18);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 17));
		lblContrasea.setBounds(1047, 367, 92, 14);
		getContentPane().add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrasea.setFont(new Font("Arial", Font.PLAIN, 17));
		lblConfirmarContrasea.setBounds(1047, 454, 183, 14);
		getContentPane().add(lblConfirmarContrasea);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(67, 294, 103, 14);
		getContentPane().add(lblTelfono);
		
		JLabel lblCorreoAcademico = new JLabel("Correo");
		lblCorreoAcademico.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreoAcademico.setBounds(396, 290, 81, 22);
		getContentPane().add(lblCorreoAcademico);
		
		textNombreAlumno = new JTextField();
		textNombreAlumno.addKeyListener(new KeyAdapter() {
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
		textNombreAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		textNombreAlumno.setBounds(426, 242, 228, 27);
		getContentPane().add(textNombreAlumno);
		textNombreAlumno.setColumns(10);
		
		textPaternoAlumno = new JTextField();
		textPaternoAlumno.addKeyListener(new KeyAdapter() {
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
		textPaternoAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaternoAlumno.setBounds(740, 242, 228, 27);
		getContentPane().add(textPaternoAlumno);
		textPaternoAlumno.setColumns(10);
		
		textMaternoAlumno = new JTextField();
		textMaternoAlumno.addKeyListener(new KeyAdapter() {
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
		textMaternoAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		textMaternoAlumno.setBounds(1064, 242, 228, 25);
		getContentPane().add(textMaternoAlumno);
		textMaternoAlumno.setColumns(10);
		
		textTelefonoAlumno = new JTextField();
		textTelefonoAlumno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		textTelefonoAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		textTelefonoAlumno.setBounds(104, 321, 228, 27);
		getContentPane().add(textTelefonoAlumno);
		textTelefonoAlumno.setColumns(10);
		
		textCorreoAlumno = new JTextField();
		textCorreoAlumno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(validarCorreo(textCorreoAlumno.getText())) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Verifica si ingresaste correctamente el correo electrónico","Error", JOptionPane.ERROR_MESSAGE);
					textCorreoAlumno.requestFocus();
				}
			}
		});
		textCorreoAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		textCorreoAlumno.setBounds(426, 323, 228, 27);
		getContentPane().add(textCorreoAlumno);
		textCorreoAlumno.setColumns(10);
		
		JLabel lblEmpresa = new JLabel("Nombre del proyecto");
		lblEmpresa.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEmpresa.setBounds(67, 454, 152, 36);
		getContentPane().add(lblEmpresa);
		
		textProyecto = new JTextField();
		textProyecto.addKeyListener(new KeyAdapter() {
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
		textProyecto.setFont(new Font("Arial", Font.PLAIN, 15));
		textProyecto.setBounds(104, 490, 228, 27);
		getContentPane().add(textProyecto);
		textProyecto.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatricula.setBounds(67, 208, 67, 14);
		getContentPane().add(lblMatricula);
		
		textMatriculaAlumno = new JTextField();
		textMatriculaAlumno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		textMatriculaAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		textMatriculaAlumno.setBounds(104, 240, 228, 27);
		getContentPane().add(textMatriculaAlumno);
		textMatriculaAlumno.setColumns(10);
		
		JLabel lblAsesorIndustrial = new JLabel("Asesor Industrial");
		lblAsesorIndustrial.setFont(new Font("Arial", Font.PLAIN, 17));
		lblAsesorIndustrial.setBounds(711, 465, 136, 14);
		getContentPane().add(lblAsesorIndustrial);
		
		JLabel lblAsesorAcademico = new JLabel("Asesor acad\u00E9mico");
		lblAsesorAcademico.setFont(new Font("Arial", Font.PLAIN, 17));
		lblAsesorAcademico.setBounds(382, 465, 161, 14);
		getContentPane().add(lblAsesorAcademico);
		
		comboAcademico = new JComboBox();
		comboAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		comboAcademico.setBounds(396, 490, 258, 27);
		getContentPane().add(comboAcademico);
		
		comboIndustrial = new JComboBox();
		comboIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		comboIndustrial.setBounds(711, 490, 257, 27);
		getContentPane().add(comboIndustrial);
		
		btnRegistrarAlumno = new JButton("Registrar");
		
		btnRegistrarAlumno.setIcon(new ImageIcon(RegistrarAlumno.class.getResource("/imagenes/guardar.png")));
		btnRegistrarAlumno.setBackground(new Color(0, 102, 153));
		btnRegistrarAlumno.setForeground(SystemColor.text);
		btnRegistrarAlumno.setFont(new Font("Arial", Font.BOLD, 17));
		btnRegistrarAlumno.setBounds(1115, 556, 174, 66);
		getContentPane().add(btnRegistrarAlumno);
		
		passwordAlumno = new JPasswordField();
		passwordAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordAlumno.setBounds(1082, 392, 228, 27);
		getContentPane().add(passwordAlumno);
		
		passwordFAlumno_1 = new JPasswordField();
		passwordFAlumno_1.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordFAlumno_1.setBounds(1082, 491, 228, 27);
		getContentPane().add(passwordFAlumno_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(66, 187, 1226, 8);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(67, 427, 902, 12);
		getContentPane().add(separator_1);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDatosPersonales.setBounds(67, 145, 174, 31);
		getContentPane().add(lblDatosPersonales);
		
		JLabel lblInformacionDelProyecto = new JLabel("Informaci\u00F3n del proyecto");
		lblInformacionDelProyecto.setFont(new Font("Arial", Font.PLAIN, 20));
		lblInformacionDelProyecto.setBounds(67, 387, 234, 29);
		getContentPane().add(lblInformacionDelProyecto);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(1044, 355, 266, 8);
		getContentPane().add(separator_2);
		
		JLabel lblOtorgarContrasea = new JLabel("Otorgar contrase\u00F1a");
		lblOtorgarContrasea.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOtorgarContrasea.setBounds(1047, 310, 183, 31);
		getContentPane().add(lblOtorgarContrasea);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(133, 200, 13, 18);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(480, 200, 13, 18);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(133, 290, 13, 18);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(448, 290, 13, 18);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(228, 463, 13, 18);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(532, 463, 13, 18);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(829, 452, 13, 18);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(829, 200, 13, 18);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(1138, 200, 13, 18);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_10.setBounds(1138, 355, 13, 18);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_11.setBounds(1208, 447, 13, 18);
		getContentPane().add(label_11);
		
		comboCarrera = new JComboBox();
		comboCarrera.setFont(new Font("Arial", Font.PLAIN, 15));
		comboCarrera.setBounds(287, 588, 374, 27);
		getContentPane().add(comboCarrera);
		
		JLabel label_12 = new JLabel("Carrera");
		label_12.setFont(new Font("Arial", Font.PLAIN, 17));
		label_12.setBounds(271, 563, 67, 14);
		getContentPane().add(label_12);
		
		comboCuatrimestre = new JComboBox();
		comboCuatrimestre.setFont(new Font("Arial", Font.PLAIN, 15));
		comboCuatrimestre.setModel(new DefaultComboBoxModel(new String[] {"", "Enero - Abril", "Mayo - Agosto", "Septiembre - Diciembre"}));
		comboCuatrimestre.setBounds(711, 588, 257, 27);
		getContentPane().add(comboCuatrimestre);
		
		JLabel label_13 = new JLabel("Periodo cuatrimestal");
		label_13.setFont(new Font("Arial", Font.PLAIN, 17));
		label_13.setBounds(711, 556, 160, 18);
		getContentPane().add(label_13);
		
		JLabel lblDivisin = new JLabel("Divisi\u00F3n");
		lblDivisin.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDivisin.setBounds(67, 563, 67, 14);
		getContentPane().add(lblDivisin);
		
		comboDivision = new JComboBox();
		comboDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					rellenarCombo(comboDivision.getSelectedIndex());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		comboDivision.setFont(new Font("Arial", Font.PLAIN, 15));
		comboDivision.setModel(new DefaultComboBoxModel(new String[] {"", "DAD", "DBT", "DCO", "DEA", "DIN", "DPP"}));
		comboDivision.setBounds(104, 590, 81, 27);
		getContentPane().add(comboDivision);
		
		JLabel label_14 = new JLabel("*");
		label_14.setForeground(Color.RED);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_14.setBounds(133, 556, 13, 18);
		getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("*");
		label_15.setForeground(Color.RED);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_15.setBounds(323, 547, 13, 18);
		getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("*");
		label_16.setForeground(Color.RED);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_16.setBounds(863, 556, 13, 18);
		getContentPane().add(label_16);
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
	
	@SuppressWarnings("unchecked")
	private void rellenarCombo(int diviciones) {
		while (comboCarrera.getModel().getSize() > 0) comboCarrera.removeItemAt(0);
		if(diviciones == 0) {
			comboCarrera.addItem("");
		}else if(diviciones == 1) {
			comboCarrera.addItem("[TSU]Administración: Área Recursos Humanos");
			comboCarrera.addItem("[ING]Negocio y gestión empresarial");
		}else if(diviciones == 2) {
			comboCarrera.addItem("[TSU]Química: Área Biotecnología");
			comboCarrera.addItem("[ING]Nanotecnología");
		}else if(diviciones == 3) {
			comboCarrera.addItem("[TSU]Administración: Área Administración y Evaluación de Proyectos");
			comboCarrera.addItem("[TSU]Desarrollo de Negocios: Área Mercadotecnia");
			comboCarrera.addItem("[ING]Gestión de proyectos");
		}else if(diviciones == 4) {
			comboCarrera.addItem("[TSU]Mecatrónica: Área Automatización");
			comboCarrera.addItem("[ING]Mecatrónica");
			comboCarrera.addItem("[TSU]Mantenimiento: Área Industrial");
			comboCarrera.addItem("[ING]Mantenimiento Industrial");
		}else if(diviciones == 5) {
			comboCarrera.addItem("[TSU]Tecnologías de la Información y Comunicación");
			comboCarrera.addItem("[ING]Tecnologías de la Información y Comunicación");
		}else if(diviciones == 6) {
			comboCarrera.addItem("[TSU]Procesos Industriales: Área Manufactura");
			comboCarrera.addItem("[ING]Procesos y Operaciones Industriales");
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean validadRegistroAlumno() {
		if(textMatriculaAlumno.getText().isEmpty() && textNombreAlumno.getText().isEmpty() && textPaternoAlumno.getText().isEmpty() 
				&& textMaternoAlumno.getText().isEmpty() &&	textTelefonoAlumno.getText().isEmpty() && textCorreoAlumno.getText().isEmpty() 
				&& textProyecto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Todos los datos con asterisco (*) son obligatorios", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMatriculaAlumno.requestFocus();
			return false;
		} else if(textMatriculaAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la matricula del alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMatriculaAlumno.requestFocus();
			return false;
		} else if(textNombreAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el nombre del alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			textNombreAlumno.requestFocus();
			return false;
		} else if(textPaternoAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido paterno del alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			textPaternoAlumno.requestFocus();
			return false;
		} else if(textMaternoAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido materno del alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMaternoAlumno.requestFocus();
			return false;
		} else if(textTelefonoAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el número telefonico del alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			textTelefonoAlumno.requestFocus();
			return false;
		} else if(textCorreoAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el correo electronico ", "ERROR", JOptionPane.ERROR_MESSAGE);
			textCorreoAlumno.requestFocus();
			return false;
		} else if(textProyecto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el nombre del proyecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			textProyecto.requestFocus();
			return false;
		} else if(comboAcademico.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null,"Selecciona al asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			comboAcademico.requestFocus();
			return false;
		} else if(comboIndustrial.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null,"Selecciona al asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			comboIndustrial.requestFocus();
			return false;
		} else if(comboDivision.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null,"Selecciona la división", "ERROR", JOptionPane.ERROR_MESSAGE);
			comboDivision.requestFocus();
			return false;
		} else if(comboCarrera.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null,"Selecciona la carrera", "ERROR", JOptionPane.ERROR_MESSAGE);
			comboCarrera.requestFocus();
			return false;
		} else if(comboCuatrimestre.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null,"Selecciona el periodo cuatrimestral", "ERROR", JOptionPane.ERROR_MESSAGE);
			comboCuatrimestre.requestFocus();
			return false;
		} else if(passwordAlumno.getText().isEmpty()) { 
			JOptionPane.showMessageDialog(null,"Debes ingresar una contraseña para el alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordAlumno.requestFocus();
			return false;
		} else if(passwordFAlumno_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes confirmar la contraseña del alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordFAlumno_1.requestFocus();
			return false;
		}else if(passwordAlumno.getText().equals(passwordFAlumno_1.getText())) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordAlumno.setText("");
			passwordFAlumno_1.setText("");
			passwordAlumno.requestFocus();
			return false;
		}
	}
	
	public void limpiarCajas() {
		textMatriculaAlumno.setText("");
		textNombreAlumno.setText("");
		textPaternoAlumno.setText("");
		textMaternoAlumno.setText("");
		textTelefonoAlumno.setText("");
		textCorreoAlumno.setText("");
		comboAcademico.setSelectedItem("");
		comboIndustrial.setSelectedItem("");
		comboDivision.setSelectedItem("");
		comboCarrera.setSelectedItem("");
		comboCuatrimestre.setSelectedItem("");
		textProyecto.setText("");
		passwordAlumno.setText("");
		passwordFAlumno_1.setText("");
		
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboAcademico() {
		return comboAcademico;
	}

	@SuppressWarnings("rawtypes")
	public void setComboAcademico(JComboBox comboAcademico) {
		this.comboAcademico = comboAcademico;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboIndustrial() {
		return comboIndustrial;
	}

	@SuppressWarnings("rawtypes")
	public void setComboIndustrial(JComboBox comboIndustrial) {
		this.comboIndustrial = comboIndustrial;
	}

	public JTextField getTextNombreAlumno() {
		return textNombreAlumno;
	}

	public void setTextNombreAlumno(JTextField textNombreAlumno) {
		this.textNombreAlumno = textNombreAlumno;
	}

	public JTextField getTextPaternoAlumno() {
		return textPaternoAlumno;
	}

	public void setTextPaternoAlumno(JTextField textPaternoAlumno) {
		this.textPaternoAlumno = textPaternoAlumno;
	}

	public JTextField getTextMaternoAlumno() {
		return textMaternoAlumno;
	}

	public void setTextMaternoAlumno(JTextField textMaternoAlumno) {
		this.textMaternoAlumno = textMaternoAlumno;
	}

	public JTextField getTextTelefonoAlumno() {
		return textTelefonoAlumno;
	}

	public void setTextTelefonoAlumno(JTextField textTelefonoAlumno) {
		this.textTelefonoAlumno = textTelefonoAlumno;
	}

	public JTextField getTextCorreoAlumno() {
		return textCorreoAlumno;
	}

	public void setTextCorreoAlumno(JTextField textCorreoAlumno) {
		this.textCorreoAlumno = textCorreoAlumno;
	}

	public JTextField getTextProyecto() {
		return textProyecto;
	}

	public void setTextProyecto(JTextField textProyecto) {
		this.textProyecto = textProyecto;
	}

	public JTextField getTextMatriculaAlumno() {
		return textMatriculaAlumno;
	}

	public void setTextMatriculaAlumno(JTextField textMatriculaAlumno) {
		this.textMatriculaAlumno = textMatriculaAlumno;
	}

	public JPasswordField getPasswordAlumno() {
		return passwordAlumno;
	}

	public void setPasswordAlumno(JPasswordField passwordAlumno) {
		this.passwordAlumno = passwordAlumno;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboDivision() {
		return comboDivision;
	}

	@SuppressWarnings("rawtypes")
	public void setComboDivision(JComboBox comboDivision) {
		this.comboDivision = comboDivision;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboCarrera() {
		return comboCarrera;
	}

	@SuppressWarnings("rawtypes")
	public void setComboCarrera(JComboBox comboCarrera) {
		this.comboCarrera = comboCarrera;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboCuatrimestre() {
		return comboCuatrimestre;
	}

	@SuppressWarnings("rawtypes")
	public void setComboCuatrimestre(JComboBox comboCuatrimestre) {
		this.comboCuatrimestre = comboCuatrimestre;
	}
	
	
}
