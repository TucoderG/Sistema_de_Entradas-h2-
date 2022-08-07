package estructura;

import java.awt.Choice;

public class ChoiceLista extends Choice{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Component comp;
	
	
	public ChoiceLista(int x, int y, int a, int l) {
		
		
		this.comp = new Component(x, y, a, l);
		
		this.setBounds(this.comp.getBounds());
		
		
		this.addItem("...");
		this.setVisible(true);
		
	}


	public void addItem(int i) {
		
		this.addItem(i);
		
	}
	

}
