package estructura;

import javax.swing.JScrollBar;

public class Scroll extends JScrollBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Component comp;
	
	public Scroll(int x, int y, int a, int l) {
		
		this.comp = new Component(x, y, a, l);
		this.setBounds(this.comp.getBounds());
		
		this.setVisible(true);
		
	}

}
