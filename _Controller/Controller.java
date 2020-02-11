package _Controller;

import GUI.AddAlbumGUI;
import GUI.AddArtistGUI;
import GUI.AddSongGUI;
import GUI.HomeGUI;
import Connessione.ConnessioneDB;
import DAO.AlbumDAO;
import DAO.AlbumDAOimpl;
import DAO.ArtistaDAO;
import DAO.ArtistaDAOimpl;
import DAO.SongDAO;
import DAO.SongDAOimpl;

import java.sql.*;

import javax.swing.JOptionPane;

public class Controller {

	Connection connection;
	
	HomeGUI frameHome;
	AddArtistGUI frameAddArtist;
	AddAlbumGUI frameAddAlbum;
	AddSongGUI frameAddSong;
	
	ArtistaDAO artistDAO;
	SongDAO songDAO;
	AlbumDAO albumDAO;

	public Controller() {
		//Connessione al DB
		connection = ConnessioneDB.getConnection();

		//Frame principale
		frameHome = new HomeGUI(this);
		frameHome.setVisible(true);

		//Altri frame
		frameAddArtist = new AddArtistGUI(this);
		frameAddAlbum = new AddAlbumGUI(this);
		frameAddSong = new AddSongGUI(this);
		
		//DAO
		artistDAO = new ArtistaDAOimpl(this, connection);
		songDAO = new SongDAOimpl(this, connection);
		albumDAO = new AlbumDAOimpl(this, connection);
	}

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	public void insertArtistDB(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta, String followers) {
		if((codice.length()>0) && (nome.length()>0) && (cognome.length()>0) && (dataNascita.length()>0) && (nomeDArte.length()>0) && (citta.length()>0) && (followers.length()>0)) {
			int Ifollowers = Integer.parseInt(followers);
			artistDAO.insertArtist(codice, nome, cognome, dataNascita, citta, Ifollowers, nomeDArte);
		}
		else {
			JOptionPane.showMessageDialog(frameAddArtist,
					"Inserisci un Artista valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteArtistDB(String codice) {
		if(codice.length()>0){
			artistDAO.deleteArtist(codice);
		}
		else {
			JOptionPane.showMessageDialog(frameHome,
				    "Impossibile eliminare l'artista!!!",
				    "Errore",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateArtistDB(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta, String followers) {
		if((codice.length()>0) && (nome.length()>0) && (cognome.length()>0) && (dataNascita.length()>0) && (nomeDArte.length()>0) && (citta.length()>0) && (followers.length()>0)) {
			int Ifollowers = Integer.parseInt(followers);
			artistDAO.updateArtist(codice, nome, cognome, dataNascita, citta, Ifollowers, nomeDArte);
		}
		else {
			JOptionPane.showMessageDialog(frameHome,
					"Errore aggiornamento artista!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet stampaArtistDB() {
		ResultSet rs = artistDAO.stampaArtist();
		try {
			if(rs != null)
				return rs;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void insertSongDB(String artista, String nome, String durata, String genere, String album) {
		if((artista.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (album.length()>0)) {
			songDAO.insertSongDB(artista, nome, durata, genere, album);
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un brano valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void insertSingleDB(String artista, String nome, String durata, String genere) {
		if((artista.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0)) {
			//Inserimento singolo
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un singolo valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void insertEPDB(String artista, String nome, String durata, String genere, String ep) {
		if((artista.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (ep.length()>0)) {
			//Inserimento ep
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un EP valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void insertAlbumDB(String codice, String nome, String genere, String data, String artista) {
		if((codice.length()>0) && (nome.length()>0) && (genere.length()>0) && (data.length()>0) && (artista.length()>0)){
			albumDAO.insertAlbum(nome, codice, genere, data, artista);
		}
		else {
			JOptionPane.showMessageDialog(frameAddAlbum,
					"Inserisci un album valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet stampaAlbumDB() {
		ResultSet rs = albumDAO.stampaAlbum();
		try {
			if(rs != null)
				return rs;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void frameAddArtistGUI() {
		frameAddArtist.setVisible(true);
	}

	public void frameAddAlbumGUI() {
		frameAddAlbum.setVisible(true);
	}

	public void frameAddSongGUI() {
		frameAddSong.setVisible(true);
	}
}
