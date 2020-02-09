package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import _Controller.Controller;

public class AlbumDAOimpl implements AlbumDAO{

	Connection connection;
	Controller controller;
	String query = new String("INSERT INTO Album (codice, nome, genere) VALUES( ?, ?, ?)");

	public AlbumDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertAlbum(String codice, String nome, String genere) {
		PreparedStatement s;
		try {
			s = connection.prepareStatement(query);
			s.setString(1, codice);
			s.setString(2, nome);
			s.setString(3, genere);
			s.execute();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}		
	}
}

