package funcionamiento;
/**
 * Clase que muestra a los alumnos que asesora el Asesor Académico.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import vista.BitacoraAcademico;

public class SocketBitacoraAcademico {
	public static BitacoraAcademico vistaBitacoraAcademico;
	private SocketBitacoraAcademico2 mostrarBitacora;
	private Socket cliente;
	private ObjectInputStream mensajeEntrada;
	private DefaultTableModel modelo;
	
	public SocketBitacoraAcademico() {
		SocketBitacoraAcademico.vistaBitacoraAcademico = new BitacoraAcademico();
		SocketBitacoraAcademico.vistaBitacoraAcademico.getTextBuscarAlumnoAca().setEditable(false);
		SocketBitacoraAcademico.vistaBitacoraAcademico.setVisible(true);
		this.mostrarBitacora = new SocketBitacoraAcademico2();
		this.modelo = null;
		this.mensajeEntrada = null;
		
		this.consultarAlumno();
		this.buscarAlumnoaporNombre();
		
		try {
			if (this.cliente != null) {
				this.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}

	public SocketBitacoraAcademico2 getMostrarBitacora() {
		return mostrarBitacora;
	}

	public void setMostrarBitacora(SocketBitacoraAcademico2 mostrarBitacora) {
		this.mostrarBitacora = mostrarBitacora;
	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}

	public ObjectInputStream getMensajeEntrada() {
		return mensajeEntrada;
	}

	public void setMensajeEntrada(ObjectInputStream mensajeEntrada) {
		this.mensajeEntrada = mensajeEntrada;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	/**
	 * Método que se conecta al servidor por medio del socket con puerto 5021 para
	 * recuperar los datos del alumno y mostrarlos en la tabla de la clase BitacoraAcademico.
	 */
	private void consultarAlumno() {
		SocketBitacoraAcademico.vistaBitacoraAcademico.btnBuscarAlumnoAca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente = new Socket("localhost", 5021);
					mensajeEntrada = new ObjectInputStream(cliente.getInputStream());

					modelo = (DefaultTableModel) mensajeEntrada.readObject();

					SocketBitacoraAcademico.vistaBitacoraAcademico.getTableMostrarAlumnoAca().setModel(modelo);
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextBuscarAlumnoAca().setEditable(true);
					SocketBitacoraAcademico.vistaBitacoraAcademico.btnBuscarAlumnoAca.setEnabled(false);
				} catch (IOException e1) {
					System.err.println("Error en el SocketBitacoraAcademico: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					System.err.println("Error en el SocketBitacoraAcademico: " + e1.getMessage());
				}
			}
		});
	}

	/**
	 * Metodo que busca registros en la tabla de la clase BitacoraAcademico.
	 */
	private void buscarAlumnoaporNombre() {
		SocketBitacoraAcademico.vistaBitacoraAcademico.getTextBuscarAlumnoAca().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				TableRowSorter<TableModel> trsFiltro = new TableRowSorter<TableModel>(modelo);
				SocketBitacoraAcademico.vistaBitacoraAcademico.getTableMostrarAlumnoAca().setRowSorter(trsFiltro);
				trsFiltro.setRowFilter(RowFilter.regexFilter(SocketBitacoraAcademico.vistaBitacoraAcademico.getTextBuscarAlumnoAca().getText(), 1));
			}
		});
	}

}
