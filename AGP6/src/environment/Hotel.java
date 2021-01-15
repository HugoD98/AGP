package environment;

public class Hotel {

	int star;
	String beach;
	int price;
	
	public Hotel(int star, String beach, int price) {
		this.star = star;
		this.beach = beach;
		this.price = price;
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
