package vista;
/**
 * Esta Clase es una vista que muestra la pantalla inicial del Asesor Académico
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import funcionamiento.SocketBitacoraAcademico;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketObservacionesAsesorAcaConsultarAlumno;
import main.Main;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AsesorAcademico extends JFrame {
	
	private JLabel jlbNombreAcademico;
	private JTable tableAlumnosAca;
	private JTextField textBuscarAlumnoAca;
	private char letras;
	
	public AsesorAcademico() {
		super("Control RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/academico.png"));
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
		mnIncio.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/inicio.png")));
		mnIncio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		menuBar.add(mnIncio);
		
		JMenu mnBuscarAlumno = new JMenu("Alumno");
		mnBuscarAlumno.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/alumno.png")));
		mnBuscarAlumno.setForeground(Color.WHITE);
		mnBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnBuscarAlumno);
		
		JMenuItem mntmVerBtacora = new JMenuItem("B\u00EDtacora");
		mntmVerBtacora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				SocketBitacoraAcademico bitacoraAcademico = new SocketBitacoraAcademico();
				AsesorAcademico.this.dispose();
			}
		});
		mntmVerBtacora.setForeground(Color.WHITE);
		mntmVerBtacora.setBackground(new Color(0, 102, 153));
		mntmVerBtacora.setFont(new Font("Arial", Font.BOLD, 15));
		mntmVerBtacora.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/bitacora.png")));
		mnBuscarAlumno.add(mntmVerBtacora);
		
		JMenuItem mntmObservacionesYCalificaciones = new JMenuItem("Observaciones y evaluaciones");
		mntmObservacionesYCalificaciones.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/Clipboard-Paste-icon.png")));
		mntmObservacionesYCalificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				SocketObservacionesAsesorAcaConsultarAlumno insertarObservación = new SocketObservacionesAsesorAcaConsultarAlumno();
				AsesorAcademico.this.dispose();
			}
		});
		mntmObservacionesYCalificaciones.setForeground(Color.WHITE);
		mntmObservacionesYCalificaciones.setBackground(new Color(0, 102, 153));
		mntmObservacionesYCalificaciones.setFont(new Font("Arial", Font.BOLD, 15));
		mnBuscarAlumno.add(mntmObservacionesYCalificaciones);
		
		menuBar.setBackground(new Color(0, 102, 153));
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					AsesorAcademico.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/cerrar.png")));
		mntmCerrarSesion.setFont(new Font("Arial", Font.BOLD, 15));
		mntmCerrarSesion.setForeground(Color.WHITE);
		mnNewMenu.add(mntmCerrarSesion);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketCambiarContraseña cambiarContraseña = new SocketCambiarContraseña();
			}
		});
		mntmCambiarContrasea.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(AsesorAcademico.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblBienvenidoAsesorAcadmico = new JLabel("BIENVENIDO ASESOR ACAD\u00C9MICO");
		lblBienvenidoAsesorAcadmico.setFont(new Font("Arial", Font.BOLD, 26));
		lblBienvenidoAsesorAcadmico.setBounds(532, 24, 471, 52);
		getContentPane().add(lblBienvenidoAsesorAcadmico);
		
		jlbNombreAcademico = new JLabel("New label");
		jlbNombreAcademico.setHorizontalAlignment(SwingConstants.CENTER);
		jlbNombreAcademico.setFont(new Font("Arial", Font.PLAIN, 20));
		jlbNombreAcademico.setBounds(497, 87, 535, 29);
		getContentPane().add(jlbNombreAcademico);
		
		JLabel lblAlumnosQueE = new JLabel("Alumnos asesorados");
		lblAlumnosQueE.setFont(new Font("Arial", Font.PLAIN, 17));
		lblAlumnosQueE.setBounds(229, 337, 365, 29);
		getContentPane().add(lblAlumnosQueE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 377, 920, 175);
		getContentPane().add(scrollPane);
		
		tableAlumnosAca = new JTable();
		tableAlumnosAca.setEnabled(false);
		tableAlumnosAca.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Matricula", "Nombre(s)", "Apellido paterno", "Apellido materno", "Tel\u00E9fono", "Correo", "Proyecto", "Asesor industrial"
			}
		));
		scrollPane.setViewportView(tableAlumnosAca);
		
		JLabel lblBusquedaRapida = new JLabel("B\u00DASQUEDA R\u00C1PIDA");
		lblBusquedaRapida.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblBusquedaRapida.setBounds(692, 175, 177, 29);
		getContentPane().add(lblBusquedaRapida);
		
		textBuscarAlumnoAca = new JTextField();
		textBuscarAlumnoAca.addKeyListener(new KeyAdapter() {
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
		textBuscarAlumnoAca.setFont(new Font("Arial", Font.PLAIN, 16));
		textBuscarAlumnoAca.setBounds(692, 246, 177, 29);
		getContentPane().add(textBuscarAlumnoAca);
		textBuscarAlumnoAca.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre(s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(588, 249, 94, 21);
		getContentPane().add(lblNombre);
	}

	public JLabel getJlbNombreAcademico() {
		return jlbNombreAcademico;
	}

	public void setJlbNombreAcademico(JLabel jlbNombreAcademico) {
		this.jlbNombreAcademico = jlbNombreAcademico;
	}
	
	public JTextField getTextBuscarAlumnoAca() {
		return textBuscarAlumnoAca;
	}

	public void setTextBuscarAlumnoAca(JTextField textBuscarAlumnoAca) {
		this.textBuscarAlumnoAca = textBuscarAlumnoAca;
	}

	public JTable getTableAlumnosAca() {
		return tableAlumnosAca;
	}

	public void setTableAlumnosAca(JTable tableAlumnosAca) {
		this.tableAlumnosAca = tableAlumnosAca;
	}
	
	
}
