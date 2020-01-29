package Connessione;

import java.sql.*;

public class ConnessioneDB {
	
	private static Connection connection = null;
	
	private ConnessioneDB() {
		
	}
	
	public static Connection getConnection() {
		
		if(connection == null){
			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Caricamento Driver...");
			}
			catch(ClassNotFoundException e) {
				System.err.println("Errore caricamento Driver: "+e.getMessage());
			}
			
			String url = "jdbc:postgresql://localhost/SmuP";
			String nome = "postgres";
			String pwd = "1234";
			
			try {
				connection = DriverManager.getConnection(url,nome,pwd);
				System.out.println("Connessione avvenuta...");
			}
			catch(SQLException sql) {
				System.err.println("Errore connessione: " + sql.getMessage());
			}
		}
		return connection;
		
	}
}

