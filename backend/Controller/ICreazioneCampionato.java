package Controller;

import java.util.List;

import model.Giocatore;
import model.Lega;
import model.PesiStatistiche;
import model.Squadra;
import model.Utente;

public interface ICreazioneCampionato 
{
	Lega creaCampionato(Utente amministratore, String nomeLega); //ho cambiato il tipo di ritorno da int a Lega
	void generazioneCalendario(Lega lega);
	void inserisciPesiStatistiche(Lega lega, PesiStatistiche pesi);
	Utente verificaUtente(String username);
	boolean inserisciSquadra(Utente utente, String nomeSquadra);
	void inserisciGiocatori(Squadra squadra, List<Giocatore> giocatori);

}
