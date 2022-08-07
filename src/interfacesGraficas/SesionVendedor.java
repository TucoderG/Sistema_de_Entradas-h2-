package interfacesGraficas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import entidades.Vendedor;
import entidades.Ventas;
import estructura.Button;
import estructura.Frame;
import estructura.Label;
import exeptions.ServiceException;
import funciones.MostrarVentas;
import servicio.VendedorServicio;

public class SesionVendedor {
	
	private static Frame frame;
	private static Label nombreEstadio, txtEstadio, etiquetaBoletos;
	private static Button bClientes, bRegreso;
	private static List<Ventas> lista;
	
	public static void botonVendedor(Vendedor usuario) {
		
		//FRAME 
		frame = new Frame("-Vendedor", 710, 400, "/imagenes/Bombonera.jpg");
		
		//ETIQUETA BOLETOS PARA VENDER
		etiquetaBoletos = new Label("Boletos para vender: " + usuario.getBoletos(), 30, 50, 250, 40);
		etiquetaBoletos.setForeground(Color.BLACK);
		
		//ETIQUETA NOMRBRE ESTADIO
		txtEstadio = new Label("Nombre del evento: ", 470, 50, 250, 40);
		txtEstadio.setForeground(Color.BLACK);
		//ETIQUETA NOMRBRE ESTADIO
		nombreEstadio = new Label(usuario.getEvento(), 490, 80, 250, 40);
		nombreEstadio.setForeground(Color.BLACK);
		
		//BOTON CLIENTES
		bClientes = new Button("Clientes", 580, 320, 110, 30, true);
		
		bClientes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				lista = new ArrayList<>();
				VendedorServicio us = new VendedorServicio();
				
				try {
					lista = us.listaTodasLasVentas(usuario);
					MostrarVentas.mostrarLista(lista, usuario);
					frame.setVisible(false);
					
				}catch(ServiceException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		//BOTON REGRESO
		bRegreso = new Button("Regresar", 20, 330, 90, 20, true);
		
		bRegreso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PanelVendedor.BotonVededor();
										
			}
									
		});
		
	
			
		frame.add(etiquetaBoletos);
		frame.add(txtEstadio);
		frame.add(nombreEstadio);
		frame.add(bClientes);
		frame.add(bRegreso);
		
		frame.setVisible(true);
	}
}
