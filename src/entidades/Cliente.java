package entidades;

public class Cliente extends Usuario {

	private int entrada;
	
	
	public Cliente() {
		
		
	}
	public Cliente(String nombreUsuario, String email, String passUsuario) {
		super(nombreUsuario, email, passUsuario);
		
	}
	
	public Cliente(Cliente usuario) {
		
		Cliente1(usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassUsuario());
	}
	
	public Cliente(Cliente usuario, int x) {
		Cliente1(usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassUsuario());
		this.entrada = x;
	}
	
	private void Cliente1(String nombreUsuario, String email, String passUsuario) {
		
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.passUsuario = passUsuario;
	
	}

	

	public Cliente(String nombreUsuario, String email, String passUsuario, int entrada) {
		super(nombreUsuario, email, passUsuario);
		this.entrada = entrada;
	}
	

	

	public int getEntrada() {
		return this.entrada;
	}

	public void setEntrada(int entrada) {
		
		this.entrada = entrada;
	}
}
