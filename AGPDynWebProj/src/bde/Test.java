package bde;

import java.sql.ResultSet;
import java.util.ArrayList;

import environment.TouristicSite;

public class Test {

	
	public static void main(String args[]) throws Exception {
		
		Request req = new Request();
		
		req.init("select * from TouristicSite with nautique");
		
		while(req.next()) {
			System.out.println( ((TouristicSite)(req.get())).getName());
		}
	}
}
