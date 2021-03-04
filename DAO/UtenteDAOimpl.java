package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Entita.Utente;
import _Controller.Controller;

public class UtenteDAOimpl implements UtenteDAO {

	Connection connection;
	Controller controller;

	public UtenteDAOimpl( Controller controller, Connection connection) {
		this.connection = connection;
		this.controller = controller;
	}

	@Override
	public void insertUser(String username, String password, boolean isAdmin) {
		try {
			String query_insert_user = "INSERT INTO Utente (username, password, isAdmin) VALUES(?, ?, ?)";

			PreparedStatement pst1 = connection.prepareStatement(query_insert_user);
			pst1.setString(1, username);
			pst1.setString(2, password);
			pst1.setBoolean(3, isAdmin);
			pst1.execute();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Username già in uso!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public Utente checkUser(String username, String password) {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();
			String query_check_user = "SELECT * FROM Utente"
					+ " WHERE username = '" + username + "' AND password = '" + password + "'";

			rs = st.executeQuery(query_check_user);

			if (rs != null) {
				while(rs.next()) {
					Utente utente = new Utente(rs.getString("id_User"), rs.getString("username"), rs.getString("password"), rs.getBoolean("isAdmin"));
					return utente;
				}
			}
		}
		catch(SQLException e) {
			System.out.println("Errore accesso: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
