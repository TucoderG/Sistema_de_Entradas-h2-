package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Vendedor;
import entidades.Ventas;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;

public class VendedorDAOH2Impl implements VendedorDAO{

	
	private String sql;
	private Statement s;
	private Connection c = DBManager.connect();
	private ResultSet rs;
	private String nombre, pass, ubicacion, nombreE;
	private int boletos, capacidad;
	
	
	
	private Vendedor v;
	private Ventas vts;
	
	//CREAR VENDEDOR
	public void crearVendedor(Vendedor user) throws DAOException, ClaveDuplicadaException {
			
		this.nombre = user.getNombreUsuario();
		this.pass = user.getPassUsuario();
		this.nombreE = user.getEvento();
		this.ubicacion = user.getUbicacion();
		this.boletos = user.getBoletos();
	
		try {
			this.s = this.c.createStatement();
			this.sql = "INSERT INTO vendedores (nombre, contraseña, nombre_evento, ubicacion_evento, voletos_para_vender) VALUES ('" + this.nombre + "', '" + this.pass + "', '" + this.nombreE + "', '" + this.ubicacion + "', '" + this.boletos + "');";
			this.c.commit();
			this.s.executeUpdate(this.sql);
			
		} catch (SQLException e) {
			
			if(e.getErrorCode() == 23505) {
				throw new ClaveDuplicadaException();
			}
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
		
	//ACTUALIZAR VENDEDOR
	public void actualizaVendedor(String unUsuario, int boletos) throws DAOException {
			
		
		
		try {
			this.s = this.c.createStatement();
			this.sql = "UPDATE vendedores SET (voletos_para_vender) = ( voletos_para_vender -'" + boletos + "') WHERE nombre LIKE '" + unUsuario + "';";
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
		
	//MOSTRAR CAPACIDAD DE EVENTO
	public int muestraCapacidadEvento(String username, String ubicacion) throws DAOException {
		
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM EVENTOS WHERE (nombre, ubicacion) = ('" + username + "', '" + ubicacion + "');";
			this.rs = this.s.executeQuery(this.sql);
			
			if(this.rs.next()) {
				
				this.capacidad = this.rs.getInt("capacidad");
				return this.capacidad;
			}
		}catch (SQLException e) {
			try {
				this.c.rollback();
				throw new DAOException(e);
				
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}finally {
			try {
				this.c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		
	}
	
	//LISTA VENDEDOR
	public List<Vendedor> listaTodosLosVendedores() throws DAOException {
		
		List<Vendedor> resultado = new ArrayList<>();
		
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM vendedores";
			this.rs = this.s.executeQuery(this.sql);
			
			while(this.rs.next()) {
				
				this.nombre = this.rs.getString("nombre");
				this.pass = this.rs.getString("contraseña");
				this.nombreE = this.rs.getString("nombre_evento");
				this.ubicacion = this.rs.getString("ubicacion_evento");
				this.boletos = this.rs.getInt("voletos_para_vender");
				
				this.v = new Vendedor(this.nombre, this.pass, this.nombreE, this.ubicacion,  this.boletos);
				resultado.add(this.v);
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
	
	
	
	//LISTA VENTAS
	public List<Ventas> listaTodasLasVentas(Vendedor vendedor) throws DAOException {
		
		List<Ventas> resultado = new ArrayList<>();
		
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM ventas WHERE nombre_vendedor = '" + vendedor.getNombreUsuario() + "';";
			this.rs = this.s.executeQuery(this.sql);
			
			while(this.rs.next()) {
				this.nombre = this.rs.getString("nombre_usuario");
				this.boletos = this.rs.getInt("voletos_comprados");
				this.nombreE = this.rs.getString("nombre_vendedor");
				this.ubicacion = this.rs.getString("ubicacion_evento");
				
				this.vts = new Ventas(this.nombre, this.boletos, this.nombreE, ubicacion);
				resultado.add(this.vts);
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
		
		
		
		
	//MUESTRA BOLETOS VENDEDOR
	public int muestraBoletosVendedor(String username) throws DAOException {
		
		
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM vendedores WHERE nombre = '" + username + "';";
			this.rs = this.s.executeQuery(this.sql);
			
			if(this.rs.next()) {
				
				this.boletos = this.rs.getInt("voletos_para_vender");
				return this.boletos;
			}
		}catch (SQLException e) {
			try {
				this.c.rollback();
				throw new DAOException(e);
				
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}finally {
			try {
				this.c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		
	}
	
}