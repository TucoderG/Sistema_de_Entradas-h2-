package funciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import entidades.Cliente;
import estructura.Button;
import estructura.Frame;
import estructura.ModeloDatos;

public class MostrarCliente {

	
	private static String titColumna[];
	private static String datoColumna[][];
	private static JScrollPane panelScroll, panel;
	private static Cliente u;
	private static Frame frame;
	private static JTable tabla;
	private static Button bRegresar;
	
	public static void mostrarCliente(Cliente user) {
		
		u = user;
		
		//FRAME
		frame = new Frame("-CLIENTE: ",520, 200, "/imagenes/FondoCreador.png");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
		//TABLA
		tabla = new JTable( new ModeloDatos());
		panel = new JScrollPane( tabla );
				 
		frame.add( panel);
				 
		CreaColumnas();
		CargaDatos();
		tabla = new JTable( datoColumna,titColumna );
		tabla.setBounds(20, 20, 160, 30);
		tabla.setShowHorizontalLines( false );
		tabla.setRowSelectionAllowed( true );
		tabla.setColumnSelectionAllowed( true );
				
		tabla.setSelectionForeground( Color.white );
		tabla.setSelectionBackground( Color.red );
		panelScroll = new JScrollPane(tabla);
		panelScroll.setBounds(50, 65, 400, 40);
		frame.add( panelScroll, BorderLayout.CENTER);
		
		//BOTON REGRESO
		bRegresar = new Button("Regresar", 15, 128, 90, 18, true);
				
		bRegresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
										
			}
									
		});
				
		frame.add(bRegresar);
		frame.setVisible(true);
	}
	
	public static void CreaColumnas() {
		titColumna = new String[4];
		    
		for( int i=0; i < 4; i++ ) {
			if(i==0) {
				titColumna[i] = "NOMBRE";
			}
			if(i==1) {
				titColumna[i] = "EMAIL";
			}
			if(i==2) {
				titColumna[i] = "CONTRASEÑA";
			}
			if(i==3) {
				titColumna[i] = "ENTRADAS_COMPRADAS";
			}
			
		}
	}
		  
	public static void CargaDatos() {
		
		datoColumna = new String[1][4];
		  
		for( int iY=0; iY<1; iY++ ) {
				
				for( int iX=0; iX < 4; iX++ ) {
					
					if(iX==0) {
						datoColumna[iY][iX] = u.getNombreUsuario();
					}
					if(iX==1) {
						datoColumna[iY][iX] = u.getEmail();
					}
					if(iX==2) {
						datoColumna[iY][iX] = u.getPassUsuario();
					}
					if(iX==3) {
						
						String entradas = Integer.toString(u.getEntrada());
						datoColumna[iY][iX] = entradas;
						
					}
				}
				
		}
	}
	
	
}
