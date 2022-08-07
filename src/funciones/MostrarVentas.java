package funciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Vendedor;
import entidades.Ventas;
import estructura.Button;
import estructura.Frame;
import estructura.ModeloDatos;
import interfacesGraficas.SesionVendedor;

public class MostrarVentas {

	
	private static String titColumna[];
	private static String datoColumna[][];
	private static JScrollPane panelScroll, panel;
	private static List<Ventas> listaventas;
	private static JTable tabla;
	private static Frame frame;
	private static Button bRegresar;
	
	public static void mostrarLista(List<Ventas> usuario, Vendedor vendedor) {
		
		 listaventas = usuario;
		
		//FRAME
		frame = new Frame("-LISTA DE VENTAS", 910, 480, "/imagenes/FondoCreador.png");
		
		//TABLA
		tabla = new JTable( new ModeloDatos());
		panel = new JScrollPane( tabla );
						 
		frame.add( panel);
						 
		CreaColumnas();
		CargaDatos();
		tabla = new JTable( datoColumna,titColumna );
		tabla.setBounds(200, 40, 210, 40);
		tabla.setShowHorizontalLines( false );
		tabla.setRowSelectionAllowed( true );
		tabla.setColumnSelectionAllowed( true );
						
		tabla.setSelectionForeground( Color.white );
		tabla.setSelectionBackground( Color.red );
		panelScroll = new JScrollPane(tabla);
		panelScroll.setBounds(200, 60, 500, 275);
		frame.add( panelScroll, BorderLayout.CENTER);
				
		//BOTON REGRESO
		bRegresar = new Button("Regresar", 20, 410, 90, 20, true);
		
		bRegresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SesionVendedor.botonVendedor(vendedor);
										
			}
									
		});
				
			
		frame.add(bRegresar);
		frame.setVisible(true);
		
		
	}
	
	public static void CreaColumnas() {
		titColumna = new String[3];
		    
		for( int i=0; i < 8; i++ ) {
			if(i==0) {
				titColumna[i] = "NOMBRE_USUARIO";
			}
			if(i==1) {
				titColumna[i] = "BOLETOS_COMPRADOS";
			}
			if(i==2) {
				titColumna[i] = "UBICACION";
			}
			
		}
	}
		  
	public static void CargaDatos() {
		datoColumna = new String[100][3];
		  
		
			
		for( int iY=0; iY<100; iY++ ) {
			
			for(Ventas v: listaventas) {
				
				for( int iX=0; iX < 3; iX++ ) {
					
					if(iX==0) {
						datoColumna[iY][iX] = v.getNombre_cliente();
					}
					if(iX==1) {
						datoColumna[iY][iX] = String.valueOf(v.getBoletos_comprados());
					}
					if(iX==2) {
						
						datoColumna[iY][iX] = v.getUbicacion_evento();
					}
					
					
				}
				iY++;
			}
			iY += 1000;
				
		}
	}
}
