package model;

public class ScontroDiretto {
	private int id;
	private float punteggioCasa;
	private float punteggioOspite;
	private int malusCasa;//1 vero, 0 falso
	private int malusOspite;//1 vero, 0 falso
	private Formazione formazioneCasa;
	private Formazione formazioneOspite;
	private Giornata giornata;
	
	public ScontroDiretto() {
		super();
		this.malusCasa=0;
		this.malusOspite=0;
	}
	public float getPunteggioCasa() {
		return punteggioCasa;
	}
	public void setPunteggioCasa(float punteggioCasa) {
		this.punteggioCasa = punteggioCasa;
	}
	public int isMalusCasa() {
		return malusCasa;
	}
	public void setMalusCasa(int malusCasa) {
		this.malusCasa = malusCasa;
	}
	public int isMalusOspite() {
		return malusOspite;
	}
	public void setMalusOspite(int malusOspite) {
		this.malusOspite = malusOspite;
	}
	public Formazione getFormazioneCasa() {
		return formazioneCasa;
	}
	public Formazione getFormazioneOspite() {
		return formazioneOspite;
	}
	public void inserimentoFormazioneCasa(Formazione formazioneCasa) {
		this.formazioneCasa = formazioneCasa;
	}
	public void inserimentoFormazioneOspite(Formazione formazioneOspite) {
		this.formazioneOspite = formazioneOspite;
	}
	public int getMalusCasa() {
		return malusCasa;
	}
	public int getMalusOspite() {
		return malusOspite;
	}
	public void setFormazioneCasa(Formazione formazioneCasa) {
		this.formazioneCasa = formazioneCasa;
	}
	public void setFormazioneOspite(Formazione formazioneOspite) {
		this.formazioneOspite = formazioneOspite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPunteggioOspite() {
		return punteggioOspite;
	}
	public void setPunteggioOspite(float punteggioOspite) {
		this.punteggioOspite = punteggioOspite;
	}
	public Giornata getGiornata() {
		return giornata;
	}
	public void setGiornata(Giornata giornata) {
		this.giornata = giornata;
	}
	
}
