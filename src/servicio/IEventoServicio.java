package servicio;

import java.util.List;

import entidades.Evento;
import exeptions.DAOException;
import exeptions.ServiceException;

public interface IEventoServicio {

	
	//CREAR EVENTO
	void insertarEvento(Evento evento) throws ServiceException;
		
	//BORRAR EVENTO
	void borraEvento(String nombre, String ubicacion) throws DAOException, ServiceException;
		
	//LISTA EVENTOS
	List<Evento> listaTodosLosEventos() throws DAOException, ServiceException;
				
	//ACTUALIZA ENTRADAS DE EVENTO
	void actualizaEntradasEvento(String evento, String ubicacion, int boletos) throws ServiceException;
			
	//LISTA UBICACIONES EVENTO
	List<String> mostrarUbicacionesEvento(String evento) throws DAOException, ServiceException;
		
	//LISTA VENDEDORES EVENTO
	List<String> mostrarVendedoresEvento(String evento, String ubicacion) throws DAOException, ServiceException;
	
}
