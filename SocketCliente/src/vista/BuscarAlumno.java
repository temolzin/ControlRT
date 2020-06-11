package vista;
/**
 * Esta Clase es una vista que muestra los datos del alumno para ser editados.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import funcionamiento.SocketBuscarActualizarAdministrador;
import funcionamiento.SocketBuscarActualizarAsesorAca;
import funcionamiento.SocketBuscarActualizarAsesorInd;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketCargarAsesores;
import funcionamiento.SocketInsertarAdministrador;
import funcionamiento.SocketInsertarAsesorAca;
import funcionamiento.SocketInsertarAsesorInd;
import funcionamiento.SocketLogin;
import main.Main;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class BuscarAlumno extends JFrame {

	private JTextField textFieldBuscarAlumno;
	private JTable tableAlumno;
	private JTextField textMatriculaAlumno;
	private JTextField textNombreAlumno;
	private JTextField textPaternoAlumno;
	private JTextField textMaternoAlumno;
	private JTextField textTelefonoAlumno;
	private JTextField textCorreoAlumno;
	private JTextField textProyectoAlumno;
	public JButton btnEditarAlumno;
	public JButton btnEliminarAlumno;
	public JButton btnBuscarAlumno;
	private char letras;
	@SuppressWarnings("rawtypes")
	public JComboBox comboDivision;
	@SuppressWarnings("rawtypes")
	public JComboBox comboCarrera;
	@SuppressWarnings("rawtypes")
	public JComboBox comboCuatrimestre;
	private JTextField jtfAsesorAca;
	private JTextField jtfAsesorInd;
	private JTextField passwordAlumno;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BuscarAlumno() {
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
				BuscarAlumno.this.dispose();
			}
		});;
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
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketBuscarActualizarAsesorAca buscarAsesorAca = new SocketBuscarActualizarAsesorAca();
				BuscarAlumno.this.dispose();
			}
		});
		mntmBuscarAcademico.setBackground(new Color(0, 102, 153));
		mntmBuscarAcademico.setForeground(new Color(255, 255, 255));
		mntmBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAcademico.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mnAsesorAcademico.add(mntmBuscarAcademico);
		
		JMenuItem mntmAgregarAcademico = new JMenuItem("Registrar");
		mntmAgregarAcademico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketInsertarAsesorAca asesorAca = new SocketInsertarAsesorAca();
				BuscarAlumno.this.dispose();
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
				BuscarAlumno.this.dispose();
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
				BuscarAlumno.this.dispose();
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

		mntmBuscarAlumno.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mntmBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAlumno.setBackground(new Color(0, 102, 153));
		mntmBuscarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmBuscarAlumno);
		
		JMenuItem mntmAgregarAlumno = new JMenuItem("Registrar");
		mntmAgregarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketCargarAsesores cargarAsesores = new SocketCargarAsesores();
				BuscarAlumno.this.dispose();
			}
		});
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
				BuscarAlumno.this.dispose();
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
				BuscarAlumno.this.dispose();
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
					BuscarAlumno.this.dispose();
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
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
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
		
		JLabel lblBuscarAlumno = new JLabel("BUSCAR ALUMNO");
		lblBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 26));
		lblBuscarAlumno.setBounds(632, 11, 261, 54);
		getContentPane().add(lblBuscarAlumno);
		
		JLabel lblNombres = new JLabel("Nombre(s)");
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombres.setBounds(555, 77, 77, 32);
		getContentPane().add(lblNombres);
		
		textFieldBuscarAlumno = new JTextField();
		textFieldBuscarAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldBuscarAlumno.addKeyListener(new KeyAdapter() {
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
		textFieldBuscarAlumno.setBounds(642, 81, 228, 27);
		getContentPane().add(textFieldBuscarAlumno);
		textFieldBuscarAlumno.setColumns(10);
		
		btnBuscarAlumno = new JButton("");
		btnBuscarAlumno.setIcon(new ImageIcon(BuscarAlumno.class.getResource("/imagenes/buscar.png")));
		btnBuscarAlumno.setBounds(907, 61, 77, 54);
		btnBuscarAlumno.setBackground(new Color(0, 102, 153));
		getContentPane().add(btnBuscarAlumno);
		
		JScrollPane scrollPaneAlumno = new JScrollPane();
		scrollPaneAlumno.setBounds(37, 154, 1301, 157);
		getContentPane().add(scrollPaneAlumno);
		
		tableAlumno = new JTable();
		tableAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableAlumno.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Nombre(s)", "Apellido paterno", "Apellido materno", "Tel\u00E9fono", "Correo", "Proyecto", "Asesor acad\u00E9mico", "Asesor industrial", "Contrase\u00F1a"
			}
		));
		scrollPaneAlumno.setViewportView(tableAlumno);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatricula.setBounds(37, 326, 77, 27);
		getContentPane().add(lblMatricula);
		
		JLabel lblNombre = new JLabel("Nombre(s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(345, 326, 88, 20);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(671, 332, 123, 20);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(978, 326, 130, 27);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(37, 414, 77, 20);
		getContentPane().add(lblTelfono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreo.setBounds(345, 416, 66, 17);
		getContentPane().add(lblCorreo);
		
		JLabel lblProyecto = new JLabel("Nombre del proyecto");
		lblProyecto.setFont(new Font("Arial", Font.PLAIN, 17));
		lblProyecto.setBounds(671, 414, 161, 20);
		getContentPane().add(lblProyecto);
		
		textMatriculaAlumno = new JTextField();
		textMatriculaAlumno.setFont(new Font("Arial", Font.PLAIN, 16));
		textMatriculaAlumno.setBackground(new Color(255, 255, 255));
		textMatriculaAlumno.setEditable(false);
		textMatriculaAlumno.setBounds(66, 366, 228, 25);
		getContentPane().add(textMatriculaAlumno);
		textMatriculaAlumno.setColumns(10);
		
		textNombreAlumno = new JTextField();
		textNombreAlumno.setFont(new Font("Arial", Font.PLAIN, 16));
		textNombreAlumno.setBounds(371, 364, 228, 25);
		getContentPane().add(textNombreAlumno);
		textNombreAlumno.setColumns(10);
		
		textPaternoAlumno = new JTextField();
		textPaternoAlumno.setFont(new Font("Arial", Font.PLAIN, 16));
		textPaternoAlumno.setBounds(695, 366, 228, 25);
		getContentPane().add(textPaternoAlumno);
		textPaternoAlumno.setColumns(10);
		
		textMaternoAlumno = new JTextField();
		textMaternoAlumno.setFont(new Font("Arial", Font.PLAIN, 16));
		textMaternoAlumno.setBounds(1021, 366, 228, 25);
		getContentPane().add(textMaternoAlumno);
		textMaternoAlumno.setColumns(10);
		
		textTelefonoAlumno = new JTextField();
		textTelefonoAlumno.setFont(new Font("Arial", Font.PLAIN, 16));
		textTelefonoAlumno.setBounds(66, 453, 228, 25);
		getContentPane().add(textTelefonoAlumno);
		textTelefonoAlumno.setColumns(10);
		
		textCorreoAlumno = new JTextField();
		textCorreoAlumno.setFont(new Font("Arial", Font.PLAIN, 16));
		textCorreoAlumno.setBounds(371, 453, 228, 25);
		getContentPane().add(textCorreoAlumno);
		textCorreoAlumno.setColumns(10);
		
		textProyectoAlumno = new JTextField();
		textProyectoAlumno.setFont(new Font("Arial", Font.PLAIN, 16));
		textProyectoAlumno.setBounds(695, 459, 228, 25);
		getContentPane().add(textProyectoAlumno);
		textProyectoAlumno.setColumns(10);
		
		JLabel lblMatriculaAsesorAcadmico = new JLabel("Matricula asesor acad\u00E9mico");
		lblMatriculaAsesorAcadmico.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatriculaAsesorAcadmico.setBounds(37, 499, 205, 27);
		getContentPane().add(lblMatriculaAsesorAcadmico);
		
		JLabel lblMatriculaAsesorIndustrial = new JLabel("Matricula asesor industrial");
		lblMatriculaAsesorIndustrial.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatriculaAsesorIndustrial.setBounds(345, 499, 205, 27);
		getContentPane().add(lblMatriculaAsesorIndustrial);
		
		btnEliminarAlumno = new JButton("Eliminar");
		btnEliminarAlumno.setBackground(new Color(128, 0, 0));
		btnEliminarAlumno.setForeground(new Color(255, 255, 255));
		btnEliminarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		btnEliminarAlumno.setIcon(new ImageIcon(BuscarAlumno.class.getResource("/imagenes/eliminar.png")));
		btnEliminarAlumno.setBounds(1063, 441, 145, 59);
		getContentPane().add(btnEliminarAlumno);
		
		btnEditarAlumno = new JButton("Editar");
		btnEditarAlumno.setForeground(new Color(255, 255, 255));
		btnEditarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditarAlumno.setIcon(new ImageIcon(BuscarAlumno.class.getResource("/imagenes/edit.png")));
		btnEditarAlumno.setBounds(1063, 527, 145, 59);
		btnEditarAlumno.setBackground(new Color(0, 102, 153));
		getContentPane().add(btnEditarAlumno);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(671, 503, 94, 19);
		getContentPane().add(lblNewLabel);
		
		comboCarrera = new JComboBox();
		comboCarrera.setBounds(253, 609, 374, 25);
		getContentPane().add(comboCarrera);
		
		JLabel lblNewLabel_1 = new JLabel("Divisi\u00F3n");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(37, 577, 66, 27);
		getContentPane().add(lblNewLabel_1);
		
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
		comboDivision.setBounds(66, 608, 81, 25);
		getContentPane().add(comboDivision);
		
		
		JLabel label_12 = new JLabel("Carrera");
		label_12.setFont(new Font("Arial", Font.PLAIN, 17));
		label_12.setBounds(225, 583, 67, 14);
		getContentPane().add(label_12);
		
		comboCuatrimestre = new JComboBox();
		comboCuatrimestre.setModel(new DefaultComboBoxModel(new String[] {"", "Enero - Abril", "Mayo - Agosto", "Septiembre - Diciembre"}));
		comboCuatrimestre.setBounds(695, 609, 228, 25);
		getContentPane().add(comboCuatrimestre);
		
		JLabel lblCarrera = new JLabel("Periodo cuatrimestral");
		lblCarrera.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCarrera.setBounds(671, 574, 161, 25);
		getContentPane().add(lblCarrera);
		
		jtfAsesorAca = new JTextField();
		jtfAsesorAca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		jtfAsesorAca.setFont(new Font("Arial", Font.PLAIN, 16));
		jtfAsesorAca.setColumns(10);
		jtfAsesorAca.setBounds(66, 537, 228, 25);
		getContentPane().add(jtfAsesorAca);
		
		jtfAsesorInd = new JTextField();
		jtfAsesorInd.setFont(new Font("Arial", Font.PLAIN, 16));
		jtfAsesorInd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		jtfAsesorInd.setColumns(10);
		jtfAsesorInd.setBounds(371, 537, 228, 25);
		getContentPane().add(jtfAsesorInd);
		
		JLabel nota = new JLabel("*Nota: Para cambiar a los asesores necesitas poner su matr\u00EDcula.");
		nota.setForeground(Color.RED);
		nota.setFont(new Font("Arial", Font.PLAIN, 13));
		nota.setBounds(525, 119, 406, 32);
		getContentPane().add(nota);
		
		passwordAlumno = new JTextField();
		passwordAlumno.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordAlumno.setColumns(10);
		passwordAlumno.setBounds(695, 527, 228, 25);
		getContentPane().add(passwordAlumno);
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

	public JTextField getTextFieldBuscarAlumno() {
		return textFieldBuscarAlumno;
	}

	public void setTextFieldBuscarAlumno(JTextField textFieldBuscarAlumno) {
		this.textFieldBuscarAlumno = textFieldBuscarAlumno;
	}

	public JTable getTableAlumno() {
		return tableAlumno;
	}

	public void setTableAlumno(JTable tableAlumno) {
		this.tableAlumno = tableAlumno;
	}

	public JTextField getTextMatriculaAlumno() {
		return textMatriculaAlumno;
	}

	public void setTextMatriculaAlumno(JTextField textMatriculaAlumno) {
		this.textMatriculaAlumno = textMatriculaAlumno;
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

	public JTextField getTextProyectoAlumno() {
		return textProyectoAlumno;
	}

	public void setTextProyectoAlumno(JTextField textProyectoAlumno) {
		this.textProyectoAlumno = textProyectoAlumno;
	}

	public JTextField getPasswordAlumno() {
		return passwordAlumno;
	}

	public void setPasswordAlumno(JTextField passwordAlumno) {
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

	public JTextField getJtfAsesorAca() {
		return jtfAsesorAca;
	}

	public void setJtfAsesorAca(JTextField jtfAsesorAca) {
		this.jtfAsesorAca = jtfAsesorAca;
	}

	public JTextField getJtfAsesorInd() {
		return jtfAsesorInd;
	}

	public void setJtfAsesorInd(JTextField jtfAsesorInd) {
		this.jtfAsesorInd = jtfAsesorInd;
	}

	public boolean validarEditarAlumno() {
		if(textMatriculaAlumno.getText().isEmpty() && textNombreAlumno.getText().isEmpty() && textPaternoAlumno.getText().isEmpty() 
				&& textMaternoAlumno.getText().isEmpty() &&	textTelefonoAlumno.getText().isEmpty() && textCorreoAlumno.getText().isEmpty() 
				&& this.textProyectoAlumno.getText().isEmpty()) {
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
		} else if(this.textProyectoAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el nombre del proyecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.textProyectoAlumno.requestFocus();
			return false;
		} else if(this.jtfAsesorAca.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la matricula del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.jtfAsesorAca.requestFocus();
			return false;
		} else if(this.jtfAsesorInd.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la matricula del asesor industrial", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.jtfAsesorInd.requestFocus();
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
		} else {
			return true;
		}
	}
}
