package interfacesGraficas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import entidades.Usuario;
import estructura.Button;
import estructura.Frame;
import estructura.Label;
import estructura.Password;
import estructura.Text;
import exeptions.DAOException;
import exeptions.Mensajes;
import exeptions.ServiceException;
import servicio.UsuarioServicio;

public class PanelUsuario {
	
	
	private static Frame frame;
	private static Label titulo, etiquetanombre, etiquetaemail, etiquetapass;
	private static Text tfnombre, tfemail;
	private static Password tfpass;
	private static Button botonRegreso, botonCrearUs, botonIniciar;
	private static String s, s1, s2;
	private static char[] c;
	

	public static void frameBotonUsuario() {
		
		//FRAME INICIO USUARIO
		frame = new Frame("-INICIO DE SESIÓN: USUARIO", 910, 480, "/imagenes/FondoCreador.png");
		
		//TITULO USUARIO
		titulo = new Label("Ingrese sus datos para iniciar sesion.", 275, 25, 350, 90);
		
		
		//ETIQUETA NOMBRE
		etiquetanombre = new Label("Usuario: ", 115, 150, 160, 30);
		//CAJA DE TEXTO NOMBREUSUARIO
		tfnombre = new Text(255, 150, 130, 30);
		
		
		//ETIQUETA EMAIL
		etiquetaemail = new Label("Email: ", 115, 220, 160, 30);	
		//CAJA DE TEXTO DE EMAIL
		tfemail = new Text(255, 220, 130, 30);
		
		
		//ETIQUETA PASS
		etiquetapass = new Label("Contraseña: ", 115, 290, 160, 30);		
		//CAJA DE CONTRASEÑA
		tfpass = new Password(255, 290, 130, 30);
		
		
		//BOTON CREAR USUARIO
		botonCrearUs = new Button("Crear Usuario", 465, 220, 140, 30, true);
		
		botonCrearUs.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				PanelCrearUsuario.frameCrearUsuario();
			}
			
		});
		
		//BOTON INICIAR SESIÓN
		botonIniciar = new Button("Ingresar", 465, 290, 140, 30, true);
		
		botonIniciar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				c = tfpass.getPassword();
				s = tfnombre.getText();
				s1 = tfemail.getText();
				s2 = new String(c);
				
				Cliente usuario = new Cliente(s, s1, s2);
				
				UsuarioServicio user = new UsuarioServicio();
				
				List<Usuario> listUsuario = new ArrayList<Usuario>();
							
				int i = 0;
				
				try {
					
					listUsuario = user.listaTodosLosUsuarios();	
					
					for(Usuario u: listUsuario) {
						
						if(s.equals(u.getNombreUsuario()) && s1.equals(u.getEmail()) && s2.equals(u.getPassUsuario())) {
							try {
								i++;
								frame.setVisible(false);
								SesionUsuario.sesionUsuario(usuario);
							}catch(Exception e1) {
								e1.printStackTrace();
							}
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
		botonRegreso = new Button("Regresar", 20, 410, 90, 20, true);
		
		botonRegreso.addActionListener(new ActionListener() {

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
		frame.add(etiquetaemail);
		frame.add(tfemail);
		
		frame.add(botonCrearUs);
		frame.add(botonIniciar);
		frame.add(botonRegreso);
		
		frame.setVisible(true);
	}

}
