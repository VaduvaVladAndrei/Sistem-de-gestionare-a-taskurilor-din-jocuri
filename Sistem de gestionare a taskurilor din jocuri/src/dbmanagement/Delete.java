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
public class Delete {
	/**
	 * Metoda care sterge un joc din baza de date
	 * @param  int id ID-ul jocului
	 */
	public static void DeleteGame(int id) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="DELETE FROM tasks WHERE GAMEID="+id;
					state.executeUpdate(query);
					query="DELETE FROM challenges WHERE GAMEID="+id;
					state.executeUpdate(query);
					query="DELETE FROM games WHERE ID="+id;
					state.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	/**
	 * Metoda care sterge un DLC din baza de date
	 * @param  int id ID-ul DLC-ului
	 */
	public static void DeleteDLC(int id) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="DELETE FROM tasks WHERE GAMEID="+id;
					state.executeUpdate(query);
					query="DELETE FROM challenges WHERE GAMEID="+id;
					state.executeUpdate(query);
					query="DELETE FROM dlcs WHERE ID="+id;
					state.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	/**
	 * Metoda care sterge un task din baza de date
	 * @param  int id ID-ul task-ului
	 */
	public static void DeleteTask(int id) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="DELETE FROM tasks WHERE ID="+id;
					state.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	/**
	 * Metoda care sterge un challenge din baza de date
	 * @param  int id ID-ul challenge-ului
	 */
	public static void DeleteChallenge(int id) {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="DELETE FROM challenges WHERE ID="+id;
					state.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
}
