package _Controller;

import GUI.AddAlbumGUI;
import GUI.AddArtistGUI;
import GUI.HomeGUI;
import Connessione.ConnessioneDB;
import java.sql.*;

public class Controller {

	Connection connection;
	
	AddArtistGUI frameAddArtist;
	AddAlbumGUI frameAddAlbum;
	
	public Controller() {
		//Connessione al DB
		connection = ConnessioneDB.getConnection();
		
		//Frame principale
		HomeGUI frameHome = new HomeGUI(this);
		frameHome.setVisible(true);
		
		//Altri frame
		frameAddArtist = new AddArtistGUI(this);
		frameAddAlbum = new AddAlbumGUI(this);
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
	}
	
	public void frameAddArtistGUI() {
		frameAddArtist.setVisible(true);
	}
	
	public void frameAddAlbumGUI() {
		frameAddAlbum.setVisible(true);
	}
}
