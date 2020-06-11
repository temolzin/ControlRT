package vista;
/**
 * Esta Clase es una vista que muestra los datos del asesor Industrial para ser editados.
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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import funcionamiento.SocketBuscarActualizarAdministrador;
import funcionamiento.SocketBuscarActualizarAlumno;
import funcionamiento.SocketBuscarActualizarAsesorAca;
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
public class BuscarIndustrial extends JFrame {
	private JTextField textFieldBuscarIndustrial;
	private JTable tableIndustrial;
	private JTextField textFieldMatriculaIndustrial;
	private JTextField textFieldNombreIndustrial;
	private JTextField textFieldPaternoIndustrial;
	private JTextField textFieldMaternoIndustrial;
	private JTextField textFieldTelefonoIndustrial;
	private JTextField textFieldCorreo;
	private JTextField textFieldEmpresa;
	private JTextField jtfPassword;
	public JButton btnEliminarIndustrial;
	public JButton btnBuscarIndustrial;
	public JButton btnEditarIndustrial;
	private char letras;
	
	public BuscarIndustrial() {
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
				BuscarIndustrial.this.dispose();
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
				BuscarIndustrial.this.dispose();
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
				BuscarIndustrial.this.dispose();
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
			public void actionPerformed(ActionEvent arg0) {
				//SocketBuscarActualizarAsesorInd asesorInd = new SocketBuscarActualizarAsesorInd();
				//BuscarIndustrial.this.dispose();
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
				BuscarIndustrial.this.dispose();
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
				BuscarIndustrial.this.dispose();
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
				BuscarIndustrial.this.dispose();
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
				BuscarIndustrial.this.dispose();
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
				BuscarIndustrial.this.dispose();
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
					BuscarIndustrial.this.dispose();
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
		
		JLabel lblBuscarAsesorIndustrial = new JLabel("BUSCAR ASESOR INDUSTRIAL");
		lblBuscarAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 26));
		lblBuscarAsesorIndustrial.setBounds(567, 21, 418, 45);
		getContentPane().add(lblBuscarAsesorIndustrial);
		
		JLabel lblNombre = new JLabel("Nombre(s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(569, 92, 77, 31);
		getContentPane().add(lblNombre);
		
		textFieldBuscarIndustrial = new JTextField();
		textFieldBuscarIndustrial.addKeyListener(new KeyAdapter() {
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
		textFieldBuscarIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldBuscarIndustrial.setBounds(656, 94, 228, 27);
		getContentPane().add(textFieldBuscarIndustrial);
		textFieldBuscarIndustrial.setColumns(10);
		
		btnBuscarIndustrial = new JButton("");

		btnBuscarIndustrial.setIcon(new ImageIcon(BuscarIndustrial.class.getResource("/imagenes/buscar.png")));
		btnBuscarIndustrial.setBackground(new Color(0, 102, 153));
		btnBuscarIndustrial.setBounds(914, 78, 86, 61);
		getContentPane().add(btnBuscarIndustrial);
		
		JScrollPane scrollPaneIndustrial = new JScrollPane();
		scrollPaneIndustrial.setBounds(32, 174, 1307, 146);
		getContentPane().add(scrollPaneIndustrial);
		
		tableIndustrial = new JTable();
		tableIndustrial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableIndustrial.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "Empresa", "Correo","Tel\u00E9fono", "Contrase\u00F1a"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPaneIndustrial.setViewportView(tableIndustrial);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatricula.setBounds(32, 368, 74, 31);
		getContentPane().add(lblMatricula);
		
		JLabel lblNombre_1 = new JLabel("Nombre(s)");
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre_1.setBounds(338, 373, 86, 20);
		getContentPane().add(lblNombre_1);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(638, 373, 117, 20);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(976, 373, 132, 20);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEmpresa.setBounds(638, 451, 74, 28);
		getContentPane().add(lblEmpresa);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTelfono.setBounds(32, 455, 74, 25);
		getContentPane().add(lblTelfono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCorreo.setBounds(338, 455, 65, 20);
		getContentPane().add(lblCorreo);
		
		textFieldMatriculaIndustrial = new JTextField();
		textFieldMatriculaIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldMatriculaIndustrial.setEnabled(false);
		textFieldMatriculaIndustrial.setBounds(68, 410, 228, 27);
		getContentPane().add(textFieldMatriculaIndustrial);
		textFieldMatriculaIndustrial.setColumns(10);
		
		textFieldNombreIndustrial = new JTextField();
		textFieldNombreIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldNombreIndustrial.setBounds(365, 410, 228, 27);
		getContentPane().add(textFieldNombreIndustrial);
		textFieldNombreIndustrial.setColumns(10);
		
		textFieldPaternoIndustrial = new JTextField();
		textFieldPaternoIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldPaternoIndustrial.setBounds(704, 410, 228, 27);
		getContentPane().add(textFieldPaternoIndustrial);
		textFieldPaternoIndustrial.setColumns(10);
		
		textFieldMaternoIndustrial = new JTextField();
		textFieldMaternoIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldMaternoIndustrial.setBounds(1030, 410, 228, 27);
		getContentPane().add(textFieldMaternoIndustrial);
		textFieldMaternoIndustrial.setColumns(10);
		
		textFieldTelefonoIndustrial = new JTextField();
		textFieldTelefonoIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldTelefonoIndustrial.setBounds(68, 490, 228, 27);
		getContentPane().add(textFieldTelefonoIndustrial);
		textFieldTelefonoIndustrial.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldCorreo.setBounds(365, 490, 228, 27);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldEmpresa.setBounds(704, 490, 228, 27);
		getContentPane().add(textFieldEmpresa);
		textFieldEmpresa.setColumns(10);
		
		btnEliminarIndustrial = new JButton("Eliminar");

		btnEliminarIndustrial.setBackground(new Color(128, 0, 0));
		btnEliminarIndustrial.setIcon(new ImageIcon(BuscarIndustrial.class.getResource("/imagenes/eliminar.png")));
		btnEliminarIndustrial.setForeground(Color.WHITE);
		btnEliminarIndustrial.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminarIndustrial.setBounds(1072, 469, 161, 57);
		getContentPane().add(btnEliminarIndustrial);
		
		btnEditarIndustrial = new JButton("Editar");
		btnEditarIndustrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditarIndustrial.setIcon(new ImageIcon(BuscarIndustrial.class.getResource("/imagenes/edit.png")));
		btnEditarIndustrial.setForeground(Color.WHITE);
		btnEditarIndustrial.setBackground(new Color(0, 102, 153));
		btnEditarIndustrial.setFont(new Font("Arial", Font.BOLD, 16));
		btnEditarIndustrial.setBounds(1072, 561, 161, 57);
		getContentPane().add(btnEditarIndustrial);
		
		jtfPassword = new JTextField();
		jtfPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		jtfPassword.setColumns(10);
		jtfPassword.setBounds(68, 577, 228, 27);
		getContentPane().add(jtfPassword);
		
		JLabel jlbPassword = new JLabel("Contrase\u00F1a");
		jlbPassword.setFont(new Font("Arial", Font.PLAIN, 17));
		jlbPassword.setBounds(32, 536, 94, 28);
		getContentPane().add(jlbPassword);
	}

	public JTextField getTextFieldBuscarIndustrial() {
		return textFieldBuscarIndustrial;
	}

	public void setTextFieldBuscarIndustrial(JTextField textFieldBuscarIndustrial) {
		this.textFieldBuscarIndustrial = textFieldBuscarIndustrial;
	}

	public JTable getTableIndustrial() {
		return tableIndustrial;
	}

	public void setTableIndustrial(JTable tableIndustrial) {
		this.tableIndustrial = tableIndustrial;
	}

	public JTextField getTextFieldMatriculaIndustrial() {
		return textFieldMatriculaIndustrial;
	}

	public void setTextFieldMatriculaIndustrial(JTextField textFieldMatriculaIndustrial) {
		this.textFieldMatriculaIndustrial = textFieldMatriculaIndustrial;
	}

	public JTextField getTextFieldNombreIndustrial() {
		return textFieldNombreIndustrial;
	}

	public void setTextFieldNombreIndustrial(JTextField textFieldNombreIndustrial) {
		this.textFieldNombreIndustrial = textFieldNombreIndustrial;
	}

	public JTextField getTextFieldPaternoIndustrial() {
		return textFieldPaternoIndustrial;
	}

	public void setTextFieldPaternoIndustrial(JTextField textFieldPaternoIndustrial) {
		this.textFieldPaternoIndustrial = textFieldPaternoIndustrial;
	}

	public JTextField getTextFieldMaternoIndustrial() {
		return textFieldMaternoIndustrial;
	}

	public void setTextFieldMaternoIndustrial(JTextField textFieldMaternoIndustrial) {
		this.textFieldMaternoIndustrial = textFieldMaternoIndustrial;
	}

	public JTextField getTextFieldTelefonoIndustrial() {
		return textFieldTelefonoIndustrial;
	}

	public void setTextFieldTelefonoIndustrial(JTextField textFieldTelefonoIndustrial) {
		this.textFieldTelefonoIndustrial = textFieldTelefonoIndustrial;
	}

	public JTextField getTextFieldCorreo() {
		return textFieldCorreo;
	}

	public void setTextFieldCorreo(JTextField textFieldCorreo) {
		this.textFieldCorreo = textFieldCorreo;
	}

	public JTextField getTextFieldEmpresa() {
		return textFieldEmpresa;
	}

	public void setTextFieldEmpresa(JTextField textFieldEmpresa) {
		this.textFieldEmpresa = textFieldEmpresa;
	}

	public JTextField getJtfPassword() {
		return jtfPassword;
	}

	public void setJtfPassword(JTextField jtfPassword) {
		this.jtfPassword = jtfPassword;
	}
	
}
