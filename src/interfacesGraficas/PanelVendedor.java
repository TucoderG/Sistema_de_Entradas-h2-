package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import entidades.Vendedor;
import estructura.Button;
import estructura.Frame;
import estructura.Label;
import estructura.Password;
import estructura.Text;
import exeptions.DAOException;
import exeptions.Mensajes;
import exeptions.ServiceException;
import servicio.VendedorServicio;

public class PanelVendedor {

	private static Frame frame;
	private static Label titulo, etiquetanombre, etiquetapass;
	private static Button bIniciar, bRegreso;
	private static Text tfnombre;
	private static Password tfpass;
	private static char[] pass;
	private static String clave, nombre;
	
	
public static void BotonVededor() {
		
		//FRAME INICIO USUARIO
		frame = new Frame("-INICIO DE SESIÓN: VENDEDOR", 910, 480, "/imagenes/1.jpg");
		
		//TITULO USUARIO
		titulo = new Label("Ingrese sus datos para iniciar sesion.", 275, 25, 350, 90);
		
		
		
		//ETIQUETA NOMBRE
		etiquetanombre = new Label("Usuario: ", 146, 150, 110, 40);
		//CAJA DE TEXTO NOMBREUSUARIO
		tfnombre = new Text(255, 150, 130, 40);
		
		
		//ETIQUETA PASS
		etiquetapass = new Label("Contraseña: ", 146, 250, 160, 40);
		//CAJA DE CONTRASEÑA
		tfpass = new Password(255, 250, 130, 40);
		
		
		
		//BOTON INICIAR SESIÓN
		bIniciar = new Button("Ingresar", 465, 200, 110, 40, true);
		
		bIniciar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				pass = tfpass.getPassword();
				clave = new String(pass);
				nombre = tfnombre.getText();
				
				VendedorServicio user = new VendedorServicio();
				
				List<Vendedor> listVendedor = new ArrayList<Vendedor>();
							
				int i = 0;
				
				try {
					
					listVendedor = user.listaTodosLosVendedores();	
					
					for(Vendedor v: listVendedor) {
						
						if(nombre.equals(v.getNombreUsuario()) && clave.equals(v.getPassUsuario())) {
							
							Vendedor usuario = new Vendedor(nombre, clave, v.getEvento(),v.getUbicacion(), v.getBoletos());
							i++;
							frame.setVisible(false);
							SesionVendedor.botonVendedor(usuario);
	
							
						}
						
					}
					if(i == 0) {
					
						Mensajes.alerta("Usuario ingresado no existe.");
					}
					
				} catch (DAOException e1) {
					e1.printStackTrace();
					
				} catch (ServiceException e1) {
				e1.printStackTrace();
					
				}
				
			}

		});
		
		//BOTON REGRESO
		bRegreso = new Button("Regresar",20, 410, 90, 20, true);
		
		bRegreso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Inicio.CrearInicio();
				
			}
			
		});
		
		
		frame.add(titulo);
		frame.add(etiquetanombre);
		frame.add(tfnombre);
		frame.add(etiquetapass);
		frame.add(tfpass);
		frame.add(bIniciar);
		frame.add(bRegreso);
		
		frame.setVisible(true);
	}

}
