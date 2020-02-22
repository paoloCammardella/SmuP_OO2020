package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _Controller.Controller;

public class EPDAOimpl implements EPDAO{

	Connection connection;
	Controller controller;

	public EPDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertEP(String nome,  String genere, int songNumber, String artista, String dataPubblicazione) {
		ResultSet rs = null;
		try {
			String query_insert_ep = "INSERT INTO EP (id_EP, nameEP, songNumber, genere) VALUES( ?, ?, ?, ?)";
			String sequence = "SELECT NEXTVAL('codiceEP')";
			String sequencePubblica = "SELECT NEXTVAL('codicePubblica')";
			String query_insert_pubblicazione = "INSERT INTO Pubblica (id_Release, releaseDate, id_Artist, id_Album, id_Single, id_EP) VALUES (?, ?, ?, NULL, NULL, ?)";

			Statement seq = connection.createStatement();
			rs = seq.executeQuery(sequence);

			int idEP = 0;
			if(rs.next()) {
				idEP = rs.getInt(1);
			}
			else
				System.out.print("Errore sequenza");

			PreparedStatement pst1 = connection.prepareStatement(query_insert_ep);
			pst1.setInt(1, idEP);
			pst1.setString(2, nome);
			pst1.setInt(3, songNumber);
			pst1.setString(4, genere);
			pst1.execute();

			Statement seqPubblica = connection.createStatement();
			rs = seqPubblica.executeQuery(sequencePubblica);

			int idPubblica = 0;
			if(rs.next()) {
				idPubblica = rs.getInt(1);
			}

			PreparedStatement pst2 = connection.prepareStatement(query_insert_pubblicazione);
			pst2.setInt(1, idPubblica);
			pst2.setString(2, dataPubblicazione);
			pst2.setString(3, artista);
			pst2.setInt(4, idEP);
			pst2.execute();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
		}		
	}
	@Override
	public void deleteEP(String codice) {
		try {
			String query_delete_ep = "DELETE FROM EP WHERE id_EP = ?";

			PreparedStatement pst = connection.prepareStatement(query_delete_ep);
			pst.setString(1, codice);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateEP(String codice, String nome, String dataPubblicazione, String genere, int songNumber) {
		try {
			String query_update_single = "UPDATE EP SET nameEP = ? , songNumber = ?, genere = ? WHERE id_EP = ?";
			String query_update_pubblica = "UPDATE Pubblica SET releaseDate = ? WHERE id_EP = ?";

			PreparedStatement pst = connection.prepareStatement(query_update_single);
			pst.setString(1, nome);
			pst.setInt(2, songNumber);
			pst.setString(3, genere);
			pst.setString(4, codice);
			pst.executeUpdate();

			PreparedStatement pst1 = connection.prepareStatement(query_update_pubblica);
			pst1.setString(1, dataPubblicazione);
			pst1.setString(2, codice);
			pst1.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet stampaEP() {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();

			String query_stampa = "SELECT * FROM EP NATURAL JOIN Pubblica ;";
			rs = st.executeQuery(query_stampa);

			return rs;
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return rs;
	}

}
