package vista;
/**
 * Esta Clase es una vista que muestra los datos del asesor Académico para ser editados.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import funcionamiento.SocketBuscarActualizarAdministrador;
import funcionamiento.SocketBuscarActualizarAlumno;
import funcionamiento.SocketBuscarActualizarAsesorInd;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketCargarAsesores;
import funcionamiento.SocketInsertarAdministrador;
import funcionamiento.SocketInsertarAsesorAca;
import funcionamiento.SocketInsertarAsesorInd;
import funcionamiento.SocketLogin;
import main.Main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class BuscarAcademico extends JFrame {
	
	private JTextField textBuscarAcademico;
	private JTextField textFieldMatriculaAcademico;
	private JTextField textFieldNombreAcademico;
	private JTextField textFieldTelefonoAcademico;
	private JTextField textFieldPaternoAcademico;
	private JTextField textFieldMaternoAcademico;
	private JTextField textFieldCorreoAcademico;
	private JTable tableAcademico;
	public JButton btnEliminarAcademico;
	public JButton btnEditarAcademico;
	public JButton btnBuscarAcademico;
	public JScrollPane scrollPaneAcademico;
	private JTextField jtfPassword;
	private char letras;

	public BuscarAcademico() {
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
				BuscarAcademico.this.dispose();
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
		mnAsesores.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/asesores.png")));
		menuBar.add(mnAsesores);
		
		JMenu mnAsesorAcademico = new JMenu("Asesor acad\u00E9mico");
		mnAsesorAcademico.setBackground(new Color(0, 102, 153));
		mnAsesorAcademico.setForeground(new Color(0, 0, 0));
		mnAsesorAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorAcademico.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/academico.png")));
		mnAsesores.add(mnAsesorAcademico);
		
		JMenuItem mntmBuscarAcademico = new JMenuItem("Buscar");
		mntmBuscarAcademico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//SocketBuscarActualizarAsesorAca buscarAsesorAca = new SocketBuscarActualizarAsesorAca();
				//BuscarAcademico.this.dispose();
			}
		});
		mntmBuscarAcademico.setBackground(new Color(0, 102, 153));
		mntmBuscarAcademico.setForeground(new Color(255, 255, 255));
		mntmBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAcademico.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/buscar.png")));
		mnAsesorAcademico.add(mntmBuscarAcademico);
		
		JMenuItem mntmAgregarAcademico = new JMenuItem("Registrar");
		mntmAgregarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorAca asesorAca = new SocketInsertarAsesorAca();
				BuscarAcademico.this.dispose();
			}
		});
		mntmAgregarAcademico.setBackground(new Color(0, 102, 153));
		mntmAgregarAcademico.setForeground(new Color(255, 255, 255));
		mntmAgregarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAcademico.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/registrar.png")));
		mnAsesorAcademico.add(mntmAgregarAcademico);
		
		JMenu mnAsesorIndustrial = new JMenu("Asesor industrial");
		mnAsesorIndustrial.setBackground(new Color(0, 102, 153));
		mnAsesorIndustrial.setForeground(new Color(0, 0, 0));
		mnAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorIndustrial.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/asesor industrial.png")));
		mnAsesores.add(mnAsesorIndustrial);
		
		JMenuItem mntmBuscarIndustrial = new JMenuItem("Buscar");
		mntmBuscarIndustrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketBuscarActualizarAsesorInd asesorInd = new SocketBuscarActualizarAsesorInd();
				BuscarAcademico.this.dispose();
			}
		});
		mntmBuscarIndustrial.setBackground(new Color(0, 102, 153));
		mntmBuscarIndustrial.setForeground(new Color(255, 255, 255));
		mntmBuscarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarIndustrial.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/buscar.png")));
		mnAsesorIndustrial.add(mntmBuscarIndustrial);
		
		JMenuItem mntmRegistrarIndustrial = new JMenuItem("Registrar");
		mntmRegistrarIndustrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketInsertarAsesorInd asesorInd = new SocketInsertarAsesorInd();
				BuscarAcademico.this.dispose();
			}
		});
		mntmRegistrarIndustrial.setBackground(new Color(0, 102, 153));
		mntmRegistrarIndustrial.setForeground(new Color(255, 255, 255));
		mntmRegistrarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrarIndustrial.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/registrar.png")));
		mnAsesorIndustrial.add(mntmRegistrarIndustrial);
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setFont(new Font("Arial", Font.BOLD, 15));
		mnAlumnos.setForeground(new Color(255, 255, 255));
		mnAlumnos.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/alumno.png")));
		menuBar.add(mnAlumnos);
		
		JMenuItem mntmBuscarAlumno = new JMenuItem("Buscar");
		mntmBuscarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAlumno alumno = new SocketBuscarActualizarAlumno();
				BuscarAcademico.this.dispose();
			}
		});
		mntmBuscarAlumno.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mntmBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAlumno.setBackground(new Color(0, 102, 153));
		mntmBuscarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmBuscarAlumno);
		
		JMenuItem mntmAgregarAlumno = new JMenuItem("Registrar");
		mntmAgregarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketCargarAsesores cargarAsesores = new SocketCargarAsesores();
				BuscarAcademico.this.dispose();
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
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketBuscarActualizarAdministrador administrador = new SocketBuscarActualizarAdministrador();
				BuscarAcademico.this.dispose();
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
				BuscarAcademico.this.dispose();
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
					BuscarAcademico.this.dispose();
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
		
		JLabel lblBuscarAsesorAcadmico = new JLabel("BUSCAR ASESOR ACAD\u00C9MICO");
		lblBuscarAsesorAcadmico.setFont(new Font("Arial", Font.BOLD, 25));
		lblBuscarAsesorAcadmico.setBounds(552, 11, 394, 40);
		getContentPane().add(lblBuscarAsesorAcadmico);
		
		JLabel lblNombre = new JLabel("Nombre (s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(540, 83, 82, 14);
		getContentPane().add(lblNombre);
		
		btnBuscarAcademico = new JButton("");

		btnBuscarAcademico.setBackground(new Color(0, 102, 153));
		btnBuscarAcademico.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/buscar.png")));
		btnBuscarAcademico.setForeground(SystemColor.text);
		btnBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 17));
		btnBuscarAcademico.setBounds(911, 62, 75, 57);
		getContentPane().add(btnBuscarAcademico);
		
		textBuscarAcademico = new JTextField();
		textBuscarAcademico.addKeyListener(new KeyAdapter() {
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

		textBuscarAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textBuscarAcademico.setBounds(632, 79, 228, 27);
		getContentPane().add(textBuscarAcademico);
		textBuscarAcademico.setEditable(false);
		textBuscarAcademico.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatricula.setBounds(37, 357, 86, 14);
		getContentPane().add(lblMatricula);
		
		textFieldMatriculaAcademico = new JTextField();
		textFieldMatriculaAcademico.setBackground(new Color(255, 255, 255));
		textFieldMatriculaAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldMatriculaAcademico.setEditable(false);
		textFieldMatriculaAcademico.setBounds(47, 406, 228, 27);
		getContentPane().add(textFieldMatriculaAcademico);
		textFieldMatriculaAcademico.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombre (s)");
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombres.setBounds(323, 352, 101, 25);
		getContentPane().add(lblNombres);
		
		textFieldNombreAcademico = new JTextField();
		textFieldNombreAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldNombreAcademico.setBounds(348, 406, 228, 27);
		getContentPane().add(textFieldNombreAcademico);
		textFieldNombreAcademico.setColumns(10);
		
		textFieldTelefonoAcademico = new JTextField();
		textFieldTelefonoAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldTelefonoAcademico.setBounds(348, 504, 228, 27);
		getContentPane().add(textFieldTelefonoAcademico);
		textFieldTelefonoAcademico.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(323, 465, 151, 14);
		getContentPane().add(lblTelfono);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(688, 352, 148, 19);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(37, 458, 148, 29);
		getContentPane().add(lblApellidoMaterno);
		
		textFieldPaternoAcademico = new JTextField();
		textFieldPaternoAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldPaternoAcademico.setBounds(743, 389, 228, 27);
		getContentPane().add(textFieldPaternoAcademico);
		textFieldPaternoAcademico.setColumns(10);
		
		textFieldMaternoAcademico = new JTextField();
		textFieldMaternoAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldMaternoAcademico.setBounds(47, 504, 228, 27);
		getContentPane().add(textFieldMaternoAcademico);
		textFieldMaternoAcademico.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreo.setBounds(688, 465, 151, 14);
		getContentPane().add(lblCorreo);
		
		textFieldCorreoAcademico = new JTextField();
		textFieldCorreoAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCorreoAcademico.setBounds(733, 504, 228, 27);
		getContentPane().add(textFieldCorreoAcademico);
		textFieldCorreoAcademico.setColumns(10);
		
		btnEditarAcademico = new JButton("Editar");
		btnEditarAcademico.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/edit.png")));
		
		btnEditarAcademico.setForeground(new Color(255, 255, 255));
		btnEditarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditarAcademico.setBackground(new Color(0, 102, 153));
		btnEditarAcademico.setBounds(1094, 515, 151, 57);
		getContentPane().add(btnEditarAcademico);
		
		btnEliminarAcademico = new JButton("Eliminar");

		btnEliminarAcademico.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/eliminar.png")));
		btnEliminarAcademico.setBackground(new Color(128, 0, 0));
		btnEliminarAcademico.setForeground(new Color(255, 255, 255));
		btnEliminarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		btnEliminarAcademico.setBounds(1091, 375, 154, 57);
		getContentPane().add(btnEliminarAcademico);
		
		scrollPaneAcademico = new JScrollPane();
		
		scrollPaneAcademico.setBounds(37, 165, 1295, 151);
		getContentPane().add(scrollPaneAcademico);
		
		tableAcademico = new JTable();
		tableAcademico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableAcademico.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Nombre(s)", "Apellido Paterno", "Apellido materno", "Correo", "Tel\u00E9fono", "Contrase\u00F1a"
			}
		));
		scrollPaneAcademico.setViewportView(tableAcademico);
		
		JLabel jlbPassword = new JLabel("Contrase\u00F1a");
		jlbPassword.setFont(new Font("Arial", Font.PLAIN, 17));
		jlbPassword.setBounds(37, 557, 151, 14);
		getContentPane().add(jlbPassword);
		
		jtfPassword = new JTextField();
		jtfPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		jtfPassword.setColumns(10);
		jtfPassword.setBounds(47, 594, 228, 27);
		getContentPane().add(jtfPassword);
	}
	
	public JTable getTableAcademico() {
		return tableAcademico;
	}

	public void setTableAcademico(JTable tableAcademico) {
		this.tableAcademico = tableAcademico;
	}
	
	
	public JTextField getTextBuscarAcademico() {
		return textBuscarAcademico;
	}

	public void setTextBuscarAcademico(JTextField textBuscarAcademico) {
		this.textBuscarAcademico = textBuscarAcademico;
	}

	public JTextField getTextFieldMatriculaAcademico() {
		return textFieldMatriculaAcademico;
	}

	public void setTextFieldMatriculaAcademico(JTextField textFieldMatriculaAcademico) {
		this.textFieldMatriculaAcademico = textFieldMatriculaAcademico;
	}

	public JTextField getTextFieldNombreAcademico() {
		return textFieldNombreAcademico;
	}

	public void setTextFieldNombreAcademico(JTextField textFieldNombreAcademico) {
		this.textFieldNombreAcademico = textFieldNombreAcademico;
	}

	public JTextField getTextFieldTelefonoAcademico() {
		return textFieldTelefonoAcademico;
	}

	public void setTextFieldTelefonoAcademico(JTextField textFieldTelefonoAcademico) {
		this.textFieldTelefonoAcademico = textFieldTelefonoAcademico;
	}

	public JTextField getTextFieldPaternoAcademico() {
		return textFieldPaternoAcademico;
	}

	public void setTextFieldPaternoAcademico(JTextField textFieldPaternoAcademico) {
		this.textFieldPaternoAcademico = textFieldPaternoAcademico;
	}

	public JTextField getTextFieldMaternoAcademico() {
		return textFieldMaternoAcademico;
	}

	public void setTextFieldMaternoAcademico(JTextField textFieldMaternoAcademico) {
		this.textFieldMaternoAcademico = textFieldMaternoAcademico;
	}

	public JTextField getTextFieldCorreoAcademico() {
		return textFieldCorreoAcademico;
	}

	public void setTextFieldCorreoAcademico(JTextField textFieldCorreoAcademico) {
		this.textFieldCorreoAcademico = textFieldCorreoAcademico;
	}

	public JTextField getJtfPassword() {
		return jtfPassword;
	}

	public void setJtfPassword(JTextField jtfPassword) {
		this.jtfPassword = jtfPassword;
	}
	
	public boolean validarEditarAcademico() {
		@SuppressWarnings("unused")
		boolean acceso = true;
		if(textFieldMatriculaAcademico.getText().isEmpty() && textFieldNombreAcademico.getText().isEmpty() && textFieldPaternoAcademico.getText().isEmpty() &&
				textFieldMaternoAcademico.getText().isEmpty() && textFieldTelefonoAcademico.getText().isEmpty() && textFieldCorreoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Todos los datos con asterisco (*) son obligatorios", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldMatriculaAcademico.requestFocus();
			return acceso = false; 
		} else if(textFieldMatriculaAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la matricula del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldMatriculaAcademico.requestFocus();
			return acceso = false; 
		} else if(textFieldNombreAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el nombre del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldNombreAcademico.requestFocus();
			return acceso = false; 
		} else if(textFieldPaternoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido paterno del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldPaternoAcademico.requestFocus();
			return acceso = false; 
		} else if(textFieldMaternoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido materno del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldMaternoAcademico.requestFocus();
			return acceso = false; 
		} else if(textFieldTelefonoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el número telefonico del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldTelefonoAcademico.requestFocus();
			return acceso = false; 
		} else if(textFieldCorreoAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el correo del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldCorreoAcademico.requestFocus();
			return acceso = false; 
		} else if(jtfPassword.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Debes ingresar una contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
			jtfPassword.requestFocus();
			return acceso = false; 
		}else {
			return true;
		}
	}
}
