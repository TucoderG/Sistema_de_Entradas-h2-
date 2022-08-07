package funciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import entidades.Evento;
import entidades.Vendedor;
import estructura.Button;
import estructura.ChoiceLista;
import estructura.Frame;
import estructura.Label;
import estructura.Password;
import estructura.Text;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;
import exeptions.Mensajes;
import exeptions.ServiceException;
import interfacesGraficas.PanelAdministrativo;
import servicio.EventoServicio;
import servicio.VendedorServicio;

public class PanelCrearCuentaVendedor {
	
	private static Frame frame;
	private static Label etiquetaNombreCuenta, etiquetaPassCuenta, etiquetaNombreEvento, etiquetaUbicacion, etiquetaVoletos;
	private static Text nombreCuenta, tBoletos;
	private static List<Evento> nombreEventos, ubicacionEventos;
	private static ChoiceLista nombreEvento, ubicacionEvento;
	private static Button bRegreso, bCrearVnd;
	private static char[] pass;
	private static String password, nombre, ubicacion;
	private static int x;
	private static Password passCuenta;
	private static List<Vendedor> v;
	
	
	public static void crearCuenta() {
		
		//FRAME 
		frame = new Frame("-Crear Cuenta Vendedor", 910, 480, "/imagenes/Fondo-Eventos.jpg");
		
		//ETIQUETA NOMBRE DE CUENTA
		etiquetaNombreCuenta = new Label("Nombre Vendedor: ", 150, 120, 190, 40);
		//INSERTAR NOMBRE DE CUENTA
		nombreCuenta = new Text(150, 150, 150, 30);
		
				
		//ETIQUETA CONTRASEÑA DE CUENTA
		etiquetaPassCuenta = new Label("Contraseña: ", 150, 220, 150, 40);	
		//INSERTAR CONTRASEÑA DE CUENTA
		passCuenta = new Password(150, 250, 150, 30);
		
				
		//ETIQUETA NOMBRE EVENTO
		etiquetaNombreEvento = new Label("Nombre Evento: ", 430, 100, 190, 40);
		//CAJA DE INGRESO NOMBRE EVENTO
		nombreEvento = new ChoiceLista(430, 150, 150, 40);
		nombreEventos = new ArrayList<Evento>();
				
		EventoServicio user = new EventoServicio();
				
		try {
			nombreEventos = user.listaTodosLosEventos();
		} catch (DAOException e3) {
			e3.printStackTrace();
		} catch (ServiceException e3) {
			e3.printStackTrace();
		}
		for(Evento e: nombreEventos) {
							
			nombreEvento.addItem(e.getNombre());
		}
						
		
				
		//ETIQUETA UBICACION EVENTO
		etiquetaUbicacion = new Label("Ubicacion: ", 600, 100, 110, 40);
				
		//CAJA DE INGRESO UBICACIONES
		ubicacionEvento = new ChoiceLista(600, 150, 150, 40);
		ubicacionEventos = new ArrayList<Evento>();
				
		try {
			ubicacionEventos = user.listaTodosLosEventos();
		} catch (DAOException e3) {
			e3.printStackTrace();
		} catch (ServiceException e3) {
			e3.printStackTrace();
		}
		for(Evento e: ubicacionEventos) {
							
			ubicacionEvento.addItem(e.getUbicacion());
		}
						
		
		
		//ETIQUETA BOLETOS
		etiquetaVoletos = new Label("Boletos: ", 430, 220, 150, 40);
		
		//BOLETOS PARA VENDER
		tBoletos = new Text(420, 250, 150, 30);
		
		
				
				
		//BOTON CREAR VENDEDOR
		bCrearVnd = new Button("CREAR", 600, 250, 110, 30, true);
		
		bCrearVnd.addActionListener(new ActionListener() {

					
			public void actionPerformed(ActionEvent e) {
						
				pass = passCuenta.getPassword();
				password = new String(pass);
						
				nombre = (String) nombreEvento.getSelectedItem();
				ubicacion = (String) ubicacionEvento.getSelectedItem();
						
				x = Integer.parseInt(tBoletos.getText());
						
				VendedorServicio user = new VendedorServicio();
						
				try {
					if (x <= user.muestraCapacidadEvento(nombre, ubicacion)) {
								
						Vendedor vendedor = new Vendedor(nombreCuenta.getText(), password, nombre, ubicacion, x);
							
						try {
							v = user.listaTodosLosVendedores();
							for(Vendedor h: v) {
								if(vendedor.getNombreUsuario().equals(h.getNombreUsuario())) {
									
								}else {
									user.crearVendedor(vendedor);
									Mensajes.informacion("Cuenta creada correctamente");
								}
							}
							
								
						}catch (DAOException | ServiceException e2) {
								
							e2.printStackTrace();
						} catch (ClaveDuplicadaException e1) {
								
							e1.printStackTrace();
						}
							
					}else {
								
						Mensajes.aviso("El evento con la ubicacion seleccionada ya no tiene más entradas. Seleccione otra ubicacion u otra cantidad de voletos para vender.");
					}
				} catch (ServiceException e1) {
							
					e1.printStackTrace();
				}
			}
					
		});
				
		//BOTON REGRESO
		bRegreso = new Button("Regresar", 20, 410, 90, 20, true);
				
		
		bRegreso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
						
				frame.setVisible(false);
				PanelAdministrativo.panelAdministrador();
										
			}
									
		});
				
		frame.add(etiquetaNombreCuenta);
		frame.add(nombreCuenta);
		frame.add(etiquetaPassCuenta);	
		frame.add(passCuenta);
		frame.add(etiquetaNombreEvento);
		frame.add(nombreEvento);
		frame.add(etiquetaUbicacion);
		frame.add(ubicacionEvento);
		frame.add(etiquetaVoletos);
		frame.add(tBoletos);
		frame.add(bCrearVnd);
		frame.add(bRegreso);
		
		frame.setVisible(true);
	}

}
