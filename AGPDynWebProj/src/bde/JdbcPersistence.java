package bde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersistence {
	
	private static String host = "localhost";
	private static String base = "agp_bd";
	private static String user = "root";
	private static String password = "root1234";
	private static String url = "jdbc:mysql://" + host + "/" + base;
	

	private Connection connection;

	public JdbcPersistence() {
		prepareConnection();
	}
	
	private void prepareConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
	}
	
	
	public void resultRequest(String request) {
		
		try {

			String selectAddressQuery = request;

			PreparedStatement preparedStatement = connection.prepareStatement(selectAddressQuery);

			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				
				//listR = result.get
			}

			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		//return ResultR; 
		//
	}
}
