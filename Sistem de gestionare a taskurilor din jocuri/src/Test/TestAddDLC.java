package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbmanagement.AddRecord;

public class TestAddDLC {
	@Test
	public void test() {
		AddRecord.addDLC("dlctest");
		Assertions.assertEquals("dlctest", selectDlc(),"Adaugare DLC in bd");
	}
	
	public String selectDlc() {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		String name="";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="SELECT NAME FROM dlcs WHERE NAME='dlctest'";
					ResultSet result=state.executeQuery(query);
					result.next();
					name=result.getString("name");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return name;
	}
}
