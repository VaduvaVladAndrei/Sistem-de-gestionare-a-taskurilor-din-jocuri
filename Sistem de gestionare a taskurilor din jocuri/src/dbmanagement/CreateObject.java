package dbmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import objects.Challenge;
import objects.Game;
import objects.Task;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class CreateObject {
	/**
	 * Metoda care returneaza o lista de jocuri din baza de date
	 * @return List<Game> O lista cu jocuri
	 */
	public static List<Game> getGame() {
		final String DB_URL="jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		List<Game> resultList = new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);			
				Statement state=conn.createStatement();){
			
			String query="CREATE OR REPLACE VIEW dlcgames AS SELECT * FROM games UNION SELECT * FROM dlcs";
			state.executeUpdate(query);
			
			query="SELECT * FROM dlcgames";
			ResultSet result=state.executeQuery(query);
			
			while(result.next()) {
				int id=result.getInt("id");
				String name=result.getString("name");
				resultList.add(new Game(id,name));
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		
		return resultList;
	}
	/**
	 * Metoda care returneaza o lista de task-uri din baza de date, care apartin unui joc anume
	 * @param  int gameid ID-ul jocului de care apartine
	 * @return List<Task> Lista de task-uri
	 */
	public static List<Task> getTask(int gameid){
		final String DB_URL="jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		List<Task> resultList = new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);			
				Statement state=conn.createStatement();){
			String query="CREATE OR REPLACE VIEW todo AS SELECT * FROM tasks WHERE gameid="+gameid;
			state.executeUpdate(query);
			query="SELECT * FROM todo";
			ResultSet result=state.executeQuery(query);
			
			while(result.next()) {
				int id=result.getInt("id");
				String description=result.getString("description");
				resultList.add(new Task(description,id,gameid));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	/**
	 * Metoda care returneaza o lista de challenge-uri din baza de date, care apartin unui joc anume
	 * @param  int gameid ID-ul jocului de care apartine
	 * @return List<Task> Lista de challenge-uri
	 */
	public static List<Challenge> getChallenge(int gameid){
		final String DB_URL="jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		List<Challenge> resultList = new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);			
				Statement state=conn.createStatement();){
			String query="CREATE OR REPLACE VIEW todoch AS SELECT * FROM challenges WHERE gameid="+gameid;
			state.executeUpdate(query);
			query="SELECT * FROM todoch";
			ResultSet result=state.executeQuery(query);
			
			while(result.next()) {
				int id=result.getInt("id");
				String description=result.getString("description");
				int maxNr=result.getInt("num");
				resultList.add(new Challenge(id,gameid,description,maxNr));
			}
			
			System.out.println("VEDERI:");
			query="SELECT table_name from information_schema.views WHERE table_schema='gestionaretaskjocuri'";
			result=state.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString("table_name"));
			}
			System.out.println();
			
			//query="DROP VIEW todoch";
			//state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
}
