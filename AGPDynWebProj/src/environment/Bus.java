package environment;

public class Bus extends Transport{
	
	public Bus(int distance) {
		
		super(1, 40);
		this.distance = distance;
		this.comfort = 80 - (distance);
		this.price = this.pricePerKm*distance;
		this.name = "Bus";
	}
}
