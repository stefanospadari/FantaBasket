package Controller;

import java.util.List;

import model.Formazione;
import model.Giocatore;
import model.Lega;
import model.Modulo;
import model.Squadra;

public interface IInserimentoFormazione 
{
	public void inserisciFormazione(List<Giocatore> titolari, List<Giocatore> panchinari, Giocatore sestoUomo,
			Giocatore capitano, Modulo modulo, Squadra squadra, Lega lega);
	public Formazione getFormazione(Lega lega,Squadra squadra);
}
