package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;

public class Giocatore {
	public Giocatore(int id, String nome, String cognome, String squadraReale, Date dataDiNascita, Ruolo ruolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.squadraReale = squadraReale;
		this.dataDiNascita = dataDiNascita;
		this.ruolo = ruolo;
	}
	private int id;
	private String nome;
	private String cognome;
	private String squadraReale;
	private Date dataDiNascita;
	private Ruolo ruolo;
	private Set<Squadra> squadre;
	
	public Giocatore() {
		super();
	}
	public Giocatore(String nome, String cognome, String squadraReale, Date dataDiNascita, Ruolo ruolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.squadraReale = squadraReale;
		this.dataDiNascita = dataDiNascita;
		this.ruolo = ruolo;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getSquadraReale() {
		return squadraReale;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
/*	public String toString() {
		DateTimeFormatter formatterLong =DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		return this.getNome()+" "+this.getCognome()+ " è nato il giorno "+this.getDataDiNascita().format(formatterLong)+".\nIl giocatore è in forza alla squadra "+this.getSquadraReale()+" nella posizione di "+this.ruolo.name();
	}
*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setSquadraReale(String squadraReale) {
		this.squadraReale = squadraReale;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public Set<Squadra> getSquadre() {
		return squadre;
	}
	public void setSquadre(Set<Squadra> squadre) {
		this.squadre = squadre;
	}
}
