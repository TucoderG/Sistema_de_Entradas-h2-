package servicio;

import java.util.List;

import entidades.Vendedor;
import entidades.Ventas;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;
import exeptions.ServiceException;

public interface IVendedorServicio {

	
	
	//CREAR VENDEDOR
	void crearVendedor(Vendedor user)throws ServiceException, ClaveDuplicadaException;

	
	//ACTUALIZAR VENDEDOR
	void actualizaVendedor(String unUsuario, int boletos) throws ServiceException;
	
	//MUESTRA LA CAPACIDAD DEL EVENTO
	int muestraCapacidadEvento(String username, String ubicacion) throws ServiceException;
	
	//LISTA VENDEDOR
	List<Vendedor> listaTodosLosVendedores() throws DAOException, ServiceException;
	
	//LISTAR VENTAS
	List<Ventas> listaTodasLasVentas(Vendedor vendedor) throws DAOException, ServiceException;

	//MUESTRA BOLETOS VENDEDOR
	int muestraBoletosVendedor(String username) throws ServiceException;

}
