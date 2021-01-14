package organisation;

import java.util.ArrayList;
import java.util.HashMap;

import environment.SiteTouristique;
import environment.Transport;

public class Excursion {

	int duree;
	HashMap<String, SiteTouristique> sitesTouristiques;
	ArrayList<Transport> transports;
	
	public Excursion(int duree) {
		this.duree = 0;
		this.sitesTouristiques = new HashMap<String, SiteTouristique>();
		this.transports = new ArrayList<Transport>();
	}
	
}
