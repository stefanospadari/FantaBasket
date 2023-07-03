package model;

public enum Ruolo {
	GUARDIA, ALA, CENTRO;
	public static Ruolo getEnum(String value) {
		if(value.equals("0"))
	    return Ruolo.GUARDIA;
		else if(value.equals("1"))
			return Ruolo.ALA;
		else return Ruolo.CENTRO;
	}
}
