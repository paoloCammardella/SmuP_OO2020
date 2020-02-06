package DAO;

import java.sql.Connection;
import _Controller.Controller;

public class SongDAOimpl {
	
	Connection connection;
	Controller controller;
	
	public SongDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}
}
