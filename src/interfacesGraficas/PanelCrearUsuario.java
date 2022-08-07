package interfacesGraficas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import entidades.Usuario;
import estructura.Button;
import estructura.Frame;
import estructura.Label;
import estructura.Password;
import estructura.Text;
import exeptions.ClaveDuplicadaException;
import exeptions.DAOException;
import exeptions.Mensajes;
import exeptions.ServiceException;
import servicio.UsuarioServicio;

public class PanelCrearUsuario {
	
	private static Frame frame;
	private static Button botonCrear, botonRegreso;
	private static Label titulo, etiquetanombre, etiquetaemail, etiquetapass, etiquetacpass;
	private static Text tfnombre, tfemail;;
	private static Password tfpass, tfcpass;
	private static char[] pass, cpass;
	private static String password, cpassword, nombre, email;
	private static List<String> listUsuarionombre, listUsuarioemail;
	private static List<Usuario> listUsuario;
	
	
	
public static void frameCrearUsuario() {
		
		//FRAME CREAR USUARIO
		frame = new Frame("-CREAR USUARIO", 910, 480, "/imagenes/FondoCreador.png");
		
		//TITULO CREAR USUARIO
		titulo = new Label("Complete los campos para crear una cuenta.", 275, 25, 400, 90);
		
		
		//ETIQUETA NOMBRE USUARIO
		 etiquetanombre = new Label("Usuario: ", 123, 150, 110, 30);
		
		//CAJA DE TEXTO NOMBRE USUARIO
		tfnombre = new Text(255, 150, 130, 30);
		
		
		//ETIQUETA EMAIL
		etiquetaemail = new Label("Email: ", 123, 200, 110, 30);
				
		//CAJA DE TEXTO EMAIL
		tfemail = new Text(255, 200, 130, 30);
		
		
		//ETIQUETA PASS
		etiquetapass = new Label("Contraseña: ", 123, 250, 140, 30);
				
		//CAJA DE CONTRASEÑA 
		tfpass = new Password(255, 250, 130, 30);
		
		//ETIQUETA CONFIRM PASS
		etiquetacpass = new Label("Contraseña*: ", 123, 300, 140, 30);
				
		//CAJA DE CONFIRMAR CONTRASEÑA 
		tfcpass = new Password(255, 300, 130, 30);
		
		
				
		//BOTON CREAR
		botonCrear = new Button("Crear", 490, 225, 110, 30, true);
		
		botonCrear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 
				pass = tfpass.getPassword();
				password = new String(pass);
				
				cpass = tfcpass.getPassword();
				cpassword = new String(cpass);
				nombre = tfnombre.getText();
				email = tfemail.getText();
				
				listUsuario = new ArrayList<Usuario>();
				listUsuarionombre = new ArrayList<String>();
				listUsuarioemail = new ArrayList<String>();
				
				int error = 0;
				
				if(pass != null && cpass != null && nombre != null && email != null) {
					if(password.equals(cpassword)) {
						Usuario user = new Usuario(nombre, email, password);
						UsuarioServicio usuario = new UsuarioServicio();
				
						try {
							listUsuario = usuario.listaTodosLosUsuarios();
							for(Usuario u: listUsuario) {
								listUsuarionombre.add(u.getNombreUsuario());
								listUsuarioemail.add(u.getEmail());
							}
							
							for(String n: listUsuarionombre) {
								
								if(user.getNombreUsuario().equals(n)) { 
									
									Mensajes.alerta("El nombre de usuario ya existe");
									error++;
								}
							}
							
							for(String e1: listUsuarioemail) {
								
								if(user.getEmail().equals(e1)) {
									
									Mensajes.alerta("El email ya existe");
									error++;
								}
							}
					
						} catch (DAOException | ServiceException e2) {
							
							e2.printStackTrace();
						}
				
				
				
						if(error == 0) {
							try {
							
								Mensajes.informacion("Cuenta creada correctamente");
								usuario.crearUsuario(user);
							
								
							} catch(DAOException | ServiceException | ClaveDuplicadaException e1) {
								e1.printStackTrace();
					
							}
							
						}else {
							Mensajes.informacion("Cambie los campos mencionados");
						}
					}else {
						Mensajes.alerta("Las contraseñas no coinciden");
					
					
					}
				}else {
					Mensajes.alerta("Complete todos los campos.");
				}
			}
			
		});
		
		//BOTON REGRESO
		botonRegreso = new Button("Regresar", 20, 410, 90, 20, true);
		
		botonRegreso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PanelUsuario.frameBotonUsuario();
						
			}
					
		});
		
		frame.add(titulo);
		frame.add(etiquetanombre);
		frame.add(tfnombre);
		frame.add(etiquetaemail);
		frame.add(tfemail);
		frame.add(etiquetapass);
		frame.add(tfpass);
		frame.add(etiquetacpass);
		frame.add(tfcpass);
		
		frame.add(botonCrear);
		frame.add(botonRegreso);
		
		frame.setVisible(true);
	}

}
