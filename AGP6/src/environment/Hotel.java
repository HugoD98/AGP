package environment;

public class Hotel {

	String gamme;
	String plage;
	int prix;
	
	public Hotel(String gamme, String plage, int prix) {
		this.gamme = gamme;
		this.plage = plage;
		this.prix = prix;
	}

	public String getGamme() {
		return gamme;
	}

	public void setGamme(String gamme) {
		this.gamme = gamme;
	}

	public String getPlage() {
		return plage;
	}

	public void setPlage(String plage) {
		this.plage = plage;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
}
