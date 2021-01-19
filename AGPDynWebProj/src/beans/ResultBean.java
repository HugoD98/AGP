package beans;


import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import environment.Boat;
import environment.Bus;
import environment.Hotel;
import environment.OnFoot;
import environment.TouristicSite;
import environment.Transport;
import organisation.Excursion;
import organisation.Stay;



@ManagedBean
@SessionScoped
public class ResultBean {

	private int budget; // budget per person for one week (500-8000) 
	private int duration; // duration in week (1-4)
	private int comfort; // in stars (1-5)
	private int activityIntensity; // number of activity (1-3)
	private int numberOfPerson; // number of person
	
	private String description = "" ;
	private String test ="bloublobliblu";

	private ArrayList<Stay> stays = new ArrayList<Stay>();
	private ArrayList<TouristicSite> touristicSiteMap = new ArrayList<TouristicSite>();

	
	public ResultBean() {
		
		System.out.println("me voici au d�but de la cr�ation de la page web");
		TouristicSite t1 = new TouristicSite("templeA", "culturel", 25, 2, 3, 4);
		TouristicSite t2 = new TouristicSite("templeB", "culturel", 25, 3, 3, 4);
		TouristicSite t3 = new TouristicSite("surf", "sportive", 200, 2, 3, 4);
		ArrayList<TouristicSite> touristicSiteMap1 = new ArrayList<TouristicSite>();
		touristicSiteMap1.add(t1);
		touristicSiteMap1.add(t2);
		touristicSiteMap1.add(t3);
		
		Transport bus = new Bus(2);
		Transport boat = new Boat();
		Transport foot = new OnFoot(2);
		
		Transport bus2 = new Bus(2);
		Transport foot2 = new OnFoot(2);
		Transport foot3 = new OnFoot(2);

		ArrayList<Transport> transportList1 = new ArrayList<Transport>();
		transportList1.add(bus);
		transportList1.add(boat);
		transportList1.add(foot);
		
		ArrayList<Transport> transportList2 = new ArrayList<Transport>();
		transportList2.add(bus2);
		transportList2.add(foot2);
		transportList2.add(foot3);

		
		Hotel hotel = new Hotel(comfort ,"Beach of Jimbaran" , comfort*100, 2, 3 );
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		hotelList.add(hotel);
		
		
		TouristicSite t4 = new TouristicSite("temple A", "culturel", 25, 2, 2, 3);
		TouristicSite t5 = new TouristicSite("balade A", "sportive", 5, 2, 2, 2);
		TouristicSite t6 = new TouristicSite("mus�e A", "culturel", 100, 3, 2, 2);
		ArrayList<TouristicSite> touristicSiteMap2 = new ArrayList<TouristicSite>();
		touristicSiteMap2.add(t4);
		touristicSiteMap2.add(t5);
		touristicSiteMap2.add(t6);
		
		ArrayList<Excursion> excursions = new ArrayList<>();
		excursions.add(new Excursion(12, 2, 3, touristicSiteMap1, transportList1));
		
		ArrayList<Excursion> excursions2 = new ArrayList<>();
		excursions.add(new Excursion(12, 2, 3, touristicSiteMap2, transportList2));
		
		this.stays.add(new Stay( (int)(5000/2) , 1 , excursions , hotelList));
		this.stays.add(new Stay( (int)(5000-200) , 3 ,  excursions2, hotelList));
	
	}
	
	
	public String showDescription(String name){
		System.out.println("pouette");
		System.out.println(name);
		
		this.description = "Situ� � l�Est de l��le, le Mont Agung est un volcan actif culminant � 3142 m�tres d�altitude, soit le plus haut sommet de tout Bali. Il assure la fertilit� des terres environnantes, c�est pourquoi il est tr�s respect� par la population balinaise tout en �tant craint du fait de ses �ruptions spectaculaires qui peuvent parfois �tre meurtri�res (pr�s de 2000 victimes en 1963). L�ascension du Mont Agung est obligatoirement encadr�e par un guide local et r�serv�e aux sportifs exp�riment�s car plus longue et physique que celle du Mont Batur. L�exp�dition compl�te dure entre 5 et 12h selon votre rythme et le circuit choisi.";
		
		System.out.println(description);
		return description;
		
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
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

	public int getActivityIntensity() {
		return activityIntensity;
	}

	public void setActivityIntensity(int activityIntensity) {
		this.activityIntensity = activityIntensity;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public ArrayList<Stay> getStays() {
		return stays;
	}

	public void setStays(ArrayList<Stay> stays) {
		this.stays = stays;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ArrayList<TouristicSite> getTouristicSiteMap() {
		return touristicSiteMap;
	}


	public void setTouristicSiteMap(ArrayList<TouristicSite> touristicSiteMap) {
		this.touristicSiteMap = touristicSiteMap;
	}


	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}
	
	
	



	

	
	

}
