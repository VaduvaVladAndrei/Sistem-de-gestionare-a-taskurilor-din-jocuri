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
public class AddChallenge {
	/**
	 * Metoda care adauga un challenge in baza de date
	 * <p>
	 * @param  int gameid ID-ul jocului de care apartine
	 * @param  String description Descrierea challenge-ului
	 * @param  int maxNr Numarul asociat challenge-ului
	 */
	public static void addChallenge(int gameid,String description,int maxNr) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="SET FOREIGN_KEY_CHECKS=0";
					state.executeUpdate(query);
					query="INSERT INTO challenges(gameid,description,num) VALUES ("+gameid+",'"+description+"',"+maxNr+")";
					state.executeUpdate(query);
					
					query="SET FOREIGN_KEY_CHECKS=1";
					state.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
}
