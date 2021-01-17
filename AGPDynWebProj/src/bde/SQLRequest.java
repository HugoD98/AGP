package bde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import environment.Hotel;

public class SQLRequest {
	
	private static String host = "localhost:8889";
	private static String base = "BaliVoyage";
	private static String user = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://" + host + "/" + base;
	
	private ResultSet results;

	private Connection connection;

	public SQLRequest() {
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
	
	public void init(String request) {
		
		try {

			String selectAddressQuery = request;

			PreparedStatement preparedStatement = connection.prepareStatement(selectAddressQuery);

			this.results = preparedStatement.executeQuery();

			//preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
	
	public Boolean next() throws Exception {
		
		if(results.next()) {
			return true;
			
		} else
			return false;
	}
	
	public ResultSet get() {
		
		return results;
	}
}
