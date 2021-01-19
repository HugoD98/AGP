package organisation;

import java.util.ArrayList;
import java.util.HashMap;

import environment.TouristicSite;
import environment.Transport;

public class Excursion {

	ArrayList<TouristicSite> touristicSites = new ArrayList<TouristicSite>();
	ArrayList<Transport> transports = new ArrayList<Transport>();	
	
	public Excursion( ArrayList<TouristicSite> touristicSites, ArrayList<Transport> transports) {
		this.touristicSites = touristicSites;
		this.transports = transports;
	}

	public ArrayList<TouristicSite> getTouristicSites() {
		return touristicSites;
	}


	public void setTouristicSites(ArrayList<TouristicSite>  touristicSites) {
		this.touristicSites = touristicSites;
	}


	public ArrayList<Transport> getTransports() {
		return transports;
	}


	public void setTransports(ArrayList<Transport> transports) {
		this.transports = transports;
	}
	
	
	
}
