package DAO;

import java.sql.Connection;
import _Controller.Controller;

public class ArtistaDAOimpl {
	
	Connection connection;
	Controller controller;
	
	public ArtistaDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}
}
