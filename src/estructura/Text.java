package estructura;

import javax.swing.JTextField;

public class Text extends JTextField{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Component comp;
	
	public Text() {
		
	}
	
	public Text(int x, int y, int altura, int largo) {
		
		this.comp = new Component(x, y, altura, largo);
		this.setBounds(this.comp.getBounds());
	}

}
