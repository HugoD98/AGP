package algorithm;

import java.util.ArrayList;

import environment.Bus;
import environment.OnFoot;
import environment.TouristicSite;
import environment.Transport;

public class AlgorithmUtility {

	
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
	
	public static Boolean proba(int time, int ref) {
		
		int n = getRandom(0, ref);
		
		return n<=time;
		
	}
}
