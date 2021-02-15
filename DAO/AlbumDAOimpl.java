package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _Controller.Controller;

public class AlbumDAOimpl implements AlbumDAO{
	
	Connection connection;
	Controller controller;
	
	public AlbumDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertAlbum(String codice, String nome, int songNumber, String genere, String data, String artista) {
		try {
			String query_insert_album = "INSERT INTO Album (id_Album, name, songNumber, genere) VALUES( ?, ?, ?, ?)";
			String query_insert_pubblicazione = "INSERT INTO Pubblica (releaseDate, id_Artist, id_Album, id_Single, id_EP) VALUES ( ?, ?, ?, NULL, NULL)";
			
			PreparedStatement pst1 = connection.prepareStatement(query_insert_album);
			pst1.setString(1, codice);
			pst1.setString(2, nome);
			pst1.setInt(3, songNumber);
			pst1.setString(4, genere);
			pst1.execute();
			
			PreparedStatement pst2 = connection.prepareStatement(query_insert_pubblicazione);

			pst2.setString(1, data);
			pst2.setString(2, artista);
			pst2.setString(3, codice);
			pst2.execute();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteAlbum(String codice) {
		try {
			String query_delete_album = "DELETE FROM Album WHERE id_Album = ?";
			
			PreparedStatement pst = connection.prepareStatement(query_delete_album);
			pst.setString(1, codice);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void updateAlbum(String codice, String nome, int songNumber, String genere, String data) {
		try {
			String query_update_album = "UPDATE Album SET name = ? , songNumber = ?, genere = ? WHERE id_Album = ?";
			String query_update_pubblica = "UPDATE Pubblica SET releaseDate = ?  WHERE id_Album = ?";
			
			PreparedStatement pst = connection.prepareStatement(query_update_album);
			pst.setString(1, nome);
			pst.setInt(2, songNumber);
			pst.setString(3, genere);
			pst.setString(4, codice);
			pst.executeUpdate();
			
			PreparedStatement pst2 = connection.prepareStatement(query_update_pubblica);
			pst2.setString(1, data);
			pst2.setString(2, codice);
			pst2.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public ResultSet stampaAlbum() {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();
			
			String query_stampa = "SELECT * FROM Album AS A NATURAL JOIN Pubblica AS P";
			rs = st.executeQuery(query_stampa);
			
			return rs;
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return rs;
	}
}
