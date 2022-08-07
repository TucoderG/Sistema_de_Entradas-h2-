package servicio;

import java.util.List;

import entidades.Cliente;
import entidades.Usuario;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;
import exeptions.ServiceException;

public interface IUsuarioServicio {
	
	//CREAR USUARIO
	void crearUsuario(Usuario unUsuario) throws ClaveDuplicadaException, ServiceException, DAOException;

	//BORRAR USUARIO
	void borraUsuario(String username) throws DAOException, ServiceException;

	//ACTUALIZAR USUARIO
	void actualizaUsuario(Usuario unUsuario) throws ServiceException;
		
	//LISTA USUARIOS
	List<Usuario> listaTodosLosUsuarios() throws DAOException, ServiceException;
			
	
	//ACTUALIZAR ENTRADAS CLIENTE
	void actualizaEntradasCliente(Cliente unUsuario) throws ServiceException;
	
	//MOSTRAR CLIENTE
	Cliente muestraCliente(String username) throws ServiceException;
	
	//LISTA CLIENTES
	List<Cliente> listaTodosLosClientes() throws DAOException, ServiceException;
		
	//INSERTAR VENTAS
	void insertarTablaVentas(Cliente unUsuario, String vendedor, String evento) throws ServiceException;
	
	
	
}
