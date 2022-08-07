package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import entidades.Cliente;
import entidades.Evento;
import entidades.Vendedor;
import estructura.Button;
import estructura.ChoiceLista;
import estructura.Frame;
import estructura.Label;
import estructura.Radio;
import estructura.Text;
import exeptions.DAOException;
import exeptions.Mensajes;
import exeptions.ServiceException;
import servicio.EventoServicio;
import servicio.UsuarioServicio;
import servicio.VendedorServicio;


public class SesionUsuario implements ActionListener{
	
	private static int i;
	private static Cliente cliente, cln;
	private static String nombreEvento;
	private static Frame frame;
	private static Button botonModificarUs, botonRegresar, botonComprar;
	private static Label etiquetanombre, etiquetaubicacion, etiquetavendedor, etiquetacompra, fechaEvento, fechaamd; 
	private static ChoiceLista ubicacion, vendedor;
	private static Text tEntradas;
	private static Radio rad1, rad2, rad3, rad4, rad5;
	private static ButtonGroup grupoRadio;
	private static ArrayList<String> listaNombres;
	private static List<String> nombreeventos, vendedores;
	private static List<Vendedor> vend;
	private static List<Evento> ev;
	
	public static void sesionUsuario(Cliente usuario) {
	
		cliente = new Cliente(usuario);
		
		
		//FRAME SESION USUARIO
		frame = new Frame("-USUARIO: " + cliente.getNombreUsuario() + ".", 910, 480, "/imagenes/FondoCreador.png");
		
		//BOTON MODIFICAR USUARIO
		botonModificarUs = new Button("Modificar Usuario", 720, 20, 160, 30, true);
						
		botonModificarUs.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {	
								
				ModificarUsuario.modificarUsuario(cliente);
				frame.setVisible(false);
											
			}
						
		});
				
		//BOTON REGRESO
		botonRegresar = new Button("Regresar", 20, 410, 90, 20, true);
				
		botonRegresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PanelUsuario.frameBotonUsuario();
								
			}
							
		});
		
		//ETIQUETA NOMBRE EVENTO
		etiquetanombre = new Label("Nombre del Evento:", 30, 140, 190, 40);
		
		//NOMBRES DEL EVENTO EN RADIOS
		listaNombres = new ArrayList<String>();
		nombreeventos = funciones.EventosCreadosNombre.eventos();
		
		grupoRadio = new ButtonGroup();
		
		for(String e: nombreeventos) {
				
			
			listaNombres.add(e);
			
			i++;
			
		}
		
		i--;
		
		while(i!=-1) {
			
			if(i==4) {
				rad5 = new Radio(listaNombres.get(i), 30, 270, 190, 20);
				grupoRadio.add(rad5);
				
				frame.add(rad5);
				rad5.addActionListener(new ActionListener(){

					
					public void actionPerformed(ActionEvent e) {
						
						if(rad5.isSelected()) {
							
							nombreEvento = rad5.getText();
							try {
								NradioEvento(nombreEvento);
							} catch (DAOException | ServiceException e1) {
								
								e1.printStackTrace();
							}
						}
					}
				});
				
			}
			if(i==3) {
				rad4 = new Radio(listaNombres.get(i), 30, 250, 190, 20);
				rad4.addActionListener(new ActionListener(){

					
					public void actionPerformed(ActionEvent e) {
						if(rad4.isSelected()) {
							
							
							nombreEvento = rad4.getText();
							try {
								NradioEvento(nombreEvento);
							} catch (DAOException | ServiceException e1) {
								
								e1.printStackTrace();
							}
							
						}
						
					}
					
				});
				
				grupoRadio.add(rad4);
				frame.add(rad4);
			}
			if(i==2) {
				rad3 = new Radio(listaNombres.get(i), 30, 230, 190, 20);
				rad3.addActionListener(new ActionListener(){

					
					public void actionPerformed(ActionEvent e) {
						if(rad3.isSelected()) {
							
							nombreEvento = rad3.getText();
							try {
								NradioEvento(nombreEvento);
							} catch (DAOException | ServiceException e1) {
								
								e1.printStackTrace();
							}
						}
						
					}
					
				});
				
				grupoRadio.add(rad3);
				frame.add(rad3);
			}
			if(i==1) {
				rad2 = new Radio(listaNombres.get(i), 30, 210, 190, 20);
				rad2.addActionListener(new ActionListener(){

					
					public void actionPerformed(ActionEvent e) {
						if(rad2.isSelected()) {
					
							nombreEvento = rad2.getText();
							try {
								NradioEvento(nombreEvento);
							} catch (DAOException | ServiceException e1) {
								
								e1.printStackTrace();
							}
							
						}
						
					}
					
				});
				
				grupoRadio.add(rad2);
				frame.add(rad2);
			}
			if(i==0) {
				rad1 = new Radio(listaNombres.get(i), 30, 190, 190, 20);
				rad1.addActionListener(new ActionListener(){

					
					public void actionPerformed(ActionEvent e) {
						if(rad1.isSelected()) {
							
							nombreEvento = rad1.getText();
							try {
								NradioEvento(nombreEvento);
							} catch (DAOException | ServiceException e1) {
								
								e1.printStackTrace();
							}
							
						}
						
					}
					
				});
				
				grupoRadio.add(rad1);
				frame.add(rad1);
			}
			i--;
		}
		
		
		
		//ETIQUETA UBICACION
		etiquetaubicacion = new Label("Ubicación:", 240, 140, 190, 40);
		
		//CAJA DE INGRESO UBICACIONES
		ubicacion = new ChoiceLista(240, 190, 190, 60);
		List<String> ubicaciones = new ArrayList<String>();
		
		EventoServicio user1 = new EventoServicio();
				
		try {
			ubicaciones = user1.mostrarUbicacionesEvento(nombreEvento);
			ubicacion.setEnabled(true);
			
		} catch (DAOException e3) {
			e3.printStackTrace();
		} catch (ServiceException e3) {
			e3.printStackTrace();
		}
							
		for(String e1: ubicaciones) {
										
			ubicacion.addItem(e1);
		}
				
	
					
		//ETIQUETA NOMBRES VENDEDORES
		etiquetavendedor = new Label("Vendedor:", 450, 140, 190, 40);
			
		//CAJA DE VENDEDORES
		vendedor = new ChoiceLista(450, 190, 190, 40);	
		vendedor.setEnabled(false);
		vendedores = new ArrayList<String>();						
		EventoServicio user = new EventoServicio();
				
		String u = (String) ubicacion.getSelectedItem();
							
		try {
			
			vendedores = user.mostrarVendedoresEvento(nombreEvento, u);
			vendedor.setEnabled(true);
			
		}catch(ServiceException e) {
			e.printStackTrace();
		}catch(DAOException e1) {
			e1.printStackTrace();
		}
		for(String e1: vendedores) {
									
			vendedor.addItem(e1);
		}
		
				
		//ETIQUETA COMPRA
		etiquetacompra = new Label("Entradas:", 660, 140, 190, 40);
																
		//TEXTO ENTRADAS
		tEntradas = new Text(660, 190, 190, 20);
		
		//FECHA DEL EVENTO
		fechaEvento = new Label("", 345, 240, 250, 30);
		fechaamd = new Label("", 345, 280, 250, 30);
				
		//BOTON COMPRAR ENTRADAS
		botonComprar = new Button("Comprar", 780, 410, 90, 20, true);	
		botonComprar.addActionListener(new ActionListener() {
							
			public void actionPerformed(ActionEvent e) {
						
				String u = (String) ubicacion.getSelectedItem();
				int x = Integer.parseInt(tEntradas.getText());	
				String v = (String) vendedor.getSelectedItem();
				vend = new ArrayList<>();
				
				
				VendedorServicio ven = new VendedorServicio();
				UsuarioServicio user = new UsuarioServicio();
				EventoServicio ev = new EventoServicio();
				
						
				try {
					if(x < ven.muestraBoletosVendedor(v)) {
						
						try {
							
							
							Mensajes.informacion("Has comprado "+ x +" entrada/as.");
							vend = ven.listaTodosLosVendedores();
							
							for(Vendedor v1: vend) {
												
								if(v.equals(v1.getNombreUsuario())) {
									//TODO
									cln = new Cliente(cliente, x);
									user.insertarTablaVentas(usuario, v, u);
									user.actualizaEntradasCliente(cln);
									ven.actualizaVendedor(v, x);
									ev.actualizaEntradasEvento(nombreEvento, u, x);
																
														
								}
							}
				
										
						}catch(ServiceException e1) {
							e1.printStackTrace();
						}catch(DAOException e2) {
							e2.printStackTrace();
						}
													
											
					}else {
						
						Mensajes.aviso("El vendedor seleccionado no tiene entradas que vender.");
					}
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}
			}
									
			});
		
						
	frame.add(etiquetavendedor);
	frame.add(vendedor);
	frame.add(etiquetacompra);
	frame.add(tEntradas);
	frame.add(botonComprar);
	frame.add(etiquetaubicacion);
	frame.add(ubicacion);		
	frame.add(fechaEvento);
	frame.add(fechaamd);
	
	frame.add(etiquetanombre);
	frame.add(botonModificarUs);
	frame.add(botonRegresar);
		
	frame.setVisible(true);
		
	}
	

	private static void NradioEvento(String nombreEvento) throws DAOException, ServiceException {
		
		
		//UBICACION
		ubicacion.removeAll();
		List<String> ubicaciones = new ArrayList<String>();
		EventoServicio user1 = new EventoServicio();
		   
		try {
			ubicaciones = user1.mostrarUbicacionesEvento(nombreEvento);
				
			for(String e1: ubicaciones) {
				
				ubicacion.addItem(e1);
				
			}
			ubicacion.setVisible(true);
			ubicacion.setEnabled(true);
			
		} catch (DAOException e3) {
			e3.printStackTrace();
		} catch (ServiceException e3) {
			e3.printStackTrace();
		}
			
		
		
		
		//VENDEDOR
		
		vendedor.removeAll();
		vendedores = new ArrayList<String>();						
		
				
		String u = (String) ubicacion.getSelectedItem();
							
		try {
			
			vendedores = user1.mostrarVendedoresEvento(nombreEvento, u);
			vendedor.setEnabled(true);
			for(String s: vendedores) {
				
				vendedor.addItem(s);
			}
			vendedor.setVisible(true);
			
		}catch(ServiceException e0) {
			e0.printStackTrace();
		}catch(DAOException e2) {
			e2.printStackTrace();
		}
		
		
		//FECHA EVENTO
		ev = new ArrayList<Evento>();
		
		
		try {
			ev = user1.listaTodosLosEventos();
			for(Evento e: ev) {
				
				if(e.getNombre().equals(nombreEvento) && e.getUbicacion().equals(u)) {
					
					String a = String.valueOf(e.getAnio());
					String m = String.valueOf(e.getMes());
					String d = String.valueOf(e.getDia());
					
					fechaEvento.setText("Fecha Del Evento:");
					fechaamd.setText(a + "/" + m + "/" + d);
					
				}
			
			}
			
		}catch(DAOException | ServiceException e3) {
			e3.printStackTrace();
		}
		
		
		
	}


	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==rad1 || e.getSource()==rad2 || e.getSource()==rad3 || e.getSource()==rad4 || e.getSource()==rad5) {
			
		}
		try {
			NradioEvento(nombreEvento);
			
		} catch (DAOException | ServiceException e1) {
			e1.printStackTrace();
		
		}
	}

}
