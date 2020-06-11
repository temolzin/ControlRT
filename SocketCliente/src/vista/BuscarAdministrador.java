package vista;
/**
 * Esta Clase es una vista que muestra los datos del administrador para ser editados.
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class BuscarAdministrador extends JFrame {

	private JTextField textFieldBuscarAdmin;
	private JTextField textFieldMatriculaAdmin;
	private JTextField textFieldNombreAdmin;
	private JTextField textFieldTelefonoAdmin;
	private JTextField textFieldPaternoAdmin;
	private JTextField textFieldMaternoAdmin;
	private JTextField textFieldCorreoAdmin;
	private JTable tableAdmin;
	public JButton btnEditarAdmin, btnBuscarAdmin, btnEliminarAdmin;
	private char letras;
	
	public BuscarAdministrador() {
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
				BuscarAdministrador.this.dispose();
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
		mnAsesores.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/asesores.png")));
		menuBar.add(mnAsesores);
		
		JMenu mnAsesorAcademico = new JMenu("Asesor acad\u00E9mico");
		mnAsesorAcademico.setBackground(new Color(0, 102, 153));
		mnAsesorAcademico.setForeground(new Color(0, 0, 0));
		mnAsesorAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorAcademico.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/academico.png")));
		mnAsesores.add(mnAsesorAcademico);
		
		JMenuItem mntmBuscarAcademico = new JMenuItem("Buscar");
		mntmBuscarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorAca buscarAsesorAca = new SocketBuscarActualizarAsesorAca();
				BuscarAdministrador.this.dispose();
			}
		});
		mntmBuscarAcademico.setBackground(new Color(0, 102, 153));
		mntmBuscarAcademico.setForeground(new Color(255, 255, 255));
		mntmBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAcademico.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/buscar.png")));
		mnAsesorAcademico.add(mntmBuscarAcademico);
		
		JMenuItem mntmAgregarAcademico = new JMenuItem("Registrar");
		mntmAgregarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorAca asesorAca = new SocketInsertarAsesorAca();
				BuscarAdministrador.this.dispose();
			}
		});
		mntmAgregarAcademico.setBackground(new Color(0, 102, 153));
		mntmAgregarAcademico.setForeground(new Color(255, 255, 255));
		mntmAgregarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAcademico.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/registrar.png")));
		mnAsesorAcademico.add(mntmAgregarAcademico);
		
		JMenu mnAsesorIndustrial = new JMenu("Asesor industrial");
		mnAsesorIndustrial.setBackground(new Color(0, 102, 153));
		mnAsesorIndustrial.setForeground(new Color(0, 0, 0));
		mnAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorIndustrial.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/asesor industrial.png")));
		mnAsesores.add(mnAsesorIndustrial);
		
		JMenuItem mntmBuscarIndustrial = new JMenuItem("Buscar");
		mntmBuscarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorInd asesorInd = new SocketBuscarActualizarAsesorInd();
				BuscarAdministrador.this.dispose();
			}
		});
		mntmBuscarIndustrial.setBackground(new Color(0, 102, 153));
		mntmBuscarIndustrial.setForeground(new Color(255, 255, 255));
		mntmBuscarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarIndustrial.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/buscar.png")));
		mnAsesorIndustrial.add(mntmBuscarIndustrial);
		
		JMenuItem mntmRegistrarIndustrial = new JMenuItem("Registrar");
		mntmRegistrarIndustrial.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorInd asesorInd = new SocketInsertarAsesorInd();
				BuscarAdministrador.this.dispose();
			}
		});
		mntmRegistrarIndustrial.setBackground(new Color(0, 102, 153));
		mntmRegistrarIndustrial.setForeground(new Color(255, 255, 255));
		mntmRegistrarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrarIndustrial.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/registrar.png")));
		mnAsesorIndustrial.add(mntmRegistrarIndustrial);
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setFont(new Font("Arial", Font.BOLD, 15));
		mnAlumnos.setForeground(new Color(255, 255, 255));
		mnAlumnos.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/alumno.png")));
		menuBar.add(mnAlumnos);
		
		JMenuItem mntmBuscarAlumno = new JMenuItem("Buscar");
		mntmBuscarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAlumno alumno = new SocketBuscarActualizarAlumno();
				BuscarAdministrador.this.dispose();
			}
		});
		mntmBuscarAlumno.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/buscar.png")));
		mntmBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAlumno.setBackground(new Color(0, 102, 153));
		mntmBuscarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmBuscarAlumno);
		
		JMenuItem mntmAgregarAlumno = new JMenuItem("Registrar");
		mntmAgregarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketCargarAsesores cargarAsesores = new SocketCargarAsesores();
				BuscarAdministrador.this.dispose();
			}
		});
		mntmAgregarAlumno.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/registrar.png")));
		mntmAgregarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAlumno.setBackground(new Color(0, 102, 153));
		mntmAgregarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmAgregarAlumno);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		mnAdministrador.setForeground(Color.WHITE);
		mnAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mnAdministrador.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/admin.png")));
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmBuscaAdministrador = new JMenuItem("Buscar");
		mntmBuscaAdministrador.setBackground(new Color(0, 102, 153));
		mntmBuscaAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BuscarAdministrador busq = new BuscarAdministrador();
				//busq.setVisible(true);
				//BuscarAdministrador.this.dispose();
			}
		});
		mntmBuscaAdministrador.setForeground(Color.WHITE);
		mntmBuscaAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscaAdministrador.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/buscar.png")));
		mnAdministrador.add(mntmBuscaAdministrador);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.setBackground(new Color(0, 102, 153));
		mntmRegistrar_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				SocketInsertarAdministrador insertarAdmin = new SocketInsertarAdministrador();
				BuscarAdministrador.this.dispose();
			}
		});
		mntmRegistrar_1.setForeground(Color.WHITE);
		mntmRegistrar_1.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrar_1.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/registrar.png")));
		mnAdministrador.add(mntmRegistrar_1);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					BuscarAdministrador.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/cerrar.png")));
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
		mntmCambiarContrasea.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblBuscarAdministrador = new JLabel("BUSCAR ADMINISTRADOR");
		lblBuscarAdministrador.setFont(new Font("Arial", Font.BOLD, 26));
		lblBuscarAdministrador.setBounds(590, 11, 379, 56);
		getContentPane().add(lblBuscarAdministrador);
		
		JLabel lblNombre = new JLabel("Nombre (s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(543, 92, 99, 36);
		getContentPane().add(lblNombre);
		
		textFieldBuscarAdmin = new JTextField();
		textFieldBuscarAdmin.addKeyListener(new KeyAdapter() {
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
		textFieldBuscarAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldBuscarAdmin.setBounds(652, 97, 228, 27);
		getContentPane().add(textFieldBuscarAdmin);
		textFieldBuscarAdmin.setColumns(10);
		
		btnBuscarAdmin = new JButton("");
		btnBuscarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarAdmin.setIcon(new ImageIcon(BuscarAdministrador.class.getResource("/imagenes/buscar.png")));
		btnBuscarAdmin.setBounds(923, 78, 81, 56);
		btnBuscarAdmin.setBackground(new Color(0, 102, 153));
		getContentPane().add(btnBuscarAdmin);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatricula.setBounds(44, 366, 86, 14);
		getContentPane().add(lblMatricula);
		
		textFieldMatriculaAdmin = new JTextField();
		textFieldMatriculaAdmin.setBackground(new Color(255, 255, 255));
		textFieldMatriculaAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldMatriculaAdmin.setEditable(false);
		textFieldMatriculaAdmin.setBounds(67, 405, 228, 27);
		getContentPane().add(textFieldMatriculaAdmin);
		textFieldMatriculaAdmin.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombre (s)");
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombres.setBounds(338, 361, 101, 25);
		getContentPane().add(lblNombres);
		
		textFieldNombreAdmin = new JTextField();
		textFieldNombreAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldNombreAdmin.setBounds(362, 405, 228, 27);
		getContentPane().add(textFieldNombreAdmin);
		textFieldNombreAdmin.setColumns(10);
		
		textFieldTelefonoAdmin = new JTextField();
		textFieldTelefonoAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldTelefonoAdmin.setBounds(67, 530, 228, 27);
		getContentPane().add(textFieldTelefonoAdmin);
		textFieldTelefonoAdmin.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(44, 504, 151, 14);
		getContentPane().add(lblTelfono);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(668, 364, 148, 19);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(995, 359, 148, 29);
		getContentPane().add(lblApellidoMaterno);
		
		textFieldPaternoAdmin = new JTextField();
		textFieldPaternoAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldPaternoAdmin.setBounds(717, 405, 228, 27);
		getContentPane().add(textFieldPaternoAdmin);
		textFieldPaternoAdmin.setColumns(10);
		
		textFieldMaternoAdmin = new JTextField();
		textFieldMaternoAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldMaternoAdmin.setBounds(1058, 406, 228, 27);
		getContentPane().add(textFieldMaternoAdmin);
		textFieldMaternoAdmin.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreo.setBounds(338, 504, 151, 14);
		getContentPane().add(lblCorreo);
		
		textFieldCorreoAdmin = new JTextField();
		textFieldCorreoAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCorreoAdmin.setBounds(362, 530, 228, 27);
		getContentPane().add(textFieldCorreoAdmin);
		textFieldCorreoAdmin.setColumns(10);
		
		btnEditarAdmin = new JButton("Editar");
		btnEditarAdmin.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/edit.png")));
		btnEditarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarAdmin.setForeground(new Color(255, 255, 255));
		btnEditarAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditarAdmin.setBackground(new Color(0, 102, 153));
		btnEditarAdmin.setBounds(778, 516, 151, 57);
		getContentPane().add(btnEditarAdmin);
		
		btnEliminarAdmin = new JButton("Eliminar");
		btnEliminarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminarAdmin.setIcon(new ImageIcon(BuscarAcademico.class.getResource("/imagenes/eliminar.png")));
		btnEliminarAdmin.setBackground(new Color(128, 0, 0));
		btnEliminarAdmin.setForeground(new Color(255, 255, 255));
		btnEliminarAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		btnEliminarAdmin.setBounds(1096, 516, 154, 57);
		getContentPane().add(btnEliminarAdmin);
		
		JScrollPane scrollPaneAdministrador = new JScrollPane();
		scrollPaneAdministrador.setBounds(44, 177, 1271, 148);
		getContentPane().add(scrollPaneAdministrador);
		
		tableAdmin = new JTable();
		tableAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableAdmin.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Tel\u00E9fono", "Correo"
			}
		));
		scrollPaneAdministrador.setViewportView(tableAdmin);
	}

	public JTextField getTextFieldBuscarAdmin() {
		return textFieldBuscarAdmin;
	}

	public void setTextFieldBuscarAdmin(JTextField textFieldBuscarAdmin) {
		this.textFieldBuscarAdmin = textFieldBuscarAdmin;
	}

	public JTextField getTextFieldMatriculaAdmin() {
		return textFieldMatriculaAdmin;
	}

	public void setTextFieldMatriculaAdmin(JTextField textFieldMatriculaAdmin) {
		this.textFieldMatriculaAdmin = textFieldMatriculaAdmin;
	}

	public JTextField getTextFieldNombreAdmin() {
		return textFieldNombreAdmin;
	}

	public void setTextFieldNombreAdmin(JTextField textFieldNombreAdmin) {
		this.textFieldNombreAdmin = textFieldNombreAdmin;
	}

	public JTextField getTextFieldTelefonoAdmin() {
		return textFieldTelefonoAdmin;
	}

	public void setTextFieldTelefonoAdmin(JTextField textFieldTelefonoAdmin) {
		this.textFieldTelefonoAdmin = textFieldTelefonoAdmin;
	}

	public JTextField getTextFieldPaternoAdmin() {
		return textFieldPaternoAdmin;
	}

	public void setTextFieldPaternoAdmin(JTextField textFieldPaternoAdmin) {
		this.textFieldPaternoAdmin = textFieldPaternoAdmin;
	}

	public JTextField getTextFieldMaternoAdmin() {
		return textFieldMaternoAdmin;
	}

	public void setTextFieldMaternoAdmin(JTextField textFieldMaternoAdmin) {
		this.textFieldMaternoAdmin = textFieldMaternoAdmin;
	}

	public JTextField getTextFieldCorreoAdmin() {
		return textFieldCorreoAdmin;
	}

	public void setTextFieldCorreoAdmin(JTextField textFieldCorreoAdmin) {
		this.textFieldCorreoAdmin = textFieldCorreoAdmin;
	}

	public JTable getTableAdmin() {
		return tableAdmin;
	}

	public void setTableAdmin(JTable tableAdmin) {
		this.tableAdmin = tableAdmin;
	}
	
	public boolean validarBuscaAcademico() {
		
		if(this.textFieldBuscarAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Ingresa el nombre(s) del asesor académico", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.textFieldBuscarAdmin.requestFocus();
			return false;
		}
		return true;
	}
	
	public boolean validarEditarAdministrador() {
		if(textFieldMatriculaAdmin.getText().isEmpty() && textFieldNombreAdmin.getText().isEmpty() && textFieldPaternoAdmin.getText().isEmpty() &&
				textFieldMaternoAdmin.getText().isEmpty() && textFieldTelefonoAdmin.getText().isEmpty() && textFieldCorreoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Todos los datos con asterisco (*) son obligatorios", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldMatriculaAdmin.requestFocus();
			return false;
		}else if(textFieldMatriculaAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar la matricula del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldMatriculaAdmin.requestFocus();
			return false;
		}else if(textFieldNombreAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el nombre del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldNombreAdmin.requestFocus();
			return false;
		}else if(textFieldPaternoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido paterno del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldPaternoAdmin.requestFocus();
			return false;
		}else if(textFieldMaternoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el apellido materno del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldMaternoAdmin.requestFocus();
			return false;
		}else if(textFieldTelefonoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el número telefonico del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldTelefonoAdmin.requestFocus();
			return false;
		}else if(textFieldCorreoAdmin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el correo del administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
			textFieldCorreoAdmin.requestFocus();
			return false;
		}else {
			return true;
		}
	}
}
