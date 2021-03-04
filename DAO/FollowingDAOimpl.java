package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _Controller.Controller;

public class FollowingDAOimpl implements FollowingDAO {
	
	Connection connection;
	Controller controller;

	public FollowingDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertFollow(String id_User, String id_Artist) {
		try {
			String query_insert_follow = "INSERT INTO Following (id_User, id_Artist) VALUES(?, ?)";

			PreparedStatement pst1 = connection.prepareStatement(query_insert_follow);
			pst1.setString(1, id_User);
			pst1.setString(2, id_Artist);
			pst1.execute();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void removeFollow(String id_User, String id_Following) {
		try {			
			String query_decremente_followers = "UPDATE Artista AS A SET followers = followers - 1 WHERE A.id_artist IN (SELECT id_Artist FROM Following AS F WHERE id_Following = ?)";
			PreparedStatement pst2 = connection.prepareStatement(query_decremente_followers);
			pst2.setString(1, id_Following);
			pst2.executeUpdate();
			
			String query_delete_follow = "DELETE FROM Following WHERE id_Following = ? AND id_User = ?";

			PreparedStatement pst1 = connection.prepareStatement(query_delete_follow);
			pst1.setString(1, id_Following);
			pst1.setString(2, id_User);
			pst1.execute();
		}
		catch(SQLException e) {
			System.out.println("Errore cancellazione: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet printFollow(String id_User) {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();

			String query_stampa = "SELECT * FROM (Utente NATURAL JOIN Following) NATURAL JOIN Artista WHERE id_User = '" + id_User + "'";
			rs = st.executeQuery(query_stampa);

			return rs;
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}

}
