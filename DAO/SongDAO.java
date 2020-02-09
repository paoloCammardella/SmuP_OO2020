package DAO;

import java.sql.ResultSet;

public interface SongDAO {
	public void insertSongDB(String artista, String nome, String durata, String genere, String album);
	public ResultSet stampaSong();
}
