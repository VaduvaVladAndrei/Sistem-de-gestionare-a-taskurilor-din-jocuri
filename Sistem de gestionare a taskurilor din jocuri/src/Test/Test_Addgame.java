package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbmanagement.AddRecord;

public class Test_Addgame {
	@Test
	public void test() {
		AddRecord.addGame("joctest");
		Assertions.assertEquals("joctest", selectGame(),"Adaugare joc in bd");
	}
	
	public String selectGame() {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		String name="";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="SELECT NAME FROM games WHERE NAME='joctest'";
					ResultSet result=state.executeQuery(query);
					result.next();
					name=result.getString("name");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return name;
	}
}
