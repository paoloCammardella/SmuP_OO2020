package DAO;

import java.sql.ResultSet;

public interface ArtistaDAO {
	public void insertArtist(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta, String followers);
	public ResultSet stampaArtist();
}
