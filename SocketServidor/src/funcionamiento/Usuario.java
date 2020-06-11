package funcionamiento;
/**
 * Clase Padre que hereda a las clases de Alumno,
 * AsesorAcademico, AsesorIndustrial, Administrador 
 * @author TemolzinItzae
 *
 */
public class Usuario {
	private String matricula;
	private String nombre;
	private String ap_pat;
	private String ap_mat;
	private String correo;
	private String telefono;
	private String password;
	
	public Usuario() {
		this.matricula = "2513160131";
		this.nombre = "Temolzin Itzae";
		this.ap_pat = "Roldan";
		this.ap_mat = "Palacios";
		this.correo = "temolzin@hotmail.com";
		this.telefono = "5535092965";
		this.password = "root";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_pat() {
		return ap_pat;
	}

	public void setAp_pat(String ap_pat) {
		this.ap_pat = ap_pat;
	}

	public String getAp_mat() {
		return ap_mat;
	}

	public void setAp_mat(String ap_mat) {
		this.ap_mat = ap_mat;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
