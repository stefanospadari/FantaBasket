package model;

public class Statistiche {
	public Statistiche(int id, int punti, int rimbalziDifensivi, int rimbalziOffensivi, int assist, int palleRecuperate,
			int stoppate, int tiriSbagliati, int tiriLiberiSbagliati, int falli, int pallePerse, int triple,
			int quintettoBase, int vittoriaSquadra, Giocatore giocatore, Partita partita) {
		super();
		this.id = id;
		this.punti = punti;
		this.rimbalziDifensivi = rimbalziDifensivi;
		this.rimbalziOffensivi = rimbalziOffensivi;
		this.assist = assist;
		this.palleRecuperate = palleRecuperate;
		this.stoppate = stoppate;
		this.tiriSbagliati = tiriSbagliati;
		this.tiriLiberiSbagliati = tiriLiberiSbagliati;
		this.falli = falli;
		this.pallePerse = pallePerse;
		this.triple = triple;
		this.quintettoBase = quintettoBase;
		this.vittoriaSquadra = vittoriaSquadra;
		this.giocatore = giocatore;
		this.partita = partita;
	}
	public Statistiche() {
		super();
	}
	private int id;
	private int punti;
	private int rimbalziDifensivi;
	private int rimbalziOffensivi;
	private int assist;
	private int palleRecuperate;
	private int stoppate;
	private int tiriSbagliati;
	private int tiriLiberiSbagliati;
	private int falli;
	private int pallePerse;
	private int triple;
	private int quintettoBase; //1 vero, 0 falso
	private int vittoriaSquadra; //1 vero, 0 falso
	private Giocatore giocatore;
	private Partita partita;
	
	
	public Giocatore getGiocatore() {
		return giocatore;
	}
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore=giocatore;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public int getRimbalziDifensivi() {
		return rimbalziDifensivi;
	}
	public void setRimbalziDifensivi(int rimbalziDifensivi) {
		this.rimbalziDifensivi = rimbalziDifensivi;
	}
	public int getRimbalziOffensivi() {
		return rimbalziOffensivi;
	}
	public void setRimbalziOffensivi(int rimbalziOffensivi) {
		this.rimbalziOffensivi = rimbalziOffensivi;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	public int getPalleRecuperate() {
		return palleRecuperate;
	}
	public void setPalleRecuperate(int palleRecuperate) {
		this.palleRecuperate = palleRecuperate;
	}
	public int getStoppate() {
		return stoppate;
	}
	public void setStoppate(int stoppate) {
		this.stoppate = stoppate;
	}
	public int getTiriSbagliati() {
		return tiriSbagliati;
	}
	public void setTiriSbagliati(int tiriSbagliati) {
		this.tiriSbagliati = tiriSbagliati;
	}
	public int getTiriLiberiSbagliati() {
		return tiriLiberiSbagliati;
	}
	public void setTiriLiberiSbagliati(int tiriLiberiSbagliati) {
		this.tiriLiberiSbagliati = tiriLiberiSbagliati;
	}
	public int getFalli() {
		return falli;
	}
	public void setFalli(int falli) {
		this.falli = falli;
	}
	public int getPallePerse() {
		return pallePerse;
	}
	public void setPallePerse(int pallePerse) {
		this.pallePerse = pallePerse;
	}
	public int getTriple() {
		return triple;
	}
	public void setTriple(int triple) {
		this.triple = triple;
	}
	public double calcolaFantaPunti(PesiStatistiche p) {
		double somma=0;
		somma+= punti*p.getPesoPunti();
		somma+= rimbalziDifensivi*p.getPesoRimbalziDifensivi();
		somma+= rimbalziOffensivi*p.getPesoRimbalziOffensivi();
		somma+= assist*p.getPesoAssist();
		somma+= palleRecuperate*p.getPesoPalleRecuperate();
		somma+= stoppate*p.getPesoStoppate();
		somma+= tiriSbagliati*p.getPesoTiroSbagliato();
		somma+= tiriLiberiSbagliati*p.getPesoTiroLiberoSbagliato();
		//si assume che l'uscita per falli sia 5
		if(falli>=5)
			somma+= p.getPesoUscitaPerFalli();
		somma+= pallePerse*p.getPesoPallePerse();
		if(triple==3)
			somma+=p.getPesoTripleSegnate3();
		else
			if(triple==4)
				somma+=p.getPesoTripleSegnate4();
			else
				if(triple>=5)
					somma+=p.getPesoTripleSegnate5piu();
		if(quintettoBase==1)
			somma+=p.getPesoQuintettoBase();
		if(isQuadruplaDoppia())
			somma+=p.getPesoQuadruplaDoppia();
		else if(isTriplaDoppia())
			somma+=p.getPesoTriplaDoppia();
		return somma;
	}
	private boolean isQuadruplaDoppia() {
		int[] vettore=new int[5];
		vettore[0]=this.getPunti();
		vettore[1]=this.getAssist();
		vettore[2]=this.getRimbalziDifensivi()+this.getRimbalziOffensivi();
		vettore[3]=this.getPalleRecuperate();
		vettore[4]=this.getStoppate();
		int cont=0;
		for(int i=0;i<5;i++) {
			if(vettore[i]>=10)
				cont++;
		}
		if(cont==4)
			return true;
		else 
			return false;
	}
	private boolean isTriplaDoppia() {
		int[] vettore=new int[5];
		vettore[0]=this.getPunti();
		vettore[1]=this.getAssist();
		vettore[2]=this.getRimbalziDifensivi()+this.getRimbalziOffensivi();
		vettore[3]=this.getPalleRecuperate();
		vettore[4]=this.getStoppate();
		int cont=0;
		for(int i=0;i<5;i++) {
			if(vettore[i]>=10)
				cont++;
		}
		if(cont==3)
			return true;
		else 
			return false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Partita getPartita() {
		return partita;
	}
	public void setPartita(Partita partita) {
		this.partita = partita;
	}
	public int getQuintettoBase() {
		return quintettoBase;
	}
	public void setQuintettoBase(int quintettoBase) {
		this.quintettoBase = quintettoBase;
	}
	public int getVittoriaSquadra() {
		return vittoriaSquadra;
	}
	public void setVittoriaSquadra(int vittoriaSquadra) {
		this.vittoriaSquadra = vittoriaSquadra;
	}
}
