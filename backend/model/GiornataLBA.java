package model;

import java.time.LocalDateTime;
import java.util.Set;

public class GiornataLBA implements IGiornataReale {
	public GiornataLBA() {
		super();
	}

	private int id;
	private int numeroGiornata;
	private Set<Partita> partite;
	
	public GiornataLBA(int numeroGiornata,Set<Partita> partite) {
		super();
		this.numeroGiornata = numeroGiornata;
		this.partite = partite;
	}
	
	@Override
	public LocalDateTime getDataOraInizio() {
		Partita[] v=partite.toArray(new Partita[0]);
		LocalDateTime winner=v[0].getDataOraInizio().toLocalDateTime();
		
		for(Partita p : partite) {
			if(p.getDataOraInizio().toLocalDateTime().isBefore(winner)) {
				winner=p.getDataOraInizio().toLocalDateTime();
			}
		}
		return winner;
	}

	@Override
	public LocalDateTime getDataOraFine() {
		Partita[] v=partite.toArray(new Partita[0]);
		LocalDateTime winner=v[0].getDataOraInizio().toLocalDateTime().plusHours(10);
		for(Partita p : partite) {
			if(p.getDataOraInizio().toLocalDateTime().plusHours(10).isAfter(winner)) {
				winner=p.getDataOraInizio().toLocalDateTime().plusHours(10);
			}
		}
		return winner;
	}

	@Override
	public int getNumeroGiornata() {
		return numeroGiornata;
	}

	@Override
	public String getSquadraAvversaria(Giocatore giocatore) {
		for (Partita p : partite) {
			if(giocatore.getSquadraReale().equals(p.getSquadraCasa()))
				return p.getSquadraOspite();	
			else
				if(giocatore.getSquadraReale().equals(p.getSquadraOspite()))
					return p.getSquadraCasa();
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Partita> getPartite() {
		return partite;
	}

	public void setPartite(Set<Partita> partite) {
		this.partite = partite;
	}

	public void setNumeroGiornata(int numeroGiornata) {
		this.numeroGiornata = numeroGiornata;
	}

}
