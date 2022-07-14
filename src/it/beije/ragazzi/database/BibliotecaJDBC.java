package it.beije.ragazzi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BibliotecaJDBC {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			System.out.println("Sono nel try");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?serverTimezone=CET&useSSL=false", "root", "Marcellona1994!");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?serverTimezone=CET&useSSL=false", "root", "beije");
			System.out.println("connection open ? " + !connection.isClosed());
			Statement statement = connection.createStatement();
		// INSERT
		// statement.executeUpdate("INSERT INTO utenti (nome, cognome, telefono, email)
		// VALUES ('Piero', 'Verde', '5355223532', 'l.verde@beije.it')");
		// statement.executeUpdate("INSERT INTO utenti VALUES (null, 'Piero', 'Verde2',
		// '5355223532', 'l.verde2@beije.it')");
			
			String nome = "Gianni";
			String cognome = "Celeste";
			String telefono = "036746134";
			String email = "gc@beije.it";
			String paese = "Albania";
			
//			String query = "INSERT INTO utenti VALUES (null, '" + nome + "', '" + cognome + "', '" + telefono + "', '" + email + "')";
//			System.out.println(query);
			//statement.executeUpdate(query);
			
			PreparedStatement insertPrepStatement = connection.prepareStatement("INSERT INTO utenti VALUES (null, ?, ?, ?, ?, ?)");
//			PreparedStatement insertPrepStatement = connection.prepareStatement("UPDATE utenti SET paese = ? where id = 10");
//			PreparedStatement insertPrepStatement = connection.prepareStatement("DELETE FROM utenti WHERE id = ?");

			insertPrepStatement.setString(1, nome);
			insertPrepStatement.setString(2, cognome);
			insertPrepStatement.setString(3, telefono);
			insertPrepStatement.setString(4, email);
			insertPrepStatement.setString(5, paese);
			
//			insertPrepStatement.setString(1, paese);
			
//			insertPrepStatement.setInt(1, 9);
			insertPrepStatement.execute();

		// UPDATE
		// statement.executeUpdate("UPDATE utenti SET telefono = '1234567' where id =
		// 2");
		// statement.executeUpdate("update utenti set paese = 'Svezia' where id = 1");

		// DELETE
		// statement.executeUpdate("DELETE FROM utenti where id = 4");

		// SELECT
//		statement.executeUpdate("insert into prestiti values (null, 1, 1987, 'Bari', '3/2/2022')");
		
//		ResultSet rs = statement.executeQuery("SELECT * FROM prestiti");
//			ResultSet rs = statement.executeQuery("SELECT * FROM prestiti");

		ResultSet rs = statement.executeQuery("SELECT * FROM utenti");
		while (rs.next()) {
			// System.out.println("id : " + rs.getInt(1));
			// System.out.println("nome : " + rs.getString(2));
			// System.out.println("cognome : " + rs.getString(3));
			// System.out.println("email : " + rs.getString(4));
			// System.out.println("telefono : " + rs.getString(5));

			System.out.println("id : " + rs.getInt("id"));
			System.out.println("nome : " + rs.getString("nome"));
			System.out.println("cognome : " + rs.getString("cognome"));
			System.out.println("email : " + rs.getString("email"));
			System.out.println("telefono : " + rs.getString("telefono"));
			System.out.println("paese : " + rs.getString("paese"));
		
//				System.out.println("id_prestito : " + rs.getInt("id"));
//				System.out.println("id_utente : " + rs.getInt("id_utente"));
//				System.out.println("id_libro : " + rs.getInt("id_libro"));
//				System.out.println("luogo_prestito : " + rs.getString("luogo_prestito"));
//				System.out.println("data_restituzione : " + rs.getString("data_restituzione"));
			}
//		ResultSet rsPrestiti = statement.executeQuery("select * from prestiti");
//		while (rsPrestiti.next()) {
//			System.out.println("id_prestito : " + rs.getInt("id"));
//			System.out.println("id_utente : " + rs.getInt("id"));
//			System.out.println("id_libro : " + rs.getInt("id"));
//			System.out.println("luogo_prestito" + rs.getString("luogo_prestito"));
//			System.out.println("data_restituzione : " + rs.getString("data_restituzione"));
//		}
		// rs.close();
		// statement.close();
		// connection.close();
//		throw new Exception("Prova di lancio eccezione");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Sono nel finally e vengo richiamato indipendentemente dalle eccezioni");
//			 rs.close();
//			 statement.close();
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
