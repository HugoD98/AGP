package environment;

public abstract class SiteTouristique {
	
	private String nom;
	private String descriptionTextuelle;
	int prix;
	int dureeVisite;

	public SiteTouristique() {
		
	}
	
	public int getDureeVisite() {
		return dureeVisite;
	}

	public void setDureeVisite(int dureeVisite) {
		this.dureeVisite = dureeVisite;
	}

	public SiteTouristique(String nom, String descriptionTextuelle, int prix, int dureeVisite) {
		this.nom = nom;
		this.descriptionTextuelle = descriptionTextuelle;
		this.prix = prix;
	}
	
	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getDescriptionTextuelle() {
		return descriptionTextuelle;
	}

	public void setDescriptionTextuelle(String descriptionTextuelle) {
		this.descriptionTextuelle = descriptionTextuelle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}