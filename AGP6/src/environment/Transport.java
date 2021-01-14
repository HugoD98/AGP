package environment;

public abstract class Transport {
	
	int prix;
	int vitesse;
	
	public Transport() {
		
	}
	
	public Transport(int prix, int vitesse) {
		
		this.prix = prix;
		this.vitesse = vitesse;
	}
}
