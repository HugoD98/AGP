package environment;

import java.awt.Point;

public class Hotel {

	int star;
	String beach;
	int price;
	Point location;
	
	public Hotel(int star, String beach, int price, int x, int y) {
		this.star = star;
		this.beach = beach;
		this.price = price;
		this.location = new Point(x, y);
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getBeach() {
		return beach;
	}

	public void setBeach(String beach) {
		this.beach = beach;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
}
