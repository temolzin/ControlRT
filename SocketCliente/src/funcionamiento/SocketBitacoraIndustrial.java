package funcionamiento;
/**
 * Clase que muestra a los alumnos que asesora el Asesor Industrial.
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
import vista.BitacoraIndustrial;

public class SocketBitacoraIndustrial {
	public static BitacoraIndustrial vistaBitacoraIndustrial;
	private SocketBitacoraIndustrial2 mostrarBitacora;
	private Socket cliente;
	private ObjectInputStream mensajeEntrada;
	private DefaultTableModel modelo;
	
	public SocketBitacoraIndustrial() {
		SocketBitacoraIndustrial.vistaBitacoraIndustrial = new BitacoraIndustrial();
		SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextBuscarAlumnoIndu().setEditable(false);
		SocketBitacoraIndustrial.vistaBitacoraIndustrial.setVisible(true);
		this.mostrarBitacora = new SocketBitacoraIndustrial2();
		this.consultarAlumno();
		this.buscarAlumnoaporNombre();
		this.mensajeEntrada = null;
		this.modelo = null;
		try {
			if (this.cliente != null) {
				this.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}

	public SocketBitacoraIndustrial2 getMostrarBitacora() {
		return mostrarBitacora;
	}

	public void setMostrarBitacora(SocketBitacoraIndustrial2 mostrarBitacora) {
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
	 * Método que se conecta al servidor por medio del socket con puerto 5023 para
	 * recuperar los datos del alumno y mostrarlos en la tabla de la clase BitacoraIndustrial.
	 */
	private void consultarAlumno() {
		SocketBitacoraIndustrial.vistaBitacoraIndustrial.btnBuscarAlumnoIndu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente = new Socket("localhost", 5023);
					mensajeEntrada = new ObjectInputStream(cliente.getInputStream());

					modelo = (DefaultTableModel) mensajeEntrada.readObject();

					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTableMostrarAlumnoIndu().setModel(modelo);
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextBuscarAlumnoIndu().setEditable(true);
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.btnBuscarAlumnoIndu.setEnabled(false);
				} catch (IOException e1) {
					System.err.println("Error en el SocketBitacoraIndustrial: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					System.err.println("Error en el SocketBitacoraIndustrial: " + e1.getMessage());
				}
			}
		});
	}

	/**
	 * Metodo que busca registros en la tabla de la clase BitacoraIndustrial.
	 */
	private void buscarAlumnoaporNombre() {
		SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextBuscarAlumnoIndu().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				TableRowSorter<TableModel> trsFiltro = new TableRowSorter<TableModel>(modelo);
				SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTableMostrarAlumnoIndu().setRowSorter(trsFiltro);
				trsFiltro.setRowFilter(
						RowFilter.regexFilter(SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextBuscarAlumnoIndu().getText(), 1));

			}
		});
	}
}
