package environment;

import java.awt.Point;

public class Hotel {
	
	String name;
	int star;
	String beach;
	int price;
	Point location;
	
	public Hotel(String name, int star, String beach, int price, int x, int y) {
		this.name = name;
		this.star = star;
		this.beach = beach;
		this.price = price;
		this.location = new Point(x, y);
	}
	
	

	public Point getLocation() {
		return location;
	}



	public void setLocation(Point location) {
		this.location = location;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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
