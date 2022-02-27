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
public class Update {
	/**
	 * Metoda care actualizeaza tabelul Challenge atunci cand numarul asociat unui challenge se modifica.
	 * @param  int id ID-ul challenge-ului
	 * @param  int newNum Numarul nou
	 */
	public static void updateChallenge(int id,int newNum) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="UPDATE challenges SET num="+newNum+" WHERE id="+id;
					state.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
}
