package servicio;

import java.util.ArrayList;
import java.util.List;

import base_datos.VendedorDAOH2Impl;
import entidades.Vendedor;
import entidades.Ventas;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;
import exeptions.ServiceException;

public class VendedorServicio implements IVendedorServicio {

	
	//CREAR VENDEDOR
	public void crearVendedor(Vendedor user)throws ServiceException, ClaveDuplicadaException {
		
		
		try {
			VendedorDAOH2Impl usuario = new VendedorDAOH2Impl();
			usuario.crearVendedor(user);
		}catch(DAOException e) {
			throw new ServiceException();
		}catch(ClaveDuplicadaException e1) {
			e1.printStackTrace();
		}
	}
		
	//ACTUALIZAR VENDEDOR
	public void actualizaVendedor(String unUsuario, int boletos) throws ServiceException {
	
		
		try {
			VendedorDAOH2Impl user = new VendedorDAOH2Impl();
			user.actualizaVendedor(unUsuario, boletos);
			
		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
	}
	
	
	//MOSTRAR CAPACIDAD DE EVENTOS
	public int muestraCapacidadEvento(String username, String ubicacion) throws ServiceException {
		
		int u = 0;
		try {
			
			VendedorDAOH2Impl user = new VendedorDAOH2Impl();
			u = user.muestraCapacidadEvento(username, ubicacion);
			
		} catch(DAOException e) {
			
			throw new ServiceException(e);
			
		}
		
		
		return u;
	}
	
	
	//LISTA VENDEDOR
	//TODO
	public List<Vendedor> listaTodosLosVendedores() throws DAOException, ServiceException {
		VendedorDAOH2Impl user = new VendedorDAOH2Impl();
		List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
		try {
		
			listaVendedor = user.listaTodosLosVendedores();
			
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
		
		return listaVendedor;
	}
	
	//LISTA VENTAS
	public List<Ventas> listaTodasLasVentas(Vendedor vendedor) throws ServiceException{
		
		VendedorDAOH2Impl user = new VendedorDAOH2Impl();
		List<Ventas> listaUsuario = new ArrayList<Ventas>();
		try {
		
			listaUsuario = user.listaTodasLasVentas(vendedor);
			
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
		
		return listaUsuario;
		
	}
	
	//MOSTRAR BOLETOS
	public int muestraBoletosVendedor(String username) throws ServiceException {
		
		int u = 0;
		try {
			
			VendedorDAOH2Impl user = new VendedorDAOH2Impl();
			u = user.muestraBoletosVendedor(username);
			
		} catch(DAOException e) {
			
			throw new ServiceException(e);
			
		}
		
		
		return u;
	}
}
