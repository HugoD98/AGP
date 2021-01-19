package environment;

public abstract class Transport {
	
	int price;
	int speed;
	private String name;

	public Transport() {
		
	}
	
	public Transport(int price, int speed, String name) {
		
		this.price = price;
		this.speed = speed;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
