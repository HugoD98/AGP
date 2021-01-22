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
	
	private ResultSet results;

	private Connection connection;

	public SQLRequest() {
		prepareConnection();
	}
	
	private void prepareConnection() {
		if (connection == null) {
			try {
		        Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(BdeEntry.url, BdeEntry.user, BdeEntry.password);
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
	
	public String getString(String label) throws Exception {
		
		return results.getNString(label);
	}
	
	public ResultSetMetaData getMetaData() throws Exception {
		
		return results.getMetaData();
	}
	
	public int getInt(String label) throws Exception {
		
		return results.getInt(label);
	}
	
	public Object getObject(int columnIndex) throws Exception {
		
		return results.getObject(columnIndex);
	}
}
