package DAO;

import java.sql.ResultSet;

public interface ArtistaDAO {
	public void insertArtist(String codice, String nome, String cognome, String dataNascita, String citta, int followers, String nomeDArte);
	public ResultSet stampaArtist();
}
