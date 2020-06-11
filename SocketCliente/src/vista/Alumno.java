package vista;
/**
 * Esta Clase es una vista que muestra la pantalla inicial del alumno
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import funcionamiento.SocketBitacoraAlumno;
import funcionamiento.SocketCambiarContraseña;
import main.Main;

@SuppressWarnings("serial")
public class Alumno extends JFrame {
	
	private JLabel lblNombreProyecto;
	private JLabel lblNombeAsesorAcademico;
	private JLabel lblNombreAsesorIndustrial;
	private JLabel jlbNombreAlumno;
	
	public Alumno() {
		super("Control RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/alumno.png"));
		setIconImage(icon);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 728);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.setBackground(new Color(0, 102, 153));
		setJMenuBar(menuBar);
		
		JMenu mnIncio = new JMenu("Inicio");
		mnIncio.setForeground(Color.WHITE);
		mnIncio.setFont(new Font("Arial", Font.BOLD, 15));
		mnIncio.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/inicio.png")));
		menuBar.add(mnIncio);
		
		JMenu mnBitcora = new JMenu("Bit\u00E1cora");
		mnBitcora.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/bitacora.png")));
		mnBitcora.setForeground(Color.WHITE);
		mnBitcora.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnBitcora);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					Alumno.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/cerrar.png")));
		mntmCerrarSesion.setFont(new Font("Arial", Font.BOLD, 15));
		mntmCerrarSesion.setForeground(Color.WHITE);
		mnNewMenu.add(mntmCerrarSesion);
		
		JMenuItem mntmVerBitcora = new JMenuItem("Ver bit\u00E1cora");
		mntmVerBitcora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketBitacoraAlumno bitacora = new SocketBitacoraAlumno();
				Alumno.this.dispose();
			}
		});
		
		mntmVerBitcora.setForeground(Color.WHITE);
		mntmVerBitcora.setBackground(new Color(0, 102, 153));
		mntmVerBitcora.setFont(new Font("Arial", Font.BOLD, 15));
		mntmVerBitcora.setIcon(new ImageIcon(Bitacora.class.getResource("/imagenes/ver.png")));
		mnBitcora.add(mntmVerBitcora);
		
		JMenuItem mntmRegistarAvances = new JMenuItem("Registar avances");
		mntmRegistarAvances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Avances db = new Avances();
				db.setVisible(true);
				Alumno.this.dispose();
			}
		});
		
		mntmRegistarAvances.setForeground(Color.WHITE);
		mntmRegistarAvances.setBackground(new Color(0, 102, 153));
		mntmRegistarAvances.setFont(new Font("Arial", Font.BOLD, 15));
		mntmRegistarAvances.setIcon(new ImageIcon(Bitacora.class.getResource("/imagenes/avances.png")));
		mnBitcora.add(mntmRegistarAvances);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				SocketCambiarContraseña cambiarContraseña = new SocketCambiarContraseña();
			}
		});
		mntmCambiarContrasea.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblBienvenido = new JLabel("Bienvenido estudiante");
		lblBienvenido.setFont(new Font("Arial", Font.BOLD, 27));
		lblBienvenido.setBounds(564, 31, 353, 85);
		getContentPane().add(lblBienvenido);
		
		JLabel lblNombreDelProyecto = new JLabel("Nombre del proyecto:");
		lblNombreDelProyecto.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNombreDelProyecto.setBounds(353, 246, 242, 68);
		getContentPane().add(lblNombreDelProyecto);
		
		JLabel lblAsesorAcademico = new JLabel("Asesor acad\u00E9mico:");
		lblAsesorAcademico.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAsesorAcademico.setBounds(353, 387, 242, 29);
		getContentPane().add(lblAsesorAcademico);
		
		JLabel lblAsesorIndustrial = new JLabel("Asesor industrial:");
		lblAsesorIndustrial.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAsesorIndustrial.setBounds(353, 501, 223, 34);
		getContentPane().add(lblAsesorIndustrial);
		
		lblNombreProyecto = new JLabel("New label");
		lblNombreProyecto.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombreProyecto.setBounds(605, 274, 479, 21);
		getContentPane().add(lblNombreProyecto);
		
		lblNombeAsesorAcademico = new JLabel("New label");
		lblNombeAsesorAcademico.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombeAsesorAcademico.setBounds(605, 395, 479, 21);
		getContentPane().add(lblNombeAsesorAcademico);
		
		lblNombreAsesorIndustrial = new JLabel("New label");
		lblNombreAsesorIndustrial.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombreAsesorIndustrial.setBounds(605, 516, 479, 29);
		getContentPane().add(lblNombreAsesorIndustrial);
		
		jlbNombreAlumno = new JLabel("New label");
		jlbNombreAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		jlbNombreAlumno.setFont(new Font("Arial", Font.PLAIN, 20));
		jlbNombreAlumno.setBounds(493, 113, 472, 29);
		getContentPane().add(jlbNombreAlumno);
	}

	public JLabel getLblNombreProyecto() {
		return lblNombreProyecto;
	}

	public void setLblNombreProyecto(JLabel lblNombreProyecto) {
		this.lblNombreProyecto = lblNombreProyecto;
	}

	public JLabel getLblNombeAsesorAcademico() {
		return lblNombeAsesorAcademico;
	}

	public void setLblNombeAsesorAcademico(JLabel lblNombeAsesorAcademico) {
		this.lblNombeAsesorAcademico = lblNombeAsesorAcademico;
	}

	public JLabel getLblNombreAsesorIndustrial() {
		return lblNombreAsesorIndustrial;
	}

	public void setLblNombreAsesorIndustrial(JLabel lblNombreAsesorIndustrial) {
		this.lblNombreAsesorIndustrial = lblNombreAsesorIndustrial;
	}

	public JLabel getJlbNombreAlumno() {
		return jlbNombreAlumno;
	}

	public void setJlbNombreAlumno(JLabel jlbNombreAlumno) {
		this.jlbNombreAlumno = jlbNombreAlumno;
	}
	
	
}
