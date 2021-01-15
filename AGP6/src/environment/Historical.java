package environment;

public class Historical extends TouristicSite {
	
	String period;
	
	public Historical() {
		
	}
	
	public Historical(String name, String textDescription, String period, int price, int visitDuration) {
		
		super(name, textDescription, price, visitDuration);
		
		this.period = period;
		
	}
	
	
}
