package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import entidades.Cliente;
import estructura.Button;
import estructura.Frame;
import estructura.Label;
import estructura.Password;
import estructura.Text;
import exeptions.Mensajes;
import exeptions.ServiceException;
import servicio.UsuarioServicio;

public class ModificarUsuario {

	private static Frame frame;
	private static Text tfnombre;
	private static Label etiquetanombre, etiquetapass;
	private static Password pass;
	private static Button botonModificar, botonRegresar;
	private static char[] cpass;
	private static String nombre, contraseña;
	
	public static void modificarUsuario(Cliente usuario) {
		
		frame = new Frame("-Modificar Usuario: " + usuario.getNombreUsuario() + ".", 480, 360, "/imagenes/FondoCreador.png");
		
		//CAJA DE TEXTO NOMBRE USUARIO
		tfnombre = new Text(170, 75, 130, 30);
		
		//ETIQUETA NOMBRE USUARIO
		etiquetanombre = new Label("Usuario: ", 50, 75, 160, 30);
		
		//ETIQUETA PASS
		etiquetapass = new Label("Crontraseña: ", 50, 175, 160, 30);
		
		//CAJA DE CONTRASEÑA 
		pass = new Password(170, 175, 130, 30);
		
		//BOTON MODIFICAR
		botonModificar = new Button("MODIFICAR", 320, 128, 110, 30, true);
		
		botonModificar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				cpass = pass.getPassword();
				nombre = tfnombre.getText();
				contraseña = new String(cpass);
				
				UsuarioServicio user = new UsuarioServicio();
				usuario.setNombreUsuario(nombre);
				usuario.setPassUsuario(contraseña);

				try {
					user.actualizaUsuario(usuario);
					Mensajes.informacion("Se actualizo el usuario con mail: "+ usuario.getEmail() +".");
					frame.setVisible(false);
					PanelUsuario.frameBotonUsuario();
					
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}	
				
			}
			
		});
		
		//BOTON REGRESO
		botonRegresar = new Button("Regresar", 20, 290, 90, 20, true);
		
		botonRegresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SesionUsuario.sesionUsuario(usuario);
						
			}
					
		});
		
		frame.add(etiquetanombre);
		frame.add(tfnombre);
		frame.add(etiquetapass);
		frame.add(pass);
		frame.add(botonModificar);
		frame.add(botonRegresar);
		
		frame.setVisible(true);
		
	}
}
