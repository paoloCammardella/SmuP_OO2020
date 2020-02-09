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
	public void insertAlbum(String codice, String nome, String genere) {
		try {
			String query_insert = "INSERT INTO Album (codice, nome, genere) VALUES( ?, ?, ?)";
			
			PreparedStatement pst = connection.prepareStatement(query_insert);
			pst.setString(1, codice);
			pst.setString(2, nome);
			pst.setString(3, genere);
			pst.execute();
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
