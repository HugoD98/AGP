package bde;

import environment.TouristicSite;

public class Test {

	
	public static void main(String args[]) throws Exception {
		
		Request req = new Request();
		
		req.init("select * from TouristicSite with nautique egypte");
		
		while(req.next()) {
			System.out.println( ((TouristicSite)(req.get())).getName());
		}
	}
}
