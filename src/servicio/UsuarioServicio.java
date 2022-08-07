package servicio;


import java.util.ArrayList;
import java.util.List;


import base_datos.UsuarioDAOH2Impl;
import entidades.Cliente;

import entidades.Usuario;

import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;
import exeptions.ServiceException;


public class UsuarioServicio implements IUsuarioServicio {

	//CREAR USUARIO
	@Override
	public void crearUsuario(Usuario unUsuario) throws ClaveDuplicadaException, DAOException, ServiceException {
		try {
		
			UsuarioDAOH2Impl user = new UsuarioDAOH2Impl();
			user.crearUsuario(unUsuario);
			

		} catch(ClaveDuplicadaException e1) {
			e1.printStackTrace();
			throw new ClaveDuplicadaException(e1);
			
		}catch(DAOException e) {
			throw new ServiceException();
		}
		
	}

	//BORRAR USUARIO
	@Override
	public void borraUsuario(String username) throws DAOException, ServiceException {
	
		try {
			
			UsuarioDAOH2Impl user = new UsuarioDAOH2Impl();	
			user.borraUsuario(username);
		
		}catch(DAOException e) {
			
			throw new ServiceException(e);
			
		}
	}
	
	//ACTUALIZAR USUARIO
	@Override
	public void actualizaUsuario(Usuario unUsuario) throws ServiceException {
		
		
		try {
			UsuarioDAOH2Impl user = new UsuarioDAOH2Impl();
			user.actualizaUsuario(unUsuario);
			
		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
	}
	
	//LISTA USUARIO
	public List<Usuario> listaTodosLosUsuarios() throws DAOException, ServiceException {
		
		UsuarioDAOH2Impl user = new UsuarioDAOH2Impl();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
		
			listaUsuario = user.listaTodosLosUsuarios();
			
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
		
		return listaUsuario;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	//ACTUALIZAR ENTRADAS CLIENTE
	@Override
	public void actualizaEntradasCliente(Cliente unUsuario) throws ServiceException {
			
			
		try {
			UsuarioDAOH2Impl user = new UsuarioDAOH2Impl();
			user.actualizaEntradasCliente(unUsuario);
				
		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
			
	}

	
	//MOSTRAR CLIENTE
	public Cliente muestraCliente(String username) throws ServiceException {
		
		Cliente c = new Cliente();
		try {
			
			UsuarioDAOH2Impl user = new UsuarioDAOH2Impl();
			c = user.muestraCliente(username);
			
		} catch(DAOException e) {
			
			throw new ServiceException(e);
			
		}
		
		
		return c;
	}
	
	//LISTA DE CLIENTE
	public List<Cliente> listaTodosLosClientes() throws DAOException, ServiceException {
		
		UsuarioDAOH2Impl user = new UsuarioDAOH2Impl();
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
	
			listaClientes = user.listaTodosLosClientes();
		
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	
		return listaClientes;
	
	}
	
	
	//INSERTAR VENTAS
	public void insertarTablaVentas(Cliente unUsuario, String vendedor, String evento) throws ServiceException {
		
		try {
			UsuarioDAOH2Impl user = new UsuarioDAOH2Impl();
			user.insertarTablaVentas(unUsuario, vendedor, evento);
		}catch(DAOException e) {
			throw new ServiceException();
		}
	}
		
	
	

		


}
