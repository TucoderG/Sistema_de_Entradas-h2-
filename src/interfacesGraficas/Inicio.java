package interfacesGraficas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import estructura.Button;
import estructura.Frame;
import estructura.Label;

public class Inicio {

	private static Frame frame;
	private static Button botonUsuario, botonVendedor, botonAdmin;
	private static Label titulo, texto, texto1;
	
	
	public static void CrearInicio() {
		
		
		frame = new Frame("Iniciar sección", 810, 540,"/imagenes/1.jpg");
		
		
		//BOTON USUARIO
		botonUsuario = new Button("USUARIO", 140, 348, 140, 50, true);
		botonUsuario.addActionListener(new ActionListener() {
						
			public void actionPerformed(ActionEvent e) {
				
				PanelUsuario.frameBotonUsuario();
				frame.setVisible(false);
				
				}	
			
			});
		
		//BOTON VENDEDOR
		botonVendedor = new Button("VENDEDOR", 330, 348, 140, 50, true);
		botonVendedor.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PanelVendedor.BotonVededor();
			}


		});
		
		//BOTON ADMINISTRADOR
		botonAdmin = new Button("ADMINISTRADOR", 520, 348, 140, 50, true);
		botonAdmin.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				PanelAdministrativo.panelAdministrador();
						
			}
			
					
		});
		
		titulo = new Label("Bienvenido/a:", 60, 30, 120, 70);
		
		texto = new Label("Elija una opcion para ingresar en la aplicacion", 190, 200, 500, 100);
		texto1 = new Label(" de venta de entradas.", 291, 235, 500, 100);
		
		frame.add(titulo);
		frame.add(botonUsuario);
		frame.add(botonVendedor);
		frame.add(botonAdmin);
		frame.add(texto);
		frame.add(texto1);
		
		frame.setVisible(true);
		
	}
	
}
