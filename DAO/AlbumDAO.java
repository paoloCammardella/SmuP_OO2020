package DAO;

import java.sql.ResultSet;

public interface AlbumDAO {
	public void insertAlbum(String codice, String nome, int songNumber, String genere, String data, String artista);
	public void deleteAlbum(String codice);
	public void updateAlbum(String codice, String nome, int songNumber, String genere, String data);
	public ResultSet stampaAlbum();
}
