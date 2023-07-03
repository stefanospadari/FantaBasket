package model;

import java.time.LocalDateTime;

public class Entry {
	public Entry() {
		super();
	}
	public Entry(LocalDateTime dataOra, String operazioneEseguita) {
		super();
		this.dataOra = dataOra;
		this.operazioneEseguita = operazioneEseguita;
	}
	private LocalDateTime dataOra;
	private String operazioneEseguita;
	public LocalDateTime getDataOra() {
		return dataOra;
	}
	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}
	public String getOperazioneEseguita() {
		return operazioneEseguita;
	}
	public void setOperazioneEseguita(String operazioneEseguita) {
		this.operazioneEseguita = operazioneEseguita;
	}
	
}
