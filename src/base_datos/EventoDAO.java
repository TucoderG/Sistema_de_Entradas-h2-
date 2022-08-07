package base_datos;

import java.util.List;

import entidades.Evento;
import exeptions.DAOException;

public interface EventoDAO {

	//CREAR EVENTO
	void insetarEvento(Evento evento) throws DAOException;
			
	//BORRAR EVENTO
	void borraEvento(String nombre, String ubicacion) throws DAOException;
			
	//LISTA DE EVENTOS
	List<Evento> listaTodosLosEventos() throws DAOException;
		
	//ACTUALIZAR ENTRADAS DE EVENTO
	void actualizaEntradasEvento(String evento, String ubicacion, int boletos)throws DAOException;
		
	//LISTA UBICACION DEL EVENTO
	List<String> mostrarUbicacionesEvento(String evento) throws DAOException;
			
	//LISTA VENDEDORES DEL EVENTO
	List<String> mostrarVendedoresDeUnEvento(String evento, String ubicacion) throws DAOException;
		
}
