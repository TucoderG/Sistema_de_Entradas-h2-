package entidades;


public class Vendedor extends Usuario {
	
	private String evento;
	private String ubicacion;
	private int boletos;
	
	public Vendedor(String nombreUsuario, String passUsuario, String nombreEvento, String ubicacionEvento, int bol) {
		super(nombreUsuario, passUsuario);
		this.evento = nombreEvento;
		this.ubicacion = ubicacionEvento;
		this.boletos = bol;
	}

	public int getBoletos() {
		return boletos;
	}

	public void setBoletos(int boletos) {
		this.boletos = boletos;
	}
	
	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	

}
