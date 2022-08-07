package base_datos;

import java.util.List;

import entidades.Cliente;
import entidades.Usuario;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;


public interface UsuarioDAO {
	
	//CREAR USUARIO
	void crearUsuario(Usuario unUsuario) throws ClaveDuplicadaException, DAOException;

	//BORRAR USUARIO
	void borraUsuario(String username) throws DAOException;
	
	//ACTUALIZAR USUARIO
	void actualizaUsuario(Usuario unUsuario)throws DAOException;
	
	//LISTA DE USUARIOS
	List<Usuario> listaTodosLosUsuarios() throws DAOException;
	
	
	//ACTUALIZAR ENTRADAS DE CLIENTE
	void actualizaEntradasCliente(Cliente unUsuario)throws DAOException;
	
	//MOSTRAR CLIENTE
	Cliente muestraCliente(String username) throws DAOException;
	
	//LISTA DE CLIENTES
	List<Cliente> listaTodosLosClientes() throws DAOException;
		
	//INSERTAR VENTAS
	void insertarTablaVentas(Cliente unUsuario, String vendedor, String evento) throws DAOException;
	
	
}
