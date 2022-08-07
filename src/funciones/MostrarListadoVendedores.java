package funciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import estructura.Frame;
import entidades.Vendedor;
import estructura.ModeloDatos;



public class MostrarListadoVendedores {
	
	private static String titColumna[];
	private static String datoColumna[][];
	private static JScrollPane panelScroll, panel;
	private static List<Vendedor> listaVendedor;
	private static JTable tabla;
	private static Frame frame;
	
	public static void mostrarLista(List<Vendedor> listaUsuario) {
		
		listaVendedor = listaUsuario;
		
		//FRAME
		frame = new Frame("-Lista De Vendedores", 910, 480, "/imagenes/Fondo-Eventos.jpg");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//TABLA
		tabla = new JTable( new ModeloDatos());
		panel = new JScrollPane( tabla );
		 
		frame.add( panel);
		 
		CreaColumnas();
		CargaDatos();
		tabla = new JTable( datoColumna,titColumna );
		tabla.setBounds(200, 40, 130, 40);
		tabla.setShowHorizontalLines( false );
		tabla.setRowSelectionAllowed( true );
		tabla.setColumnSelectionAllowed( true );
		
		tabla.setSelectionForeground( Color.white );
		tabla.setSelectionBackground( Color.red );
		panelScroll = new JScrollPane(tabla);
		panelScroll.setBounds(200, 60, 500, 275);
		frame.add( panelScroll, BorderLayout.CENTER);
				
		frame.setVisible(true);
	}
	
	public static void CreaColumnas() {
		titColumna = new String[4];
		    
		for( int i=0; i < 4; i++ ) {
			if(i==0) {
				titColumna[i] = "VENDEDOR";
			}
			if(i==1) {
				titColumna[i] = "CONTRASEÑA";
			}
			if(i==2) {
				titColumna[i] = "EVENTO";
			}
			if(i==3) {
				titColumna[i] = "BOLETOS";
			}
		}
	}
		  
	public static void CargaDatos() {
		datoColumna = new String[100][4];
		  
		
			
		for( int iY=0; iY<100; iY++ ) {
			
			for(Vendedor v: listaVendedor) {
				
				for( int iX=0; iX < 4; iX++ ) {
					
					if(iX==0) {
						datoColumna[iY][iX] = v.getNombreUsuario();
					}
					if(iX==1) {
						datoColumna[iY][iX] = v.getPassUsuario();
					}
					if(iX==2) {
						datoColumna[iY][iX] = v.getEvento();
					}
					if(iX==3) {
						
						String bol = Integer.toString(v.getBoletos());
						datoColumna[iY][iX] = bol;
					}
				}
				iY++;
			}
			iY += 1000;
				
		}
	}

}
