package model;

public class Utente {
	private String username;
	/*
	 * La password è composta dal salt concatenato all hash della password+salt
	 * I primi 16 char della stringa convertiti in byte rappresentano il salt 
	 */
	private String password;
	
	
	public Utente() {
		super();
	}
	public Utente(String username) {
		super();
		this.username = username;
	}
	

	public String getUsername() {
		return username;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPassword() {
		return password;
	}
}
