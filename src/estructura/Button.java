package estructura;

import javax.swing.JButton;

public class Button extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String txt;
	private boolean b;
	private Component comp;
	
	public Button() {
		
	}
	
	public Button(String txt, int x, int y, int a, int l, boolean b) {
		
		this.txt = txt;
		
		this.b = b;
		this.comp = new Component(x, y, a, l);
		this.setBounds(this.comp.getBounds());
		
		this.setEnabled(this.b);
		this.setText(this.txt);
		
	}
}
