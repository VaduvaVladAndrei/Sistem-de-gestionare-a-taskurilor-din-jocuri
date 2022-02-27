package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import dbmanagement.AddRecord;
import dbmanagement.AddTask;

public class TestAddtask {
	@Test
	public void test() {
		AddTask.AddTask(67477029,"tasktest");
		Assertions.assertEquals("67477029 tasktest", selectTask(),"Adaugare task in bd");
	}
	
	public String selectTask() {
		final String DB_URL = "jdbc:mysql://localhost/gestionaretaskjocuri";
		final String USER = "vlad";
		final String PASS = "pass123";
		
		String rec="";
		
		try(Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
				Statement state=conn.createStatement();){
					String query="SELECT gameid,description FROM tasks WHERE gameid=67477029";
					ResultSet result=state.executeQuery(query);
					result.next();
					rec+=result.getInt("gameid")+" ";
					rec+=result.getString("description");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return rec;
	}
}
