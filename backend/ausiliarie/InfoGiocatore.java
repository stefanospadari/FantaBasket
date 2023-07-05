package ausiliarie;

import model.Giocatore;

public class InfoGiocatore 
{
	private Giocatore giocatore;
	private String prossimoAvversario;
	private String disponibilità;
	
	public InfoGiocatore(Giocatore giocatore, String prossimoAvversario, String disponibilità) {
		super();
		this.giocatore = giocatore;
		this.prossimoAvversario = prossimoAvversario;
		this.disponibilità = disponibilità;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public String getProssimoAvversario() {
		return prossimoAvversario;
	}

	public void setProssimoAvversario(String prossimoAvversario) {
		this.prossimoAvversario = prossimoAvversario;
	}

	public String getDisponibilità() {
		return disponibilità;
	}

	public void setDisponibilità(String disponibilità) {
		this.disponibilità = disponibilità;
	}
	
	
	
}
