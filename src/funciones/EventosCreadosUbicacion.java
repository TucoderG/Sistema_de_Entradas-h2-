package funciones;

import java.util.ArrayList;
import java.util.List;

import entidades.Evento;
import exeptions.DAOException;
import exeptions.ServiceException;
import servicio.EventoServicio;

public class EventosCreadosUbicacion {
	
	private static List<Evento> evento;
	private static List<String> eventos;
	
	public static List<String> events() {
		
		evento = new ArrayList<Evento>();
		eventos = new ArrayList<String>();
		
		EventoServicio user = new EventoServicio();
		
		
		try {
			evento = user.listaTodosLosEventos();
			
			for(Evento e: evento) {
				eventos.add(e.getUbicacion());
			}
			
		} catch (DAOException e) {
			
			e.printStackTrace();
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
		
		
		return eventos;
	}

}
