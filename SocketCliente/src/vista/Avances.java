package vista;
/**
 * Esta Clase es una vista que muestra el formulario para que el alumno agregue sus avances
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

import funcionamiento.SocketBitacoraAlumno;
import funcionamiento.SocketCambiarContraseña;
import funcionamiento.SocketLogin;
import main.Main;

import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Avances extends JFrame {
	
	private TextArea textAreaAvance;
	@SuppressWarnings("rawtypes")
	private JComboBox comboSemana;
	public JButton btnRegistrarAvance;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Avances() {
		super("Control RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/alumno.png"));
		setIconImage(icon);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 735);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.setBackground(new Color(0, 102, 153));
		setJMenuBar(menuBar);
		
		JMenu mnIncio = new JMenu("Inicio");
		mnIncio.setForeground(Color.WHITE);
		mnIncio.setFont(new Font("Arial", Font.BOLD, 15));
		mnIncio.setIcon(new ImageIcon(Avances.class.getResource("/imagenes/inicio.png")));
		mnIncio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SocketLogin.vistaAlumno.setVisible(true);
				Avances.this.dispose();
			}
		});
		menuBar.add(mnIncio);
		
		JMenu mnBitcora = new JMenu("Bit\u00E1cora");
		
		mnBitcora.setIcon(new ImageIcon(Avances.class.getResource("/imagenes/bitacora.png")));
		mnBitcora.setForeground(Color.WHITE);
		mnBitcora.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnBitcora);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setIcon(new ImageIcon(Avances.class.getResource("/imagenes/opciones.png")));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesion?","Cerrar sesion", JOptionPane.YES_NO_OPTION,  1) == 0) {
					Main.frameSesion.setVisible(true);
					Avances.this.dispose();
				}
			}
		});
		mntmCerrarSesion.setBackground(new Color(0, 102, 153));
		mntmCerrarSesion.setIcon(new ImageIcon(Avances.class.getResource("/imagenes/cerrar.png")));
		mntmCerrarSesion.setFont(new Font("Arial", Font.BOLD, 15));
		mntmCerrarSesion.setForeground(Color.WHITE);
		mnNewMenu.add(mntmCerrarSesion);
		JMenuItem mntmVerBitcora = new JMenuItem("Ver bit\u00E1cora");
		mntmVerBitcora.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				SocketBitacoraAlumno bitacoraAlumno = new SocketBitacoraAlumno();
				Avances.this.dispose();
			}
		});
		mntmVerBitcora.setForeground(Color.WHITE);
		mntmVerBitcora.setBackground(new Color(0, 102, 153));
		mntmVerBitcora.setFont(new Font("Arial", Font.BOLD, 15));
		mntmVerBitcora.setIcon(new ImageIcon(Bitacora.class.getResource("/imagenes/ver.png")));
		mnBitcora.add(mntmVerBitcora);
		
		JMenuItem mntmRegistarAvances = new JMenuItem("Registar avances");

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
		mntmCambiarContrasea.setIcon(new ImageIcon(Avances.class.getResource("/imagenes/cambiar.png")));
		mntmCambiarContrasea.setBackground(new Color(0, 102, 153));
		mntmCambiarContrasea.setForeground(Color.WHITE);
		mntmCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.add(mntmCambiarContrasea);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Avances.class.getResource("/imagenes/Uttec.jpg")));
		label.setBounds(10, 11, 328, 117);
		getContentPane().add(label);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Avances.class.getResource("/imagenes/logo.png")));
		lblIcono.setBounds(1195, 11, 161, 128);
		getContentPane().add(lblIcono);

		textAreaAvance = new TextArea();
		textAreaAvance.setBounds(275, 206, 926, 117);
		getContentPane().add(textAreaAvance);
		
		JLabel lblRegistrarAvancesEn = new JLabel("REGISTAR AVANCE EN ESTADIA");
		lblRegistrarAvancesEn.setFont(new Font("Arial", Font.BOLD, 26));
		lblRegistrarAvancesEn.setBounds(535, 33, 430, 95);
		getContentPane().add(lblRegistrarAvancesEn);
		
		JLabel lblNmeroDeSeman = new JLabel("N\u00FAmero de semana");
		lblNmeroDeSeman.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNmeroDeSeman.setBounds(570, 383, 152, 20);
		getContentPane().add(lblNmeroDeSeman);
		
		comboSemana = new JComboBox();
		comboSemana.setModel(new DefaultComboBoxModel(new String[] {"", "2", "4", "6", "8", "10", "12", "14", "15"}));
		comboSemana.setBounds(754, 382, 68, 27);
		getContentPane().add(comboSemana);
		
		btnRegistrarAvance = new JButton("Registrar avance");

		btnRegistrarAvance.setIcon(new ImageIcon(Avances.class.getResource("/imagenes/registrar.png")));
		btnRegistrarAvance.setForeground(Color.WHITE);
		btnRegistrarAvance.setBackground(new Color(0, 102, 153));
		btnRegistrarAvance.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrarAvance.setBounds(594, 489, 233, 57);
		getContentPane().add(btnRegistrarAvance);
	}
	
	public TextArea getTextAreaAvance() {
		return textAreaAvance;
	}
	public void setTextAreaAvance(TextArea textAreaAvance) {
		this.textAreaAvance = textAreaAvance;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboSemana() {
		return comboSemana;
	}

	@SuppressWarnings("rawtypes")
	public void setComboSemana(JComboBox comboSemana) {
		this.comboSemana = comboSemana;
	}



	public boolean validarAvances() {
		if(textAreaAvance.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Debes ingresar el avance que hiciste en la semana", "ERROR", JOptionPane.ERROR_MESSAGE);
			textAreaAvance.requestFocus();
			return false;
		}else if(comboSemana.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,"Selecciona la semana que realizaste el avance", "ERROR", JOptionPane.ERROR_MESSAGE);
			comboSemana.requestFocus();
			return true;
		}else {
			return true;
		}
	}
}
