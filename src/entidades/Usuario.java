package entidades;

public class Usuario {
	
	protected String nombreUsuario;
	protected String email;
	protected String passUsuario;
	

	public Usuario() {
		
	}
	
	public Usuario(String nombreUsuario, String passUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.passUsuario = passUsuario;
	}
	
	public Usuario(String nombreUsuario, String email, String passUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.passUsuario = passUsuario;
	}
	

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombre) {
		this.nombreUsuario = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassUsuario() {
		return passUsuario;
	}
	public void setPassUsuario(String pass) {
		this.passUsuario = pass;
	}
	
	
	
	

}
