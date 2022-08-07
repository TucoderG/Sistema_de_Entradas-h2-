package estructura;

import javax.swing.JPasswordField;

public class Password extends JPasswordField{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Component comp;
	
	public Password(int x, int y, int altura, int largo){
		
		this.comp = new Component(x, y, altura, largo);
		this.setBounds(this.comp.getBounds());
		
		this.setEnabled(true);
		this.setVisible(true);
		
		
	}

}
