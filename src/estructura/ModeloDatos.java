package estructura;

import javax.swing.table.AbstractTableModel;

public class ModeloDatos extends AbstractTableModel {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Object datos[][] = {};
	  
	public ModeloDatos() {
	  
	}
	  
	public int getColumnCount() { 
	  return( datos.length ); 
	}
	  
	
	public int getRowCount() { 
	  return( datos.length );
	}
	  
	 
	public Object getValueAt( int fila,int col ) { 
	  return( datos[fila][col] ); 
	}
	  
	  
	public void setValueAt( Object valor,int fila,int col ) {
	  datos[fila][col] = valor;
	   
	  fireTableDataChanged();
	}
	  
	public boolean isCellEditable( int fila,int col ) { 
	  return( true ); 
	}
	  
	
	} 