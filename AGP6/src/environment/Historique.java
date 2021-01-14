package environment;

public class Historique extends SiteTouristique {
	
	String epoque;
	
	public Historique() {
		
	}
	
	public Historique(String nom, String descriptionTextuelle, String epoque, int prix, int dureeVisite) {
		
		super(nom, descriptionTextuelle, prix, dureeVisite);
		
		this.epoque = epoque;
		
	}

	public String getEpoque() {
		return epoque;
	}

	public void setEpoque(String epoque) {
		this.epoque = epoque;
	}
	
	
}
