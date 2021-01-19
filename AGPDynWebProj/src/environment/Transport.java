package environment;

public abstract class Transport {
	
	int pricePerKm;
	int price;
	int speed;
	int distance;
	int duration;
	int comfort;
	
	public Transport(int pricePerKm, int speed) {
		
		this.pricePerKm = pricePerKm;
		this.speed = speed;
	}
	
	
	
	public int getPricePerKm() {
		return pricePerKm;
	}



	public void setPricePerKm(int pricePerKm) {
		this.pricePerKm = pricePerKm;
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



	public int getDistance() {
		return distance;
	}



	public void setDistance(int distance) {
		this.distance = distance;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	public int getComfort() {
		return comfort;
	}



	public void setComfort(int comfort) {
		this.comfort = comfort;
	}
	
}
