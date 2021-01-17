package environment;

public class TouristicSite {
	
	private String name;
	private String type;
	private String textDescription;
	private int price;
	private int visitDuration;

	public TouristicSite() {
		
	}

	public TouristicSite(String name, String type, int price, int visitDuration) {
		this.name = name;
		this.type = type;
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