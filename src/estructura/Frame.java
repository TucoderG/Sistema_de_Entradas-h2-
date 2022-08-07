package estructura;

import javax.swing.*;


import java.awt.*;

public class Frame extends JFrame {
	        
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private Panel fondo;
	private String imagen;
	private Component comp;
	
	public Frame() {
		
	}
	
	public Frame(String titulo, int x, int y, String imagen) {
		
		this.titulo = titulo;
		this.imagen = imagen;
		
		this.comp = new Component(x, y);
		
		this.setBounds(this.comp.getBounds());
		
		this.frameInit();
		
		
		fondo = new Panel(this.imagen);
		
		this.setTitle(this.titulo);
		
		this.setLocationRelativeTo(null);
		this.setContentPane(fondo);
		this.setLayout(null);
		this.setResizable(false);
		this.setBackground(Color.BLACK);
			
		this.getContentPane().setBackground(Color.BLACK);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
}