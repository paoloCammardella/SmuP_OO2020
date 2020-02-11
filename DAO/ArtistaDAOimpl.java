package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _Controller.Controller;

public class ArtistaDAOimpl implements ArtistaDAO{
	
	Connection connection;
	Controller controller;
	
	public ArtistaDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertArtist(String codice, String nome, String cognome, String dataNascita, String citta, int followers, String nomeDArte) {
		try {
			String query_insert = "INSERT INTO Artist (id_artist, firstName, secondName, birthDate, city, followers, nomeDArte) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(query_insert);
			pst.setString(1, codice);
			pst.setString(2, nome);
			pst.setString(3, cognome);
			pst.setString(4, dataNascita);
			pst.setString(5, citta);
			pst.setInt(6, followers);
			pst.setString(7, nomeDArte);
			pst.executeUpdate();
			
			System.out.println("\nInserimento avvenuto(Artista)...");
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
		}
	}
	
	@Override
	public void deleteArtist(String codice) {
		try {
			String query_delete = "DELETE FROM Artist WHERE id_Artist = ?";
			
			PreparedStatement pst = connection.prepareStatement(query_delete);
			pst.setString(1, codice);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void updateArtist(String codice, String nome, String cognome, String dataNascita, String citta, int followers, String nomeDArte) {
		try {
			String query_update = "UPDATE Artist SET firstName = ? , secondName = ?, birthDate = ?, city = ?, followers = ?, nomeDArte = ? WHERE id_Artist = ? ";
			
			PreparedStatement pst = connection.prepareStatement(query_update);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, dataNascita);
			pst.setString(4, citta);
			pst.setInt(5, followers);
			pst.setString(6, nomeDArte);
			pst.setString(7, codice);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public ResultSet stampaArtist() {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();
			
			String query_stampa = "SELECT * FROM Artist";
			rs = st.executeQuery(query_stampa);
			
			return rs;
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return rs;
	}
}
