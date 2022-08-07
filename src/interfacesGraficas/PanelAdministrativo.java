package interfacesGraficas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import entidades.Evento;
import entidades.Usuario;
import entidades.Vendedor;
import estructura.Button;
import estructura.Frame;
import estructura.Label;
import estructura.Text;
import exeptions.DAOException;
import exeptions.Mensajes;
import exeptions.ServiceException;
import funciones.PanelCrearCuentaVendedor;
import servicio.EventoServicio;
import servicio.UsuarioServicio;
import servicio.VendedorServicio;

public class PanelAdministrativo {
	
	private static Frame frame;
	private static Label titulo, lnombree, lnombrem, lubicacion, lnombreev;
	private static Button bCrearEvnt, bMostrEvnt, bElimEv, bListarUs, bElimUs, bMostUs, bListarVend, bCrearVend, bRegresar;
	private static Text tfnomEv, tfubEv, tfnombre, tfmnombre;
	private static String s, s1, nombre;
	private static int h = 0, io = 0;
	private static List<Cliente> c; 
	
	public static void panelAdministrador() {
		
		//FRAME
		frame = new Frame("-ADMINISTRADOR/A", 910, 480, "/imagenes/Administrador.jpg");
		
		
		//TITULO ADMINISTRADOR
		titulo = new Label("Bienvenido/a ADMIN.", 345, -10, 400, 90);
		
		//BOTON CREAR EVENTO
		bCrearEvnt = new Button("Crear Evento", 720, 80, 140, 30, true);
				
		bCrearEvnt.addActionListener(new ActionListener() {
							
			public void actionPerformed(ActionEvent e) {
								
				frame.setVisible(false);
				try {
					funciones.PanelCrearEvento.crearEvento();
				} catch (ParseException e1) {
									
					e1.printStackTrace();
				}
			}
		});
		
		
		
		//BOTON MOSTRAR EVENTO
		bMostrEvnt = new Button("Mostrar Eventos", 720, 130, 140, 30, true);
		
		bMostrEvnt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
										
				List<Evento> listaEvento = new ArrayList<Evento>();
				EventoServicio user = new EventoServicio();
										
				try {
					listaEvento = user.listaTodosLosEventos();
					funciones.MostrarEventos.mostrarLista(listaEvento);
											
											
				} catch (DAOException e1) {
					e1.printStackTrace();
										
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}
									
			}
		});
		
		
		//ETIQUETA NOMBRE EV
		lnombreev = new Label("Nombre: ", 480, 180, 140, 30);
		lnombreev.setForeground(Color.BLACK);
		//CAJA NOMBRE DE EVENTO A ELIMINAR
		tfnomEv = new Text(570, 180, 140, 30);
		
		//ETIQUETA UBICACION
		lubicacion = new Label("Ubicacion: ", 480, 230, 140, 30);
		lubicacion.setForeground(Color.BLACK);
		//CAJA UBICACION DE EVENTO A ELIMINAR
		tfubEv = new Text(570, 230, 140, 30);
		
		//BOTON ELIMINAR EVENTO
		bElimEv = new Button("Eliminar Evento", 720, 180, 140, 30, true);
		
		bElimEv.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				s = tfnomEv.getText();
				s1 = tfubEv.getText();
				
				if(s.equals("") && s1.equals("")) {
					
					Mensajes.alerta("Complete todos los campos.");
					return;
							
				}else {
					EventoServicio user = new EventoServicio();
												
					try {
					
						user.borraEvento(s,s1);
						Mensajes.informacion("Se elimino el Evento: "+ s + " en la ubiacion: " + s1 + ".");
													
													
					} catch (DAOException | ServiceException e1) {
						e1.printStackTrace();
											
					}
				}
			}
		});
				
		//BOTON LISTAR USUARIOS
		bListarUs = new Button("Listar Usuarios", 50, 80, 140, 30, true);
		
		bListarUs.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
						
				List<Usuario> listaUsuario = new ArrayList<Usuario>();
				UsuarioServicio user = new UsuarioServicio();
						
				try {
					listaUsuario = user.listaTodosLosUsuarios();
					funciones.MostrarListadoUsuarios.mostrarLista(listaUsuario);
							
							
				} catch (DAOException e1) {
					e1.printStackTrace();
							
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}
				
			}
					
		});
		
		//ETIQUETA NOMBRE USUARIO ELIMINAR
		lnombree = new Label("Nombre: ", 350, 130, 140, 30);
		lnombree.setForeground(Color.BLACK);
		
		//CAJA DE TEXTO USUARIO A ELIMINAR
		tfnombre = new Text(200, 130, 140, 30);
						
		//BOTON ELIMINAR USUARIO
		bElimUs = new Button("Eliminar Usuario", 50, 130, 140, 30, true);
				
		bElimUs.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					
				s = tfnombre.getText();
				
				if(s.equals("")) {
					Mensajes.alerta("Complete todos los campos.");
					return;
							
				}else {
							
						
					UsuarioServicio user = new UsuarioServicio();
					
					try {
						c = user.listaTodosLosClientes();
						for(Cliente n: c) {
							if(s.equals(n.getNombreUsuario())) {
								h = 1;
							}
						}
						if(h == 1) {
							user.borraUsuario(s);
							Mensajes.informacion("Se elimino el usuario: "+ s + ".");
						}else {
							
							Mensajes.alerta("Usuario ingresado no existe.");
						}
						
					} catch (DAOException | ServiceException e1) {
						e1.printStackTrace();
									
					}		
				}
			}
		});
		
		//ETIQUETA NOMBRE USUARIO MOSTRAR
		lnombrem = new Label("Nombre: ", 350, 180, 140, 30);
		lnombrem.setForeground(Color.black);
		//CAJA DE TEXTO USUARIO A MOSTRAR
		tfmnombre = new Text(200, 180, 140, 30);
		
		//BOTON MOSTRAR CLIENTE
		bMostUs = new Button("Mostrar Cliente", 50, 180, 140, 30, true);
				
		bMostUs.addActionListener(new ActionListener() {
							
			public void actionPerformed(ActionEvent e) {
								
				Cliente u = new Cliente();
						
				UsuarioServicio user = new UsuarioServicio();
				
				
				io = 0;
				nombre = tfmnombre.getText();
				try {
					
					try {
						for(Cliente c1 : user.listaTodosLosClientes()) {
							
							if(nombre.equals(c1.getNombreUsuario())) {
								io = 1;
							}
						}
						if(io == 1) {
							u = user.muestraCliente(nombre);
							funciones.MostrarCliente.mostrarCliente(u);
						}else {
							exeptions.Mensajes.alerta("Usuario ingresado no existe.");
						}
					} catch (ServiceException e1) {
						
						e1.printStackTrace();
					}
				} catch (DAOException e1) {
						
					e1.printStackTrace();
				}
					
									
			}					
							
		});
		
		//TODO
		//BOTON LISTAR VENDEDORES
		bListarVend = new Button("Listar Vendedores", 465, 300, 140, 30, true);
		bListarVend.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
								
				List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
				VendedorServicio user = new VendedorServicio();
								
				try {
					listaVendedor = user.listaTodosLosVendedores();
					funciones.MostrarListadoVendedores.mostrarLista(listaVendedor);
									
									
				} catch (DAOException e1) {
					e1.printStackTrace();
								
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}
						
			}
							
		});
				
		
				
		
		//BOTON CREAR CUENTA VENDEDOR
		bCrearVend = new Button("Crear Vendedor", 305, 300, 140, 30, true);
		
		bCrearVend.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				PanelCrearCuentaVendedor.crearCuenta();
				
				
			}
			
		});
		
		
		
		//BOTON REGRESO
		bRegresar = new Button("Regresar", 20, 410, 90, 20, true);
		
		bRegresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Inicio.CrearInicio();
								
			}
							
		});
				
		frame.add(titulo);
		frame.add(bListarUs);
		frame.add(bListarVend);
		frame.add(lnombreev);
		frame.add(tfnomEv);
		frame.add(lubicacion);
		frame.add(tfubEv);
		frame.add(bElimEv);
		frame.add(lnombree);
		frame.add(tfnombre);
		frame.add(lnombrem);
		frame.add(tfmnombre);
		frame.add(bElimUs);
		frame.add(bMostUs);
		frame.add(bCrearEvnt);
		frame.add(bCrearVend);
		frame.add(bMostrEvnt);
		frame.add(bRegresar);
		
		frame.setVisible(true);
	}

}
