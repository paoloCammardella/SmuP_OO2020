package DAO;

import java.sql.Connection;
import java.sql.ResultSet;

import _Controller.Controller;

public class SongDAOimpl implements SongDAO{
	
	Connection connection;
	Controller controller;
	
	public SongDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertSongDB(String artista, String nome, String durata, String genere, String album) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet stampaSong() {
		// TODO Auto-generated method stub
		return null;
	}
}
