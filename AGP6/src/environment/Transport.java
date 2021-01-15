package environment;

public abstract class Transport {
	
	int price;
	int speed;
	
	public Transport() {
		
	}
	
	public Transport(int price, int speed) {
		
		this.price = price;
		this.speed = speed;
	}
}
