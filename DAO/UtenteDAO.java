package DAO;

import Entita.Utente;

public interface UtenteDAO {
	public void insertUser(String username, String password, boolean isAdmin);
	public Utente checkUser(String username, String password);
}
