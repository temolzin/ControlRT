package vista;
/**
 * Esta Clase es una vista que muestra el formulario para registrar un Asesor Académico
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
import funcionamiento.SocketCargarAsesores;
import funcionamiento.SocketInsertarAdministrador;
import funcionamiento.SocketInsertarAsesorAca;
import funcionamiento.SocketInsertarAsesorInd;
import funcionamiento.SocketLogin;
import main.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class RegistrarAcademico extends JFrame {
	private JTextField textMatriculaAcademico;
	private JTextField textNombreAcademico;
	private JTextField textPaternoAcademico;
	private JTextField textMaternoAcademico;
	private JTextField textTelefonoAcademico;
	private JTextField textCorreoAcademico;
	private JPasswordField passwordAcademico;
	private JPasswordField passwordAcademico_1;
	public JButton btnRegistrar;
	private char letras;

	public RegistrarAcademico() {
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
				RegistrarAcademico.this.dispose();
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
		mnAsesores.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/asesores.png")));
		menuBar.add(mnAsesores);
		
		JMenu mnAsesorAcademico = new JMenu("Asesor acad\u00E9mico");
		mnAsesorAcademico.setBackground(new Color(0, 102, 153));
		mnAsesorAcademico.setForeground(new Color(0, 0, 0));
		mnAsesorAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorAcademico.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/academico.png")));
		mnAsesores.add(mnAsesorAcademico);
		
		JMenuItem mntmBuscarAcademico = new JMenuItem("Buscar");
		mntmBuscarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorAca buscarAsesorAca = new SocketBuscarActualizarAsesorAca();
				RegistrarAcademico.this.dispose();
			}
		});
		mntmBuscarAcademico.setBackground(new Color(0, 102, 153));
		mntmBuscarAcademico.setForeground(new Color(255, 255, 255));
		mntmBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAcademico.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/buscar.png")));
		mnAsesorAcademico.add(mntmBuscarAcademico);
		
		JMenuItem mntmAgregarAcademico = new JMenuItem("Registrar");
		mntmAgregarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorAca asesorAca = new SocketInsertarAsesorAca();
				RegistrarAcademico.this.dispose();
			}
		});
		mntmAgregarAcademico.setBackground(new Color(0, 102, 153));
		mntmAgregarAcademico.setForeground(new Color(255, 255, 255));
		mntmAgregarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAcademico.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/registrar.png")));
		mnAsesorAcademico.add(mntmAgregarAcademico);
		
		JMenu mnAsesorIndustrial = new JMenu("Asesor industrial");
		mnAsesorIndustrial.setBackground(new Color(0, 102, 153));
		mnAsesorIndustrial.setForeground(new Color(0, 0, 0));
		mnAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorIndustrial.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/asesor industrial.png")));
		mnAsesores.add(mnAsesorIndustrial);
		
		JMenuItem mntmBuscarIndustrial = new JMenuItem("Buscar");
		mntmBuscarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorInd asesorInd = new SocketBuscarActualizarAsesorInd();
				RegistrarAcademico.this.dispose();
			}
		});
		mntmBuscarIndustrial.setBackground(new Color(0, 102, 153));
		mntmBuscarIndustrial.setForeground(new Color(255, 255, 255));
		mntmBuscarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarIndustrial.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/buscar.png")));
		mnAsesorIndustrial.add(mntmBuscarIndustrial);
		
		JMenuItem mntmRegistrarIndustrial = new JMenuItem("Registrar");
		mntmRegistrarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorInd asesorInd = new SocketInsertarAsesorInd();
				RegistrarAcademico.this.dispose();
			}
		});
		mntmRegistrarIndustrial.setBackground(new Color(0, 102, 153));
		mntmRegistrarIndustrial.setForeground(new Color(255, 255, 255));
		mntmRegistrarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrarIndustrial.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/registrar.png")));
		mnAsesorIndustrial.add(mntmRegistrarIndustrial);
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setFont(new Font("Arial", Font.BOLD, 15));
		mnAlumnos.setForeground(new Color(255, 255, 255));
		mnAlumnos.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/alumno.png")));
		menuBar.add(mnAlumnos);
		
		JMenuItem mntmBuscarAlumno = new JMenuItem("Buscar");
		mntmBuscarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAlumno alumno = new SocketBuscarActualizarAlumno();
				RegistrarAcademico.this.dispose();
			}
		});
		mntmBuscarAlumno.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/buscar.png")));
		mntmBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAlumno.setBackground(new Color(0, 102, 153));
		mntmBuscarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmBuscarAlumno);
		
		JMenuItem mntmAgregarAlumno = new JMenuItem("Registrar");
		mntmAgregarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketCargarAsesores cargarAsesores = new SocketCargarAsesores();
				RegistrarAcademico.this.dispose();
			}
		});
		mntmAgregarAlumno.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/registrar.png")));
		mntmAgregarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAlumno.setBackground(new Color(0, 102, 153));
		mntmAgregarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmAgregarAlumno);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		mnAdministrador.setForeground(Color.WHITE);
		mnAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mnAdministrador.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/admin.png")));
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmBuscaAdministrador = new JMenuItem("Buscar");
		mntmBuscaAdministrador.setBackground(new Color(0, 102, 153));
		mntmBuscaAdministrador.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAdministrador administrador = new SocketBuscarActualizarAdministrador();
				RegistrarAcademico.this.dispose();
			}
		});
		mntmBuscaAdministrador.setForeground(Color.WHITE);
		mntmBuscaAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscaAdministrador.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/buscar.png")));
		mnAdministrador.add(mntmBuscaAdministrador);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.setBackground(new Color(0, 102, 153));
		mntmRegistrar_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				SocketInsertarAdministrador insertarAdmin = new SocketInsertarAdministrador();
				RegistrarAcademico.this.dispose();
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
					RegistrarAcademico.this.dispose();
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
		
		JLabel lblRegistrarAsesorAcadmico = new JLabel("REGISTRAR ASESOR ACAD\u00C9MICO");
		lblRegistrarAsesorAcadmico.setFont(new Font("Arial", Font.BOLD, 26));
		lblRegistrarAsesorAcadmico.setBounds(526, 28, 458, 100);
		getContentPane().add(lblRegistrarAsesorAcadmico);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatricula.setBounds(176, 204, 67, 31);
		getContentPane().add(lblMatricula);
		
		JLabel lblNombre = new JLabel("Nombre (s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(546, 204, 92, 31);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(858, 210, 145, 18);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(176, 310, 127, 18);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 17));
		lblContrasea.setBounds(175, 492, 92, 14);
		getContentPane().add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrasea.setFont(new Font("Arial", Font.PLAIN, 17));
		lblConfirmarContrasea.setBounds(542, 492, 198, 14);
		getContentPane().add(lblConfirmarContrasea);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(546, 312, 103, 14);
		getContentPane().add(lblTelfono);
		
		JLabel lblCorreoAcademico = new JLabel("Correo");
		lblCorreoAcademico.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreoAcademico.setBounds(858, 308, 81, 22);
		getContentPane().add(lblCorreoAcademico);
		
		textMatriculaAcademico = new JTextField();
		textMatriculaAcademico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		textMatriculaAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textMatriculaAcademico.setBounds(202, 246, 228, 27);		
		getContentPane().add(textMatriculaAcademico);
		textMatriculaAcademico.setColumns(10);
		
		textNombreAcademico = new JTextField();
		textNombreAcademico.addKeyListener(new KeyAdapter() {
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
		textNombreAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textNombreAcademico.setBounds(578, 246, 228, 27);
		getContentPane().add(textNombreAcademico);
		textNombreAcademico.setColumns(10);
		
		textPaternoAcademico = new JTextField();
		textPaternoAcademico.addKeyListener(new KeyAdapter() {
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
		textPaternoAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textPaternoAcademico.setBounds(917, 246, 228, 27);
		getContentPane().add(textPaternoAcademico);
		textPaternoAcademico.setColumns(10);
		
		textMaternoAcademico = new JTextField();
		textMaternoAcademico.addKeyListener(new KeyAdapter() {
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
		textMaternoAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textMaternoAcademico.setBounds(202, 349, 228, 27);
		getContentPane().add(textMaternoAcademico);
		textMaternoAcademico.setColumns(10);
		
		textTelefonoAcademico = new JTextField();
		textTelefonoAcademico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		textTelefonoAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textTelefonoAcademico.setBounds(578, 349, 228, 27);
		getContentPane().add(textTelefonoAcademico);
		textTelefonoAcademico.setColumns(10);
		
		textCorreoAcademico = new JTextField();
		textCorreoAcademico.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(validarCorreo(textCorreoAcademico.getText())) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Verifica si ingresaste correctamente el correo electrónico","Error", JOptionPane.ERROR_MESSAGE);
					textCorreoAcademico.requestFocus();
				}
			}
		});
		textCorreoAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textCorreoAcademico.setBounds(917, 349, 228, 27);
		getContentPane().add(textCorreoAcademico);
		textCorreoAcademico.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");

		btnRegistrar.setIcon(new ImageIcon(RegistrarAcademico.class.getResource("/imagenes/guardar.png")));
		btnRegistrar.setBackground(new Color(0, 102, 153));
		btnRegistrar.setForeground(SystemColor.text);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 17));
		btnRegistrar.setBounds(935, 489, 174, 66);
		getContentPane().add(btnRegistrar);
		
		passwordAcademico = new JPasswordField();
		passwordAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordAcademico.setBounds(202, 530, 228, 27);
		getContentPane().add(passwordAcademico);
		
		passwordAcademico_1 = new JPasswordField();
		passwordAcademico_1.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordAcademico_1.setBounds(578, 531, 228, 27);
		getContentPane().add(passwordAcademico_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(176, 193, 967, 2);
		getContentPane().add(separator);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDatosPersonales.setBounds(176, 154, 198, 31);
		getContentPane().add(lblDatosPersonales);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(176, 479, 649, 2);
		getContentPane().add(separator_1);
		
		JLabel lblOtorgarContrasea = new JLabel("Otorgar contrase\u00F1a");
		lblOtorgarContrasea.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOtorgarContrasea.setBounds(176, 431, 181, 37);
		getContentPane().add(lblOtorgarContrasea);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(241, 204, 9, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(629, 204, 9, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(297, 310, 9, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(610, 308, 9, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(975, 206, 9, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(910, 308, 9, 14);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(260, 489, 9, 14);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(704, 491, 9, 14);
		getContentPane().add(label_8);
	}

	public JTextField getTextMatriculaAcademico() {
		return textMatriculaAcademico;
	}

	public void setTextMatriculaAcademico(JTextField textMatriculaAcademico) {
		this.textMatriculaAcademico = textMatriculaAcademico;
	}

	public JTextField getTextNombreAcademico() {
		return textNombreAcademico;
	}

	public void setTextNombreAcademico(JTextField textNombreAcademico) {
		this.textNombreAcademico = textNombreAcademico;
	}

	public JTextField getTextPaternoAcademico() {
		return textPaternoAcademico;
	}

	public void setTextPaternoAcademico(JTextField textPaternoAcademico) {
		this.textPaternoAcademico = textPaternoAcademico;
	}

	public JTextField getTextMaternoAcademico() {
		return textMaternoAcademico;
	}

	public void setTextMaternoAcademico(JTextField textMaternoAcademico) {
		this.textMaternoAcademico = textMaternoAcademico;
	}

	public JTextField getTextTelefonoAcademico() {
		return textTelefonoAcademico;
	}

	public void setTextTelefonoAcademico(JTextField textTelefonoAcademico) {
		this.textTelefonoAcademico = textTelefonoAcademico;
	}

	public JTextField getTextCorreoAcademico() {
		return textCorreoAcademico;
	}

	public void setTextCorreoAcademico(JTextField textCorreoAcademico) {
		this.textCorreoAcademico = textCorreoAcademico;
	}

	public JPasswordField getPasswordAcademico() {
		return passwordAcademico;
	}

	public void setPasswordAcademico(JPasswordField passwordAcademico) {
		this.passwordAcademico = passwordAcademico;
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
	
	public void limpiarCajas() {
		textMatriculaAcademico.setText("");
		textNombreAcademico.setText("");
		textPaternoAcademico.setText("");
		textMaternoAcademico.setText("");
		textTelefonoAcademico.setText("");
		textCorreoAcademico.setText("");
		passwordAcademico.setText("");
		passwordAcademico_1.setText("");
	}
	
	@SuppressWarnings("deprecation")
	public boolean validarRegistroAcademico() {
		@SuppressWarnings("unused")
		boolean acceso = true;
		if(textMatriculaAcademico.getText().isEmpty() && textNombreAcademico.getText().isEmpty() && textPaternoAcademico.getText().isEmpty() &&
				textMaternoAcademico.getText().isEmpty() && textTelefonoAcademico.getText().isEmpty() && textCorreoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Todos los datos con asterisco (*) son obligatorios", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMatriculaAcademico.requestFocus();
			return acceso = false; 
		} else if(textMatriculaAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la matricula del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMatriculaAcademico.requestFocus();
			return acceso = false; 
		} else if(textNombreAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el nombre del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textNombreAcademico.requestFocus();
			return acceso = false; 
		} else if(textPaternoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido paterno del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textPaternoAcademico.requestFocus();
			return acceso = false; 
		} else if(textMaternoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido materno del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textMaternoAcademico.requestFocus();
			return acceso = false; 
		} else if(textTelefonoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el número telefonico del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textTelefonoAcademico.requestFocus();
			return acceso = false; 
		} else if(textCorreoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el correo del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textCorreoAcademico.requestFocus();
			return acceso = false; 
		} else if(passwordAcademico.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Debes ingresar una contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordAcademico.requestFocus();
			return acceso = false; 
		} else if(passwordAcademico_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la confimacion de la contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordAcademico_1.requestFocus();
			return acceso = false; 
		} else if(passwordAcademico.getText().equals(passwordAcademico_1.getText())) {
			return acceso = true; 
		} else {
			JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales", "ERROR", JOptionPane.ERROR_MESSAGE);
			passwordAcademico.setText("");
			passwordAcademico_1.setText("");
			passwordAcademico.requestFocus();
			return acceso = false; 
		}
	}
	
}
