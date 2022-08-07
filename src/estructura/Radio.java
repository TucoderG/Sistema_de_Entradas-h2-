package estructura;

import javax.swing.JRadioButton;

public class Radio extends JRadioButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Component comp;
	
	public Radio(String texto, int x, int y, int a, int l) {
		
		this.texto = texto;
		this.comp = new Component(x, y, a, l);
		this.setBounds(this.comp.getBounds());
		
		this.setText(this.texto);
		
	}

}
