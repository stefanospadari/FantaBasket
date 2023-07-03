package model;

import java.time.LocalDateTime;

public interface IGiornataReale {
	public LocalDateTime getDataOraInizio();
	public LocalDateTime getDataOraFine();
	public int getNumeroGiornata();
	public String getSquadraAvversaria(Giocatore giocatore);
}
