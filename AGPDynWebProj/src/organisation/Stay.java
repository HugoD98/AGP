package organisation;

import java.util.ArrayList;
import environment.Hotel;

public class Stay {

	private int price;
	private int duration;
	
	private ArrayList<Excursion> excursions;
	private ArrayList<Hotel> hotel;
	
	public Stay(int price, int duration, ArrayList<Excursion> excursions, ArrayList<Hotel> hotel) {
		
		this.price = price;
		this.duration = duration;
		this.excursions = excursions;
		this.hotel = hotel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
	}

	public ArrayList<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(ArrayList<Hotel> hotel) {
		this.hotel = hotel;
	}
	
}
