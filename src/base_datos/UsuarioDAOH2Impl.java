package base_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import entidades.Usuario;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;


public class UsuarioDAOH2Impl implements UsuarioDAO {
	
	private String sql;
	private Statement s;
	private Connection c = DBManager.connect();
	private ResultSet rs;
	private String nombre, email, pass;
	private int boletos, entradas;
	private Usuario u;
	private Cliente cl;
	
	
	//CREAR USUARIO
	public void crearUsuario(Usuario unUsuario) throws ClaveDuplicadaException, DAOException {

		
		this.nombre = unUsuario.getNombreUsuario();
		this.email = unUsuario.getEmail();
		this.pass = unUsuario.getPassUsuario();
		
		
		try {
			this.s = this.c.createStatement();
			
			this. sql = "INSERT INTO usuarios (usuario, email, contraseña, entradas_compradas) VALUES ('" + this.nombre + "', '" + this.email + "', '" + this.pass + "', '" + 0 + "');";
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
	
	
	//BORRAR USUARIO
	public void borraUsuario(String username) throws DAOException {
			
		try {
				
			this.s = this.c.createStatement();
			this.sql = "DELETE FROM usuarios WHERE usuario = '" + username + "'";
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
	
	
	//ACTUALIZAR USUARIO
	public void actualizaUsuario(Usuario unUsuario) throws DAOException {
			
		this.nombre = unUsuario.getNombreUsuario();
		this.email = unUsuario.getEmail();
		this.pass = unUsuario.getPassUsuario();
			
		try {
			this.s = this.c.createStatement();
			this.sql = "UPDATE usuarios SET (usuario, contraseña) = ('" + this.nombre + "', '" + this.pass + "') WHERE email = '" + this.email + "';";
			this.s.executeUpdate(sql);
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
	
	
	//LISTA USUARIO
	public List<Usuario> listaTodosLosUsuarios() throws DAOException {
		
		List<Usuario> resultado = new ArrayList<Usuario>();
			
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM USUARIOS";
			this.rs = this.s.executeQuery(this.sql);
				
			while(this.rs.next()) {
				this.nombre = this.rs.getString("usuario");
				this.email = this.rs.getString("email");
				this.pass = this.rs.getString("contraseña");
				
				this.u = new Usuario(this.nombre, this.email, this.pass);
				resultado.add(this.u);
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
	
	
	//ACTUALIZAR ENTRADAS CLIENTE
	public void actualizaEntradasCliente(Cliente unUsuario) throws DAOException {
			
		this.entradas = unUsuario.getEntrada();
		this.email = unUsuario.getEmail();
			
		try {
			this.s = this.c.createStatement(); 
			this.sql = "UPDATE usuarios SET entradas_compradas = entradas_compradas + " + this.entradas + " WHERE email ='" + this.email + "';";
			this.s.executeUpdate(sql);
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
	
	
	//MOSTRAR CLIENTE
	public Cliente muestraCliente(String username) throws DAOException {
		
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM usuarios WHERE usuario = '" + username + "';";
			this.rs = this.s.executeQuery(this.sql);
			
			if(rs.next()) {
				
				this.nombre = this.rs.getString("usuario");
				this.email = this.rs.getString("email");
				this.pass = this.rs.getString("contraseña");
				this.entradas = this.rs.getInt("entradas_compradas");
				
				this.cl = new Cliente(this.nombre, this.email, this.pass, this.entradas);
				return this.cl;
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
		
		return null;
	}
	
	//LISTA CLIENTE
	public List<Cliente> listaTodosLosClientes() throws DAOException {
		
		List<Cliente> resultado = new ArrayList<Cliente>();
		
		try {
			this.s = this.c.createStatement();
			this.sql = "SELECT * FROM USUARIOS";
			this.rs = this.s.executeQuery(this.sql);
			
			while(this.rs.next()) {
				this.nombre = this.rs.getString("usuario");
				this.email = this.rs.getString("email");
				this.pass = this.rs.getString("contraseña");
				this.boletos = this.rs.getInt("entradas_compradas");
				
				this.cl = new Cliente(this.nombre, this.email, this.pass, this.boletos);
				resultado.add(this.cl);
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
	
	
	//INSERTAR VENTAS
	public void insertarTablaVentas(Cliente unUsuario, String vendedor, String evento) throws DAOException {
				
		this.nombre = unUsuario.getNombreUsuario();
		this.boletos = unUsuario.getEntrada();
				
		try {
			this.s = this.c.createStatement();
					
			this.sql = "INSERT INTO ventas (nombre_usuario, voletos_comprados, nombre_vendedor, ubicacion_evento) VALUES ('" + this.nombre + "', '" + this.boletos + "', '" + vendedor + "', '" + evento + "');";
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

}
