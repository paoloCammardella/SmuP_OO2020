package DAO;

import java.sql.ResultSet;

public interface SingleDAO {
	public void insertSingle(String nome, int durata, String genere, String artista, String dataPubblicazione);
	public void deleteSingle(String codice);
	public void updateSingle(String codice,String nome, int durata, String genere, String dataPubblicazione);
	public ResultSet stampaSingle();
}
