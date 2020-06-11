package vista;
/**
 * Esta Clase es una vista que muestra el formulario para registrar un Asesor Industrial
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import funcionamiento.SocketBuscarActualizarAdministrador;
import funcionamiento.SocketBuscarActualizarAlumno;
import funcionamiento.SocketBuscarActualizarAsesorAca;
import funcionamiento.SocketBuscarActualizarAsesorInd;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketCargarAsesores;
import funcionamiento.SocketInsertarAdministrador;
import funcionamiento.SocketInsertarAsesorAca;
import funcionamiento.SocketInsertarAsesorInd;
import funcionamiento.SocketLogin;
import main.Main;

import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class RegistrarIndustrial extends JFrame {

	private JTextField textNombreIndustrial;
	private JTextField textPaternoIndustrial;
	private JTextField textMaternoIndustrial;
	private JTextField textTelefonoIndustrial;
	private JTextField textCorreoIndustrial;
	private JTextField textEmpresa;
	private JPasswordField passwordIndustrial;
	private JPasswordField passwordIndustrial_1;
	public JButton btnRegistrarAdministrador;
	private char letras;
	
	public RegistrarIndustrial() {
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
				RegistrarIndustrial.this.dispose();
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
		mnAsesores.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/asesores.png")));
		menuBar.add(mnAsesores);
		
		JMenu mnAsesorAcademico = new JMenu("Asesor acad\u00E9mico");
		mnAsesorAcademico.setBackground(new Color(0, 102, 153));
		mnAsesorAcademico.setForeground(new Color(0, 0, 0));
		mnAsesorAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorAcademico.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/academico.png")));
		mnAsesores.add(mnAsesorAcademico);
		
		JMenuItem mntmBuscarAcademico = new JMenuItem("Buscar");
		mntmBuscarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorAca buscarAsesorAca = new SocketBuscarActualizarAsesorAca();
				RegistrarIndustrial.this.dispose();
			}
		});
		mntmBuscarAcademico.setBackground(new Color(0, 102, 153));
		mntmBuscarAcademico.setForeground(new Color(255, 255, 255));
		mntmBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAcademico.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/buscar.png")));
		mnAsesorAcademico.add(mntmBuscarAcademico);
		
		JMenuItem mntmAgregarAcademico = new JMenuItem("Registrar");
		mntmAgregarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorAca asesorAca = new SocketInsertarAsesorAca();
				RegistrarIndustrial.this.dispose();
			}
		});
		mntmAgregarAcademico.setBackground(new Color(0, 102, 153));
		mntmAgregarAcademico.setForeground(new Color(255, 255, 255));
		mntmAgregarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAcademico.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/registrar.png")));
		mnAsesorAcademico.add(mntmAgregarAcademico);
		
		JMenu mnAsesorIndustrial = new JMenu("Asesor industrial");
		mnAsesorIndustrial.setBackground(new Color(0, 102, 153));
		mnAsesorIndustrial.setForeground(new Color(0, 0, 0));
		mnAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorIndustrial.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/asesor industrial.png")));
		mnAsesores.add(mnAsesorIndustrial);
		
		JMenuItem mntmBuscarIndustrial = new JMenuItem("Buscar");
		mntmBuscarIndustrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketBuscarActualizarAsesorInd asesorInd = new SocketBuscarActualizarAsesorInd();
				RegistrarIndustrial.this.dispose();
			}
		});
		mntmBuscarIndustrial.setBackground(new Color(0, 102, 153));
		mntmBuscarIndustrial.setForeground(new Color(255, 255, 255));
		mntmBuscarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarIndustrial.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/buscar.png")));
		mnAsesorIndustrial.add(mntmBuscarIndustrial);
		
		JMenuItem mntmRegistrarIndustrial = new JMenuItem("Registrar");
		mntmRegistrarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorInd asesorInd = new SocketInsertarAsesorInd();
				RegistrarIndustrial.this.dispose();
			}
		});
		mntmRegistrarIndustrial.setBackground(new Color(0, 102, 153));
		mntmRegistrarIndustrial.setForeground(new Color(255, 255, 255));
		mntmRegistrarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrarIndustrial.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/registrar.png")));
		mnAsesorIndustrial.add(mntmRegistrarIndustrial);
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setFont(new Font("Arial", Font.BOLD, 15));
		mnAlumnos.setForeground(new Color(255, 255, 255));
		mnAlumnos.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/alumno.png")));
		menuBar.add(mnAlumnos);
		
		JMenuItem mntmBuscarAlumno = new JMenuItem("Buscar");
		mntmBuscarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAlumno alumno = new SocketBuscarActualizarAlumno();
				RegistrarIndustrial.this.dispose();
			}
		});
		mntmBuscarAlumno.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/buscar.png")));
		mntmBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAlumno.setBackground(new Color(0, 102, 153));
		mntmBuscarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmBuscarAlumno);
		
		JMenuItem mntmAgregarAlumno = new JMenuItem("Registrar");
		mntmAgregarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketCargarAsesores cargarAsesores = new SocketCargarAsesores();
				RegistrarIndustrial.this.dispose();
			}
		});
		mntmAgregarAlumno.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/registrar.png")));
		mntmAgregarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAlumno.setBackground(new Color(0, 102, 153));
		mntmAgregarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmAgregarAlumno);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		mnAdministrador.setForeground(Color.WHITE);
		mnAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mnAdministrador.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/admin.png")));
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmBuscaAdministrador = new JMenuItem("Buscar");
		mntmBuscaAdministrador.setBackground(new Color(0, 102, 153));
		mntmBuscaAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketBuscarActualizarAdministrador administrador = new SocketBuscarActualizarAdministrador();
				RegistrarIndustrial.this.dispose();
			}
		});
		mntmBuscaAdministrador.setForeground(Color.WHITE);
		mntmBuscaAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscaAdministrador.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/buscar.png")));
		mnAdministrador.add(mntmBuscaAdministrador);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.setBackground(new Color(0, 102, 153));
		mntmRegistrar_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				SocketInsertarAdministrador insertarAdmin = new SocketInsertarAdministrador();
				RegistrarIndustrial.this.dispose();
			}
		});
		mntmRegistrar_1.setForeground(Color.WHITE);
		mntmRegistrar_1.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrar_1.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/registrar.png")));
		mnAdministrador.add(mntmRegistrar_1);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					RegistrarIndustrial.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/cerrar.png")));
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
		mntmCambiarContrasea.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblRegistrarAsesorIndustrial = new JLabel("REGISTRAR ASESOR INDUSTRIAL");
		lblRegistrarAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 26));
		lblRegistrarAsesorIndustrial.setBounds(536, 28, 473, 100);
		getContentPane().add(lblRegistrarAsesorIndustrial);
		
		JLabel lblNombre = new JLabel("Nombre (s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(189, 223, 82, 31);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(544, 229, 123, 18);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(902, 229, 123, 18);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(544, 343, 103, 14);
		getContentPane().add(lblTelfono);
		
		JLabel lblCorreoAcademico = new JLabel("Correo");
		lblCorreoAcademico.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreoAcademico.setBounds(902, 339, 81, 22);
		getContentPane().add(lblCorreoAcademico);
		
		textNombreIndustrial = new JTextField();
		textNombreIndustrial.addKeyListener(new KeyAdapter() {
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
		textNombreIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textNombreIndustrial.setBounds(242, 265, 228, 25);
		getContentPane().add(textNombreIndustrial);
		textNombreIndustrial.setColumns(10);
		
		textPaternoIndustrial = new JTextField();
		textPaternoIndustrial.addKeyListener(new KeyAdapter() {
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
		textPaternoIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaternoIndustrial.setBounds(594, 265, 228, 25);
		getContentPane().add(textPaternoIndustrial);
		textPaternoIndustrial.setColumns(10);
		
		textMaternoIndustrial = new JTextField();
		textMaternoIndustrial.addKeyListener(new KeyAdapter() {
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
		textMaternoIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textMaternoIndustrial.setBounds(942, 266, 228, 25);
		getContentPane().add(textMaternoIndustrial);
		textMaternoIndustrial.setColumns(10);
		
		textTelefonoIndustrial = new JTextField();
		textTelefonoIndustrial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		textTelefonoIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textTelefonoIndustrial.setBounds(594, 370, 228, 27);
		getContentPane().add(textTelefonoIndustrial);
		textTelefonoIndustrial.setColumns(10);
		
		textCorreoIndustrial = new JTextField();
		textCorreoIndustrial.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(validarCorreo(textCorreoIndustrial.getText())) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Verifica si ingresaste correctamente el correo electrónico","Error", JOptionPane.ERROR_MESSAGE);
					textCorreoIndustrial.requestFocus();
				}
			}
		});
		textCorreoIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textCorreoIndustrial.setBounds(942, 370, 228, 27);
		getContentPane().add(textCorreoIndustrial);
		textCorreoIndustrial.setColumns(10);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEmpresa.setBounds(189, 341, 67, 18);
		getContentPane().add(lblEmpresa);
		
		textEmpresa = new JTextField();
		textEmpresa.addKeyListener(new KeyAdapter() {
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
		textEmpresa.setFont(new Font("Arial", Font.PLAIN, 15));
		textEmpresa.setBounds(242, 370, 228, 27);
		getContentPane().add(textEmpresa);
		textEmpresa.setColumns(10);
		
		btnRegistrarAdministrador = new JButton("Registrar");
		btnRegistrarAdministrador.setIcon(new ImageIcon(RegistrarIndustrial.class.getResource("/imagenes/guardar.png")));
		btnRegistrarAdministrador.setBackground(new Color(0, 102, 153));
		btnRegistrarAdministrador.setForeground(SystemColor.text);
		btnRegistrarAdministrador.setFont(new Font("Arial", Font.BOLD, 17));
		btnRegistrarAdministrador.setBounds(974, 504, 174, 66);
		getContentPane().add(btnRegistrarAdministrador);
		
		passwordIndustrial = new JPasswordField();
		passwordIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordIndustrial.setBounds(242, 545, 228, 27);
		getContentPane().add(passwordIndustrial);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(189, 520, 94, 14);
		getContentPane().add(lblContrasea);
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 17));
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrasea.setBounds(544, 520, 188, 14);
		getContentPane().add(lblConfirmarContrasea);
		lblConfirmarContrasea.setFont(new Font("Arial", Font.PLAIN, 17));
		
		passwordIndustrial_1 = new JPasswordField();
		passwordIndustrial_1.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordIndustrial_1.setBounds(594, 545, 228, 27);
		getContentPane().add(passwordIndustrial_1);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDatosPersonales.setBounds(189, 155, 166, 31);
		getContentPane().add(lblDatosPersonales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(189, 197, 995, 8);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(191, 486, 658, 2);
		getContentPane().add(separator_1);
		
		JLabel lblOtorgarContrasea = new JLabel("Otorgar contrase\u00F1a");
		lblOtorgarContrasea.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOtorgarContrasea.setBounds(191, 444, 188, 31);
		getContentPane().add(lblOtorgarContrasea);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(281, 231, 13, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(664, 231, 13, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(1024, 233, 13, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(258, 345, 13, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(608, 345, 13, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(955, 339, 13, 14);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(281, 520, 13, 14);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(703, 522, 13, 14);
		getContentPane().add(label_8);
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
	public boolean validarRegistroIndustrial() {
		@SuppressWarnings("unused")
		boolean acceso = true;
		if(textNombreIndustrial.getText().isEmpty() && textPaternoIndustrial.getText().isEmpty() && textMaternoIndustrial.getText().isEmpty() &&
				textEmpresa.getText().isEmpty() && textEmpresa.getText().isEmpty() && textTelefonoIndustrial.getText().isEmpty() && 
				textCorreoIndustrial.getText().isEmpty() && passwordIndustrial.getText().isEmpty() && passwordIndustrial_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Todos los datos con asterisco (*) son obligatorios", "ERROR", JOptionPane.ERROR_MESSAGE);
			textNombreIndustrial.requestFocus();
			return acceso = false;
		}else if(textNombreIndustrial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el nombre del asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			textNombreIndustrial.requestFocus();
			return acceso = false;
		}else if(textPaternoIndustrial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido paterno del asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			textPaternoIndustrial.requestFocus();
			return acceso = false;
		}else if(textMaternoIndustrial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido materno del asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMaternoIndustrial.requestFocus();
			return acceso = false;
		}else if(textEmpresa.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la empresa del asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			textEmpresa.requestFocus();
			return acceso = false;
		}else if(textTelefonoIndustrial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el número telefonico del asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			textTelefonoIndustrial.getText().isEmpty();
			return acceso = false;
		}else if(textCorreoIndustrial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el correo electrónico del asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			textCorreoIndustrial.getText().isEmpty();
			return acceso = false;
		}else if(passwordIndustrial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar una contraseña para el asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordIndustrial.requestFocus();
			return acceso = false;
		}else if(passwordIndustrial_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes confirmar la contraseña del asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordIndustrial_1.requestFocus();
			return acceso = false;
		}else if(passwordIndustrial.getText().equals(passwordIndustrial_1.getText())) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordIndustrial.setText("");
			passwordIndustrial_1.setText("");
			passwordIndustrial.requestFocus();
			return acceso = false;
		}
	}

	public void limpiarCajas() {
		textNombreIndustrial.setText("");
		textPaternoIndustrial.setText("");
		textMaternoIndustrial.setText("");
		textEmpresa.setText("");
		textCorreoIndustrial.setText("");
		textTelefonoIndustrial.setText("");
		passwordIndustrial.setText("");
		passwordIndustrial_1.setText("");
	}

	public JTextField getTextNombreIndustrial() {
		return textNombreIndustrial;
	}

	public void setTextNombreIndustrial(JTextField textNombreIndustrial) {
		this.textNombreIndustrial = textNombreIndustrial;
	}

	public JTextField getTextPaternoIndustrial() {
		return textPaternoIndustrial;
	}

	public void setTextPaternoIndustrial(JTextField textPaternoIndustrial) {
		this.textPaternoIndustrial = textPaternoIndustrial;
	}

	public JTextField getTextMaternoIndustrial() {
		return textMaternoIndustrial;
	}

	public void setTextMaternoIndustrial(JTextField textMaternoIndustrial) {
		this.textMaternoIndustrial = textMaternoIndustrial;
	}

	public JTextField getTextTelefonoIndustrial() {
		return textTelefonoIndustrial;
	}

	public void setTextTelefonoIndustrial(JTextField textTelefonoIndustrial) {
		this.textTelefonoIndustrial = textTelefonoIndustrial;
	}

	public JTextField getTextCorreoIndustrial() {
		return textCorreoIndustrial;
	}

	public void setTextCorreoIndustrial(JTextField textCorreoIndustrial) {
		this.textCorreoIndustrial = textCorreoIndustrial;
	}

	public JTextField getTextEmpresa() {
		return textEmpresa;
	}

	public void setTextEmpresa(JTextField textEmpresa) {
		this.textEmpresa = textEmpresa;
	}

	public JPasswordField getPasswordIndustrial() {
		return passwordIndustrial;
	}

	public void setPasswordIndustrial(JPasswordField passwordIndustrial) {
		this.passwordIndustrial = passwordIndustrial;
	}

	public JButton getBtnRegistrarAdministrador() {
		return btnRegistrarAdministrador;
	}

	public void setBtnRegistrarAdministrador(JButton btnRegistrarAdministrador) {
		this.btnRegistrarAdministrador = btnRegistrarAdministrador;
	}
	
	
}
