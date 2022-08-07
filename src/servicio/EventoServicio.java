package servicio;

import java.util.ArrayList;
import java.util.List;

import base_datos.EventoDAOH2Impl;
import entidades.Evento;
import exeptions.DAOException;
import exeptions.ServiceException;

public class EventoServicio implements IEventoServicio{
	
	//CREAR EVENTO
	public void insertarEvento(Evento evento) throws ServiceException {
		
		
		try {
			EventoDAOH2Impl user = new EventoDAOH2Impl();
			user.insetarEvento(evento);
		}catch(DAOException e) {
			throw new ServiceException();
		}
		
	}
		
	//BORRAR EVENTO
	@Override
	public void borraEvento(String nombre, String ubicacion) throws DAOException, ServiceException {
		
		try {
				
			EventoDAOH2Impl user = new EventoDAOH2Impl();	
			user.borraEvento(nombre, ubicacion);
		
		}catch(DAOException e) {
				
			throw new ServiceException(e);
				
		}
	}

	//LISTA DE EVENTOS
	public List<Evento> listaTodosLosEventos() throws DAOException, ServiceException {
		EventoDAOH2Impl user = new EventoDAOH2Impl();
		List<Evento> listaEvento = new ArrayList<Evento>();
		try {
		
			listaEvento = user.listaTodosLosEventos();
			
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
		
		return listaEvento;
	}
	
	
	//ACTUALIZAR ENTRADAS DE EVENTO
	public void actualizaEntradasEvento(String evento, String ubicacion, int boletos) throws ServiceException {
		
		
		try {
			EventoDAOH2Impl user = new EventoDAOH2Impl();
			user.actualizaEntradasEvento(evento, ubicacion, boletos);
			
		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
	}
	
	//LISTA UBICACIONES DE EVENTO
	public List<String> mostrarUbicacionesEvento(String evento) throws DAOException, ServiceException {
		EventoDAOH2Impl user = new EventoDAOH2Impl();
		List<String> listaEvento = new ArrayList<String>();
		try {
		
			listaEvento = user.mostrarUbicacionesEvento(evento);
			
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
		
		return listaEvento;
	}
	
	//LISTA VENDEDORES DE EVENTO
	public List<String> mostrarVendedoresEvento(String evento, String ubicacion) throws DAOException, ServiceException {
		
		EventoDAOH2Impl user = new EventoDAOH2Impl();
		List<String> listaEvento = new ArrayList<String>();
		try {
		
			listaEvento = user.mostrarVendedoresDeUnEvento(evento, ubicacion);
			
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
		
		return listaEvento;
	}
	


}
