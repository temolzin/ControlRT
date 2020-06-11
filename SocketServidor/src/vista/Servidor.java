package vista;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class Servidor extends JFrame {

	private JPanel contentPane;
	private TextArea textArea;
	public Servidor() {
		
		super("Servidor RT");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icono.png"));
		setIconImage(icon);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 585);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(32, 118, 926, 419);
		add(textArea);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Servidor.class.getResource("/imagenes/Uttec.jpg")));
		lblNewLabel.setBounds(32, 11, 320, 101);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Servidor.class.getResource("/imagenes/logo.png")));
		lblNewLabel_1.setBounds(790, 11, 159, 101);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblServidorRt = new JLabel("Servidor RT");
		lblServidorRt.setFont(new Font("Arial", Font.BOLD, 26));
		lblServidorRt.setBounds(495, 22, 182, 78);
		contentPane.add(lblServidorRt);
	}
	
	public void setTextArea(String mensaje) {
		this.textArea.append(mensaje);
	}
}
