package environment;

public abstract class TouristicSite {
	
	private String name;
	private String textDescription;
	int price;
	int visitDuration;

	public TouristicSite() {
		
	}

	public TouristicSite(String name, String textDescription, int price, int visitDuration) {
		this.name = name;
		this.textDescription = textDescription;
		this.price = price;
		this.visitDuration = visitDuration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
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
	
	
	
}