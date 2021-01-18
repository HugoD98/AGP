package tests;

import bde.Request;
import bde.SQLRequest;
import bde.TextRequest;
import environment.TouristicSite;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class bdeTests {

	@Test
	public void testTextRequest() throws Exception {
		
		TextRequest txt = new TextRequest();
		
		txt.init("nautique");
		
		while(txt.next()) {
			
			assertEquals("jetSki", txt.get());
		}
		
		txt.init("pyramide");
		
		while(txt.next()) {
			
			assertEquals("pyramide", txt.get());
		}
	}
	
	@Test
	public void testSQlRequest() throws Exception {
		
		SQLRequest sql = new SQLRequest();
		TouristicSite t1 = new TouristicSite("jetSki", "Leisure", 12, 45);
		TouristicSite t2 = new TouristicSite("pyramide", "Historic", 5, 60);
		TouristicSite t3 = new TouristicSite("surf", "Leisure", 30, 120);
		
		sql.init("SELECT * from TouristicSite");
		int compteur = 0;
		
		while(sql.next()) {
			
			String name = sql.getString("name");
			String type = sql.getString("type");
			int price = sql.getInt("price");
			int visitDuration = sql.getInt("visitDuration");
			TouristicSite t = new TouristicSite(name,type,price,visitDuration);
			if (compteur ==0)
				assertEquals(t1, t);
			else if(compteur ==1)
				assertEquals(t2, t);
			else if(compteur ==2)
				assertEquals(t3, t);
			compteur++;	
		}
	}
	
	@Test
	public void testRequest() throws Exception {
		
		Request req = new Request();
		
		req.init("SELECT * from TouristicSite with nautique");
		
		while(req.next()) {
			
			String name = req.getString("name");
			assertEquals("jetSki", name);
		}
		
		req.init("SELECT * from TouristicSite with pyramide");
		
		while(req.next()) {
			
			String name = req.getString("name");
			assertEquals("pyramide", name);
		}
		
		req.init("SELECT * from TouristicSite with loisir");
		
		assertEquals(false, req.next());
	}
}
