package DAO;

import java.sql.ResultSet;

public interface SongDAO {
	public void insertSongDB(String nome, int durata, String genere, String album);
	public void deleteSong(String codice);
	public void updateSong(String codice, String nome, int durata);
	public ResultSet stampaSong();
}
