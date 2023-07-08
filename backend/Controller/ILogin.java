package Controller;

public interface ILogin 
{
	/*
	 * Return:
	 *  - "Utente" se si tratta di un utente normale
	 *  - "AmministratoreLega" se si tratta di un amministratore di Lega
	 *  - "AdminSistema" se si tratta di un admin di sistema
	 *  - "Errore" se username o password non sono corretti
	 */
	public String verificaCredenziali(String username, String password);
}
