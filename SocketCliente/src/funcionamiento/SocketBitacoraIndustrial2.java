package funcionamiento;

import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketBitacoraIndustrial2 {
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
	
	public SocketBitacoraIndustrial2() {
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

	private void mostrarBitacora() {
		SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTableMostrarAlumnoIndu().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaAvancesAlum().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaObservacionesAca().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaObservacionesIndu().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSer1().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberAca1().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerAca1().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerAca2().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberAca2().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerAca2().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerAca3().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberAca3().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerAca3().setText("");

					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerIndu1().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberIndu1().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerIndu1().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerIndu2().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberIndu2().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerIndu2().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerIndu3().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberIndu3().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerIndu3().setText("");

					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextEvaluacionAca1().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextEvaluacionAca2().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextEvaluacionAca3().setText("");
					
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextEvaluacionIndu1().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextEvalucionIndu2().setText("");
					SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextEvaluacionIndu3().setText("");
					
					cliente = new Socket("localhost", 5022);
					mensajeSalida = new ObjectOutputStream(cliente.getOutputStream());
					filaSeleccionada = SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTableMostrarAlumnoIndu().getSelectedRow();
					matricula = (String) SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTableMostrarAlumnoIndu().getValueAt(filaSeleccionada, 0);
					mensajeSalida.writeObject(matricula);

					mensajeEntrada = new ObjectInputStream(cliente.getInputStream());
					objeto = mensajeEntrada.readObject();
					// MARKER INTERFACE
					if (objeto instanceof List) {
						listaNoSemanaAvancesAlumno = (List) objeto;
						listaAvancesAlumno = (List) mensajeEntrada.readObject();
						
						for (int i = 0; i < listaNoSemanaAvancesAlumno.getItemCount(); i++) {
							SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaAvancesAlum().append("Semana: " + listaNoSemanaAvancesAlumno.getItem(i) + "\n");
							SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaAvancesAlum().append("Avance: " + listaAvancesAlumno.getItem(i) + "\n");
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
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSer1().setText(listaEvaluacionSerAcademico1.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberAca1().setText(listaEvaluacionSaberAcademico1.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerAca1().setText(listaEvaluacionHacerAcademico1.getItem(0));
							}else if (listaNoParcialAcademico.getItem(i).equals("2")) {
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerAca2().setText(listaEvaluacionSerAcademico2.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberAca2().setText(listaEvaluacionSaberAcademico2.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerAca2().setText(listaEvaluacionHacerAcademico2.getItem(0));
							}else if (listaNoParcialAcademico.getItem(i).equals("3")) {
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerAca3().setText(listaEvaluacionSerAcademico3.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberAca3().setText(listaEvaluacionSaberAcademico3.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerAca3().setText(listaEvaluacionHacerAcademico3.getItem(0));
							}
						}

						for (int i = 0; i < listaNoParcialIndustrial.getItemCount(); i++) {
							if (listaNoParcialIndustrial.getItem(i).equals("1")) {
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerIndu1().setText(listaEvaluacionSerIndustrial1.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberIndu1().setText(listaEvaluacionSaberIndustrial1.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerIndu1().setText(listaEvaluacionHacerIndustrial1.getItem(0));
							}else if (listaNoParcialIndustrial.getItem(i).equals("2")) {
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerIndu2().setText(listaEvaluacionSerIndustrial2.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberIndu2().setText(listaEvaluacionSaberIndustrial2.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerIndu2().setText(listaEvaluacionHacerIndustrial2.getItem(0));
							}else if (listaNoParcialIndustrial.getItem(i).equals("3")) {
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSerIndu3().setText(listaEvaluacionSerIndustrial3.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextSaberIndu3().setText(listaEvaluacionSaberIndustrial3.getItem(0));
								SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextHacerIndu3().setText(listaEvaluacionHacerIndustrial3.getItem(0));
							}
						}
						
						listaObservacionAcademico = (List) mensajeEntrada.readObject();
						listaNoSemanaAcademico = (List) mensajeEntrada.readObject();
						for (int i = 0; i < listaNoSemanaAcademico.getItemCount(); i++) {
							SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaObservacionesAca().append("Semana: " + listaNoSemanaAcademico.getItem(i) + "\n");
							SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaObservacionesAca().append("Avance: " + listaObservacionAcademico.getItem(i) + "\n");
						}
						listaObservacionIndustrial = (List) mensajeEntrada.readObject();
						listaNoSemanaIndustrial = (List) mensajeEntrada.readObject();
						for (int i = 0; i < listaNoSemanaIndustrial.getItemCount(); i++) {
							SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaObservacionesIndu().append("Semana: " + listaNoSemanaIndustrial.getItem(i) + "\n");
							SocketBitacoraIndustrial.vistaBitacoraIndustrial.getTextAreaObservacionesIndu().append("Avance: " + listaObservacionIndustrial.getItem(i) + "\n");
						}
						
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.evaluacionIntermediaAca1();
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.evaluacionIntermediaAca2();
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.evaluacionIntermediaAca3();
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.evaluacionIntermediaInd1();
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.evaluacionIntermediaInd2();
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.evaluacionIntermediaInd3();
						
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.promedioAcademico();
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.promedioIndustrial();
						SocketBitacoraIndustrial.vistaBitacoraIndustrial.calificacionFinal();
					}

				} catch (IOException | ClassNotFoundException e1) {
					System.err.println("Error en el SocketBitacoraIndustrial2: " + e1.getMessage());
				}
			}
		});
	}

}
