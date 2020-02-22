package DAO;

import java.sql.ResultSet;

public interface EPDAO {
	public void insertEP(String nome,  String genere, int songNumber, String artista, String dataPubblicazione);
	public void deleteEP(String codice);
	public void updateEP(String codice, String nome, String dataPubblicazione, String genere, int songNumber);
	public ResultSet stampaEP();
}