package funciones;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import entidades.Evento;
import estructura.Button;
import estructura.FormattedText;
import estructura.Frame;
import estructura.Label;
import estructura.Text;
import exeptions.Mensajes;
import exeptions.ServiceException;
import interfacesGraficas.PanelAdministrativo;
import servicio.EventoServicio;


public class PanelCrearEvento {
	
	private static Frame frame;
	private static Label etiquetaNombre, etiquetaUbicacion, etiquetaFecha, etiquetaCapacidad, etiquetaEntradas;
	private static Text nombreEvento, ubicacionEvento, tDia, tMes, tAnio;
	private static FormattedText capacidadEvento, precioEvento;
	private static Button bCrear, bRegresar;
	private static int dia, mes, anio, capacidad, precio;
	private static String s, s1;
	
	
	public static void crearEvento() throws ParseException{
		
		
		//FRAME 
		frame = new Frame("-CREADOR DE EVENTOS", 910, 480, "/imagenes/Fondo-Eventos.jpg");
				
		
		//ETIQUETA NOMBRE
		etiquetaNombre = new Label("Nombre del evento", 75, 100, 190, 40);
		//CAJA TEXTO NOMBRE
		nombreEvento = new Text(270, 100, 210, 40);
		
		//ETIQUETA UBICACION
		etiquetaUbicacion = new Label("Ubicacion del evento", 75, 150, 190, 40);
		//CAJA TEXTO UBICACION
		ubicacionEvento = new Text(270, 150, 210, 40);
		
		
		//ETIQUETA FECHA
		etiquetaFecha = new Label("Fecha del evento", 75, 200, 190, 40);	
		
		//CAJA DE INGRESO DIA
		tDia = new Text(270, 200, 50, 30);
		
		//CAJA DE INGRESO MES
		tMes = new Text(320, 200, 50, 30);
		
		//CAJA DE INGRESO ANIO
		tAnio = new Text(370, 200, 90, 30);
		
		//ETIQUETA CAPACIDAD
		etiquetaCapacidad = new Label("Capacidad del evento", 75, 250, 190, 40);
		//CAJA TEXTO CAPACIDAD
		MaskFormatter mascaraCapacidad = null;
		try {
			mascaraCapacidad = new MaskFormatter("#####");
		}catch(ParseException ev) {
			ev.printStackTrace();
		}
		
		capacidadEvento = new FormattedText(mascaraCapacidad, 270, 250, 210, 40);
		
		
		//ETIQUETA PRECIO
		etiquetaEntradas = new Label("Precio de las entradas", 75, 300, 190, 40);
		//CAJA TEXTO PRECIO
		MaskFormatter mascaraPrecio = null;
		try {
			
			mascaraPrecio = new MaskFormatter("####");
		}catch(ParseException el) {
			el.printStackTrace();
		}
		precioEvento = new FormattedText(mascaraPrecio, 270, 300, 210, 40);
			
		
		
		//BOTON CREAR
		bCrear = new Button("CREAR", 500, 175, 110, 40, true);
		
		bCrear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try {
						
					s = nombreEvento.getText();
					s1 = ubicacionEvento.getText();
					
					if(s == null || s1 == null) {
						Mensajes.alerta("Complete los campos faltantes.");
						
					}else {
						
						dia = Integer.parseInt(tDia.getText());
						mes = Integer.parseInt(tMes.getText());
						anio = Integer.parseInt(tAnio.getText());
						capacidad = Integer.parseInt(capacidadEvento.getText());
						precio = Integer.parseInt(precioEvento.getText());
						
						EventoServicio user = new EventoServicio();
					
						Evento evento = new Evento(s, s1, anio, mes, dia, capacidad, precio, 0);
				
						user.insertarEvento(evento);
						Mensajes.informacion("Evento creado correctamente");
					}
					
				}catch(ServiceException e1) {
					e1.printStackTrace();
					
				}
			}
			
		});
		
		
		
		//BOTON REGRESO
		bRegresar = new Button("Regresar", 20, 410, 90, 20, true);
		
		bRegresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PanelAdministrativo.panelAdministrador();
								
			}
							
		});
		
		frame.add(etiquetaNombre);
		frame.add(nombreEvento);
		frame.add(etiquetaUbicacion);
		frame.add(ubicacionEvento);
		frame.add(etiquetaFecha);
		frame.add(tDia);
		frame.add(tMes);
		frame.add(tAnio);
		frame.add(etiquetaCapacidad);
		frame.add(capacidadEvento);
		frame.add(etiquetaEntradas);
		frame.add(precioEvento);
		frame.add(bCrear);
		frame.add(bRegresar);
		
		frame.setVisible(true);
		
	}

	

}
