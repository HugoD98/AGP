package environment;

public class OnFoot extends Transport{
	
	public OnFoot(int distance) {
				
		super(0, 6);
		this.distance = distance;
		this.comfort = 100 - (5*distance);
		this.price = this.pricePerKm*distance;
	}
}
