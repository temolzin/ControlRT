package funcionamiento;
/**
 * Clase que tiene los atributos de un inicio de sesión.
 * @author TemolzinItzae
 * @author TaniaCitlali
 */
public class Login {
	private static String matricula;
	private static String password;
	private static String tipoUsuario;
	
	public Login() {
		Login.matricula = "2513160131";
		Login.password = "root";
		Login.tipoUsuario = "Administrador";
	}

	public static String getMatricula() {
		return matricula;
	}

	public static void setMatricula(String matricula) {
		Login.matricula = matricula;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Login.password = password;
	}

	public static String getTipoUsuario() {
		return tipoUsuario;
	}

	public static void setTipoUsuario(String tipoUsuario) {
		Login.tipoUsuario = tipoUsuario;
	}
	
	
	
}
