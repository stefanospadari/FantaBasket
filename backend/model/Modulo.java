package model;

public enum Modulo {
	M221(2,2,1), M122(1,2,2), M212(2,1,2), M131(1,3,1), M311(3,1,1);
	private int numeroAli;
	private int numeroGuardie;
	private int numeroCentri;
	
	private Modulo(int numeroGuardie, int numeroAli, int numeroCentri) {
		this.numeroAli=numeroAli;
		this.numeroCentri=numeroCentri;
		this.numeroGuardie=numeroGuardie;
	}
	public String toString() {
		return this.numeroGuardie+"-"+this.numeroAli+"-"+this.numeroCentri;
	}
}
