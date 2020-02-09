package DAO;

import java.sql.Connection;
import java.sql.ResultSet;

import _Controller.Controller;

public class ArtistaDAOimpl implements ArtistaDAO{
	
	Connection connection;
	Controller controller;
	
	public ArtistaDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertArtist(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta, String followers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet stampaArtist() {
		// TODO Auto-generated method stub
		return null;
	}
}
