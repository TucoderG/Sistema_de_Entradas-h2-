package funciones;

import java.awt.BorderLayout;
import java.awt.Color;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import entidades.Evento;

import estructura.Frame;
import estructura.ModeloDatos;


public class MostrarEventos {
	
	private static String titColumna[];
	private static String datoColumna[][];
	private static JScrollPane panelScroll, panel;
	private static List<Evento> listaEvento;
	private static JTable tabla;
	private static Frame frame;
	
	public static void mostrarLista(List<Evento> evento) {
		
		 listaEvento = evento;
		
		//FRAME
		frame = new Frame("-LISTA DE EVENTOS", 910, 480, "/imagenes/Fondo-Eventos.jpg");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
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
				
			
		frame.setVisible(true);
		
		}
		
	
	public static void CreaColumnas() {
		titColumna = new String[8];
		    
		for( int i=0; i < 8; i++ ) {
			if(i==0) {
				titColumna[i] = "NOMBRE";
			}
			if(i==1) {
				titColumna[i] = "UBICACION";
			}
			if(i==2) {
				titColumna[i] = "AÑO";
			}
			if(i==3) {
				titColumna[i] = "MES";
			}
			if(i==4) {
				titColumna[i] = "DIA";
			}
			if(i==5) {
				titColumna[i] = "CAPACIDAD";
			}
			if(i==6) {
				titColumna[i] = "PRECIO";
			}
			if(i==7) {
				titColumna[i] = "ENTRADAS VENDIDAS";
			}
			
		}
	}
		  
	public static void CargaDatos() {
		datoColumna = new String[100][8];
		  
		
			
		for( int iY=0; iY<100; iY++ ) {
			
			for(Evento v: listaEvento) {
				
				for( int iX=0; iX < 8; iX++ ) {
					
					if(iX==0) {
						datoColumna[iY][iX] = v.getNombre();
					}
					if(iX==1) {
						datoColumna[iY][iX] = v.getUbicacion();
					}
					if(iX==2) {
						
						datoColumna[iY][iX] = String.valueOf(v.getAnio());
					}
					if(iX==3) {
						
						datoColumna[iY][iX] = String.valueOf(v.getMes());
					}if(iX==4) {
						
						datoColumna[iY][iX] = String.valueOf(v.getDia());
					}if(iX==5) {
						
						datoColumna[iY][iX] = String.valueOf(v.getCapacidad());
					}if(iX==6) {
						
						datoColumna[iY][iX] = String.valueOf(v.getPrecio());
					}if(iX==7) {
						
						datoColumna[iY][iX] = String.valueOf(v.getEntradasVendidas());
					}
					
				}
				iY++;
			}
			iY += 1000;
				
		}
	}
}
