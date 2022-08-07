package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Evento;
import exeptions.DAOException;

public class EventoDAOH2Impl implements EventoDAO{
	
	private String sql;
	private Statement s;
	private Connection c = DBManager.connect();
	private ResultSet rs;
	private String nombre, ubicacion, nombreE;
	private int boletos, anio, mes, dia, capacidad, precio;
	private Evento e;
	
	
	//CREAR EVENTO
	public void insetarEvento(Evento evento) throws DAOException {

		this.nombreE = evento.getNombre();
		this.ubicacion = evento.getUbicacion();
		this.anio = evento.getAnio();
		this.mes = evento.getMes();
		this.dia = evento.getDia();
		this.capacidad = evento.getCapacidad();
		this.precio = evento.getPrecio();
	
		try {
			
			this.s = this.c.createStatement();
			this.sql = "INSERT INTO EVENTOS (nombre, ubicacion, año, mes, dia, capacidad, precio) VALUES ('" + this.nombreE + "', '" + this.ubicacion + "', '" + this.anio + "', '" + this.mes +"', '" + this.dia +  "', '" + this.capacidad + "', '" + this.precio + "');";
			this.c.commit();
			this.s.executeUpdate(this.sql);
		
		} catch (SQLException e) {
			
			try {
				
				e.printStackTrace();
				this.c.rollback();
			
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DAOException();
			}	
		} finally {
			try {
				this.c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	//BORRAR EVENTO
	public void borraEvento(String nombre, String ubicacion) throws DAOException {
			
		try {
				
			this.s = this.c.createStatement();
			this.sql = "DELETE FROM eventos WHERE nombre = '" + nombre + "' AND ubicacion = '" + ubicacion + "';";
			this.s.executeUpdate(this.sql);
			this.c.commit();
				
		} catch (SQLException e) {
			try {
				this.c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				throw new DAOException();
			}
		} finally { 
			try {
				this.c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
			
	}

	//LISTA EVENTOS
	public List<Evento> listaTodosLosEventos() throws DAOException {
		
		List<Evento> resultado = new ArrayList<>();
		
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM EVENTOS";
			this.rs = this.s.executeQuery(this.sql);
			
			while(this.rs.next()) {
				
				this.nombreE = this.rs.getString("nombre");
				this.ubicacion = this.rs.getString("ubicacion");
				this.anio = this.rs.getInt("año");
				this.mes = this.rs.getInt("mes");
				this.dia = this.rs.getInt("dia");
				this.capacidad = this.rs.getInt("capacidad");
				this.precio = this.rs.getInt("precio");
				this.boletos = this.rs.getInt("entradas_vendidas");
				
				this.e = new Evento(this.nombreE, this.ubicacion, this.anio, this.mes, this.dia, this.capacidad, this.precio, this.boletos);
				resultado.add(this.e);
			}
		}catch(SQLException e) {
				try {
					this.c.rollback();
				}catch(SQLException e1) {
					throw new DAOException(e);
				}
		}finally {
			try {
				this.c.close();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	
		
		return resultado;
	}
	
	//ACTUALIZAR ENTRADAS EVENTOS
	public void actualizaEntradasEvento(String evento, String ubicacion, int boletos) throws DAOException {
			
			
		try {
			this.s = c.createStatement();
			this.sql = "UPDATE EVENTOS SET entradas_vendidas = ( entradas_vendidas + " + boletos + ") WHERE (nombre, ubicacion) = ('" + evento + "', '" + ubicacion + "');";
			this.s.executeUpdate(this.sql);
			this.c.commit();
		} catch (SQLException e) {
			try {
				this.c.rollback();
				e.printStackTrace();
				throw new DAOException(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				this.c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
			
	}
	
	//MOSTRAR UBICACIONES DE EVENTOS
	public List<String> mostrarUbicacionesEvento(String evento) throws DAOException {
		
		List<String> resultado = new ArrayList<>();
		
		try {
			
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM EVENTOS WHERE nombre = '" + evento + "';";
			this.rs = this.s.executeQuery(this.sql);
			
			while(this.rs.next()) {
				
				this.ubicacion = this.rs.getString("ubicacion");
				
				resultado.add(this.ubicacion);
			}
		}catch(SQLException e) {
				try {
					this.c.rollback();
				}catch(SQLException e1) {
					throw new DAOException(e);
				}
		}finally {
			try {
				this.c.close();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	
		
		return resultado;
	}
	
	//MOSTRAR VENDEDORES DE UN EVENTO
	public List<String> mostrarVendedoresDeUnEvento(String evento, String ubicacion) throws DAOException {

		List<String> resultado = new ArrayList<>();
		
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM VENDEDORES WHERE (nombre_evento, ubicacion_evento) = ('" + evento + "', '" + ubicacion + "');";
			this.rs = this.s.executeQuery(this.sql);
			
			while(this.rs.next()) {
				
				this.nombre = this.rs.getString("nombre");
				
				resultado.add(this.nombre);
			}
		}catch(SQLException e) {
				try {
					this.c.rollback();
				}catch(SQLException e1) {
					throw new DAOException(e);
				}
		}finally {
			try {
				this.c.close();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	
		
		return resultado;
	}


}
