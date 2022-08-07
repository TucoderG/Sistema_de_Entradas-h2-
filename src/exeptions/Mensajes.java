package exeptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mensajes extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static void alerta(String s) {
		
		JOptionPane.showMessageDialog(null, s,"Mensaje ALERTA: ",JOptionPane.WARNING_MESSAGE);
	}
	
	public static void informacion(String s) {
		
		JOptionPane.showMessageDialog(null, s,"Mensaje INFORMACION: ",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void aviso(String s) {
		
		JOptionPane.showMessageDialog(null, s ,"Mensaje AVISO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}

	