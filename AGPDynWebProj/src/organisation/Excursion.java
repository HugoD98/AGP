package organisation;

import java.util.ArrayList;
import java.util.HashMap;

import environment.TouristicSite;
import environment.Transport;

public class Excursion {

	int duration;
	int price;
	int comfort;
	ArrayList<TouristicSite> touristicSites;
	ArrayList<Transport> transports;
	
	public Excursion() {
		this.duration = 0;
		this.price = 0;
		this.comfort = 0;
		this.touristicSites = new ArrayList<>();
		this.transports = new ArrayList<Transport>();
	}
	
	
	
	public Excursion(int duration, int price, int comfort, ArrayList<TouristicSite> touristicSites, ArrayList<Transport> transports) {
		
		this.duration = duration;
		this.price = price;
		this.comfort = comfort;
		this.touristicSites = touristicSites;
		this.transports = transports;
	}



	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getComfort() {
		return comfort;
	}

	public void setComfort(int comfort) {
		this.comfort = comfort;
	}

	public ArrayList<TouristicSite> getTouristicSites() {
		return touristicSites;
	}

	public void setTouristicSites(ArrayList<TouristicSite> touristicSites) {
		this.touristicSites = touristicSites;
	}

	public ArrayList<Transport> getTransports() {
		return transports;
	}

	public void setTransports(ArrayList<Transport> transports) {
		this.transports = transports;
	}

	public void addSite(TouristicSite site) {
		
		this.touristicSites.add(site);
		addPrice(site.getPrice());
		addDuration(site.getVisitDuration());
	}
	
	public void addTransport(Transport t) {
		
		this.transports.add(t);
		addPrice(t.getPrice());
		addDuration(t.getDuration());
	}
	
	public void actualizeComfort() {
		int comfort = 0;
		for(Transport t : transports) {
			
			comfort += t.getComfort();
		}
 
		this.comfort = comfort/transports.size();
	}
	
	public void addPrice(int price) {
		
		this.price += price;
	}
	
	public void addDuration(int duration) {
		
		this.duration += duration;
	}
	
	public TouristicSite getLastSite() {
		
		return touristicSites.get(touristicSites.size()-1);
	}
	
	@Override
	public String toString() { 
		
		String s = "Site touristiques : \n";
		
		for(TouristicSite t : this.touristicSites) {
			
			s += t.getName()+"\n";
		}
		s += "Transports : \n";
		for(Transport t : this.transports) {
			
			s += t.getName()+"\n";
		}
		
		return s;
	}
	
}
