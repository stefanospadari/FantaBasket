package ausiliarie;

public class StatisticheMedie 
{
	private float punti;
	private float rimbalziOffensivi;
	private float rimbalziDifensivi;
	private float assist;
	private float palleRecuperate;
	private float stoppate;
	private float tiriSbagliati;
	private float falli;
	private float pallePerse;
	private float quintettoBase;
	private float vittoriaSquadra;
	private float triple;
	
	public StatisticheMedie(float punti, float rimbalziOffensivi, float rimbalziDifensivi, float assist,
			float palleRecuperate, float stoppate, float tiriSbagliati, float falli, float pallePerse,
			float quintettoBase, float vittoriaSquadra, float triple) {
		super();
		this.punti = punti;
		this.rimbalziOffensivi = rimbalziOffensivi;
		this.rimbalziDifensivi = rimbalziDifensivi;
		this.assist = assist;
		this.palleRecuperate = palleRecuperate;
		this.stoppate = stoppate;
		this.tiriSbagliati = tiriSbagliati;
		this.falli = falli;
		this.pallePerse = pallePerse;
		this.quintettoBase = quintettoBase;
		this.vittoriaSquadra = vittoriaSquadra;
		this.triple = triple;
	}

	public float getPunti() {
		return punti;
	}

	public void setPunti(float punti) {
		this.punti = punti;
	}

	public float getRimbalziOffensivi() {
		return rimbalziOffensivi;
	}

	public void setRimbalziOffensivi(float rimbalziOffensivi) {
		this.rimbalziOffensivi = rimbalziOffensivi;
	}

	public float getRimbalziDifensivi() {
		return rimbalziDifensivi;
	}

	public void setRimbalziDifensivi(float rimbalziDifensivi) {
		this.rimbalziDifensivi = rimbalziDifensivi;
	}

	public float getAssist() {
		return assist;
	}

	public void setAssist(float assist) {
		this.assist = assist;
	}

	public float getPalleRecuperate() {
		return palleRecuperate;
	}

	public void setPalleRecuperate(float palleRecuperate) {
		this.palleRecuperate = palleRecuperate;
	}

	public float getStoppate() {
		return stoppate;
	}

	public void setStoppate(float stoppate) {
		this.stoppate = stoppate;
	}

	public float getTiriSbagliati() {
		return tiriSbagliati;
	}

	public void setTiriSbagliati(float tiriSbagliati) {
		this.tiriSbagliati = tiriSbagliati;
	}

	public float getFalli() {
		return falli;
	}

	public void setFalli(float falli) {
		this.falli = falli;
	}

	public float getPallePerse() {
		return pallePerse;
	}

	public void setPallePerse(float pallePerse) {
		this.pallePerse = pallePerse;
	}

	public float getQuintettoBase() {
		return quintettoBase;
	}

	public void setQuintettoBase(float quintettoBase) {
		this.quintettoBase = quintettoBase;
	}

	public float getVittoriaSquadra() {
		return vittoriaSquadra;
	}

	public void setVittoriaSquadra(float vittoriaSquadra) {
		this.vittoriaSquadra = vittoriaSquadra;
	}

	public float getTriple() {
		return triple;
	}

	public void setTriple(float triple) {
		this.triple = triple;
	}
	
	

}
