package funciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import entidades.Usuario;
import estructura.Frame;
import estructura.ModeloDatos;


public class MostrarListadoUsuarios {
	
	private static String titColumna[];
	private static String datoColumna[][];
	private static JScrollPane panelScroll, panel;
	private static List<Usuario> listaUsuario;
	private static JTable tabla;
	private static Frame frame;
	
	public static void mostrarLista(List<Usuario> usuario) {
		
		listaUsuario = usuario;
		
		//FRAME
		frame = new Frame("-LISTA DE USUARIOS", 910, 480, "/imagenes/Fondo-Eventos.jpg");
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
		titColumna = new String[3];
		    
		for( int i=0; i < 3; i++ ) {
			if(i==0) {
				titColumna[i] = "NOMBRE";
			}
			if(i==1) {
				titColumna[i] = "EMAIL";
			}
			if(i==2) {
				titColumna[i] = "CONTRASEÑA";
			}
			
		}
	}
		  
	public static void CargaDatos() {
		
		datoColumna = new String[100][3];
		  
		for( int iY=0; iY<100; iY++ ) {
			
			for(Usuario u:listaUsuario) {
				
				for( int iX=0; iX < 3; iX++ ) {
					
					if(iX==0) {
						datoColumna[iY][iX] = u.getNombreUsuario();
					}
					if(iX==1) {
						datoColumna[iY][iX] = u.getEmail();
					}
					if(iX==2) {
						datoColumna[iY][iX] = u.getPassUsuario();
					}
				}
				iY++;
			}
			iY += 1000;
				
		}
	}
	
}
