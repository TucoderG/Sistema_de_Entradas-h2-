package entidades;

public class Administrador extends Usuario {
	
	private int numAdmin;
	
	public Administrador(String nombreUsuario, String email, String passUsuario, int numAdmin) {
		super(nombreUsuario, email, passUsuario);
		this.numAdmin = numAdmin;
	}
	
	public int getNumAdmin() {
		return numAdmin;
	}

	public void setNumAdmin(int numAdmin) {
		this.numAdmin = numAdmin;
	}

	

	
	
}
