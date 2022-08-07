package estructura;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Label extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String txt;
	private Component comp;
	
	public Label() {
		
	}

	
	public Label(String txt, int x, int y, int altura, int largo) {
		
		this.txt = txt;
		
		this.comp = new Component(x, y, altura, largo);
		
		this.setBounds(this.comp.getBounds());
		this.setText(this.txt);
		
		this.setFont(new Font("Arial",Font.PLAIN, 20));
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		this.setVisible(true);
		
		
	}
	
	
}
