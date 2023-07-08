package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lega {
	private int id;
	private String nome;
	private PesiStatistiche pesiStatistiche;
	private Utente amministratoreLega;
	private Calendario calendario;
	private List<Giocatore> svincolati;
	private Set<Squadra> squadre;
	
	
	public Lega() {
		super();
	}
	public Lega(String nome) {
		super();
		this.nome = nome;
		this.squadre = new HashSet<Squadra>();
		this.svincolati = new ArrayList<Giocatore>();
	}
	public void addSquadra(Squadra squadra) {
		squadre.add(squadra);
	}
	public String getNome() {
		return nome;
	}
	public PesiStatistiche getPesiStatistiche() {
		return pesiStatistiche;
	}
	public Utente getAmministratoreLega() {
		return amministratoreLega;
	}
	public Calendario getCalendario() {
		return calendario;
	}
	public List<Giocatore> getSvincolati() {
		return svincolati;
	}
	public Set<Squadra> getSquadre() {
		return squadre;
	}
	public void setPesiStatistiche(PesiStatistiche pesiStatistiche) {
		this.pesiStatistiche = pesiStatistiche;
	}
	public void setAmministratoreLega(Utente amministratoreLega) {
		this.amministratoreLega = amministratoreLega;
	}
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	public void setSvincolati(List<Giocatore> svincolati) {
		this.svincolati = svincolati;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSquadre(Set<Squadra> squadre) {
		this.squadre = squadre;
	}
	
}
