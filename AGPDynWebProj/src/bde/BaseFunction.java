package bde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BaseFunction {

	private Connection connection;
	
	private void prepareConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(BdeEntry.url, BdeEntry.user, BdeEntry.password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
	}
	
	public void addText(String text, String name, String table) {
		
		
	}
	
}
