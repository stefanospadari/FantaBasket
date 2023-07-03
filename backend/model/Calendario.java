package model;

import java.util.List;

public class Calendario {
	public Calendario() {
		super();
	}
	private List<Giornata> calendario;
	
	public Calendario(List<Giornata> calendario) {
		this.calendario=calendario;
	}
	public Giornata getGiornata(int giornata) {
		return calendario.get(giornata);
	}
	public List<Giornata> getCalendario() {
		return calendario;
	}
	public void setCalendario(List<Giornata> calendario) {
		this.calendario = calendario;
	}
}
