package organisation;

import java.util.ArrayList;
import java.util.HashMap;

import environment.TouristicSite;
import environment.Transport;

public class Excursion {

	int duration;
	HashMap<String, TouristicSite> touristicSites;
	ArrayList<Transport> transports;
	
	public Excursion(int duration) {
		this.duration = 0;
		this.touristicSites = new HashMap<String, TouristicSite>();
		this.transports = new ArrayList<Transport>();
	}
	
}
