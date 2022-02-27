package dbmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */

public class AddTask {
	/**
	 * Metoda care adauga un Task in baza de date
	 * @param  int gameid ID-ul jocului de care apartine
	 * @param  String description Descrierea task-ului
	 */
	public static void AddTask(int gameid,String description) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="SET FOREIGN_KEY_CHECKS=0";
					state.executeUpdate(query);
					query="INSERT INTO tasks(gameid,description) VALUES ("+gameid+",'"+description+"')";
					state.executeUpdate(query);
					
					query="SET FOREIGN_KEY_CHECKS=1";
					state.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
}
