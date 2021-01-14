package organisation;

import java.util.ArrayList;
import environment.Hotel;

public class Sejour {

	int prix;
	int duree;
	
	ArrayList<Excursion> excursions;
	Hotel hotel;
	
	public Sejour(int prix, int duree, ArrayList<Excursion> excursions, Hotel hotel) {
		
		this.prix = prix;
		this.duree = duree;
		this.excursions = new ArrayList<Excursion>();
		this.hotel = hotel;
	}
}
