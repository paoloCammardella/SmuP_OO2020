package DAO;

import java.sql.ResultSet;

public interface ArtistaDAO {
	public void insertArtist(String codice, String nome, String cognome, String dataNascita, String citta, String nomeDArte);
	public void deleteArtist(String codice);
	public void updateArtist(String codice, String nome, String cognome, String dataNascita, String citta, int followers, String nomeDArte);
	public ResultSet searchArtist(String nomeDaCercare);
	public ResultSet stampaArtist(String id_User);
	public ResultSet stampaArtist();
}
