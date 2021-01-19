package organisation;

import java.util.ArrayList;
import environment.Hotel;

public class Stay {

	int price;
	int duration;
	
	ArrayList<Excursion> excursions;
	ArrayList<Hotel> hotel;
	
	public Stay(int price, int duration, ArrayList<Excursion> excursions, Hotel hotel) {
		
		this.price = price;
		this.duration = duration;
		this.excursions = new ArrayList<Excursion>();
		this.hotel = new ArrayList<Hotel>();
	}
}