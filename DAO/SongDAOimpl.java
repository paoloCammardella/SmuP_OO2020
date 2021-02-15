package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _Controller.Controller;

public class SongDAOimpl implements SongDAO{
	
	Connection connection;
	Controller controller;
	
	public SongDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertSongDB(String nome, int durata, String genere, String album) {
		try {
			String query_insert_song = "INSERT INTO Brano (songName, songDuration, genereSong, id_Album) VALUES(?, ?, ?, ?)";
			
			PreparedStatement pst1 = connection.prepareStatement(query_insert_song);
			pst1.setString(1, nome);
			pst1.setInt(2, durata);
			pst1.setString(3, genere);
			pst1.setString(4, album);
			pst1.execute();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
		}		
	}
	
	@Override
	public void deleteSong(String codice) {
		try {
			String query_delete_song = "DELETE FROM Brano WHERE id_Song = ?";
			
			PreparedStatement pst = connection.prepareStatement(query_delete_song);
			pst.setString(1, codice);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void updateSong(String codice, String nome, int durata) {
		try {
			String query_update_song = "UPDATE Brano SET songName = ? , songDuration = ? WHERE id_Song = ?";
			
			PreparedStatement pst = connection.prepareStatement(query_update_song);
			pst.setString(1, nome);
			pst.setInt(2, durata);
			pst.setString(3, codice);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public ResultSet stampaSong() {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();
			
			String query_stampa = "SELECT * FROM Album AS A,Pubblica AS P,Brano AS B WHERE A.id_Album = P.id_Album AND A.id_Album = B.id_Album";
			rs = st.executeQuery(query_stampa);
			
			return rs;
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return rs;
	}
}
