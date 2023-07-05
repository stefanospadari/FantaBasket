package Controller;

import java.util.List;

import ausiliarie.EntryClassifica;
import ausiliarie.InfoGiocatore;
import ausiliarie.StatisticheMedie;
import model.Calendario;
import model.Giocatore;
import model.Lega;
import model.Squadra;

public interface IVistaCampionato 
{
	public Calendario getCalendario(Lega lega);
	public List<EntryClassifica> getClassifica(Lega lega);
	public Squadra getSquadra(Lega lega, String nomeSquadra);
	public StatisticheMedie getStatisticheMedieGiocatore(Giocatore giocatore);
	public List<Giocatore> getSvincolati(Lega lega);
	public InfoGiocatore getInfoGiocatore(Giocatore giocatore, int giornata);
	

}
















