package model;

import java.sql.Timestamp;

public class Partita {
	public Partita() {
		super();
	}
	private int id;
	private Timestamp dataOraInizio;
	private String squadraCasa;
	private String squadraOspite;
	private GiornataLBA giornata;
	
	public Partita(Timestamp dataOraInizio, String squadraCasa, String squadraOspite) {
		super();
		this.dataOraInizio = dataOraInizio;
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
	}
	public Timestamp getDataOraInizio() {
		return dataOraInizio;
	}

	public String getSquadraCasa() {
		return squadraCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}
	public void setDataOraInizio(Timestamp dataOraInizio) {
		this.dataOraInizio = dataOraInizio;
	}
	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}
	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GiornataLBA getGiornata() {
		return giornata;
	}
	public void setGiornata(GiornataLBA giornata) {
		this.giornata = giornata;
	}
}
