package _Controller;

import Connessione.ConnessioneDB;
import DAO.*;
import Entita.Utente;
import GUI.*;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Controller {

	Connection connection;

	// Frame
	private LoginGUI frameLogin;
	private SignUpGUI frameSignUp;
	private HomeGUI frameHome;
	private HomeUserGUI frameHomeUser;
	private AddArtistGUI frameAddArtist;
	private AddAlbumGUI frameAddAlbum;
	private AddSongGUI frameAddSong;

	// Interface
	private UtenteDAO utenteDAO;
	private ArtistaDAO artistDAO;
	private SongDAO songDAO;
	private AlbumDAO albumDAO;
	private EPDAO epDAO;
	private SingleDAO singleDAO;

	public Utente user = null;

	public Controller() {
		// Connessione al DB
		connection = ConnessioneDB.getConnection();

		// Frame principale
		frameLogin = new LoginGUI(this);
		frameLoginGUI();

		// Altri frame
		frameSignUp = new SignUpGUI(this);
		frameAddArtist = new AddArtistGUI(this);
		frameAddAlbum = new AddAlbumGUI(this);
		frameAddSong = new AddSongGUI(this);

		// DAO
		utenteDAO = new UtenteDAOimpl(this,connection);
		artistDAO = new ArtistaDAOimpl(this, connection);
		songDAO = new SongDAOimpl(this, connection);
		albumDAO = new AlbumDAOimpl(this, connection);
		epDAO = new EPDAOimpl(this, connection);
		singleDAO = new SingleDAOimpl(this, connection);

		// Aspetto default dei componenti
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Controller();
	}

	// SEARCH

	public void search(String TestoDaCercare) {

	}

	// USER

	public void insertUser(String username, String password, boolean isAdmin) {
		if((username.length()>0) && password.length()>0) {
			utenteDAO.insertUser(username, password, isAdmin);
		}
		else {
			JOptionPane.showMessageDialog(frameAddArtist,
					"Inserisci dei dati validi!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void checkUser(String username, String password) {
		if((username.length()>0) && password.length()>0) {
			user = utenteDAO.checkUser(username, password);
			if (user != null && user.isAdmin() == true) {
				frameHome = new HomeGUI(this);
				frameHomeGUI();
				frameLoginNotVisibleGUI();
			}
			else if(user != null && user.isAdmin() == false) {
				frameHomeUser = new HomeUserGUI(this);
				frameHomeUserGUI();
				frameLoginNotVisibleGUI();
			}
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"Password/Email errati!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(frameAddArtist,
					"Inserisci un User valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// ARTIST

	public void insertArtistDB(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta) {
		if((codice.length()>0) && (nome.length()>0) && (cognome.length()>0) && (dataNascita.length()>0) && (nomeDArte.length()>0) && (citta.length()>0)) {
			if(codice.length() >= 5) {
				String codArtista = codice.substring(0, 5);
				artistDAO.insertArtist(codArtista, nome, cognome, dataNascita, citta, nomeDArte);
			}
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"Il codice deve essere di 5 caratteri!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}

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
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare l'artista!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateArtistDB(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta, String followers) {
		if((codice.length()>0) && (nome.length()>0) && (cognome.length()>0) && (dataNascita.length()>0) && (nomeDArte.length()>0) && (citta.length()>0) && (followers.length()>0)) {
			int Ifollowers = Integer.parseInt(followers);
			if (Ifollowers >= 0) 
				artistDAO.updateArtist(codice, nome, cognome, dataNascita, citta, Ifollowers, nomeDArte);
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"Il numero di followers deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento artista!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
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

	// SONG

	public void insertSongDB(String nome, String durata, String genere, String album) {
		if((nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (album.length()>0)) {
			int duration = Integer.parseInt(durata);
			if (duration > 0) {
				String codAlbum = album.substring(0, 5);
				songDAO.insertSongDB(nome, duration, genere, codAlbum);
			}
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"La durata deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
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
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare il brano!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateSong(String codice, String nome, String songDuration) {
		if((codice.length()>0) && (nome.length()>0) && (songDuration.length()>0)) {
			int sDuration = Integer.parseInt(songDuration);
			if (sDuration > 0)
				songDAO.updateSong(codice, nome, sDuration);
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"La durata deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento il brano!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
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

	// SINGLE

	public void insertSingleDB(String nome, String durata, String genere, String artista, String dataPubblicazione) {
		if((artista.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (dataPubblicazione.length()>0)) {
			int durataInt = Integer.parseInt(durata);
			if (durataInt > 0) {
				String codArtista = artista.substring(0, 5);
				singleDAO.insertSingle(nome, durataInt, genere, codArtista, dataPubblicazione);
			}
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"La durata deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
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
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare il singolo!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateSingle(String codice,String nome, String durata, String genere, String dataPubblicazione) {
		if((codice.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (dataPubblicazione.length()>0)) {
			int durataInt = Integer.parseInt(durata);
			if (durataInt > 0)
				singleDAO.updateSingle(codice, nome, durataInt, genere, dataPubblicazione);
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"La durata deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento singolo!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
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

	// EP

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
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare l'EP!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateEP(String codice, String nome, String dataPubblicazione, String genere, String songNumber) {
		if((codice.length()>0) && (nome.length()>0) && (dataPubblicazione.length()>0) && (genere.length()>0) && (songNumber.length()>0)) {
			int songNumberInt = Integer.parseInt(songNumber);
			epDAO.updateEP(codice, nome, dataPubblicazione, genere, songNumberInt);
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento EP!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
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

	// ALBUM

	public void insertAlbumDB(String codice, String nome, String songNumber, String genere, String data, String artista) {
		if((codice.length()>0) && (nome.length()>0) && (songNumber.length()>0) && (genere.length()>0) && (data.length()>0) && (artista.length()>0)){
			int nSong = Integer.parseInt(songNumber);
			String codArtista = artista.substring(0, 5);
			if (nSong > 6) {
				if(codice.length() >= 5) {
					String codiceAlbum = codice.substring(0, 5);
					albumDAO.insertAlbum(codiceAlbum, nome, nSong, genere, data, codArtista);
				}
				else {
					JOptionPane.showMessageDialog(frameAddAlbum,
							"Il codice deve essere di 5 caratteri!!!",
							"Errore",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(frameAddAlbum,
						"Il numero di brani deve essere maggiore di 6!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
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
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare l'album!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateAlbum(String codice, String nome, String songNumber, String genere, String data) {
		if((codice.length()>0) && (nome.length()>0) && (songNumber.length()>0) && (genere.length()>0) && (data.length()>0)) {
			int nSong = Integer.parseInt(songNumber);
			if (nSong > 6)
				albumDAO.updateAlbum(codice, nome, nSong, genere, data);
			else {
				JOptionPane.showMessageDialog(frameAddAlbum,
						"Il numero di brani deve essere maggiore di 6!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento album!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
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

	// Visualizzazione FRAME

	public void frameLoginNotVisibleGUI() {
		frameLogin.setVisible(false);
	}

	public void frameLoginGUI() {
		frameLogin.setVisible(true);
	}

	public void frameSignUpGUI() {
		frameSignUp.setVisible(true);
	}

	public void frameHomeGUI() {
		frameHome.setVisible(true);
	}

	public void frameHomeUserGUI() {
		frameHomeUser.setVisible(true);
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
