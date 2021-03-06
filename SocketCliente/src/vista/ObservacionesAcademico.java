package vista;
/**
 * Esta Clase es una vista que muestra el formulario para registrar Observaciones a los alumnos,
 * al iniciar sesión como Asesor Académico. 
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
import javax.swing.JTextField;
import funcionamiento.SocketBitacoraAcademico;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketLogin;
import main.Main;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.SystemColor;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ObservacionesAcademico extends JFrame {
	private JTextField textBuscarAlumno;
	private JTextField textNombreAlumno;
	private JTextField textPaternoAlumno;
	private JTextField textMaternoAlumno;
	private JTextArea textAreaObservacionAcademico;
	private JTextField textFieldEvaluacionIntermedia;
	public JButton btnBuscarAlumno;
	public JButton btnAgregarCalif;
	public JButton btnAgregarObservacion;
	@SuppressWarnings("rawtypes")
	private JComboBox comboParciales;
	@SuppressWarnings("rawtypes")
	private JComboBox comboNumeroSemana;
	@SuppressWarnings("rawtypes")
	private JComboBox comboSaber;
	@SuppressWarnings("rawtypes")
	private JComboBox comboHacer;
	@SuppressWarnings("rawtypes")
	private JComboBox comboSer;
	private int ser;
	private int saber;
	private int hacer;
	private int evaluacionIntermedia;
	private JLabel lblMatricula;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ObservacionesAcademico() {
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
		mnIncio.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/inicio.png")));
		mnIncio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SocketLogin.vistaAsesorAca.setVisible(true);
				ObservacionesAcademico.this.dispose();
			}
		});
		menuBar.add(mnIncio);
		
		JMenu mnBuscarAlumno = new JMenu("Alumno");
		mnBuscarAlumno.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/alumno.png")));
		mnBuscarAlumno.setForeground(Color.WHITE);
		mnBuscarAlumno.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnBuscarAlumno);
		
		JMenuItem mntmVerBtacora = new JMenuItem("B\u00EDtacora");
		mntmVerBtacora.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				SocketBitacoraAcademico bitacora = new SocketBitacoraAcademico();
				ObservacionesAcademico.this.dispose();
			}
		});
		mntmVerBtacora.setForeground(Color.WHITE);
		mntmVerBtacora.setBackground(new Color(0, 102, 153));
		mntmVerBtacora.setFont(new Font("Arial", Font.BOLD, 15));
		mntmVerBtacora.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/bitacora.png")));
		mnBuscarAlumno.add(mntmVerBtacora);
		
		JMenuItem mntmObservacionesYCalificaciones = new JMenuItem("Observaciones y evaluaciones");
		mntmObservacionesYCalificaciones.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/Clipboard-Paste-icon.png")));
		mntmObservacionesYCalificaciones.setForeground(Color.WHITE);
		mntmObservacionesYCalificaciones.setBackground(new Color(0, 102, 153));
		mntmObservacionesYCalificaciones.setFont(new Font("Arial", Font.BOLD, 15));
		mnBuscarAlumno.add(mntmObservacionesYCalificaciones);
		
		menuBar.setBackground(new Color(0, 102, 153));
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					ObservacionesAcademico.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/cerrar.png")));
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
		mntmCambiarContrasea.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);
		
		JLabel lblMatriculaAlumno = new JLabel("Matricula alumno");
		lblMatriculaAlumno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatriculaAlumno.setBounds(521, 84, 136, 30);
		getContentPane().add(lblMatriculaAlumno);

		this.textBuscarAlumno = new JTextField();
		textBuscarAlumno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
				     Toolkit.getDefaultToolkit().beep();
				     evt.consume();
				     JOptionPane.showMessageDialog(null,"Solo se admiten números", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			}
		});
		this.textBuscarAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.textBuscarAlumno.setBounds(667, 84, 228, 25);
		this.getContentPane().add(this.textBuscarAlumno);
		this.textBuscarAlumno.setColumns(10);
		
		this.btnBuscarAlumno = new JButton("");

		this.btnBuscarAlumno.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/buscar.png")));
		this.btnBuscarAlumno.setBounds(905, 67, 72, 61);
		this.btnBuscarAlumno.setBackground(new Color(0, 102, 153));
		getContentPane().add(this.btnBuscarAlumno);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombre.setBounds(269, 166, 106, 30);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoMaterno.setBounds(913, 166, 136, 30);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setFont(new Font("Arial", Font.PLAIN, 17));
		lblApellidoPaterno.setBounds(590, 166, 129, 30);
		getContentPane().add(lblApellidoPaterno);
		
		this.textNombreAlumno = new JTextField();
		this.textNombreAlumno.setBackground(Color.WHITE);
		this.textNombreAlumno.setEditable(false);
		this.textNombreAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.textNombreAlumno.setBounds(269, 206, 228, 25);
		this.getContentPane().add(this.textNombreAlumno);
		this.textNombreAlumno.setColumns(10);
		
		this.textPaternoAlumno = new JTextField();
		this.textPaternoAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.textPaternoAlumno.setBackground(Color.WHITE);
		this.textPaternoAlumno.setEnabled(true);
		this.textPaternoAlumno.setEditable(false);
		this.textPaternoAlumno.setText("");
		this.textPaternoAlumno.setBounds(590, 208, 228, 25);
		getContentPane().add(this.textPaternoAlumno);
		this.textPaternoAlumno.setColumns(10);
		
		this.textMaternoAlumno = new JTextField();
		this.textMaternoAlumno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.textMaternoAlumno.setBackground(Color.WHITE);
		this.textMaternoAlumno.setEditable(false);
		this.textMaternoAlumno.setBounds(913, 207, 228, 25);
		getContentPane().add(textMaternoAlumno);
		this.textMaternoAlumno.setColumns(10);
		
		JLabel lblObservacionesDelAsesor = new JLabel("OBSERVACIONES DEL ASESOR ACAD\u00C9MICO");
		lblObservacionesDelAsesor.setFont(new Font("Arial", Font.BOLD, 19));
		lblObservacionesDelAsesor.setBounds(47, 304, 426, 25);
		getContentPane().add(lblObservacionesDelAsesor);
		
		JLabel lblNmeroDeSemana = new JLabel("N\u00FAmero de semana");
		lblNmeroDeSemana.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNmeroDeSemana.setBounds(118, 516, 148, 30);
		getContentPane().add(lblNmeroDeSemana);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(45, 338, 428, 12);
		getContentPane().add(separator);
		
		this.comboNumeroSemana = new JComboBox();
		comboNumeroSemana.setFont(new Font("Arial", Font.PLAIN, 15));
		this.comboNumeroSemana.setModel(new DefaultComboBoxModel(new String[] {"", "2", "4", "6", "8", "10", "11", "12", "14", "15"}));
		this.comboNumeroSemana.setBounds(291, 521, 61, 27);
		getContentPane().add(comboNumeroSemana);
		
		JLabel lblEvaluacionesPorEl = new JLabel("EVALUAR AL ALUMNO\r\n");
		lblEvaluacionesPorEl.setFont(new Font("Arial", Font.BOLD, 19));
		lblEvaluacionesPorEl.setBounds(667, 304, 245, 25);
		getContentPane().add(lblEvaluacionesPorEl);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(667, 338, 551, 12);
		getContentPane().add(separator_1);
		
		JLabel lblSaber = new JLabel("Saber ");
		lblSaber.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSaber.setBounds(774, 359, 56, 25);
		getContentPane().add(lblSaber);
		
		JLabel lblHacer = new JLabel("Hacer");
		lblHacer.setFont(new Font("Arial", Font.PLAIN, 17));
		lblHacer.setBounds(774, 418, 46, 14);
		getContentPane().add(lblHacer);
		
		JLabel lblSer = new JLabel("Ser");
		lblSer.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSer.setBounds(774, 467, 46, 14);
		getContentPane().add(lblSer);
		
		this.comboSaber = new JComboBox();
		comboSaber.setFont(new Font("Arial", Font.PLAIN, 15));
		this.comboSaber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!comboHacer.getSelectedItem().equals("") && !comboSaber.getSelectedItem().equals("") && !comboSer.getSelectedItem().equals("")) {
					hacer = Integer.parseInt((String) comboHacer.getSelectedItem());
					ser = Integer.parseInt((String) comboSer.getSelectedItem());
					saber = Integer.parseInt((String) comboSaber.getSelectedItem());
					evaluacionIntermedia = hacer + saber + ser;
					textFieldEvaluacionIntermedia.setText("" + evaluacionIntermedia);
				}
			}
		});
		this.comboSaber.setBounds(927, 361, 72, 25);
		this.comboSaber.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		getContentPane().add(comboSaber);
		
		this.comboHacer = new JComboBox();
		comboHacer.setFont(new Font("Arial", Font.PLAIN, 15));
		this.comboHacer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!comboHacer.getSelectedItem().equals("") && !comboSaber.getSelectedItem().equals("") && !comboSer.getSelectedItem().equals("")) {
					hacer = Integer.parseInt((String) comboHacer.getSelectedItem());
					ser = Integer.parseInt((String) comboSer.getSelectedItem());
					saber = Integer.parseInt((String) comboSaber.getSelectedItem());
					evaluacionIntermedia = hacer + saber + ser;
					textFieldEvaluacionIntermedia.setText("" + evaluacionIntermedia);
				}
			}
		});
		this.comboHacer.setBounds(927, 415, 72, 25);
		this.comboHacer.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		getContentPane().add(comboHacer);
		
		this.comboSer = new JComboBox();
		comboSer.setFont(new Font("Arial", Font.PLAIN, 15));
		this.comboSer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (!comboHacer.getSelectedItem().equals("") && !comboSaber.getSelectedItem().equals("") && !comboSer.getSelectedItem().equals("")) {
					hacer = Integer.parseInt((String) comboHacer.getSelectedItem());
					ser = Integer.parseInt((String) comboSer.getSelectedItem());
					saber = Integer.parseInt((String) comboSaber.getSelectedItem());
					evaluacionIntermedia = hacer + saber + ser;
					textFieldEvaluacionIntermedia.setText("" + evaluacionIntermedia);
				}
			}
		});
		this.comboSer.setBounds(927, 464, 72, 25);
		this.comboSer.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		getContentPane().add(comboSer);
		
		JLabel lblEvaluacionIntermedia = new JLabel("Evaluaci\u00F3n intermedia");
		lblEvaluacionIntermedia.setFont(new Font("Arial", Font.BOLD, 17));
		lblEvaluacionIntermedia.setBounds(713, 519, 182, 25);
		getContentPane().add(lblEvaluacionIntermedia);
		
		this.textFieldEvaluacionIntermedia = new JTextField();
		this.textFieldEvaluacionIntermedia.setBackground(Color.WHITE);
		this.textFieldEvaluacionIntermedia.setFont(new Font("Arial", Font.BOLD, 16));
		this.textFieldEvaluacionIntermedia.setEditable(false);
		this.textFieldEvaluacionIntermedia.setBounds(927, 519, 123, 27);

		getContentPane().add(this.textFieldEvaluacionIntermedia);
		this.textFieldEvaluacionIntermedia.setColumns(10);
		
		JLabel lblEjeDeEvaluacin = new JLabel("Parcial");
		lblEjeDeEvaluacin.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEjeDeEvaluacin.setBounds(922, 307, 72, 21);
		getContentPane().add(lblEjeDeEvaluacin);
		
		this.comboParciales = new JComboBox();
		comboParciales.setFont(new Font("Arial", Font.PLAIN, 15));
		this.comboParciales.setBounds(1004, 304, 82, 25);
		this.comboParciales.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		getContentPane().add(comboParciales);
		
		this.btnAgregarObservacion = new JButton("Agregar Observaci\u00F3n");

		this.btnAgregarObservacion.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/registrar.png")));
		this.btnAgregarObservacion.setForeground(Color.WHITE);
		this.btnAgregarObservacion.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnAgregarObservacion.setBounds(118, 574, 245, 56);
		this.btnAgregarObservacion.setBackground(new Color(0, 102, 153));
		getContentPane().add(btnAgregarObservacion);
		
		JLabel lblObservacionesYCalificaciones = new JLabel("OBSERVACIONES Y EVALUACIONES");
		lblObservacionesYCalificaciones.setFont(new Font("Arial", Font.BOLD, 27));
		lblObservacionesYCalificaciones.setBounds(521, 30, 506, 30);
		getContentPane().add(lblObservacionesYCalificaciones);
		
		this.btnAgregarCalif = new JButton("Agregar Calificaci\u00F3n");
		this.btnAgregarCalif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		this.btnAgregarCalif.setIcon(new ImageIcon(ObservacionesAcademico.class.getResource("/imagenes/registrar.png")));
		this.btnAgregarCalif.setForeground(Color.WHITE);
		this.btnAgregarCalif.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnAgregarCalif.setBackground(new Color(0, 102, 153));
		this.btnAgregarCalif.setBounds(821, 574, 245, 56);
		getContentPane().add(btnAgregarCalif);
		
		lblMatricula = new JLabel("matricula");
		lblMatricula.setEnabled(false);
		lblMatricula.setVisible(false);
		lblMatricula.setBounds(713, 133, 161, 18);
		getContentPane().add(lblMatricula);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 360, 426, 121);
		getContentPane().add(scrollPane);
		this.textAreaObservacionAcademico = new JTextArea();
		scrollPane.setViewportView(textAreaObservacionAcademico);
		this.textAreaObservacionAcademico.setBackground(SystemColor.controlHighlight);
		this.textAreaObservacionAcademico.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblnotaRecuerdaQue = new JLabel("<html><body> <p align='justify'> *Nota: Recuerda que no puedes evaluar el mismo parcial 2 veces, <br>ten cuidado por la calificaci\u00F3n que asignes porque no se podr\u00E1 modificar. </p></body></html>");
		lblnotaRecuerdaQue.setForeground(Color.BLUE);
		lblnotaRecuerdaQue.setFont(new Font("Arial", Font.PLAIN, 13));
		lblnotaRecuerdaQue.setBounds(662, 250, 551, 43);
		getContentPane().add(lblnotaRecuerdaQue);
		
		JLabel label_1 = new JLabel("<html><body><p align='justify'> *Nota: Recuerda que sólo puedes agregar un comentario por semana, ten cuidado en los comentarios que realices, porque ya no se podrán modificar.</p></body></html>");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Arial", Font.PLAIN, 13));
		label_1.setBounds(47, 250, 440, 43);
		getContentPane().add(label_1);
	}

	
	
	public JTextField getTextBuscarAlumno() {
		return textBuscarAlumno;
	}
	public void setTextBuscarAlumno(JTextField textBuscarAlumno) {
		this.textBuscarAlumno = textBuscarAlumno;
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

	public JTextArea getTextAreaObservacionAcademico() {
		return textAreaObservacionAcademico;
	}

	public void setTextAreaObservacionAcademico(JTextArea textAreaObservacionAcademico) {
		this.textAreaObservacionAcademico = textAreaObservacionAcademico;
	}
	public JTextField getTextFieldEvaluacionIntermedia() {
		return textFieldEvaluacionIntermedia;
	}

	public void setTextFieldEvaluacionIntermedia(JTextField textField) {
		this.textFieldEvaluacionIntermedia = textField;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getComboParciales() {
		return comboParciales;
	}
	@SuppressWarnings("rawtypes")
	public void setComboParciales(JComboBox comboParciales) {
		this.comboParciales = comboParciales;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboNumeroSemana() {
		return comboNumeroSemana;
	}
	@SuppressWarnings("rawtypes")
	public void setComboNumeroSemana(JComboBox comboNumeroSemana) {
		this.comboNumeroSemana = comboNumeroSemana;
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getComboSaber() {
		return comboSaber;
	}
	@SuppressWarnings("rawtypes")
	public void setComboSaber(JComboBox comboSaber) {
		this.comboSaber = comboSaber;
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getComboHacer() {
		return comboHacer;
	}
	@SuppressWarnings("rawtypes")
	public void setComboHacer(JComboBox comboHacer) {
		this.comboHacer = comboHacer;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboSer() {
		return comboSer;
	}
	@SuppressWarnings("rawtypes")
	public void setComboSer(JComboBox comboSer) {
		this.comboSer = comboSer;
	}

	public JLabel getLblMatricula() {
		return lblMatricula;
	}
	public void setLblMatricula(JLabel lblMatricula) {
		this.lblMatricula = lblMatricula;
	}



	public boolean validarEvaluacion() {
		if(textBuscarAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes buscar al alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.textBuscarAlumno.requestFocus();
			return false;
		}else if(textNombreAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes buscar al alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.textBuscarAlumno.requestFocus();
			return false;
		}else if(comboParciales.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,"Debes seleccionar el parcial", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.comboParciales.requestFocus();
			return false;
		}else if(comboSaber.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,"Debes seleccionar la evaluacion del saber", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.comboSaber.requestFocus();
			return false;
		}else if(comboHacer.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,"Debes seleccionar la evaluación del hacer", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.comboHacer.requestFocus();
			return false;
		}else if(comboSer.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,"Debes seleccionar la evaluacion del ser", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.comboSer.requestFocus();
			return false;
		}else {
			return true;
		}
	}
	
	public boolean validarObservaciones() {
		if(textBuscarAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes buscar al alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.textBuscarAlumno.requestFocus();
			return false;
		}else if(textNombreAlumno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes buscar al alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.textBuscarAlumno.requestFocus();
			return false;
		}else if(textAreaObservacionAcademico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar un observación", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.textAreaObservacionAcademico.requestFocus();
			return false;
		}else if(comboNumeroSemana.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,"Debes seleccionar el número de semana", "ERROR", JOptionPane.ERROR_MESSAGE);
			this.comboNumeroSemana.requestFocus();
			return false;
		}else {
			return true;
		}
	}
	
	public void limpiarCajas() {
		this.textNombreAlumno.setText("");
		this.textPaternoAlumno.setText("");
		this.textMaternoAlumno.setText("");
		this.textFieldEvaluacionIntermedia.setText("");
		this.comboSaber.setSelectedItem("");
		this.comboHacer.setSelectedItem("");
		this.comboParciales.setSelectedItem("");
		this.comboSer.setSelectedItem("");
		this.textAreaObservacionAcademico.setText("");
		this.textBuscarAlumno.setText("");
		this.comboNumeroSemana.setSelectedItem("");
	}
}
