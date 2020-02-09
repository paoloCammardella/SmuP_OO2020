package _Controller;

import GUI.AddAlbumGUI;
import GUI.AddArtistGUI;
import GUI.AddSongGUI;
import GUI.HomeGUI;
import Connessione.ConnessioneDB;
import DAO.AlbumDAO;

import java.sql.*;

import javax.swing.JOptionPane;

public class Controller {

	Connection connection;
	
	AddArtistGUI frameAddArtist;
	AddAlbumGUI frameAddAlbum;
	AddSongGUI frameAddSong;
	
	AlbumDAO albumDAO;
	
	public Controller() {
		//Connessione al DB
		connection = ConnessioneDB.getConnection();
		
		//Frame principale
		HomeGUI frameHome = new HomeGUI(this);
		frameHome.setVisible(true);
		
		//Altri frame
		frameAddArtist = new AddArtistGUI(this);
		frameAddAlbum = new AddAlbumGUI(this);
		frameAddSong = new AddSongGUI(this);
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
	public void insertAlbumDB(String codice, String nome, String genere) {
		if((codice.length()>0) && (nome.length()>0) && (genere.length()>0)){
			albumDAO.insertAlbum(nome, codice, genere);
		}
		else {
			JOptionPane.showMessageDialog(frameAddAlbum,
					"Inserisci un album valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public void frameAddSongGUI() {
		frameAddSong.setVisible(true);
	}
}
