package _Controller;

import Connessione.ConnessioneDB;
import DAO.*;
import GUI.*;

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
	EPDAO epDAO;
	SingleDAO singleDAO;

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
		epDAO = new EPDAOimpl(this, connection);
		singleDAO = new SingleDAOimpl(this, connection);
	}

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	public void insertArtistDB(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta, String followers) {
		if((codice.length()>0) && (nome.length()>0) && (cognome.length()>0) && (dataNascita.length()>0) && (nomeDArte.length()>0) && (citta.length()>0) && (followers.length()>0)) {
			int Ifollowers = Integer.parseInt(followers);
			String codArtista = codice.substring(0, 5);
			artistDAO.insertArtist(codArtista, nome, cognome, dataNascita, citta, Ifollowers, nomeDArte);
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
			JOptionPane.showMessageDialog(null,
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
			JOptionPane.showMessageDialog(null,
					"Errore aggiornamento artista!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public float retribuzioneArtista(String followers) {
		float followersArtista = Float.parseFloat(followers);
		float retribuzione = followersArtista / 1000;
		return retribuzione;
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

	public void insertSongDB(String nome, String durata, String genere, String album) {
		if((nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (album.length()>0)) {
			int duration = Integer.parseInt(durata);
			String codAlbum = album.substring(0, 5);
			songDAO.insertSongDB(nome, duration, genere, codAlbum);
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un brano valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteSongDB(String codice) {
		if(codice.length()>0){
			songDAO.deleteSong(codice);
		}
		else {
			JOptionPane.showMessageDialog(null,
				    "Impossibile eliminare il brano!!!",
				    "Errore",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateSong(String codice, String nome, String songDuration) {
		if((codice.length()>0) && (nome.length()>0) && (songDuration.length()>0)) {
			int sDuration = Integer.parseInt(songDuration);
			songDAO.updateSong(codice, nome, sDuration);
		}
		else {
			JOptionPane.showMessageDialog(null,
					"Errore aggiornamento il brano!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet stampaSongDB() {
		ResultSet rs = songDAO.stampaSong();
		try {
			if(rs != null)
				return rs;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void insertSingleDB(String nome, String durata, String genere, String artista, String dataPubblicazione) {
		if((artista.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (dataPubblicazione.length()>0)) {
			int durataInt = Integer.parseInt(durata);
			String codArtista = artista.substring(0, 5);
			singleDAO.insertSingle(nome, durataInt, genere, codArtista, dataPubblicazione);
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un singolo valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteSingleDB(String codice) {
		if(codice.length()>0){
			singleDAO.deleteSingle(codice);
		}
		else {
			JOptionPane.showMessageDialog(null,
				    "Impossibile eliminare il singolo!!!",
				    "Errore",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateSingle(String codice,String nome, String durata, String genere, String dataPubblicazione) {
		if((codice.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (dataPubblicazione.length()>0)) {
			int durataInt = Integer.parseInt(durata);
			singleDAO.updateSingle(codice, nome, durataInt, genere, dataPubblicazione);
		}
		else {
			JOptionPane.showMessageDialog(null,
					"Errore aggiornamento singolo!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet stampaSingleDB() {
		ResultSet rs = singleDAO.stampaSingle();
		try {
			if(rs != null)
				return rs;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void insertEPDB(String nome,  String genere, String songNumber, String artista, String dataPubblicazione) {
		if((nome.length()>0) && (genere.length()>0) && (songNumber.length()>0) && (artista.length()>0)  && (dataPubblicazione.length()>0)) {
			int songNumberInt = Integer.parseInt(songNumber);
			String codArtista = artista.substring(0, 5);
			epDAO.insertEP(nome, genere, songNumberInt, codArtista, dataPubblicazione);
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un EP valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteEPDB(String codice) {
		if(codice.length()>0){
			epDAO.deleteEP(codice);
		}
		else {
			JOptionPane.showMessageDialog(null,
				    "Impossibile eliminare l'EP!!!",
				    "Errore",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateEP(String codice, String nome, String dataPubblicazione, String genere, String songNumber) {
		if((codice.length()>0) && (nome.length()>0) && (dataPubblicazione.length()>0) && (genere.length()>0) && (songNumber.length()>0)) {
			int songNumberInt = Integer.parseInt(songNumber);
			epDAO.updateEP(codice, nome, dataPubblicazione, genere, songNumberInt);
		}
		else {
			JOptionPane.showMessageDialog(null,
					"Errore aggiornamento EP!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet stampaEPDB() {
		ResultSet rs = epDAO.stampaEP();
		try {
			if(rs != null)
				return rs;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void insertAlbumDB(String codice, String nome, String songNumber, String genere, String data, String artista) {
		if((codice.length()>0) && (nome.length()>0) && (songNumber.length()>0) && (genere.length()>0) && (data.length()>0) && (artista.length()>0)){
			int nSong = Integer.parseInt(songNumber);
			String codArtista = artista.substring(0, 5);
			String codiceAlbum = codice.substring(0, 5);
			albumDAO.insertAlbum(codiceAlbum, nome, nSong, genere, data, codArtista);
		}
		else {
			JOptionPane.showMessageDialog(frameAddAlbum,
					"Inserisci un album valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteAlbumDB(String codice) {
		if(codice.length()>0){
			albumDAO.deleteAlbum(codice);
		}
		else {
			JOptionPane.showMessageDialog(null,
				    "Impossibile eliminare l'album!!!",
				    "Errore",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateAlbum(String codice, String nome, String songNumber, String genere, String data) {
		if((codice.length()>0) && (nome.length()>0) && (songNumber.length()>0) && (genere.length()>0) && (data.length()>0)) {
			int nSong = Integer.parseInt(songNumber);
			albumDAO.updateAlbum(codice, nome, nSong, genere, data);
		}
		else {
			JOptionPane.showMessageDialog(null,
					"Errore aggiornamento album!!!",
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
