package funcionamiento;

import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionPost;
import main.Main;

public class SocketServidorBitacoraIndustrial2 implements Runnable {
	ServerSocket servidor;
	Socket cliente;
	ObjectOutputStream mensajeSalida;
	ObjectInputStream mensajeEntrada;
	ConexionPost conex;
	ResultSet observacionAcademico;
	ResultSet evaluacionAcademico;
	ResultSet evaluacionIndustrial;
	ResultSet observacionIndustrial;
	ResultSet avancesAlumno;
	List listaNoSemanaAvancesAlumno;
	List listaAvancesAlumno;
	List listaNoSemanaIndustrial;
	List listaObservacionIndustrial;
	List listaNoParcialIndustrial;
	List listaEvaluacionSerIndustrial1;
	List listaEvaluacionSaberIndustrial1;
	List listaEvaluacionHacerIndustrial1;
	List listaEvaluacionSerIndustrial2;
	List listaEvaluacionSaberIndustrial2;
	List listaEvaluacionHacerIndustrial2;
	List listaEvaluacionSerIndustrial3;
	List listaEvaluacionSaberIndustrial3;
	List listaEvaluacionHacerIndustrial3;
	List listaNoSemanaAcademico;
	List listaObservacionAcademico;
	List listaNoParcialAcademico;
	List listaEvaluacionSerAcademico1;
	List listaEvaluacionSaberAcademico1;
	List listaEvaluacionHacerAcademico1;
	List listaEvaluacionSerAcademico2;
	List listaEvaluacionSaberAcademico2;
	List listaEvaluacionHacerAcademico2;
	List listaEvaluacionSerAcademico3;
	List listaEvaluacionSaberAcademico3;
	List listaEvaluacionHacerAcademico3;
	Thread hilo;
	String matriculaAlumno;

	public SocketServidorBitacoraIndustrial2() {
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
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	@Override
	public void run() {
		try {

			this.servidor = new ServerSocket(5024, 50);

			while (true) {
				this.cliente = this.servidor.accept();
				this.conex = ConexionPost.getInstance();
				this.consultarBitacora();
				this.cliente.close();
			}
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBitacoraIndustrial2 ClassNot: " + e.getMessage() + "\n");
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBitacoraIndustrial2 IOException: " + e.getMessage() + "\n");
		}
	}

	private void consultarBitacora() {
		try {
			this.mensajeEntrada = new ObjectInputStream(this.cliente.getInputStream());
			this.matriculaAlumno = (String) this.mensajeEntrada.readObject();
			this.avancesAlumno = conex.consultar("select * from avancesalumno where matriculaalumno = " + this.matriculaAlumno);
			this.evaluacionAcademico = conex.consultar("select * from evaluacionaca where matriculaalumno = " + this.matriculaAlumno);
			this.evaluacionIndustrial = conex.consultar("select * from evaluacionind where matriculaalumno = " + this.matriculaAlumno);
			this.observacionAcademico = conex.consultar("select * from observacionesaca where matriculaalumno = " + this.matriculaAlumno);
			this.observacionIndustrial = conex.consultar("select * from observacionesind where matriculaalumno = " + this.matriculaAlumno);
			this.mensajeSalida = new ObjectOutputStream(this.cliente.getOutputStream());
			
			while (this.avancesAlumno.next()) {
				this.listaNoSemanaAvancesAlumno.add(this.avancesAlumno.getString("nosemana"));
				this.listaAvancesAlumno.add(this.avancesAlumno.getString("avance"));
			}
			this.mensajeSalida.writeObject(this.listaNoSemanaAvancesAlumno);
			this.mensajeSalida.writeObject(this.listaAvancesAlumno);
			this.listaNoSemanaAvancesAlumno.removeAll();
			this.listaAvancesAlumno.removeAll();

			while(this.evaluacionAcademico.next()) {
				this.listaNoParcialAcademico.add(this.evaluacionAcademico.getString("parcial"));
				for (int i = 0; i < this.listaNoParcialAcademico.getItemCount(); i++) {
					if (this.listaNoParcialAcademico.getItem(i).equals("1")) {
						this.listaEvaluacionSerAcademico1.add(this.evaluacionAcademico.getString("ser"));
						this.listaEvaluacionSaberAcademico1.add(this.evaluacionAcademico.getString("saber"));
						this.listaEvaluacionHacerAcademico1.add(this.evaluacionAcademico.getString("hacer"));
					}else if (this.listaNoParcialAcademico.getItem(i).equals("2")) {
						this.listaEvaluacionSerAcademico2.add(this.evaluacionAcademico.getString("ser"));
						this.listaEvaluacionSaberAcademico2.add(this.evaluacionAcademico.getString("saber"));
						this.listaEvaluacionHacerAcademico2.add(this.evaluacionAcademico.getString("hacer"));
					}else if (this.listaNoParcialAcademico.getItem(i).equals("3")) {
						this.listaEvaluacionSerAcademico3.add(this.evaluacionAcademico.getString("ser"));
						this.listaEvaluacionSaberAcademico3.add(this.evaluacionAcademico.getString("saber"));
						this.listaEvaluacionHacerAcademico3.add(this.evaluacionAcademico.getString("hacer"));
					}
				}
			}
			this.mensajeSalida.writeObject(this.listaNoParcialAcademico);
			this.mensajeSalida.writeObject(this.listaEvaluacionSerAcademico1);
			this.mensajeSalida.writeObject(this.listaEvaluacionSaberAcademico1);
			this.mensajeSalida.writeObject(this.listaEvaluacionHacerAcademico1);
			this.mensajeSalida.writeObject(this.listaEvaluacionSerAcademico2);
			this.mensajeSalida.writeObject(this.listaEvaluacionSaberAcademico2);
			this.mensajeSalida.writeObject(this.listaEvaluacionHacerAcademico2);
			this.mensajeSalida.writeObject(this.listaEvaluacionSerAcademico3);
			this.mensajeSalida.writeObject(this.listaEvaluacionSaberAcademico3);
			this.mensajeSalida.writeObject(this.listaEvaluacionHacerAcademico3);
			this.listaNoParcialAcademico.removeAll();
			this.listaEvaluacionSerAcademico1.removeAll();
			this.listaEvaluacionSaberAcademico1.removeAll();
			this.listaEvaluacionHacerAcademico1.removeAll();
			this.listaEvaluacionSerAcademico2.removeAll();
			this.listaEvaluacionSaberAcademico2.removeAll();
			this.listaEvaluacionHacerAcademico2.removeAll();
			this.listaEvaluacionSerAcademico3.removeAll();
			this.listaEvaluacionSaberAcademico3.removeAll();
			this.listaEvaluacionHacerAcademico3.removeAll();
			
			while(this.evaluacionIndustrial.next()) {
				this.listaNoParcialIndustrial.add(this.evaluacionIndustrial.getString("parcial"));
				for (int i = 0; i < this.listaNoParcialIndustrial.getItemCount(); i++) {
					if (this.listaNoParcialIndustrial.getItem(i).equals("1")) {
						this.listaEvaluacionSerIndustrial1.add(this.evaluacionIndustrial.getString("ser"));
						this.listaEvaluacionSaberIndustrial1.add(this.evaluacionIndustrial.getString("saber"));
						this.listaEvaluacionHacerIndustrial1.add(this.evaluacionIndustrial.getString("hacer"));
					}else if (this.listaNoParcialIndustrial.getItem(i).equals("2")) {
						this.listaEvaluacionSerIndustrial2.add(this.evaluacionIndustrial.getString("ser"));
						this.listaEvaluacionSaberIndustrial2.add(this.evaluacionIndustrial.getString("saber"));
						this.listaEvaluacionHacerIndustrial2.add(this.evaluacionIndustrial.getString("hacer"));
					}else if (this.listaNoParcialIndustrial.getItem(i).equals("3")) {
						this.listaEvaluacionSerIndustrial3.add(this.evaluacionIndustrial.getString("ser"));
						this.listaEvaluacionSaberIndustrial3.add(this.evaluacionIndustrial.getString("saber"));
						this.listaEvaluacionHacerIndustrial3.add(this.evaluacionIndustrial.getString("hacer"));
					}
				}
			}
			this.mensajeSalida.writeObject(this.listaNoParcialIndustrial);
			this.mensajeSalida.writeObject(this.listaEvaluacionSerIndustrial1);
			this.mensajeSalida.writeObject(this.listaEvaluacionSaberIndustrial1);
			this.mensajeSalida.writeObject(this.listaEvaluacionHacerIndustrial1);
			
			this.mensajeSalida.writeObject(this.listaEvaluacionSerIndustrial2);
			this.mensajeSalida.writeObject(this.listaEvaluacionSaberIndustrial2);
			this.mensajeSalida.writeObject(this.listaEvaluacionHacerIndustrial2);
			
			this.mensajeSalida.writeObject(this.listaEvaluacionSerIndustrial3);
			this.mensajeSalida.writeObject(this.listaEvaluacionSaberIndustrial3);
			this.mensajeSalida.writeObject(this.listaEvaluacionHacerIndustrial3);
			this.listaNoParcialIndustrial.removeAll();
			this.listaEvaluacionSerIndustrial1.removeAll();
			this.listaEvaluacionSaberIndustrial1.removeAll();
			this.listaEvaluacionHacerIndustrial1.removeAll();
			this.listaEvaluacionSerIndustrial2.removeAll();
			this.listaEvaluacionSaberIndustrial2.removeAll();
			this.listaEvaluacionHacerIndustrial2.removeAll();
			this.listaEvaluacionSerIndustrial3.removeAll();
			this.listaEvaluacionSaberIndustrial3.removeAll();
			this.listaEvaluacionHacerIndustrial3.removeAll();
			
			while(this.observacionAcademico.next()) {
				this.listaObservacionAcademico.add(this.observacionAcademico.getString("observacionaca"));
				this.listaNoSemanaAcademico.add(this.observacionAcademico.getString("noSemana"));
			}
			this.mensajeSalida.writeObject(this.listaObservacionAcademico);
			this.mensajeSalida.writeObject(this.listaNoSemanaAcademico);
			this.listaObservacionAcademico.removeAll();
			this.listaNoSemanaAcademico.removeAll();
			
			while(this.observacionIndustrial.next()) {
				this.listaObservacionIndustrial.add(this.observacionIndustrial.getString("observacionind"));
				this.listaNoSemanaIndustrial.add(this.observacionIndustrial.getString("noSemana"));
			}
			this.mensajeSalida.writeObject(this.listaObservacionIndustrial);
			this.mensajeSalida.writeObject(this.listaNoSemanaIndustrial);
			this.listaObservacionIndustrial.removeAll();
			this.listaNoSemanaIndustrial.removeAll();
			
			this.cliente.close();
		} catch (SQLException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBitacoraIndustrial2 SQLException: " + e.getMessage() + "\n");
		} catch (IOException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBitacoraIndustrial2: " + e.getMessage() + "\n");
		} catch (ClassNotFoundException e) {
			Main.vistaServer.setTextArea("Error en SocketServidorBitacoraIndustrial2: " + e.getMessage() + "\n");
		}
	}
}
