package vista;
/**
 * Esta Clase es una vista que muestra la bitacora del alumno en el inicio de sesión del Asesor Industrial.
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketLogin;
import funcionamiento.SocketObservacionesAsesorIndConsultarAlumno;
import main.Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class BitacoraIndustrial extends JFrame {
	private JTextField textBuscarAlumnoIndu;
	private JTextArea textAreaObservacionesAca;
	private JTextArea textAreaObservacionesIndu;
	private JTextArea textAreaAvancesAlum;
	private JTable tableMostrarAlumnoIndu;
	private JTextField textSaberAca1;
	private JTextField textHacerAca1;
	private JTextField textSer1;
	private JTextField textSaberAca2;
	private JTextField textHacerAca2;
	private JTextField textSerAca2;
	private JTextField textSaberAca3;
	private JTextField textHacerAca3;
	private JTextField textSerAca3;
	private JTextField textEvaluacionAca1;
	private JTextField textEvaluacionAca2;
	private JTextField textSaberIndu1;
	private JTextField textSaberIndu2;
	private JTextField textSaberIndu3;
	private JTextField textHacerIndu3;
	private JTextField textHacerIndu2;
	private JTextField textHacerIndu1;
	private JTextField textSerIndu1;
	private JTextField textSerIndu2;
	private JTextField textSerIndu3;
	private JTextField textEvaluacionIndu3;
	private JTextField textEvaluacionIndu2;
	private JTextField textEvaluacionIndu1;
	private JTextField textEvaluacionAca3;
	private JTextField textPromedioIndu;
	private JTextField textPromedioAca;
	private JTextField textEvaluacionFinal;
	public JButton btnBuscarAlumnoIndu;
	private char letras;
	private int hacer;
	private int saber;
	private int ser;
	private int evaluacionIntermedia;
	private double promedioIndustrial;
	private double promedioAcademico;
	private double promedioFinal;
	private DecimalFormat decimal;
	
	public BitacoraIndustrial() {
		
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
		mnIncio.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/inicio.png")));
		mnIncio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SocketLogin.vistaAsesorInd.setVisible(true);
				BitacoraIndustrial.this.dispose();
			}
		});
		menuBar.add(mnIncio);
		
		JMenu mnBuscarAlumno = new JMenu("Alumno");
		mnBuscarAlumno.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/alumno.png")));
		mnBuscarAlumno.setForeground(Color.WHITE);
		mnBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnBuscarAlumno);
		
		JMenuItem mntmVerBtacora = new JMenuItem("B\u00EDtacora");
		mntmVerBtacora.setForeground(Color.WHITE);
		mntmVerBtacora.setBackground(new Color(0, 102, 153));
		mntmVerBtacora.setFont(new Font("Arial", Font.BOLD, 15));
		mntmVerBtacora.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/bitacora.png")));
		mnBuscarAlumno.add(mntmVerBtacora);
		
		JMenuItem mntmObservacionesYCalificaciones = new JMenuItem("Observaciones y calificaciones");
		mntmObservacionesYCalificaciones.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/Clipboard-Paste-icon.png")));
		mntmObservacionesYCalificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				SocketObservacionesAsesorIndConsultarAlumno observaciones = new SocketObservacionesAsesorIndConsultarAlumno();
				BitacoraIndustrial.this.dispose();
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
		mnNewMenu.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					BitacoraIndustrial.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/cerrar.png")));
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
		mntmCambiarContrasea.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(BitacoraIndustrial.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblBitcoraDelAlumno = new JLabel("BIT\u00C1CORA DEL ALUMNO");
		lblBitcoraDelAlumno.setFont(new Font("Arial", Font.BOLD, 26));
		lblBitcoraDelAlumno.setBounds(577, 11, 334, 39);
		getContentPane().add(lblBitcoraDelAlumno);
		
		JLabel lblNombre = new JLabel("Nombre(s)");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(517, 76, 86, 25);
		getContentPane().add(lblNombre);
		
		textBuscarAlumnoIndu = new JTextField();
		textBuscarAlumnoIndu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				letras = e.getKeyChar();
				if((letras < 'a' || letras > 'z') && (letras < 'A' || letras > 'Z') && (letras != (char)KeyEvent.VK_BACK_SPACE) 
						&& (letras != (char) KeyEvent.VK_SPACE)) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Solo se admiten letras", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textBuscarAlumnoIndu.setFont(new Font("Arial", Font.PLAIN, 15));
		textBuscarAlumnoIndu.setBounds(619, 76, 228, 27);
		getContentPane().add(textBuscarAlumnoIndu);
		textBuscarAlumnoIndu.setColumns(10);
		
		btnBuscarAlumnoIndu = new JButton("");
		btnBuscarAlumnoIndu.setBackground(new Color(0, 102, 153));
		btnBuscarAlumnoIndu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscarAlumnoIndu.setIcon(new ImageIcon(BitacoraAcademico.class.getResource("/imagenes/buscar.png")));
		btnBuscarAlumnoIndu.setBounds(857, 60, 65, 55);
		getContentPane().add(btnBuscarAlumnoIndu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 122, 1310, 100);
		getContentPane().add(scrollPane);
		
		tableMostrarAlumnoIndu = new JTable();
		tableMostrarAlumnoIndu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Nombre(s)", "Apellido paterno", "Apellido materno", "Tel\u00E9fono", "Correo", "Proyecto", "Asesor acad\u00E9mico", "Asesor industrial", "Contrase\u00F1a"
			}
		));
		tableMostrarAlumnoIndu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tableMostrarAlumnoIndu);
		
		JLabel lblObservacionesDelAsesor = new JLabel("Observaciones del asesor acad\u00E9mico");
		lblObservacionesDelAsesor.setFont(new Font("Arial", Font.PLAIN, 17));
		lblObservacionesDelAsesor.setBounds(36, 236, 282, 33);
		getContentPane().add(lblObservacionesDelAsesor);
		
		JLabel lblAsesorCademico = new JLabel("EVALUACI\u00D3N DEL ASESOR ACAD\u00C9MICO");
		lblAsesorCademico.setFont(new Font("Arial", Font.PLAIN, 17));
		lblAsesorCademico.setBounds(71, 343, 328, 39);
		getContentPane().add(lblAsesorCademico);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 373, 417, 9);
		getContentPane().add(separator);
		
		textSaberAca1 = new JTextField();
		textSaberAca1.setFont(new Font("Arial", Font.PLAIN, 15));
		textSaberAca1.setEditable(false);
		textSaberAca1.setBounds(232, 420, 34, 27);
		getContentPane().add(textSaberAca1);
		textSaberAca1.setColumns(10);
		
		textHacerAca1 = new JTextField();
		textHacerAca1.setFont(new Font("Arial", Font.PLAIN, 15));
		textHacerAca1.setEditable(false);
		textHacerAca1.setBounds(232, 469, 34, 27);
		getContentPane().add(textHacerAca1);
		textHacerAca1.setColumns(10);
		
		textSer1 = new JTextField();
		textSer1.setFont(new Font("Arial", Font.PLAIN, 15));
		textSer1.setEditable(false);
		textSer1.setBounds(232, 513, 34, 27);
		getContentPane().add(textSer1);
		textSer1.setColumns(10);
		
		JLabel lblSaber = new JLabel("Saber");
		lblSaber.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSaber.setBounds(57, 426, 46, 14);
		getContentPane().add(lblSaber);
		
		JLabel lblHacer = new JLabel("Hacer");
		lblHacer.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHacer.setBounds(57, 475, 46, 14);
		getContentPane().add(lblHacer);
		
		JLabel lblSer = new JLabel("Ser");
		lblSer.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSer.setBounds(57, 519, 46, 14);
		getContentPane().add(lblSer);
		
		textSaberAca2 = new JTextField();
		textSaberAca2.setFont(new Font("Arial", Font.PLAIN, 15));
		textSaberAca2.setEditable(false);
		textSaberAca2.setBounds(304, 420, 34, 27);
		getContentPane().add(textSaberAca2);
		textSaberAca2.setColumns(10);
		
		textHacerAca2 = new JTextField();
		textHacerAca2.setFont(new Font("Arial", Font.PLAIN, 15));
		textHacerAca2.setEditable(false);
		textHacerAca2.setBounds(304, 469, 34, 27);
		getContentPane().add(textHacerAca2);
		textHacerAca2.setColumns(10);
		
		textSerAca2 = new JTextField();
		textSerAca2.setFont(new Font("Arial", Font.PLAIN, 15));
		textSerAca2.setEditable(false);
		textSerAca2.setBounds(304, 513, 34, 27);
		getContentPane().add(textSerAca2);
		textSerAca2.setColumns(10);
		
		JLabel lblEvaluacion = new JLabel("Evaluaci\u00F3n intermedia");
		lblEvaluacion.setFont(new Font("Arial", Font.BOLD, 15));
		lblEvaluacion.setBounds(25, 564, 158, 33);
		getContentPane().add(lblEvaluacion);
		
		textSaberAca3 = new JTextField();
		textSaberAca3.setFont(new Font("Arial", Font.PLAIN, 15));
		textSaberAca3.setEditable(false);
		textSaberAca3.setColumns(10);
		textSaberAca3.setBounds(382, 420, 34, 27);
		getContentPane().add(textSaberAca3);
		
		textHacerAca3 = new JTextField();
		textHacerAca3.setFont(new Font("Arial", Font.PLAIN, 15));
		textHacerAca3.setEditable(false);
		textHacerAca3.setColumns(10);
		textHacerAca3.setBounds(382, 469, 34, 27);
		getContentPane().add(textHacerAca3);
		
		textSerAca3 = new JTextField();
		textSerAca3.setFont(new Font("Arial", Font.PLAIN, 15));
		textSerAca3.setEditable(false);
		textSerAca3.setColumns(10);
		textSerAca3.setBounds(382, 513, 34, 27);
		getContentPane().add(textSerAca3);
		
		textEvaluacionAca1 = new JTextField();
		textEvaluacionAca1.setFont(new Font("Arial", Font.BOLD, 15));
		textEvaluacionAca1.setBackground(Color.WHITE);
		textEvaluacionAca1.setEditable(false);
		textEvaluacionAca1.setBounds(232, 567, 34, 26);
		getContentPane().add(textEvaluacionAca1);
		textEvaluacionAca1.setColumns(10);
		
		textEvaluacionAca2 = new JTextField();
		textEvaluacionAca2.setFont(new Font("Arial", Font.BOLD, 15));
		textEvaluacionAca2.setBackground(Color.WHITE);
		textEvaluacionAca2.setEditable(false);
		textEvaluacionAca2.setColumns(10);
		textEvaluacionAca2.setBounds(304, 567, 34, 26);
		getContentPane().add(textEvaluacionAca2);
		
		textEvaluacionAca3 = new JTextField();
		textEvaluacionAca3.setFont(new Font("Arial", Font.BOLD, 15));
		textEvaluacionAca3.setBackground(Color.WHITE);
		textEvaluacionAca3.setEditable(false);
		textEvaluacionAca3.setColumns(10);
		textEvaluacionAca3.setBounds(382, 567, 34, 26);
		getContentPane().add(textEvaluacionAca3);
		
		JLabel lblEjeDeEvaluacin = new JLabel("EJE DE EVALUACI\u00D3N");
		lblEjeDeEvaluacin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEjeDeEvaluacin.setBounds(36, 383, 147, 26);
		getContentPane().add(lblEjeDeEvaluacin);
		
		JLabel label_1 = new JLabel("3");
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(113, 426, 20, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("4");
		label_2.setFont(new Font("Arial", Font.PLAIN, 15));
		label_2.setBounds(113, 475, 20, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("3");
		label_3.setFont(new Font("Arial", Font.PLAIN, 15));
		label_3.setBounds(113, 519, 46, 14);
		getContentPane().add(label_3);
		
		JLabel lblEvaluacinDelAsesor = new JLabel("EVALUACI\u00D3N DEL ASESOR INDUSTRIAL");
		lblEvaluacinDelAsesor.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEvaluacinDelAsesor.setBounds(533, 343, 328, 39);
		getContentPane().add(lblEvaluacinDelAsesor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(485, 373, 417, 9);
		getContentPane().add(separator_1);
		
		JLabel label_4 = new JLabel("EJE DE EVALUACI\u00D3N");
		label_4.setFont(new Font("Arial", Font.PLAIN, 15));
		label_4.setBounds(496, 383, 147, 26);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Saber");
		label_5.setFont(new Font("Arial", Font.PLAIN, 15));
		label_5.setBounds(517, 426, 46, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("3");
		label_6.setFont(new Font("Arial", Font.PLAIN, 15));
		label_6.setBounds(573, 426, 20, 14);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Hacer");
		label_7.setFont(new Font("Arial", Font.PLAIN, 15));
		label_7.setBounds(517, 475, 46, 14);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("4");
		label_8.setFont(new Font("Arial", Font.PLAIN, 15));
		label_8.setBounds(573, 475, 20, 14);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Ser");
		label_9.setFont(new Font("Arial", Font.PLAIN, 15));
		label_9.setBounds(517, 519, 46, 14);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("3");
		label_10.setFont(new Font("Arial", Font.PLAIN, 15));
		label_10.setBounds(573, 519, 46, 14);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("Evaluaci\u00F3n intermedia");
		label_11.setFont(new Font("Arial", Font.BOLD, 15));
		label_11.setBounds(485, 564, 158, 33);
		getContentPane().add(label_11);
		
		textSaberIndu1 = new JTextField();
		textSaberIndu1.setFont(new Font("Arial", Font.PLAIN, 15));
		textSaberIndu1.setEditable(false);
		textSaberIndu1.setColumns(10);
		textSaberIndu1.setBounds(692, 420, 34, 27);
		getContentPane().add(textSaberIndu1);
		
		textSaberIndu2 = new JTextField();
		textSaberIndu2.setFont(new Font("Arial", Font.PLAIN, 15));
		textSaberIndu2.setEditable(false);
		textSaberIndu2.setColumns(10);
		textSaberIndu2.setBounds(767, 420, 34, 27);
		getContentPane().add(textSaberIndu2);
		
		textSaberIndu3 = new JTextField();
		textSaberIndu3.setFont(new Font("Arial", Font.PLAIN, 15));
		textSaberIndu3.setEditable(false);
		textSaberIndu3.setColumns(10);
		textSaberIndu3.setBounds(843, 420, 34, 27);
		getContentPane().add(textSaberIndu3);
		
		textHacerIndu3 = new JTextField();
		textHacerIndu3.setFont(new Font("Arial", Font.PLAIN, 15));
		textHacerIndu3.setEditable(false);
		textHacerIndu3.setColumns(10);
		textHacerIndu3.setBounds(843, 469, 34, 27);
		getContentPane().add(textHacerIndu3);
		
		textHacerIndu2 = new JTextField();
		textHacerIndu2.setFont(new Font("Arial", Font.PLAIN, 15));
		textHacerIndu2.setEditable(false);
		textHacerIndu2.setColumns(10);
		textHacerIndu2.setBounds(767, 469, 34, 27);
		getContentPane().add(textHacerIndu2);
		
		textHacerIndu1 = new JTextField();
		textHacerIndu1.setFont(new Font("Arial", Font.PLAIN, 15));
		textHacerIndu1.setEditable(false);
		textHacerIndu1.setColumns(10);
		textHacerIndu1.setBounds(692, 469, 34, 27);
		getContentPane().add(textHacerIndu1);
		
		textSerIndu1 = new JTextField();
		textSerIndu1.setFont(new Font("Arial", Font.PLAIN, 15));
		textSerIndu1.setEditable(false);
		textSerIndu1.setColumns(10);
		textSerIndu1.setBounds(692, 513, 34, 27);
		getContentPane().add(textSerIndu1);
		
		textSerIndu2 = new JTextField();
		textSerIndu2.setFont(new Font("Arial", Font.PLAIN, 15));
		textSerIndu2.setEditable(false);
		textSerIndu2.setColumns(10);
		textSerIndu2.setBounds(767, 513, 34, 27);
		getContentPane().add(textSerIndu2);
		
		textSerIndu3 = new JTextField();
		textSerIndu3.setFont(new Font("Arial", Font.PLAIN, 15));
		textSerIndu3.setEditable(false);
		textSerIndu3.setColumns(10);
		textSerIndu3.setBounds(843, 513, 34, 27);
		getContentPane().add(textSerIndu3);
		
		textEvaluacionIndu3 = new JTextField();
		textEvaluacionIndu3.setFont(new Font("Arial", Font.BOLD, 15));
		textEvaluacionIndu3.setEditable(false);
		textEvaluacionIndu3.setColumns(10);
		textEvaluacionIndu3.setBackground(Color.WHITE);
		textEvaluacionIndu3.setBounds(843, 567, 34, 26);
		getContentPane().add(textEvaluacionIndu3);
		
		textEvaluacionIndu2 = new JTextField();
		textEvaluacionIndu2.setFont(new Font("Arial", Font.BOLD, 15));
		textEvaluacionIndu2.setEditable(false);
		textEvaluacionIndu2.setColumns(10);
		textEvaluacionIndu2.setBackground(Color.WHITE);
		textEvaluacionIndu2.setBounds(767, 567, 34, 26);
		getContentPane().add(textEvaluacionIndu2);
		
		textEvaluacionIndu1 = new JTextField();
		textEvaluacionIndu1.setFont(new Font("Arial", Font.BOLD, 15));
		textEvaluacionIndu1.setEditable(false);
		textEvaluacionIndu1.setColumns(10);
		textEvaluacionIndu1.setBackground(Color.WHITE);
		textEvaluacionIndu1.setBounds(692, 567, 34, 26);
		getContentPane().add(textEvaluacionIndu1);
		
		JLabel lblEvaluacinFinalDel = new JLabel("EVALUACI\u00D3N FINAL DEL ALUMNO EN LA ESTAD\u00CDA");
		lblEvaluacinFinalDel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEvaluacinFinalDel.setBounds(934, 343, 412, 39);
		getContentPane().add(lblEvaluacinFinalDel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(934, 373, 417, 9);
		getContentPane().add(separator_2);
		
		JLabel lblAsesorIndustrial = new JLabel("Asesor industrial");
		lblAsesorIndustrial.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAsesorIndustrial.setBounds(974, 419, 128, 27);
		getContentPane().add(lblAsesorIndustrial);
		
		JLabel lblAsesorAcademico = new JLabel("Asesor acad\u00E9mico");
		lblAsesorAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAsesorAcademico.setBounds(973, 489, 128, 20);
		getContentPane().add(lblAsesorAcademico);
		
		JLabel lblEvaluaconFinal = new JLabel("Evaluaci\u00F3n final");
		lblEvaluaconFinal.setFont(new Font("Arial", Font.BOLD, 15));
		lblEvaluaconFinal.setBounds(974, 567, 128, 26);
		getContentPane().add(lblEvaluaconFinal);
		
		JLabel lblPromedio = new JLabel("PROMEDIO");
		lblPromedio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPromedio.setBounds(1161, 386, 92, 19);
		getContentPane().add(lblPromedio);
		
		textPromedioIndu = new JTextField();
		textPromedioIndu.setFont(new Font("Arial", Font.PLAIN, 15));
		textPromedioIndu.setEditable(false);
		textPromedioIndu.setBounds(1161, 420, 86, 27);
		getContentPane().add(textPromedioIndu);
		textPromedioIndu.setColumns(10);
		
		textPromedioAca = new JTextField();
		textPromedioAca.setFont(new Font("Arial", Font.PLAIN, 15));
		textPromedioAca.setEditable(false);
		textPromedioAca.setColumns(10);
		textPromedioAca.setBounds(1161, 486, 86, 27);
		getContentPane().add(textPromedioAca);
		
		textEvaluacionFinal = new JTextField();
		textEvaluacionFinal.setBackground(Color.WHITE);
		textEvaluacionFinal.setFont(new Font("Arial", Font.BOLD, 15));
		textEvaluacionFinal.setEditable(false);
		textEvaluacionFinal.setBounds(1161, 567, 86, 27);
		getContentPane().add(textEvaluacionFinal);
		textEvaluacionFinal.setColumns(10);
		
		JLabel label_12 = new JLabel("Observaciones del asesor industrial");
		label_12.setFont(new Font("Arial", Font.PLAIN, 16));
		label_12.setBounds(485, 236, 254, 33);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("Avances en estad\u00EDa por el alumno");
		label_13.setFont(new Font("Arial", Font.PLAIN, 17));
		label_13.setBounds(935, 233, 334, 39);
		getContentPane().add(label_13);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 276, 428, 67);
		getContentPane().add(scrollPane_1);
		
		textAreaObservacionesAca = new JTextArea();
		scrollPane_1.setViewportView(textAreaObservacionesAca);
		textAreaObservacionesAca.setFont(new Font("Arial", Font.PLAIN, 15));
		textAreaObservacionesAca.setBackground(SystemColor.controlHighlight);
		textAreaObservacionesAca.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(485, 276, 428, 67);
		getContentPane().add(scrollPane_2);
		
		textAreaObservacionesIndu = new JTextArea();
		scrollPane_2.setViewportView(textAreaObservacionesIndu);
		textAreaObservacionesIndu.setFont(new Font("Arial", Font.PLAIN, 15));
		textAreaObservacionesIndu.setBackground(SystemColor.controlHighlight);
		textAreaObservacionesIndu.setEditable(false);
		
		JLabel label_14 = new JLabel("<html><body><p align='justify'>*Nota: Los promedios y la calificaci\u00F3n final, se asignar\u00E1 autom\u00E1ticamente al presentarse todas las evaluaciones.</p></body></html>");
		label_14.setForeground(Color.BLUE);
		label_14.setFont(new Font("Arial", Font.PLAIN, 13));
		label_14.setBounds(949, 11, 254, 95);
		getContentPane().add(label_14);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(934, 276, 412, 67);
		getContentPane().add(scrollPane_3);
		
		textAreaAvancesAlum = new JTextArea();
		scrollPane_3.setViewportView(textAreaAvancesAlum);
		textAreaAvancesAlum.setEditable(false);
		textAreaAvancesAlum.setBackground(SystemColor.controlHighlight);
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(244, 393, 14, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel label_15 = new JLabel("2");
		label_15.setFont(new Font("Arial", Font.PLAIN, 15));
		label_15.setBounds(316, 393, 14, 14);
		getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("3");
		label_16.setFont(new Font("Arial", Font.PLAIN, 15));
		label_16.setBounds(393, 393, 14, 14);
		getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("2");
		label_17.setFont(new Font("Arial", Font.PLAIN, 15));
		label_17.setBounds(777, 393, 14, 14);
		getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("1");
		label_18.setFont(new Font("Arial", Font.PLAIN, 15));
		label_18.setBounds(705, 393, 14, 14);
		getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("3");
		label_19.setFont(new Font("Arial", Font.PLAIN, 15));
		label_19.setBounds(854, 393, 14, 14);
		getContentPane().add(label_19);
		decimal = new DecimalFormat("####.##");
	}

	public JTextField getTextBuscarAlumnoIndu() {
		return textBuscarAlumnoIndu;
	}

	public void setTextBuscarAlumnoIndu(JTextField textBuscarAlumnoIndu) {
		this.textBuscarAlumnoIndu = textBuscarAlumnoIndu;
	}

	public JTextArea getTextAreaObservacionesAca() {
		return textAreaObservacionesAca;
	}

	public void setTextAreaObservacionesAca(JTextArea textAreaObservacionesAca) {
		this.textAreaObservacionesAca = textAreaObservacionesAca;
	}

	public JTextArea getTextAreaObservacionesIndu() {
		return textAreaObservacionesIndu;
	}

	public void setTextAreaObservacionesIndu(JTextArea textAreaObservacionesIndu) {
		this.textAreaObservacionesIndu = textAreaObservacionesIndu;
	}

	public JTextArea getTextAreaAvancesAlum() {
		return textAreaAvancesAlum;
	}

	public void setTextAreaAvancesAlum(JTextArea textAreaAvancesAlum) {
		this.textAreaAvancesAlum = textAreaAvancesAlum;
	}

	public JTable getTableMostrarAlumnoIndu() {
		return tableMostrarAlumnoIndu;
	}

	public void setTableMostrarAlumnoIndu(JTable tableMostrarAlumnoIndu) {
		this.tableMostrarAlumnoIndu = tableMostrarAlumnoIndu;
	}

	public JTextField getTextSaberAca1() {
		return textSaberAca1;
	}

	public void setTextSaberAca1(JTextField textSaberAca1) {
		this.textSaberAca1 = textSaberAca1;
	}

	public JTextField getTextHacerAca1() {
		return textHacerAca1;
	}

	public void setTextHacerAca1(JTextField textHacerAca1) {
		this.textHacerAca1 = textHacerAca1;
	}

	public JTextField getTextSer1() {
		return textSer1;
	}

	public void setTextSer1(JTextField textSer1) {
		this.textSer1 = textSer1;
	}

	public JTextField getTextSaberAca2() {
		return textSaberAca2;
	}

	public void setTextSaberAca2(JTextField textSaberAca2) {
		this.textSaberAca2 = textSaberAca2;
	}

	public JTextField getTextHacerAca2() {
		return textHacerAca2;
	}

	public void setTextHacerAca2(JTextField textHacerAca2) {
		this.textHacerAca2 = textHacerAca2;
	}

	public JTextField getTextSerAca2() {
		return textSerAca2;
	}

	public void setTextSerAca2(JTextField textSerAca2) {
		this.textSerAca2 = textSerAca2;
	}

	public JTextField getTextSaberAca3() {
		return textSaberAca3;
	}

	public void setTextSaberAca3(JTextField textSaberAca3) {
		this.textSaberAca3 = textSaberAca3;
	}

	public JTextField getTextHacerAca3() {
		return textHacerAca3;
	}

	public void setTextHacerAca3(JTextField textHacerAca3) {
		this.textHacerAca3 = textHacerAca3;
	}

	public JTextField getTextSerAca3() {
		return textSerAca3;
	}

	public void setTextSerAca3(JTextField textSerAca3) {
		this.textSerAca3 = textSerAca3;
	}

	public JTextField getTextEvaluacionAca1() {
		return textEvaluacionAca1;
	}

	public void setTextEvaluacionAca1(JTextField textEvaluacionAca1) {
		this.textEvaluacionAca1 = textEvaluacionAca1;
	}

	public JTextField getTextEvaluacionAca2() {
		return textEvaluacionAca2;
	}

	public void setTextEvaluacionAca2(JTextField textEvaluacionAca2) {
		this.textEvaluacionAca2 = textEvaluacionAca2;
	}

	public JTextField getTextSaberIndu1() {
		return textSaberIndu1;
	}

	public void setTextSaberIndu1(JTextField textSaberIndu1) {
		this.textSaberIndu1 = textSaberIndu1;
	}

	public JTextField getTextSaberIndu2() {
		return textSaberIndu2;
	}

	public void setTextSaberIndu2(JTextField textSaberIndu2) {
		this.textSaberIndu2 = textSaberIndu2;
	}

	public JTextField getTextSaberIndu3() {
		return textSaberIndu3;
	}

	public void setTextSaberIndu3(JTextField textSaberIndu3) {
		this.textSaberIndu3 = textSaberIndu3;
	}

	public JTextField getTextHacerIndu3() {
		return textHacerIndu3;
	}

	public void setTextHacerIndu3(JTextField textHacerIndu3) {
		this.textHacerIndu3 = textHacerIndu3;
	}

	public JTextField getTextHacerIndu2() {
		return textHacerIndu2;
	}

	public void setTextHacerIndu2(JTextField textHacerIndu2) {
		this.textHacerIndu2 = textHacerIndu2;
	}

	public JTextField getTextHacerIndu1() {
		return textHacerIndu1;
	}

	public void setTextHacerIndu1(JTextField textHacerIndu1) {
		this.textHacerIndu1 = textHacerIndu1;
	}

	public JTextField getTextSerIndu1() {
		return textSerIndu1;
	}

	public void setTextSerIndu1(JTextField textSerIndu1) {
		this.textSerIndu1 = textSerIndu1;
	}

	public JTextField getTextSerIndu2() {
		return textSerIndu2;
	}

	public void setTextSerIndu2(JTextField textSerIndu2) {
		this.textSerIndu2 = textSerIndu2;
	}

	public JTextField getTextSerIndu3() {
		return textSerIndu3;
	}

	public void setTextSerIndu3(JTextField textSerIndu3) {
		this.textSerIndu3 = textSerIndu3;
	}

	public JTextField getTextEvaluacionIndu3() {
		return textEvaluacionIndu3;
	}

	public void setTextEvaluacionIndu3(JTextField textEvaluacionIndu3) {
		this.textEvaluacionIndu3 = textEvaluacionIndu3;
	}

	public JTextField getTextEvalucionIndu2() {
		return textEvaluacionIndu2;
	}

	public void setTextEvalucionIndu2(JTextField textEvalucionIndu2) {
		this.textEvaluacionIndu2 = textEvalucionIndu2;
	}

	public JTextField getTextEvaluacionIndu1() {
		return textEvaluacionIndu1;
	}

	public void setTextEvaluacionIndu1(JTextField textEvaluacionIndu1) {
		this.textEvaluacionIndu1 = textEvaluacionIndu1;
	}

	public JTextField getTextEvaluacionAca3() {
		return textEvaluacionAca3;
	}

	public void setTextEvaluacionAca3(JTextField textEvaluacionAca3) {
		this.textEvaluacionAca3 = textEvaluacionAca3;
	}

	public JTextField getTextPromedioIndu() {
		return textPromedioIndu;
	}

	public void setTextPromedioIndu(JTextField textPromedioIndu) {
		this.textPromedioIndu = textPromedioIndu;
	}

	public JTextField getTextPromedioAca() {
		return textPromedioAca;
	}

	public void setTextPromedioAca(JTextField textPromedioAca) {
		this.textPromedioAca = textPromedioAca;
	}

	public JTextField getTextEvaluacionFinal() {
		return textEvaluacionFinal;
	}

	public void setTextEvaluacionFinal(JTextField textEvaluacionFinal) {
		this.textEvaluacionFinal = textEvaluacionFinal;
	}
	
	/**
	 * Metodo que suma ser, saber y hacer y muestra la evaluación intermedia del parcial 1 del Asesor Academico
	 */
	public boolean evaluacionIntermediaAca1() {
		if (!this.textSaberAca1.getText().equals("") && !this.textSer1.getText().equals("") && !this.textHacerAca1.getText().equals("")) {
			this.saber = Integer.parseInt((String) this.textSaberAca1.getText());
			this.ser = Integer.parseInt((String) this.textSer1.getText());
			this.hacer = Integer.parseInt((String) this.textHacerAca1.getText());
			this.evaluacionIntermedia = this.hacer + this.saber + this.ser;
			this.textEvaluacionAca1.setText("" + this.evaluacionIntermedia);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que suma ser, saber y hacer y muestra la evaluación intermedia del parcial 2 del Asesor Academico
	 */
	public boolean evaluacionIntermediaAca2() {
		if (!this.textSaberAca2.getText().equals("") && !this.textSerAca2.getText().equals("") && !this.textHacerAca2.getText().equals("")) {
			this.saber = Integer.parseInt((String) this.textSaberAca2.getText());
			this.ser = Integer.parseInt((String) this.textSerAca2.getText());
			this.hacer = Integer.parseInt((String) this.textHacerAca2.getText());
			this.evaluacionIntermedia = this.hacer + this.saber + this.ser;
			this.textEvaluacionAca2.setText("" + this.evaluacionIntermedia);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que suma ser, saber y hacer y muestra la evaluación intermedia del parcial 3 del Asesor Academico
	 */
	public boolean evaluacionIntermediaAca3() {
		if (!this.textSaberAca3.getText().equals("") && !this.textSerAca3.getText().equals("") && !this.textHacerAca3.getText().equals("")) {
			this.saber = Integer.parseInt((String) this.textSaberAca3.getText());
			this.ser = Integer.parseInt((String) this.textSerAca3.getText());
			this.hacer = Integer.parseInt((String) this.textHacerAca3.getText());
			this.evaluacionIntermedia = this.hacer + this.saber + this.ser;
			this.textEvaluacionAca3.setText("" + this.evaluacionIntermedia);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que suma ser, saber y hacer y muestra la evaluación intermedia del parcial 1 del Asesor Industrial
	 */
	public boolean evaluacionIntermediaInd1() {
		if (!this.textSaberIndu1.getText().equals("") && !this.textSerIndu1.getText().equals("") && !this.textHacerIndu1.getText().equals("")) {
			this.saber = Integer.parseInt((String) this.textSaberIndu1.getText());
			this.ser = Integer.parseInt((String) this.textSerIndu1.getText());
			this.hacer = Integer.parseInt((String) this.textHacerIndu1.getText());
			this.evaluacionIntermedia = this.hacer + this.saber + this.ser;
			this.textEvaluacionIndu1.setText("" + this.evaluacionIntermedia);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que suma ser, saber y hacer y muestra la evaluación intermedia del parcial 2 del Asesor Industrial
	 */
	public boolean evaluacionIntermediaInd2() {
		if (!this.textSaberIndu2.getText().equals("") && !this.textSerIndu2.getText().equals("") && !this.textHacerIndu2.getText().equals("")) {
			this.saber = Integer.parseInt((String) this.textSaberIndu2.getText());
			this.ser = Integer.parseInt((String) this.textSerIndu2.getText());
			this.hacer = Integer.parseInt((String) this.textHacerIndu2.getText());
			this.evaluacionIntermedia = this.hacer + this.saber + this.ser;
			this.textEvaluacionIndu2.setText("" + this.evaluacionIntermedia);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que suma ser, saber y hacer y muestra la evaluación intermedia del parcial 3 del Asesor Industrial
	 */
	public boolean evaluacionIntermediaInd3() {
		if (!this.textSaberIndu3.getText().equals("") && !this.textSerIndu3.getText().equals("") && !this.textHacerIndu3.getText().equals("")) {
			this.saber = Integer.parseInt((String) this.textSaberIndu3.getText());
			this.ser = Integer.parseInt((String) this.textSerIndu3.getText());
			this.hacer = Integer.parseInt((String) this.textHacerIndu3.getText());
			this.evaluacionIntermedia = this.hacer + this.saber + this.ser;
			this.textEvaluacionIndu3.setText("" + this.evaluacionIntermedia);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que suma las evaluaciones intermedias del Asesor Industrial y muestra el promedio de éstas.
	 */
	public boolean promedioIndustrial() {
		if (this.evaluacionIntermediaInd1() == true && this.evaluacionIntermediaInd2() == true && this.evaluacionIntermediaInd3() == true) {
			this.saber = Integer.parseInt((String) this.textEvaluacionIndu1.getText());
			this.ser = Integer.parseInt((String) this.textEvaluacionIndu2.getText());
			this.hacer = Integer.parseInt((String) this.textEvaluacionIndu3.getText());
			this.evaluacionIntermedia = this.hacer + this.saber + this.ser;
			this.promedioIndustrial = (this.evaluacionIntermedia/3.0);
			this.textPromedioIndu.setText("" + this.decimal.format(this.promedioIndustrial));
			return true;
		}
		return false;
	}
	/**
	 * Metodo que suma las evaluaciones intermedias del Asesor Academico y muestra el promedio de éstas.
	 */
	public boolean promedioAcademico() {
		if (this.evaluacionIntermediaAca1() == true && this.evaluacionIntermediaAca2() == true && this.evaluacionIntermediaAca3() == true) {
			this.saber = Integer.parseInt((String) this.textEvaluacionAca1.getText());
			this.ser = Integer.parseInt((String) this.textEvaluacionAca2.getText());
			this.hacer = Integer.parseInt((String) this.textEvaluacionAca3.getText());
			this.evaluacionIntermedia = this.hacer + this.saber + this.ser;
			this.promedioAcademico = (this.evaluacionIntermedia/3.0);
			this.textPromedioAca.setText("" + this.decimal.format(this.promedioAcademico));
			return true;
		}
		return false;
	}
	/**
	 * Metodo que muestra la calificación final del alumno
	 */
	public void calificacionFinal() {
		if (this.promedioAcademico() == true && this.promedioIndustrial() == true) {
			this.promedioFinal = ((this.promedioAcademico + this.promedioIndustrial)/2.0);
			this.textEvaluacionFinal.setText("" + this.decimal.format(this.promedioFinal));
		}
	}
}
