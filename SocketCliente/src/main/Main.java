package main;
/**
 * Clase donde se encuentra el metodo main para ejecutar la aplicación.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
import funcionamiento.SocketLogin;
import vista.Sesion;

public class Main {
	public static Sesion frameSesion;
	private static SocketLogin sock;
	
	public static void main(String[] args) {
		frameSesion = new Sesion();
		frameSesion.setVisible(true);
		setSock(new SocketLogin());
	}

	public static SocketLogin getSock() {
		return sock;
	}

	public static void setSock(SocketLogin sock) {
		Main.sock = sock;
	}

}
