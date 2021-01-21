package algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import bde.BdeEntry;
import bde.Request;
import bde.SQLRequest;
import environment.Bus;
import environment.Hotel;
import environment.OnFoot;
import environment.TouristicSite;
import environment.Transport;
import organisation.Stay;

public class AlgorithmUtility {

	public static ArrayList<Stay> stays = new ArrayList<Stay>();
	
	public static int getRandom(int min, int max) {
		
		int nb = min + (int)(Math.random()*((max-min) + 1));
		return nb;
	}
	
	public static TouristicSite getRandomSite(ArrayList<TouristicSite> list) {
		
		int n = getRandom(0, list.size()-1);
		return list.get(n);
	}
	
	public static TouristicSite getCloserSite(TouristicSite t, ArrayList<TouristicSite> list) {
		
		double minDist = 10000;
		TouristicSite closer = null;
		
		for(TouristicSite ts : list) {
			
			double dist = ts.getLocation().distance(t.getLocation());
			
			if(dist < minDist) {
				
				minDist = dist;
				closer = ts;
			}
		}
		
		return closer;
	}

	public static Transport getBestTransport(int distance) {
		
		Bus bus = new Bus(distance);
		OnFoot feet = new OnFoot(distance);
		if (bus.getComfort() > feet.getComfort())
			return bus;
		else
			return feet;
	}

	public static int getDistance(TouristicSite ts1, TouristicSite ts2) {
		
		return (int)ts1.getLocation().distance(ts2.getLocation());
	}
	
	public static int getDistance(Hotel h, TouristicSite ts) {
		
		return (int)ts.getLocation().distance(h.getLocation());
	}
	
	public static Boolean proba(int time, int ref) {
		
		int n = getRandom(0, ref);
		
		return n<=time;
		
	}
	
	public static ArrayList<TouristicSite> getSites(String filter) throws Exception{
		
		ArrayList<TouristicSite> sites = new ArrayList<>();
		
		Request req = new Request();
		
		req.init("SELECT * from TouristicSite with "+filter);
		
		while(req.next()) {
			
			String name = req.getString("name");
			String type = req.getString("type");
			int price = req.getInt("price");
			int visitDuration = req.getInt("visitDuration");
			int x = req.getInt("x");
			int y = req.getInt("y");
			
			TouristicSite s = new TouristicSite(name, type, price, visitDuration, x, y);
			sites.add(s);
		}
		
		return sites;
	}
	
	public static ArrayList<Hotel> getHotels() throws Exception{
		
		ArrayList<Hotel> hotels = new ArrayList<>();
		
		SQLRequest sql = new SQLRequest();
		
		sql.init("SELECT * from Hotels");
		
		while(sql.next()) {
			
			int star = sql.getInt("star");
			String beach = sql.getString("beach");
			int price = sql.getInt("price");
			int x = sql.getInt("x");
			int y = sql.getInt("y");
			String name = sql.getString("name");
			Hotel h = new Hotel(name, star, beach, price, x, y);
			hotels.add(h);
		}
		
		return hotels;
	}
	
	public static String getText(String name) throws Exception {
		
		String result = "";
		File repertoire = new File(BdeEntry.fileLocation+"/");
		
		String list[] = repertoire.list();      
        
        if (list != null) {         
            for(String s : list) {
            	
            	if(s.split("\\.")[0].contentEquals(name)) {
            				
            		BufferedReader in = new BufferedReader(new FileReader(BdeEntry.fileLocation+"/"+s));
        			String line;
        			while ((line = in.readLine()) != null)
        			{
        				result += line + "\n";
           			 
        			}
        			in.close();
            	} 	
            }
        }
        return result;
	}
}





