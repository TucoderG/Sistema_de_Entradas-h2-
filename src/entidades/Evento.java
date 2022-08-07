package entidades;

public class Evento {
	
	private String nombre;
	private String ubicacion;
	private int anio;
	private int mes;
	private int dia;
	private int capacidad;
	private int precio;
	private int entradasVendidas;
	
	
	public Evento(String nombre, String ubicacion,int anio, int mes, int dia, int capacidad, int precio, int entradas) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.capacidad = capacidad;
		this.precio = precio;
		this.entradasVendidas = entradas;
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getUbicacion() {
		
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getPrecio() {
		
		return precio;
	}

	public int getEntradasVendidas() {
		return entradasVendidas;
	}

	public void setEntradasVendidas(int entradasVendidas) {
		this.entradasVendidas = entradasVendidas;
	}

}
