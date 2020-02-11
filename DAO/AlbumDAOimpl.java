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
	public void insertAlbum(String codice, String nome, String genere, String data, String artista) {
		try {
			String query_insert_album = "INSERT INTO Album (codice, nome, genere) VALUES( ?, ?, ?)";
			String query_insert_pubblicazione = "INSERT INTO Publica (id_Release, relaseDate, id_Artist, id_Album, id_Song, id_EP) VALUES( codicePublica.NEXTVAL, ?, ?, ?, NULL, NULL)";
			
			PreparedStatement pst1 = connection.prepareStatement(query_insert_album);
			pst1.setString(1, codice);
			pst1.setString(2, nome);
			pst1.setString(3, genere);
			pst1.execute();
			
			PreparedStatement pst2 = connection.prepareStatement(query_insert_pubblicazione);
			pst2.setString(1, data);
			pst2.setString(2, artista);
			pst2.setString(3, codice);
			pst2.execute();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
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
