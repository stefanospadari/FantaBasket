package model;

import java.util.Set;

public class Giornata {
	public Giornata() {
		super();
	}

	private int id;
	private int numeroGiornata;
	private int calcolabile;
	private IGiornataReale giornataReale;
	private Set<ScontroDiretto> scontriDiretti;
	
	// costruttore senza interfaccia IGiornataReale
	public Giornata(int numeroGiornata,Set<ScontroDiretto> scontriDiretti) {
		this.numeroGiornata=numeroGiornata;
		this.scontriDiretti=scontriDiretti;
		this.calcolabile=0;
	}
	
	// costruttore con interfaccia IGiornataReale
	public Giornata(int numeroGiornata,Set<ScontroDiretto> scontriDiretti, IGiornataReale giornataReale) {
		this.numeroGiornata=numeroGiornata;
		this.scontriDiretti=scontriDiretti;
		this.calcolabile=0;
		this.giornataReale=giornataReale;
	}

	public void abilitaCalcolo() {
		this.calcolabile = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroGiornata() {
		return numeroGiornata;
	}

	public void setNumeroGiornata(int numeroGiornata) {
		this.numeroGiornata = numeroGiornata;
	}

	public int getCalcolabile() {
		return calcolabile;
	}

	public void setCalcolabile(int calcolabile) {
		this.calcolabile = calcolabile;
	}

	public IGiornataReale getGiornataReale() {
		return giornataReale;
	}

	public void setGiornataReale(IGiornataReale giornataReale) {
		this.giornataReale = giornataReale;
	}

	public Set<ScontroDiretto> getScontriDiretti() {
		return scontriDiretti;
	}

	public void setScontriDiretti(Set<ScontroDiretto> scontriDiretti) {
		this.scontriDiretti = scontriDiretti;
	}
	
	
}
