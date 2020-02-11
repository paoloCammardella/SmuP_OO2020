package DAO;

import java.sql.ResultSet;

public interface AlbumDAO {
	public void insertAlbum(String codice, String nome, String genere, String data, String artista);
	public ResultSet stampaAlbum();
}
