package estructura;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String imagen;
	private ImageIcon icon;
	
	public Panel(String imagen) {
		this.setSize(810, 540);
		this.imagen = imagen;
		
	}
	
    public void paint(Graphics g){
    	
        Dimension dimension = this.getSize();
        icon = new ImageIcon(getClass().getResource(this.imagen));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, this);
        this.setOpaque(false);
        super.paintChildren(g);
        
    }
    
    
    
}
