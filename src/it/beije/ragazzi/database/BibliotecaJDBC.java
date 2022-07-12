package it.beije.ragazzi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BibliotecaJDBC {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?serverTimezone=CET", "root", "beije");

		System.out.println("connection open ? " + !connection.isClosed());
		
		Statement statement = connection.createStatement();

		//INSERT
		//statement.executeUpdate("INSERT INTO utenti (nome, cognome, telefono, email) VALUES ('Piero', 'Verde', '5355223532', 'l.verde@beije.it')");
//		statement.executeUpdate("INSERT INTO utenti VALUES (null, 'Piero', 'Verde2', '5355223532', 'l.verde2@beije.it')");
		
		//UPDATE
//		statement.executeUpdate("UPDATE utenti SET telefono = '1234567' where id = 2");

		//DELETE
//		statement.executeUpdate("DELETE FROM utenti where id = 4");

		//SELECT		
		ResultSet rs = statement.executeQuery("SELECT * FROM utenti");
		//ResultSet rs = statement.executeQuery("SELECT nome, cognome, email FROM utenti");
		while (rs.next()) {
//			System.out.println("id : " + rs.getInt(1));				
//			System.out.println("nome : " + rs.getString(2));				
//			System.out.println("cognome : " + rs.getString(3));				
//			System.out.println("email : " + rs.getString(4));				
//			System.out.println("telefono : " + rs.getString(5));				

			System.out.println("id : " + rs.getInt("id"));				
			System.out.println("nome : " + rs.getString("nome"));				
			System.out.println("cognome : " + rs.getString("cognome"));				
			System.out.println("email : " + rs.getString("email"));				
			System.out.println("telefono : " + rs.getString("telefono"));				
		}
		
		
		rs.close();
		statement.close();
		connection.close();
	}

}
