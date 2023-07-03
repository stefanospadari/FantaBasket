package model;

import java.util.HashSet;
import java.util.Set;

public class Squadra {
	private int id;
	private String nome;
	private int puntiClassifica;
	private int partiteVinte;
	private int partitePerse;
	private double sommaPunteggi;
	private Set<Giocatore> giocatori;
	private Utente allenatore;
	private Lega lega;//aggiunto per far funzionare hibernate
	
	public Squadra() {
		super();
	}
	public Squadra(Utente allenatore, String nome) {
		this.allenatore=allenatore;
		this.giocatori=new HashSet<>();
		this.nome=nome;
		this.partitePerse=0;
		this.partiteVinte=0;
		this.puntiClassifica=0;
		this.sommaPunteggi=0;
	}
	public void aggiungiGiocatore(Giocatore giocatore) {
		giocatori.add(giocatore);
	}
	public void eliminaGiocatore(Giocatore giocatore) {
		giocatori.remove(giocatore);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPuntiClassifica() {
		return puntiClassifica;
	}
	public void setPuntiClassifica(int puntiClassifica) {
		this.puntiClassifica = puntiClassifica;
	}
	public int getPartiteVinte() {
		return partiteVinte;
	}
	public void setPartiteVinte(int partiteVinte) {
		this.partiteVinte = partiteVinte;
	}
	public int getPartitePerse() {
		return partitePerse;
	}
	public void setPartitePerse(int partitePerse) {
		this.partitePerse = partitePerse;
	}
	public double getSommaPunteggi() {
		return sommaPunteggi;
	}
	public void setSommaPunteggi(double sommaPunteggi) {
		this.sommaPunteggi = sommaPunteggi;
	}
	public Utente getAllenatore() {
		return allenatore;
	}
	public Set<Giocatore> getGiocatori() {
		return giocatori;
	}
	public void setGiocatori(Set<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}
	public void setAllenatore(Utente allenatore) {
		this.allenatore = allenatore;
	}
	public Lega getLega() {
		return lega;
	}
	public void setLega(Lega lega) {
		this.lega = lega;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
