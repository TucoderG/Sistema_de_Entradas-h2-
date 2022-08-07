package estructura;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class FormattedText extends JFormattedTextField {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MaskFormatter mascara;
	
	private Component comp;
	
	public FormattedText() {
		
	}
	
	public FormattedText(MaskFormatter mascara,int x, int y, int altura, int largo) {
		
		
		this.comp = new Component(x, y, altura, largo);
		
		this.setBounds(this.comp.getBounds());
		
		this.mascara = mascara;
		this.setFormatter(mascara);
	}
}
