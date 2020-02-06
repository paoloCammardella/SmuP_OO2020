package DAO;

import java.sql.Connection;

import _Controller.Controller;

public class AlbumDAOimpl {
	
	Connection connection;
	Controller controller;
	
	public AlbumDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}
}
