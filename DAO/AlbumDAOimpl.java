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
		ResultSet rs = null;
		try {
			String query_insert_album = "INSERT INTO Album (id_Album, name, songNumber, genere) VALUES( ?, ?, ?, ?)";
			String sequence = "SELECT NEXTVAL('codicePubblica')";
			String query_insert_pubblicazione = "INSERT INTO Pubblica (id_Release, releaseDate, id_Artist, id_Album, id_Single, id_EP) VALUES (?, ?, ?, ?, NULL, NULL)";
			
			Statement seq = connection.createStatement();
			rs = seq.executeQuery(sequence);
			
			PreparedStatement pst1 = connection.prepareStatement(query_insert_album);
			pst1.setString(1, codice);
			pst1.setString(2, nome);
			pst1.setInt(3, songNumber);
			pst1.setString(4, genere);
			pst1.execute();
			
			PreparedStatement pst2 = connection.prepareStatement(query_insert_pubblicazione);
			
			int idPubblica = 0;
			if(rs.next()) {
				idPubblica = rs.getInt(1);
			}
			else
				System.out.print("Errore sequenza");
			
			pst2.setInt(1, idPubblica);
			pst2.setString(2, data);
			pst2.setString(3, artista);
			pst2.setString(4, codice);
			pst2.execute();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet stampaAlbum() {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();
			
			String query_stampa = "SELECT * FROM Album";
			rs = st.executeQuery(query_stampa);
			
			return rs;
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return rs;
	}
}
