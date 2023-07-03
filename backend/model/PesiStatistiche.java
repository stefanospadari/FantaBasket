package model;

public class PesiStatistiche {
	private Lega lega;
	private int id;
	private double pesoPunti;
	private double pesoRimbalziDifensivi;
	private double pesoRimbalziOffensivi;
	private double pesoAssist;
	private double pesoPalleRecuperate;
	private double pesoStoppate;
	private double pesoPallePerse;
	private double pesoDoppiaDoppia;
	private double pesoTriplaDoppia;
	private double pesoQuadruplaDoppia;
	private double pesoQuintettoBase;
	private double pesoTripleSegnate3;
	private double pesoTripleSegnate4;
	private double pesoTripleSegnate5piu;
	private double pesoTiroSbagliato;
	private double pesoTiroLiberoSbagliato;
	private double pesoUscitaPerFalli;
	private double malus;
	
	public PesiStatistiche(double pesoPunti, double pesoRimbalziDifensivi, double pesoRimbalziOffensivi,
			double pesoAssist, double pesoPalleRecuperate, double pesoStoppate, double pesoPallePerse,
			double pesoDoppiaDoppia, double pesoTriplaDoppia, double pesoQuadruplaDoppia, double pesoQuintettoBase,
			double pesoTripleSegnate3, double pesoTripleSegnate4, double pesoTripleSegnate5piu,
			double pesoTiroSbagliato, double pesoTiroLiberoSbagliato, double pesoUscitaPerFalli, double malus) {
		super();
		this.pesoPunti = pesoPunti;
		this.pesoRimbalziDifensivi = pesoRimbalziDifensivi;
		this.pesoRimbalziOffensivi = pesoRimbalziOffensivi;
		this.pesoAssist = pesoAssist;
		this.pesoPalleRecuperate = pesoPalleRecuperate;
		this.pesoStoppate = pesoStoppate;
		this.pesoPallePerse = pesoPallePerse;
		this.pesoDoppiaDoppia = pesoDoppiaDoppia;
		this.pesoTriplaDoppia = pesoTriplaDoppia;
		this.pesoQuadruplaDoppia = pesoQuadruplaDoppia;
		this.pesoQuintettoBase = pesoQuintettoBase;
		this.pesoTripleSegnate3 = pesoTripleSegnate3;
		this.pesoTripleSegnate4 = pesoTripleSegnate4;
		this.pesoTripleSegnate5piu = pesoTripleSegnate5piu;
		this.pesoTiroSbagliato = pesoTiroSbagliato;
		this.pesoTiroLiberoSbagliato = pesoTiroLiberoSbagliato;
		this.pesoUscitaPerFalli = pesoUscitaPerFalli;
		this.malus = malus;
	}
	public PesiStatistiche() {
		super();
		this.pesoPunti = 1;
		this.pesoRimbalziDifensivi = 1;
		this.pesoRimbalziOffensivi =  1.25;
		this.pesoAssist = 1.5;
		this.pesoPalleRecuperate =  1.5;
		this.pesoStoppate = 1.5;
		this.pesoPallePerse = -1.5;
		this.pesoDoppiaDoppia = 5;
		this.pesoTriplaDoppia = 10;
		this.pesoQuadruplaDoppia = 40;
		this.pesoQuintettoBase = 1;
		this.pesoTripleSegnate3 = 3;
		this.pesoTripleSegnate4 = 4;
		this.pesoTripleSegnate5piu = 5;
		this.pesoTiroSbagliato = -1;
		this.pesoTiroLiberoSbagliato = -1;
		this.pesoUscitaPerFalli = -5;
		this.malus = 0;
	}

	public double getPesoPunti() {
		return pesoPunti;
	}

	public void setPesoPunti(double pesoPunti) {
		this.pesoPunti = pesoPunti;
	}

	public double getPesoRimbalziDifensivi() {
		return pesoRimbalziDifensivi;
	}

	public void setPesoRimbalziDifensivi(double pesoRimbalziDifensivi) {
		this.pesoRimbalziDifensivi = pesoRimbalziDifensivi;
	}

	public double getPesoRimbalziOffensivi() {
		return pesoRimbalziOffensivi;
	}

	public void setPesoRimbalziOffensivi(double pesoRimbalziOffensivi) {
		this.pesoRimbalziOffensivi = pesoRimbalziOffensivi;
	}

	public double getPesoAssist() {
		return pesoAssist;
	}

	public void setPesoAssist(double pesoAssist) {
		this.pesoAssist = pesoAssist;
	}

	public double getPesoPalleRecuperate() {
		return pesoPalleRecuperate;
	}

	public void setPesoPalleRecuperate(double pesoPalleRecuperate) {
		this.pesoPalleRecuperate = pesoPalleRecuperate;
	}

	public double getPesoStoppate() {
		return pesoStoppate;
	}

	public void setPesoStoppate(double pesoStoppate) {
		this.pesoStoppate = pesoStoppate;
	}

	public double getPesoPallePerse() {
		return pesoPallePerse;
	}

	public void setPesoPallePerse(double pesoPallePerse) {
		this.pesoPallePerse = pesoPallePerse;
	}

	public double getPesoDoppiaDoppia() {
		return pesoDoppiaDoppia;
	}

	public void setPesoDoppiaDoppia(double pesoDoppiaDoppia) {
		this.pesoDoppiaDoppia = pesoDoppiaDoppia;
	}

	public double getPesoTriplaDoppia() {
		return pesoTriplaDoppia;
	}

	public void setPesoTriplaDoppia(double pesoTriplaDoppia) {
		this.pesoTriplaDoppia = pesoTriplaDoppia;
	}

	public double getPesoQuadruplaDoppia() {
		return pesoQuadruplaDoppia;
	}

	public void setPesoQuadruplaDoppia(double pesoQuadruplaDoppia) {
		this.pesoQuadruplaDoppia = pesoQuadruplaDoppia;
	}

	public double getPesoQuintettoBase() {
		return pesoQuintettoBase;
	}

	public void setPesoQuintettoBase(double pesoQuintettoBase) {
		this.pesoQuintettoBase = pesoQuintettoBase;
	}

	public double getPesoTripleSegnate3() {
		return pesoTripleSegnate3;
	}

	public void setPesoTripleSegnate3(double pesoTripleSegnate3) {
		this.pesoTripleSegnate3 = pesoTripleSegnate3;
	}

	public double getPesoTripleSegnate4() {
		return pesoTripleSegnate4;
	}

	public void setPesoTripleSegnate4(double pesoTripleSegnate4) {
		this.pesoTripleSegnate4 = pesoTripleSegnate4;
	}

	public double getPesoTripleSegnate5piu() {
		return pesoTripleSegnate5piu;
	}

	public void setPesoTripleSegnate5piu(double pesoTripleSegnate5piu) {
		this.pesoTripleSegnate5piu = pesoTripleSegnate5piu;
	}

	public double getPesoTiroSbagliato() {
		return pesoTiroSbagliato;
	}

	public void setPesoTiroSbagliato(double pesoTiroSbagliato) {
		this.pesoTiroSbagliato = pesoTiroSbagliato;
	}

	public double getPesoTiroLiberoSbagliato() {
		return pesoTiroLiberoSbagliato;
	}

	public void setPesoTiroLiberoSbagliato(double pesoTiroLiberoSbagliato) {
		this.pesoTiroLiberoSbagliato = pesoTiroLiberoSbagliato;
	}

	public double getPesoUscitaPerFalli() {
		return pesoUscitaPerFalli;
	}

	public void setPesoUscitaPerFalli(double pesoUscitaPerFalli) {
		this.pesoUscitaPerFalli = pesoUscitaPerFalli;
	}

	public double getMalus() {
		return malus;
	}

	public void setMalus(double malus) {
		this.malus = malus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Lega getLega() {
		return lega;
	}
	public void setLega(Lega lega) {
		this.lega = lega;
	}
	@Override
	public String toString() {
		return "PesiStatistiche [lega=" + lega + ", id=" + id + ", pesoPunti=" + pesoPunti + ", pesoRimbalziDifensivi="
				+ pesoRimbalziDifensivi + ", pesoRimbalziOffensivi=" + pesoRimbalziOffensivi + ", pesoAssist="
				+ pesoAssist + ", pesoPalleRecuperate=" + pesoPalleRecuperate + ", pesoStoppate=" + pesoStoppate
				+ ", pesoPallePerse=" + pesoPallePerse + ", pesoDoppiaDoppia=" + pesoDoppiaDoppia
				+ ", pesoTriplaDoppia=" + pesoTriplaDoppia + ", pesoQuadruplaDoppia=" + pesoQuadruplaDoppia
				+ ", pesoQuintettoBase=" + pesoQuintettoBase + ", pesoTripleSegnate3=" + pesoTripleSegnate3
				+ ", pesoTripleSegnate4=" + pesoTripleSegnate4 + ", pesoTripleSegnate5piu=" + pesoTripleSegnate5piu
				+ ", pesoTiroSbagliato=" + pesoTiroSbagliato + ", pesoTiroLiberoSbagliato=" + pesoTiroLiberoSbagliato
				+ ", pesoUscitaPerFalli=" + pesoUscitaPerFalli + ", malus=" + malus + "]";
	}
}
