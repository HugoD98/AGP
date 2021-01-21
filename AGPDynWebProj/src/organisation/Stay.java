package organisation;

import java.util.ArrayList;
import environment.Hotel;

public class Stay {

	private int price;
	private int duration;
	
	private ArrayList<Excursion> excursions;
	private ArrayList<Hotel> hotel;
	
	public Stay(int duration, ArrayList<Excursion> excursions, ArrayList<Hotel> hotel) {
		
		this.duration = duration;
		this.excursions = excursions;
		this.hotel = hotel;
		this.price = calculatePrice();
	}
	
	@Override
	public String toString() {
		
		String s = "";
		s += "duration : "+this.duration;
		s += " price : "+this.price;
		s += " Hotels : \n";
		for(Hotel h : this.hotel) {
			
			s += h.getName()+"\n";
		}
		s += " Excursions : \n";
		for(Excursion exc : this.excursions) {
			
			s += exc.toString();
		}
		return s;
	}

	public int calculatePrice() {
		
		int price = 0;
		
		for(Excursion exc : this.excursions) {
			price += exc.getPrice();
		}
		
		for(Hotel h : hotel) {
			price += h.getPrice();
		}
		
		return price;
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
