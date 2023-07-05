package ausiliarie;

public class EntryClassifica implements Comparable<EntryClassifica>
{
	private String nome;
	private int puntiClassifica;
	private int partiteVinte;
	private int partitePerse;
	private double sommaPunteggi;
	
	public EntryClassifica(String nome, int pC, int pV, int pP, double sP) {
		this.nome = nome;
		this.puntiClassifica = pC;
		this.partiteVinte = pV;
		this.partitePerse = pP;
		this.sommaPunteggi = sP;
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

	@Override
	public int compareTo(EntryClassifica o) 
	{
		return o.getPuntiClassifica() - this.getPuntiClassifica();
	}
	
	

}
