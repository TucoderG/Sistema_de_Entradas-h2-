package entidades;

public class Ventas {
	
	private String nombre_cliente;
	private int boletos_comprados;
	private String nombre_vendedor;
	private String ubicacion_evento;
	
	public Ventas(String nombreU, int boletos, String nombreV, String ubicacion) {
		
		this.nombre_cliente = nombreU;
		this.boletos_comprados = boletos;
		this.nombre_vendedor = nombreV;
		this.ubicacion_evento = ubicacion;
		
	}
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public int getBoletos_comprados() {
		return boletos_comprados;
	}
	public void setBoletos_comprados(int boletos_comprados) {
		this.boletos_comprados = boletos_comprados;
	}
	public String getNombre_vendedor() {
		return nombre_vendedor;
	}
	public void setNombre_vendedor(String nombre_vendedor) {
		this.nombre_vendedor = nombre_vendedor;
	}
	public String getUbicacion_evento() {
		return ubicacion_evento;
	}
	public void setUbicacion_evento(String ubicacion_evento) {
		this.ubicacion_evento = ubicacion_evento;
	}
	
	

}
