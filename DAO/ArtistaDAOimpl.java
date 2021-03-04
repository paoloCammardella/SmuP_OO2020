package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _Controller.Controller;

public class ArtistaDAOimpl implements ArtistaDAO{

	Connection connection;
	Controller controller;

	public ArtistaDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertArtist(String codice, String nome, String cognome, String dataNascita, String citta, String nomeDArte) {
		try {
			String query_insert = "INSERT INTO Artista (id_artist, firstName, secondName, birthDate, city, followers, nomeDArte) VALUES (?,?,?,?,?,0,?)";

			PreparedStatement pst = connection.prepareStatement(query_insert);
			pst.setString(1, codice);
			pst.setString(2, nome);
			pst.setString(3, cognome);
			pst.setString(4, dataNascita);
			pst.setString(5, citta);
			pst.setString(6, nomeDArte);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
		}
	}

	@Override
	public void deleteArtist(String codice) {
		try {
			String query_delete = "DELETE FROM Artista WHERE id_Artist = ?";

			PreparedStatement pst = connection.prepareStatement(query_delete);
			pst.setString(1, codice);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateArtist(String codice, String nome, String cognome, String dataNascita, String citta, int followers, String nomeDArte) {
		try {
			String query_update = "UPDATE Artista SET firstName = ? , secondName = ?, birthDate = ?, city = ?, followers = ?, nomeDArte = ? WHERE id_Artist = ? ";

			PreparedStatement pst = connection.prepareStatement(query_update);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, dataNascita);
			pst.setString(4, citta);
			pst.setInt(5, followers);
			pst.setString(6, nomeDArte);
			pst.setString(7, codice);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	
	// STAMPA PER USER NON ADMIN
	@Override
	public ResultSet stampaArtist(String id_User) {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();

			String query_stampa = "SELECT * FROM Artista WHERE id_Artist NOT IN (SELECT id_Artist FROM Following WHERE id_User = '" + id_User + "')";
			rs = st.executeQuery(query_stampa);

			return rs;
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}
	
	@Override
	public ResultSet stampaArtist() {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();

			String query_stampa = "SELECT * FROM Artista";
			rs = st.executeQuery(query_stampa);

			return rs;
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}

	@Override
	public ResultSet searchArtist(String nomeDaCercare) {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();

			String query_cerca = "SELECT nomeDArte, id_Artist FROM Artista AS A WHERE nomeDArte LIKE '%" + nomeDaCercare + "%'";
			rs = st.executeQuery(query_cerca);

			return rs;
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}
}
