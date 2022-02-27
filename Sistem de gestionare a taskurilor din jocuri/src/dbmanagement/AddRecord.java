package dbmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import functions.GenerateId;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class AddRecord {
	/**
	 * Metoda care adauga un joc in baza de date
	 * @param  String name Numele jocului
	 */
	public static void addGame(String name) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement state=conn.createStatement();){
			String query="INSERT INTO games(name) VALUES ('"+name+"')";
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metoda care adauga un DLC in baza de date
	 * @param  String name Numele DLC-ului
	 */
	public static void addDLC(String name) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		long id=GenerateId.generateId();
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement state=conn.createStatement();){
			String query="INSERT INTO dlcs VALUES ("+id+",'"+name+"')";
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
