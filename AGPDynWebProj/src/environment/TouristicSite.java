package environment;

import java.awt.Point;

public class TouristicSite {
	
	private String name;
	private String type;
	private int price;
	private int visitDuration;
	private Point location;

	public TouristicSite() {
		
	}

	public TouristicSite(String name, String type, int price, int visitDuration, int x, int y) {
		this.name = name;
		this.setType(type);
		this.price = price;
		this.visitDuration = visitDuration;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVisitDuration() {
		return visitDuration;
	}

	public void setVisitDuration(int visitDuration) {
		this.visitDuration = visitDuration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + visitDuration;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TouristicSite other = (TouristicSite) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (visitDuration != other.visitDuration)
			return false;
		return true;
	}
	
}