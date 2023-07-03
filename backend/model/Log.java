package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Log {
	public Log() {
		super();
	}
	public Log(List<Entry> entries) {
		super();
		this.entries = entries;
	}
	List<Entry> entries;
	public List<Entry> getEntry(LocalDateTime inizio, LocalDateTime fine) {
		List<Entry> risultato=new ArrayList<>();
		for(Entry entry : entries) {
			if( (entry.getDataOra().isAfter(inizio)||entry.getDataOra().isEqual(inizio))&&(entry.getDataOra().isBefore(fine)||entry.getDataOra().isEqual(fine))) {
				risultato.add(entry);
			}
		}
		return risultato;
	}
	public List<Entry> getEntry(LocalDate giorno) {
		List<Entry> risultato=new ArrayList<>();
		for(Entry entry : entries) {
			if(entry.getDataOra().getDayOfYear()==giorno.getDayOfYear()&&entry.getDataOra().getYear()==giorno.getYear()) {
				risultato.add(entry);
			}
		}
		return risultato;
	}
	public List<Entry> getEntries() {
		return entries;
	}
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
}
