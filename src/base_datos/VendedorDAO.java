package base_datos;

import java.util.List;


import entidades.Vendedor;
import entidades.Ventas;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;

public interface VendedorDAO {

	//CREAR VENDEDOR
	void crearVendedor(Vendedor user) throws DAOException, ClaveDuplicadaException;
		
	//ACTUALIZAR VENDEDOR
	void actualizaVendedor(String unUsuario, int boletos)throws DAOException;

	//MUESTRA CAPACIDAD DEL EVENTO
	int muestraCapacidadEvento(String username, String ubicacion) throws DAOException;
	
	//LISTA VENDEDOR
	List<Vendedor> listaTodosLosVendedores() throws DAOException;

	//LISTA VENTAS
	List<Ventas> listaTodasLasVentas(Vendedor vendedor) throws DAOException;
	
	//BOLETOS VENDEDOR
	int muestraBoletosVendedor(String username) throws DAOException;
}
