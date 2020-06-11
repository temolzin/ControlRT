package main;
/**
 * Clase Main para ejecutar la aplicación Servidor de ControlRT
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import funcionamiento.SocketServidorBitacoraAcademico;
import funcionamiento.SocketServidorBitacoraAcademico2;
import funcionamiento.SocketServidorBitacoraAlumno;
import funcionamiento.SocketServidorBitacoraIndustrial;
import funcionamiento.SocketServidorBitacoraIndustrial2;
import funcionamiento.SocketServidorBuscarActualizarAdministrador;
import funcionamiento.SocketServidorBuscarActualizarAlumno;
import funcionamiento.SocketServidorBuscarActualizarAsesorAca;
import funcionamiento.SocketServidorBuscarActualizarAsesorInd;
import funcionamiento.SocketServidorCambiarContraseña;
import funcionamiento.SocketServidorCargarAsesores;
import funcionamiento.SocketServidorEliminarAdministrador;
import funcionamiento.SocketServidorEliminarAlumno;
import funcionamiento.SocketServidorEliminarAsesorAca;
import funcionamiento.SocketServidorEliminarAsesorInd;
import funcionamiento.SocketServidorInsertarAdministrador;
import funcionamiento.SocketServidorInsertarAlumnos;
import funcionamiento.SocketServidorInsertarAsesorAca;
import funcionamiento.SocketServidorInsertarAsesorInd;
import funcionamiento.SocketServidorInsertarAvancesAlumno;
import funcionamiento.SocketServidorInsertarEvaluaciónAcademico;
import funcionamiento.SocketServidorInsertarEvaluaciónIndustrial;
import funcionamiento.SocketServidorInsertarObservacionesAcademico;
import funcionamiento.SocketServidorInsertarObservacionesIndustrial;
import funcionamiento.SocketServidorLogin;
import funcionamiento.SocketServidorObservacionesAsesorAcaConsultarAlumno;
import funcionamiento.SocketServidorObservacionesAsesorIndConsultarAlumno;
import vista.Servidor;

@SuppressWarnings("unused")
public class Main {
	public static Servidor vistaServer;
	private static SocketServidorLogin server;
	private static SocketServidorInsertarAsesorAca asesorAca;
	private static SocketServidorInsertarAlumnos insertarAlumnos;
	private static SocketServidorInsertarAsesorInd asesorInd;
	private static SocketServidorBuscarActualizarAsesorAca buscarAsesorAca;
	private static SocketServidorInsertarAdministrador insertarAdmin;
	private static SocketServidorEliminarAsesorAca eliminarAsesorAca;
	private static SocketServidorBuscarActualizarAsesorInd buscarAsesorInd;
	private static SocketServidorEliminarAsesorInd eliminarAsesorInd;
	private static SocketServidorEliminarAdministrador eliminarAdmin;
	private static SocketServidorBuscarActualizarAdministrador buscarAdministrador;
	private static SocketServidorCambiarContraseña cambiarPassword;
	private static SocketServidorInsertarAvancesAlumno avancesAlumno;
	private static SocketServidorObservacionesAsesorAcaConsultarAlumno observacionesAsesorAca;
	private static SocketServidorInsertarObservacionesAcademico insertarObservacionesAcademico;
	private static SocketServidorInsertarEvaluaciónAcademico insertarEvaluacionAcademico;
	private static SocketServidorObservacionesAsesorIndConsultarAlumno consultarAlumnoIndustrial;
	private static SocketServidorInsertarObservacionesIndustrial insertarObservacionIndustrial;
	private static SocketServidorInsertarEvaluaciónIndustrial insertarEvaluacionIndustrial;
	private static SocketServidorBitacoraAlumno bitacoraAlumno;
	private static SocketServidorBitacoraAcademico bitacoraAcademico;
	private static SocketServidorBitacoraAcademico2 bitacoraAcademico2;
	private static SocketServidorBitacoraIndustrial bitacoraIndustrial;
	private static SocketServidorBitacoraIndustrial2 bitacoraIndustrial2;
	private static SocketServidorBuscarActualizarAlumno actualizarAlumno;
	private static SocketServidorEliminarAlumno eliminarAlumno;
	private static SocketServidorCargarAsesores cargarAsesores;
	
	public Main() {
		vistaServer = new Servidor();
		vistaServer.setVisible(true);
		vistaServer.setTextArea("Esperando al cliente..." + "\n");
		
		Main.buscarAsesorAca = new SocketServidorBuscarActualizarAsesorAca();
		Main.server = new SocketServidorLogin();
		Main.asesorAca = new SocketServidorInsertarAsesorAca();
		Main.asesorInd = new SocketServidorInsertarAsesorInd();
		Main.insertarAlumnos = new SocketServidorInsertarAlumnos();
		Main.insertarAdmin = new SocketServidorInsertarAdministrador();
		Main.eliminarAsesorAca = new SocketServidorEliminarAsesorAca();
		Main.buscarAsesorInd = new SocketServidorBuscarActualizarAsesorInd();
		Main.eliminarAsesorInd = new SocketServidorEliminarAsesorInd();
		Main.buscarAdministrador = new SocketServidorBuscarActualizarAdministrador();
		Main.eliminarAdmin = new SocketServidorEliminarAdministrador();
		Main.cambiarPassword = new SocketServidorCambiarContraseña();
		Main.avancesAlumno = new SocketServidorInsertarAvancesAlumno();
		Main.observacionesAsesorAca = new SocketServidorObservacionesAsesorAcaConsultarAlumno();
		Main.insertarObservacionesAcademico = new SocketServidorInsertarObservacionesAcademico();
		Main.insertarEvaluacionAcademico = new SocketServidorInsertarEvaluaciónAcademico();
		Main.consultarAlumnoIndustrial = new SocketServidorObservacionesAsesorIndConsultarAlumno();
		Main.insertarObservacionIndustrial = new SocketServidorInsertarObservacionesIndustrial();
		Main.insertarEvaluacionIndustrial = new SocketServidorInsertarEvaluaciónIndustrial();
		Main.bitacoraAlumno = new SocketServidorBitacoraAlumno();
		Main.bitacoraAcademico = new SocketServidorBitacoraAcademico();
		Main.bitacoraAcademico2 = new SocketServidorBitacoraAcademico2();
		Main.bitacoraIndustrial = new SocketServidorBitacoraIndustrial();
		Main.bitacoraIndustrial2 = new SocketServidorBitacoraIndustrial2();
		Main.actualizarAlumno = new SocketServidorBuscarActualizarAlumno();
		Main.eliminarAlumno = new SocketServidorEliminarAlumno();
		Main.cargarAsesores = new SocketServidorCargarAsesores();
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
