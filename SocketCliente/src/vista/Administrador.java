package vista;
/**
 * Esta Clase es una vista que muestra la pantalla inicial del administrador
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
import main.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Administrador extends JFrame {
	
	private JMenuBar menuBar;
	@SuppressWarnings("unused")
	private JMenu menu, mnAsesores, mnAsesorAcademico,mnAsesorIndustrial, mnAlumnos,mnAdministrador;
	private JMenuItem mntmBuscarAcademico, mntmAgregarAcademico,mntmAgregarAlumno, mntmBuscarAlumno;
	private JLabel lblBienvenidoAdministrador;
	private JLabel jlbNombreAdmin;
	private JLabel lblCuandoSe;
	private JLabel lblAlRegistrarUn;
	@SuppressWarnings("unused")
	private JMenu mnInicio;
	
	public Administrador() {

		super("Control RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/admin.png"));
		setIconImage(icon);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 728);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.setBackground(new Color(0, 102, 153));
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		JMenu mnIncio = new JMenu("Inicio");
		mnIncio.setForeground(Color.WHITE);
		mnIncio.setFont(new Font("Arial", Font.BOLD, 15));
		mnIncio.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/inicio.png")));
		menuBar.add(mnIncio);
		
		mnAsesores = new JMenu("Asesores");
		mnAsesores.setForeground(new Color(255, 255, 255));
		mnAsesores.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesores.setBackground(new Color(0, 102, 153));
		mnAsesores.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/asesores.png")));
		menuBar.add(mnAsesores);
		
		mnAsesorAcademico = new JMenu("Asesor acad\u00E9mico");
		mnAsesorAcademico.setBackground(new Color(0, 102, 153));
		mnAsesorAcademico.setForeground(new Color(0, 0, 0));
		mnAsesorAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mnAsesorAcademico.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/academico.png")));
		mnAsesores.add(mnAsesorAcademico);
		
		mntmBuscarAcademico = new JMenuItem("Buscar");
		mntmBuscarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAsesorAca buscarAsesorAca = new SocketBuscarActualizarAsesorAca();
				Administrador.this.dispose();
			}
		});
		mntmBuscarAcademico.setBackground(new Color(0, 102, 153));
		mntmBuscarAcademico.setForeground(new Color(255, 255, 255));
		mntmBuscarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAcademico.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mnAsesorAcademico.add(mntmBuscarAcademico);
		
		mntmAgregarAcademico = new JMenuItem("Registrar");
		mntmAgregarAcademico.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketInsertarAsesorAca asesorAca = new SocketInsertarAsesorAca();
				Administrador.this.dispose();
			}
		});
		mntmAgregarAcademico.setBackground(new Color(0, 102, 153));
		mntmAgregarAcademico.setForeground(new Color(255, 255, 255));
		mntmAgregarAcademico.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAcademico.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/registrar.png")));
		mnAsesorAcademico.add(mntmAgregarAcademico);
		
		mnAsesorIndustrial = new JMenu("Asesor industrial");
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
				Administrador.this.dispose();
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
				Administrador.this.dispose();
			}
		});
		mntmRegistrarIndustrial.setBackground(new Color(0, 102, 153));
		mntmRegistrarIndustrial.setForeground(new Color(255, 255, 255));
		mntmRegistrarIndustrial.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistrarIndustrial.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/registrar.png")));
		mnAsesorIndustrial.add(mntmRegistrarIndustrial);
		
		mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setFont(new Font("Arial", Font.BOLD, 15));
		mnAlumnos.setForeground(new Color(255, 255, 255));
		mnAlumnos.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/alumno.png")));
		menuBar.add(mnAlumnos);
		
		mntmBuscarAlumno = new JMenuItem("Buscar");
		mntmBuscarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBuscarActualizarAlumno alumno = new SocketBuscarActualizarAlumno();
				Administrador.this.dispose();
			}
		});
		mntmBuscarAlumno.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/buscar.png")));
		mntmBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmBuscarAlumno.setBackground(new Color(0, 102, 153));
		mntmBuscarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmBuscarAlumno);
		
		mntmAgregarAlumno = new JMenuItem("Registrar");
		mntmAgregarAlumno.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketCargarAsesores cargarAsesores = new SocketCargarAsesores();
				Administrador.this.dispose();
			}
		});
		mntmAgregarAlumno.setIcon(new ImageIcon(Administrador.class.getResource("/imagenes/registrar.png")));
		mntmAgregarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		mntmAgregarAlumno.setBackground(new Color(0, 102, 153));
		mntmAgregarAlumno.setForeground(new Color(255, 255, 255));
		mnAlumnos.add(mntmAgregarAlumno);
		
		mnAdministrador = new JMenu("Administrador");
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
				Administrador.this.dispose();
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
				Administrador.this.dispose();
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
					Administrador.this.dispose();
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
			public void actionPerformed(ActionEvent arg0) {
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
		
		lblBienvenidoAdministrador = new JLabel("BIENVENIDO ADMINISTRADOR");
		lblBienvenidoAdministrador.setFont(new Font("Arial", Font.BOLD, 26));
		lblBienvenidoAdministrador.setBounds(592, 28, 412, 42);
		getContentPane().add(lblBienvenidoAdministrador);
		
		jlbNombreAdmin = new JLabel("New label");
		jlbNombreAdmin.setFont(new Font("Arial", Font.PLAIN, 20));
		jlbNombreAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		jlbNombreAdmin.setBounds(546, 81, 483, 24);
		getContentPane().add(jlbNombreAdmin);
		
		JLabel lblNota = new JLabel("NOTAS");
		lblNota.setForeground(new Color(0, 0, 0));
		lblNota.setFont(new Font("Arial", Font.BOLD, 20));
		lblNota.setBounds(404, 218, 71, 24);
		getContentPane().add(lblNota);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(404, 253, 663, 2);
		getContentPane().add(separator);
		
		JLabel lblCuandoRegistresUn = new JLabel("* Cuando se registre un asesor industrial, el sistema le otorgar\u00E1 una matricula, con la cual el ingresar\u00E1 al sistema.");
		lblCuandoRegistresUn.setForeground(Color.BLUE);
		lblCuandoRegistresUn.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCuandoRegistresUn.setBounds(404, 266, 684, 71);
		getContentPane().add(lblCuandoRegistresUn);
		
		lblCuandoSe = new JLabel("* Al actualizar un alumno, para cambiar alg\u00FAn asesor, es necesario poner su matricula.");
		lblCuandoSe.setForeground(Color.BLUE);
		lblCuandoSe.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCuandoSe.setBounds(404, 341, 684, 71);
		getContentPane().add(lblCuandoSe);
		
		lblAlRegistrarUn = new JLabel("* Al registrar un nuevo Alumno, para que aparezca su carrera, primero se tiene que seleccionar su divisi\u00F3n.");
		lblAlRegistrarUn.setForeground(Color.BLUE);
		lblAlRegistrarUn.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblAlRegistrarUn.setBounds(404, 412, 684, 71);
		getContentPane().add(lblAlRegistrarUn);
		
		JLabel lblRecuerdaOtorgarLa = new JLabel("* Recuerda otorgar la contrase\u00F1a a los asesores y alumnos.");
		lblRecuerdaOtorgarLa.setForeground(Color.BLUE);
		lblRecuerdaOtorgarLa.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblRecuerdaOtorgarLa.setBounds(404, 486, 643, 71);
		getContentPane().add(lblRecuerdaOtorgarLa);

	}

	public JLabel getJlbNombreAdmin() {
		return jlbNombreAdmin;
	}

	public void setJlbNombreAdmin(JLabel jlbNombreAdmin) {
		this.jlbNombreAdmin = jlbNombreAdmin;
	}
}
