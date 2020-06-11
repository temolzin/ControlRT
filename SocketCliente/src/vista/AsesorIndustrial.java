package vista;
/**
 * Esta Clase es una vista que muestra la pantalla inicial del Asesor Industrial
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import funcionamiento.SocketBitacoraIndustrial;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketObservacionesAsesorIndConsultarAlumno;
import main.Main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AsesorIndustrial extends JFrame {
	
	private JLabel jlbNombreIndustrial;
	private JTable tableAlumnosIndu;
	private JTextField textBuscarAlumnoIndu;
	private char letras;

	public AsesorIndustrial() {
		super("Control RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/asesor industrial.png"));
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
		mnIncio.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/inicio.png")));
		mnIncio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		menuBar.add(mnIncio);
		
		JMenu mnBuscarAlumno = new JMenu("Alumno");
		mnBuscarAlumno.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/alumno.png")));
		mnBuscarAlumno.setForeground(Color.WHITE);
		mnBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnBuscarAlumno);
		
		JMenuItem mntmVerBtacora = new JMenuItem("B\u00EDtacora");
		mntmVerBtacora.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				SocketBitacoraIndustrial bitacora = new SocketBitacoraIndustrial();
				AsesorIndustrial.this.dispose();
			}
		});
		mntmVerBtacora.setForeground(Color.WHITE);
		mntmVerBtacora.setBackground(new Color(0, 102, 153));
		mntmVerBtacora.setFont(new Font("Arial", Font.BOLD, 15));
		mntmVerBtacora.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/bitacora.png")));
		mnBuscarAlumno.add(mntmVerBtacora);
		
		JMenuItem mntmObservacionesYCalificaciones = new JMenuItem("Observaciones y evaluaciones");
		mntmObservacionesYCalificaciones.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/Clipboard-Paste-icon.png")));
		mntmObservacionesYCalificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				SocketObservacionesAsesorIndConsultarAlumno observaciones = new SocketObservacionesAsesorIndConsultarAlumno();
				AsesorIndustrial.this.dispose();
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
		mnNewMenu.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					AsesorIndustrial.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/cerrar.png")));
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
		mntmCambiarContrasea.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(AsesorIndustrial.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblBienvenidoAsesorIndustrial = new JLabel("BIENVENIDO ASESOR INDUSTRIAL");
		lblBienvenidoAsesorIndustrial.setFont(new Font("Arial", Font.BOLD, 26));
		lblBienvenidoAsesorIndustrial.setBounds(546, 43, 463, 37);
		getContentPane().add(lblBienvenidoAsesorIndustrial);
		
		jlbNombreIndustrial = new JLabel("New label");
		jlbNombreIndustrial.setHorizontalAlignment(SwingConstants.CENTER);
		jlbNombreIndustrial.setFont(new Font("Arial", Font.PLAIN, 20));
		jlbNombreIndustrial.setBounds(506, 91, 540, 31);
		getContentPane().add(jlbNombreIndustrial);
		
		JLabel lblAlumnosQueE = new JLabel("Alumnos asesorados");
		lblAlumnosQueE.setFont(new Font("Arial", Font.PLAIN, 17));
		lblAlumnosQueE.setBounds(229, 337, 365, 29);
		getContentPane().add(lblAlumnosQueE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 377, 920, 175);
		getContentPane().add(scrollPane);
		
		tableAlumnosIndu = new JTable();
		tableAlumnosIndu.setEnabled(false);
		tableAlumnosIndu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Matricula", "Nombre(s)", "Apellido paterno", "Apellido materno", "Tel\u00E9fono", "Correo", "Proyecto", "Asesor industrial"
			}
		));
		scrollPane.setViewportView(tableAlumnosIndu);
		
		JLabel lblBusquedaRapida = new JLabel("B\u00DASQUEDA R\u00C1PIDA");
		lblBusquedaRapida.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblBusquedaRapida.setBounds(692, 177, 177, 29);
		getContentPane().add(lblBusquedaRapida);
		
		textBuscarAlumnoIndu = new JTextField();
		textBuscarAlumnoIndu.addKeyListener(new KeyAdapter() {
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
		textBuscarAlumnoIndu.setFont(new Font("Arial", Font.PLAIN, 16));
		textBuscarAlumnoIndu.setBounds(692, 246, 177, 29);
		getContentPane().add(textBuscarAlumnoIndu);
		textBuscarAlumnoIndu.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre(s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(602, 249, 80, 21);
		getContentPane().add(lblNombre);
	}

	public JLabel getJlbNombreIndustrial() {
		return jlbNombreIndustrial;
	}

	public void setJlbNombreIndustrial(JLabel jlbNombreIndustrial) {
		this.jlbNombreIndustrial = jlbNombreIndustrial;
	}

	public JTable getTableAlumnosIndu() {
		return tableAlumnosIndu;
	}

	public void setTableAlumnosIndu(JTable tableAlumnosIndu) {
		this.tableAlumnosIndu = tableAlumnosIndu;
	}

	public JTextField getTextBuscarAlumnoIndu() {
		return textBuscarAlumnoIndu;
	}

	public void setTextBuscarAlumnoIndu(JTextField textBuscarAlumnoIndu) {
		this.textBuscarAlumnoIndu = textBuscarAlumnoIndu;
	}
	
	
}
