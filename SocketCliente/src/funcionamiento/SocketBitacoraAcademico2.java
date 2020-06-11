package funcionamiento;
/**
 * Clase que muestra los valores de la bitacora en la interfaz de AsesorAcademico
 * @see SocketBitacoraAcademico
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketBitacoraAcademico2 {
	private Socket cliente;
	private ObjectInputStream mensajeEntrada;
	private ObjectOutputStream mensajeSalida;
	private int filaSeleccionada;
	private String matricula;
	private Object objeto;
	private List listaNoSemanaAvancesAlumno;
	private List listaAvancesAlumno;
	private List listaNoSemanaIndustrial;
	private List listaObservacionIndustrial;
	private List listaNoParcialIndustrial;
	private List listaEvaluacionSerIndustrial1;
	private List listaEvaluacionSaberIndustrial1;
	private List listaEvaluacionHacerIndustrial1;
	private List listaEvaluacionSerIndustrial2;
	private List listaEvaluacionSaberIndustrial2;
	private List listaEvaluacionHacerIndustrial2;
	private List listaEvaluacionSerIndustrial3;
	private List listaEvaluacionSaberIndustrial3;
	private List listaEvaluacionHacerIndustrial3;
	private List listaNoSemanaAcademico;
	private List listaObservacionAcademico;
	private List listaNoParcialAcademico;
	private List listaEvaluacionSerAcademico1;
	private List listaEvaluacionSaberAcademico1;
	private List listaEvaluacionHacerAcademico1;
	private List listaEvaluacionSerAcademico2;
	private List listaEvaluacionSaberAcademico2;
	private List listaEvaluacionHacerAcademico2;
	private List listaEvaluacionSerAcademico3;
	private List listaEvaluacionSaberAcademico3;
	private List listaEvaluacionHacerAcademico3;
	
	public SocketBitacoraAcademico2() {
		this.listaNoSemanaAvancesAlumno = new List();
		this.listaAvancesAlumno = new List();
		this.listaNoSemanaIndustrial = new List();
		this.listaObservacionIndustrial = new List();
		this.listaNoParcialIndustrial = new List();
		this.listaEvaluacionSerIndustrial1 = new List();
		this.listaEvaluacionSaberIndustrial1 = new List();
		this.listaEvaluacionHacerIndustrial1 = new List();
		this.listaEvaluacionSerIndustrial2 = new List();
		this.listaEvaluacionSaberIndustrial2 = new List();
		this.listaEvaluacionHacerIndustrial2 = new List();
		this.listaEvaluacionSerIndustrial3 = new List();
		this.listaEvaluacionSaberIndustrial3 = new List();
		this.listaEvaluacionHacerIndustrial3 = new List();
		this.listaNoSemanaAcademico = new List();
		this.listaObservacionAcademico = new List();
		this.listaNoParcialAcademico = new List();
		this.listaEvaluacionSerAcademico1 = new List();
		this.listaEvaluacionSaberAcademico1 = new List();
		this.listaEvaluacionHacerAcademico1 = new List();
		this.listaEvaluacionSerAcademico2 = new List();
		this.listaEvaluacionSaberAcademico2 = new List();
		this.listaEvaluacionHacerAcademico2 = new List();
		this.listaEvaluacionSerAcademico3 = new List();
		this.listaEvaluacionSaberAcademico3 = new List();
		this.listaEvaluacionHacerAcademico3 = new List();
		this.mostrarBitacora();
		
		try {
			if (this.cliente != null) {
				this.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}
	/**
	 * Metodo que al iniciar limpia las cajas de texto de la bitacora, se conecta 
	 * al servidor por medio del puerto 5024, recibe toda la información de la bitacora,
	 * y la muestra en la vista(BitacoraAcademico)
	 */
	private void mostrarBitacora() {
		SocketBitacoraAcademico.vistaBitacoraAcademico.getTableMostrarAlumnoAca().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaAvancesAlum().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaObservacionesAca().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaObservacionesIndu().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSer1().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberAca1().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerAca1().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerAca2().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberAca2().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerAca2().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerAca3().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberAca3().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerAca3().setText("");

					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerIndu1().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberIndu1().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerIndu1().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerIndu2().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberIndu2().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerIndu2().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerIndu3().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberIndu3().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerIndu3().setText("");
					
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextEvaluacionAca1().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextEvaluacionAca2().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextEvaluacionAca3().setText("");
					
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextEvaluacionIndu1().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextEvalucionIndu2().setText("");
					SocketBitacoraAcademico.vistaBitacoraAcademico.getTextEvaluacionIndu3().setText("");

					cliente = new Socket("localhost", 5024);
					mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());
					filaSeleccionada = SocketBitacoraAcademico.vistaBitacoraAcademico.getTableMostrarAlumnoAca().getSelectedRow();
					matricula = (String) SocketBitacoraAcademico.vistaBitacoraAcademico.getTableMostrarAlumnoAca().getValueAt(filaSeleccionada, 0);
					mensajeSalida.writeObject(matricula);

					mensajeEntrada = new ObjectInputStream(cliente.getInputStream());
					objeto = mensajeEntrada.readObject();
					//Patrón de diseño MARKER INTERFACE
					if (objeto instanceof List) {
						listaNoSemanaAvancesAlumno = (List) objeto;
						listaAvancesAlumno = (List) mensajeEntrada.readObject();
						
						for (int i = 0; i < listaNoSemanaAvancesAlumno.getItemCount(); i++) {
							SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaAvancesAlum().append("Semana: " + listaNoSemanaAvancesAlumno.getItem(i) + "\n");
							SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaAvancesAlum().append("Avance: " + listaAvancesAlumno.getItem(i) + "\n");
						}
						
						listaNoParcialAcademico = (List) mensajeEntrada.readObject();
						listaEvaluacionSerAcademico1 = (List) mensajeEntrada.readObject();
						listaEvaluacionSaberAcademico1 = (List) mensajeEntrada.readObject();
						listaEvaluacionHacerAcademico1 = (List) mensajeEntrada.readObject();
						listaEvaluacionSerAcademico2 = (List) mensajeEntrada.readObject();
						listaEvaluacionSaberAcademico2 = (List) mensajeEntrada.readObject();
						listaEvaluacionHacerAcademico2 = (List) mensajeEntrada.readObject();
						listaEvaluacionSerAcademico3 = (List) mensajeEntrada.readObject();
						listaEvaluacionSaberAcademico3 = (List) mensajeEntrada.readObject();
						listaEvaluacionHacerAcademico3 = (List) mensajeEntrada.readObject();
						
						listaNoParcialIndustrial = (List) mensajeEntrada.readObject();
						listaEvaluacionSerIndustrial1 = (List) mensajeEntrada.readObject();
						listaEvaluacionSaberIndustrial1 = (List) mensajeEntrada.readObject();
						listaEvaluacionHacerIndustrial1 = (List) mensajeEntrada.readObject();
						
						listaEvaluacionSerIndustrial2 = (List) mensajeEntrada.readObject();
						listaEvaluacionSaberIndustrial2 = (List) mensajeEntrada.readObject();
						listaEvaluacionHacerIndustrial2 = (List) mensajeEntrada.readObject();
						
						listaEvaluacionSerIndustrial3 = (List) mensajeEntrada.readObject();
						listaEvaluacionSaberIndustrial3 = (List) mensajeEntrada.readObject();
						listaEvaluacionHacerIndustrial3 = (List) mensajeEntrada.readObject();
						
						for (int i = 0; i < listaNoParcialAcademico.getItemCount(); i++) {
							if (listaNoParcialAcademico.getItem(i).equals("1")) {
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSer1().setText(listaEvaluacionSerAcademico1.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberAca1().setText(listaEvaluacionSaberAcademico1.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerAca1().setText(listaEvaluacionHacerAcademico1.getItem(0));
							}else if (listaNoParcialAcademico.getItem(i).equals("2")) {
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerAca2().setText(listaEvaluacionSerAcademico2.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberAca2().setText(listaEvaluacionSaberAcademico2.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerAca2().setText(listaEvaluacionHacerAcademico2.getItem(0));
							}else if (listaNoParcialAcademico.getItem(i).equals("3")) {
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerAca3().setText(listaEvaluacionSerAcademico3.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberAca3().setText(listaEvaluacionSaberAcademico3.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerAca3().setText(listaEvaluacionHacerAcademico3.getItem(0));
							}
						}

						for (int i = 0; i < listaNoParcialIndustrial.getItemCount(); i++) {
							if (listaNoParcialIndustrial.getItem(i).equals("1")) {
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerIndu1().setText(listaEvaluacionSerIndustrial1.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberIndu1().setText(listaEvaluacionSaberIndustrial1.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerIndu1().setText(listaEvaluacionHacerIndustrial1.getItem(0));
							}else if (listaNoParcialIndustrial.getItem(i).equals("2")) {
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerIndu2().setText(listaEvaluacionSerIndustrial2.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberIndu2().setText(listaEvaluacionSaberIndustrial2.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerIndu2().setText(listaEvaluacionHacerIndustrial2.getItem(0));
							}else if (listaNoParcialIndustrial.getItem(i).equals("3")) {
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSerIndu3().setText(listaEvaluacionSerIndustrial3.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextSaberIndu3().setText(listaEvaluacionSaberIndustrial3.getItem(0));
								SocketBitacoraAcademico.vistaBitacoraAcademico.getTextHacerIndu3().setText(listaEvaluacionHacerIndustrial3.getItem(0));
							}
						}
						
						listaObservacionAcademico = (List) mensajeEntrada.readObject();
						listaNoSemanaAcademico = (List) mensajeEntrada.readObject();
						for (int i = 0; i < listaNoSemanaAcademico.getItemCount(); i++) {
							SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaObservacionesAca().append("Semana: " + listaNoSemanaAcademico.getItem(i) + "\n");
							SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaObservacionesAca().append("Avance: " + listaObservacionAcademico.getItem(i) + "\n");
						}
						listaObservacionIndustrial = (List) mensajeEntrada.readObject();
						listaNoSemanaIndustrial = (List) mensajeEntrada.readObject();
						for (int i = 0; i < listaNoSemanaIndustrial.getItemCount(); i++) {
							SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaObservacionesIndu().append("Semana: " + listaNoSemanaIndustrial.getItem(i) + "\n");
							SocketBitacoraAcademico.vistaBitacoraAcademico.getTextAreaObservacionesIndu().append("Avance: " + listaObservacionIndustrial.getItem(i) + "\n");
						}
						
						SocketBitacoraAcademico.vistaBitacoraAcademico.evaluacionIntermediaAca1();
						SocketBitacoraAcademico.vistaBitacoraAcademico.evaluacionIntermediaAca2();
						SocketBitacoraAcademico.vistaBitacoraAcademico.evaluacionIntermediaAca3();
						SocketBitacoraAcademico.vistaBitacoraAcademico.evaluacionIntermediaInd1();
						SocketBitacoraAcademico.vistaBitacoraAcademico.evaluacionIntermediaInd2();
						SocketBitacoraAcademico.vistaBitacoraAcademico.evaluacionIntermediaInd3();
						
						SocketBitacoraAcademico.vistaBitacoraAcademico.promedioAcademico();
						SocketBitacoraAcademico.vistaBitacoraAcademico.promedioIndustrial();
						SocketBitacoraAcademico.vistaBitacoraAcademico.calificacionFinal();
					}

				} catch (IOException | ClassNotFoundException e1) {
					System.err.println("Error en el SocketBitacoraAcademico2: " + e1.getMessage());
				}
			}
		});
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
	public ObjectOutputStream getMensajeSalida() {
		return mensajeSalida;
	}
	public void setMensajeSalida(ObjectOutputStream mensajeSalida) {
		this.mensajeSalida = mensajeSalida;
	}
	public int getFilaSeleccionada() {
		return filaSeleccionada;
	}
	public void setFilaSeleccionada(int filaSeleccionada) {
		this.filaSeleccionada = filaSeleccionada;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Object getObjeto() {
		return objeto;
	}
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
	

}
