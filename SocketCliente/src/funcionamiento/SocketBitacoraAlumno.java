package funcionamiento;

import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import vista.Bitacora;

public class SocketBitacoraAlumno {

	private Bitacora vistaBitacora;
	private Socket cliente;
	private ObjectInputStream mensajeEntrada;
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

	public SocketBitacoraAlumno() {

		this.vistaBitacora = new Bitacora();
		this.vistaBitacora.setVisible(true);
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
		this.consultarBitacora();

		try {
			if (this.cliente != null) {
				this.cliente.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el socket: " + e.getMessage());
		}
	}

	private void consultarBitacora() {

		try {
			this.cliente = new Socket("localhost", 5020);
			this.mensajeEntrada = new ObjectInputStream(cliente.getInputStream());

			this.objeto = this.mensajeEntrada.readObject();
			// MARKER INTERFACE
			if (this.objeto instanceof List) {
				this.listaNoSemanaAvancesAlumno = (List) this.objeto;
				this.listaAvancesAlumno = (List) this.mensajeEntrada.readObject();
				
				for (int i = 0; i < this.listaNoSemanaAvancesAlumno.getItemCount(); i++) {
					this.vistaBitacora.getTextAreaAvancesAlum().append("Semana: " + this.listaNoSemanaAvancesAlumno.getItem(i) + "\n");
					this.vistaBitacora.getTextAreaAvancesAlum().append("Avance: " + this.listaAvancesAlumno.getItem(i) + "\n");
				}
				
				this.listaNoParcialAcademico = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSerAcademico1 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSaberAcademico1 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionHacerAcademico1 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSerAcademico2 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSaberAcademico2 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionHacerAcademico2 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSerAcademico3 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSaberAcademico3 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionHacerAcademico3 = (List) this.mensajeEntrada.readObject();
				
				this.listaNoParcialIndustrial = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSerIndustrial1 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSaberIndustrial1 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionHacerIndustrial1 = (List) this.mensajeEntrada.readObject();
				
				this.listaEvaluacionSerIndustrial2 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSaberIndustrial2 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionHacerIndustrial2 = (List) this.mensajeEntrada.readObject();
				
				this.listaEvaluacionSerIndustrial3 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionSaberIndustrial3 = (List) this.mensajeEntrada.readObject();
				this.listaEvaluacionHacerIndustrial3 = (List) this.mensajeEntrada.readObject();
				
				for (int i = 0; i < this.listaNoParcialAcademico.getItemCount(); i++) {
					if (this.listaNoParcialAcademico.getItem(i).equals("1")) {
						this.vistaBitacora.getTextSerAca1().setText(this.listaEvaluacionSerAcademico1.getItem(0));
						this.vistaBitacora.getTextSaberAca1().setText(this.listaEvaluacionSaberAcademico1.getItem(0));
						this.vistaBitacora.getTextHacerAca1().setText(this.listaEvaluacionHacerAcademico1.getItem(0));
					}else if (this.listaNoParcialAcademico.getItem(i).equals("2")) {
						this.vistaBitacora.getTextSerAca2().setText(this.listaEvaluacionSerAcademico2.getItem(0));
						this.vistaBitacora.getTextSaberAca2().setText(this.listaEvaluacionSaberAcademico2.getItem(0));
						this.vistaBitacora.getTextHacerAca2().setText(this.listaEvaluacionHacerAcademico2.getItem(0));
					}else if (this.listaNoParcialAcademico.getItem(i).equals("3")) {
						this.vistaBitacora.getTextSerAca3().setText(this.listaEvaluacionSerAcademico3.getItem(0));
						this.vistaBitacora.getTextSaberAca3().setText(this.listaEvaluacionSaberAcademico3.getItem(0));
						this.vistaBitacora.getTextHacerAca3().setText(this.listaEvaluacionHacerAcademico3.getItem(0));
					}
				}

				for (int i = 0; i < this.listaNoParcialIndustrial.getItemCount(); i++) {
					if (this.listaNoParcialIndustrial.getItem(i).equals("1")) {
						this.vistaBitacora.getTextSerIndu1().setText(this.listaEvaluacionSerIndustrial1.getItem(0));
						this.vistaBitacora.getTextSaberIndu1().setText(this.listaEvaluacionSaberIndustrial1.getItem(0));
						this.vistaBitacora.getTextHacerIndu1().setText(this.listaEvaluacionHacerIndustrial1.getItem(0));
					}else if (this.listaNoParcialIndustrial.getItem(i).equals("2")) {
						this.vistaBitacora.getTextSerIndu2().setText(this.listaEvaluacionSerIndustrial2.getItem(0));
						this.vistaBitacora.getTextSaberIndu2().setText(this.listaEvaluacionSaberIndustrial2.getItem(0));
						this.vistaBitacora.getTextHacerIndu2().setText(this.listaEvaluacionHacerIndustrial2.getItem(0));
					}else if (this.listaNoParcialIndustrial.getItem(i).equals("3")) {
						this.vistaBitacora.getTextSerIndu3().setText(this.listaEvaluacionSerIndustrial3.getItem(0));
						this.vistaBitacora.getTextSaberIndu3().setText(this.listaEvaluacionSaberIndustrial3.getItem(0));
						this.vistaBitacora.getTextHacerIndu3().setText(this.listaEvaluacionHacerIndustrial3.getItem(0));
					}
				}
				
				this.listaObservacionAcademico = (List) this.mensajeEntrada.readObject();
				this.listaNoSemanaAcademico = (List) this.mensajeEntrada.readObject();
				for (int i = 0; i < this.listaNoSemanaAcademico.getItemCount(); i++) {
					this.vistaBitacora.getTextAreaObservacionesAca().append("Semana: " + this.listaNoSemanaAcademico.getItem(i) + "\n");
					this.vistaBitacora.getTextAreaObservacionesAca().append("Avance: " + this.listaObservacionAcademico.getItem(i) + "\n");
				}
				this.listaObservacionIndustrial = (List) this.mensajeEntrada.readObject();
				this.listaNoSemanaIndustrial = (List) this.mensajeEntrada.readObject();
				for (int i = 0; i < this.listaNoSemanaIndustrial.getItemCount(); i++) {
					this.vistaBitacora.getTextAreaObservacionesIndu().append("Semana: " + this.listaNoSemanaIndustrial.getItem(i) + "\n");
					this.vistaBitacora.getTextAreaObservacionesIndu().append("Avance: " + this.listaObservacionIndustrial.getItem(i) + "\n");
				}
				this.vistaBitacora.evaluacionIntermediaAca1();
				this.vistaBitacora.evaluacionIntermediaAca2();
				this.vistaBitacora.evaluacionIntermediaAca3();
				this.vistaBitacora.evaluacionIntermediaInd1();
				this.vistaBitacora.evaluacionIntermediaInd2();
				this.vistaBitacora.evaluacionIntermediaInd3();
				
				this.vistaBitacora.promedioAcademico();
				this.vistaBitacora.promedioIndustrial();
				this.vistaBitacora.calificacionFinal();
			}

		} catch (IOException e1) {
			System.err.println("Error en el SocketBitacoraAlumno: " + e1.getMessage());
		} catch (ClassNotFoundException e1) {
			System.err.println("Error en el SocketBitacoraAlumno: " + e1.getMessage());
		}
	}
}
