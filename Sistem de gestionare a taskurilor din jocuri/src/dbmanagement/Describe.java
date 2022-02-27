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
public class Describe {
	/**
	 * Metoda care afiseaza informatii despre tabelele din baza de date
	 * <p>
	 * Se afiseaza structura tabelelor si constrangerile
	 * <p>
	 */
	public static void structure() {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement state=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);){
			ResultSet rs = state.executeQuery("DESCRIBE games");
			System.out.println();
			
			System.out.println("Structura tabel Games:");
			System.out.println("Field:");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.beforeFirst();
			System.out.println("\nType:");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.beforeFirst();
			System.out.println("\nNull:");
			while(rs.next()) {
				System.out.println(rs.getString(3));
			}
			System.out.println("\nKey:");
			while(rs.next()) {
				System.out.println(rs.getString(4));
			}
			System.out.println("\nDefault:");
			while(rs.next()) {
				System.out.println(rs.getString(5));
			}
			System.out.println("\nExtra:");
			while(rs.next()) {
				System.out.println(rs.getString(6));
			}
			
			System.out.println("\nConstrangeri:");
			rs=state.executeQuery("select COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_COLUMN_NAME, REFERENCED_TABLE_NAME "
					+"from information_schema.KEY_COLUMN_USAGE "
					+"where TABLE_NAME = 'games'");
			System.out.println("COLUMN_NAME/ CONSTRAINT_NAME/ REFERENCED_COLUMN_NAME/ REFERENCED_TABLE_NAME");
			while (rs.next()){
				for(int i=1;i<=4;i++) {
					System.out.print(rs.getString(i)+"/ ");			
				}
				System.out.println();
			}
			System.out.println();
			
			
			rs = state.executeQuery("DESCRIBE dlcs");
			System.out.println("\nStructura tabel Dlcs:");
			System.out.println("Field:");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.beforeFirst();
			System.out.println("\nType:");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.beforeFirst();
			System.out.println("\nNull:");
			while(rs.next()) {
				System.out.println(rs.getString(3));
			}
			System.out.println("\nKey:");
			while(rs.next()) {
				System.out.println(rs.getString(4));
			}
			System.out.println("\nDefault:");
			while(rs.next()) {
				System.out.println(rs.getString(5));
			}
			System.out.println("\nExtra:");
			while(rs.next()) {
				System.out.println(rs.getString(6));
			}
			
			System.out.println("\nConstrangeri:");
			rs=state.executeQuery("select COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_COLUMN_NAME, REFERENCED_TABLE_NAME "
					+"from information_schema.KEY_COLUMN_USAGE "
					+"where TABLE_NAME = 'dlcs'");
			System.out.println("COLUMN_NAME/ CONSTRAINT_NAME/ REFERENCED_COLUMN_NAME/ REFERENCED_TABLE_NAME");
			while (rs.next()){
				for(int i=1;i<=4;i++) {
					System.out.print(rs.getString(i)+"/ ");			
				}
				System.out.println();
			}
			System.out.println();


			rs = state.executeQuery("DESCRIBE tasks");
			System.out.println("\nStructura tabel Tasks:");
			System.out.println("Field:");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.beforeFirst();
			System.out.println("\nType:");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.beforeFirst();
			System.out.println("\nNull:");
			while(rs.next()) {
				System.out.println(rs.getString(3));
			}
			System.out.println("\nKey:");
			while(rs.next()) {
				System.out.println(rs.getString(4));
			}
			System.out.println("\nDefault:");
			while(rs.next()) {
				System.out.println(rs.getString(5));
			}
			System.out.println("\nExtra:");
			while(rs.next()) {
				System.out.println(rs.getString(6));
			}
			
			System.out.println("\nConstrangeri:");
			rs=state.executeQuery("select COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_COLUMN_NAME, REFERENCED_TABLE_NAME "
					+"from information_schema.KEY_COLUMN_USAGE "
					+"where TABLE_NAME = 'tasks'");
			System.out.println("COLUMN_NAME/ CONSTRAINT_NAME/ REFERENCED_COLUMN_NAME/ REFERENCED_TABLE_NAME");
			while (rs.next()){
				for(int i=1;i<=4;i++) {
					System.out.print(rs.getString(i)+"/ ");			
				}
				System.out.println();
			}
			System.out.println();
			
			
			rs = state.executeQuery("DESCRIBE challenges");
			System.out.println("\nStructura tabel Challenges:");
			System.out.println("Field:");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.beforeFirst();
			System.out.println("\nType:");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.beforeFirst();
			System.out.println("\nNull:");
			while(rs.next()) {
				System.out.println(rs.getString(3));
			}
			System.out.println("\nKey:");
			while(rs.next()) {
				System.out.println(rs.getString(4));
			}
			System.out.println("\nDefault:");
			while(rs.next()) {
				System.out.println(rs.getString(5));
			}
			System.out.println("\nExtra:");
			while(rs.next()) {
				System.out.println(rs.getString(6));
			}
			
			System.out.println("\nConstrangeri:");
			rs=state.executeQuery("select COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_COLUMN_NAME, REFERENCED_TABLE_NAME "
					+"from information_schema.KEY_COLUMN_USAGE "
					+"where TABLE_NAME = 'challenges'");
			System.out.println("COLUMN_NAME/ CONSTRAINT_NAME/ REFERENCED_COLUMN_NAME/ REFERENCED_TABLE_NAME");
			while (rs.next()){
				for(int i=1;i<=4;i++) {
					System.out.print(rs.getString(i)+"/ ");			
				}
				System.out.println();
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
