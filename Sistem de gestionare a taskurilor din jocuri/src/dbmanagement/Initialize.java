package dbmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class Initialize {
	/**
	 * Metoda care creaza tabelele necesare pentru rularea programului
	 * <p>
	 * Se creaza tabelele Games, DLCs, Tasks si Challenges
	 * <p>
	 * In aceasta metoda se adauga, de asemenea, indecsi, se afiseaza acesti indecsi, precum si secventele din fiecare tabel, dar si o lista de tabele.
	 */
	public static void createMainTable() {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);			
		Statement state=conn.createStatement();){
			String query="CREATE TABLE IF NOT EXISTS GAMES"
					+"("
					+"ID int AUTO_INCREMENT PRIMARY KEY,"
					+"NAME VARCHAR(50)"
					+")";
			state.executeUpdate(query);
			
			query="CREATE TABLE IF NOT EXISTS DLCs"
					+"("
					+"ID int NOT NULL,"
					+"NAME VARCHAR(50),"
					+"PRIMARY KEY(ID)"
					+")";
			state.executeUpdate(query);
			
			query="CREATE TABLE IF NOT EXISTS TASKS"
					+"("
					+"ID int AUTO_INCREMENT PRIMARY KEY,"
					+"GAMEID int NOT NULL,"
					+"DESCRIPTION VARCHAR(200),"
					+"CONSTRAINT fk_taskgame FOREIGN KEY (GAMEID) REFERENCES GAMES(ID),"
					+"CONSTRAINT fk_taskdlc FOREIGN KEY (GAMEID) REFERENCES DLCs(ID)"
					+")";
			state.executeUpdate(query);
			query="CREATE INDEX IF NOT EXISTS task_index ON tasks (gameid)";
			state.executeUpdate(query);
			
			query="CREATE TABLE IF NOT EXISTS CHALLENGES"
					+"("
					+"ID int AUTO_INCREMENT PRIMARY KEY,"
					+"GAMEID int NOT NULL,"
					+"DESCRIPTION VARCHAR(200),"
					+"NUM INT NOT NULL,"
					+"CONSTRAINT fk_challengegame FOREIGN KEY (GAMEID) REFERENCES GAMES(ID),"
					+"CONSTRAINT fk_challengedlc FOREIGN KEY (GAMEID) REFERENCES DLCs(ID)"
					+")";
			state.executeUpdate(query);
			query="CREATE INDEX IF NOT EXISTS challenge_index ON challenges (gameid)";
			state.executeUpdate(query);
						
			query="SELECT table_name FROM information_schema.tables WHERE table_schema='gestionaretaskjocuri'";
			ResultSet result=state.executeQuery(query);
			System.out.println("TABELE:");
			while(result.next()) {
				System.out.println(result.getString("table_name"));
			}
			System.out.println();
			query="SELECT table_name,index_name FROM information_schema.statistics WHERE table_schema='gestionaretaskjocuri'";
			result=state.executeQuery(query);
			System.out.println("INDECSI:");
			while(result.next()) {
				System.out.println(result.getString("table_name")+" "+result.getString("index_name"));
			}
			
			query="SELECT * FROM information_schema.columns WHERE extra LIKE '%auto_increment%'";
			result=state.executeQuery(query);
			System.out.println();
			System.out.println("SECVENTE:");
			while(result.next()) {
				System.out.println(result.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
