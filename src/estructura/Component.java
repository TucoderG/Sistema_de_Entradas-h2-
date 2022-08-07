package estructura;

import java.awt.Dimension;

import javax.swing.JComponent;

public class Component extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x;
	private int y;
	private int altura;
	private int largo;
	

	public Component(int x, int y, int altura, int largo) {
		
		this.x = x;
		this.y = y;
		this.altura = altura;
		this.largo = largo;
		
		this.setBounds(this.x, this.y, this.altura, this.largo);
	}



	public Component(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		this.setSize(new Dimension(this.x, this.y));
	}

}
