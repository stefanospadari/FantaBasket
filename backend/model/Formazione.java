package model;

import java.util.ArrayList;
import java.util.List;

public class Formazione {
	public Formazione() {
		super();
	}
	private int id;
	private List<Giocatore> titolari;//esiste solo il get per ottenere una lista dei giocatori invece che averceli come attirbuti singoli
	private List<Giocatore> panchinari;//esiste solo il get per ottenere una lista dei giocatori invece che averceli come attirbuti singoli
	private Giocatore capitano;
	private Giocatore sestoUomo;
	private Giocatore titolare2;
	private Giocatore titolare3;
	private Giocatore titolare4;
	private Giocatore titolare5;
	private Giocatore panchinaro2;
	private Giocatore panchinaro3;
	private Giocatore panchinaro4;
	private Giocatore panchinaro5;
	private Modulo modulo;
	private Squadra squadra;
	
	public Formazione(Squadra squadra) {
		super();
		this.squadra = squadra;
	}
	public Formazione(List<Giocatore> titolari, List<Giocatore> panchinari, Giocatore capitano, Giocatore sestoUomo,
			Modulo modulo, Squadra squadra) {
		super();
		this.titolari = titolari;
		this.panchinari = panchinari;
		this.capitano = capitano;
		this.sestoUomo = sestoUomo;
		this.modulo = modulo;
		this.squadra = squadra;
	}
	public List<Giocatore> getTitolari() {
		titolari=new ArrayList<>();
		titolari.add(this.getCapitano());
		titolari.add(this.getTitolare2());
		titolari.add(this.getTitolare3());
		titolari.add(this.getTitolare4());
		titolari.add(this.getTitolare5());
		return titolari;
	}
	public List<Giocatore> getPanchinari() {
		panchinari=new ArrayList<>();
		panchinari.add(this.getSestoUomo());
		panchinari.add(this.getPanchinaro2());
		panchinari.add(this.getPanchinaro3());
		panchinari.add(this.getPanchinaro4());
		panchinari.add(this.getPanchinaro5());
		return panchinari;
	}
	public Giocatore getCapitano() {
		return capitano;
	}
	public Giocatore getSestoUomo() {
		return sestoUomo;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public Squadra getSquadra() {
		return squadra;
	}
	public void setCapitano(Giocatore capitano) {
		this.capitano = capitano;
	}
	public void setSestoUomo(Giocatore sestoUomo) {
		this.sestoUomo = sestoUomo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Giocatore getTitolare2() {
		return titolare2;
	}
	public void setTitolare2(Giocatore titolare2) {
		this.titolare2 = titolare2;
	}
	public Giocatore getTitolare3() {
		return titolare3;
	}
	public void setTitolare3(Giocatore titolare3) {
		this.titolare3 = titolare3;
	}
	public Giocatore getTitolare4() {
		return titolare4;
	}
	public void setTitolare4(Giocatore titolare4) {
		this.titolare4 = titolare4;
	}
	public Giocatore getTitolare5() {
		return titolare5;
	}
	public void setTitolare5(Giocatore titolare5) {
		this.titolare5 = titolare5;
	}
	public Giocatore getPanchinaro2() {
		return panchinaro2;
	}
	public void setPanchinaro2(Giocatore panchinaro2) {
		this.panchinaro2 = panchinaro2;
	}
	public Giocatore getPanchinaro3() {
		return panchinaro3;
	}
	public void setPanchinaro3(Giocatore panchinaro3) {
		this.panchinaro3 = panchinaro3;
	}
	public Giocatore getPanchinaro4() {
		return panchinaro4;
	}
	public void setPanchinaro4(Giocatore panchinaro4) {
		this.panchinaro4 = panchinaro4;
	}
	public Giocatore getPanchinaro5() {
		return panchinaro5;
	}
	public void setPanchinaro5(Giocatore panchinaro5) {
		this.panchinaro5 = panchinaro5;
	}
}
