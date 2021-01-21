package beans;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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
@RequestScoped
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

	
	@ManagedProperty("#{entryBean}")
	private EntryBean entryBean;
	
	public ResultBean() {
		System.out.println("me voici au début de la création de la page web");
		TouristicSite t1 = new TouristicSite("templeA", "culturel", 25, 2);
		TouristicSite t2 = new TouristicSite("templeB", "culturel", 25, 3);
		TouristicSite t3 = new TouristicSite("surf", "sportive", 200, 2);
		ArrayList<TouristicSite> touristicSiteMap1 = new ArrayList<TouristicSite>();
		touristicSiteMap1.add(t1);
		touristicSiteMap1.add(t2);
		touristicSiteMap1.add(t3);
		
		
		touristicSiteMap.add(t1);
		touristicSiteMap.add(t2);
		touristicSiteMap.add(t3);
		
		TouristicSite t4 = new TouristicSite("templeC", "culturel", 25, 2);
		TouristicSite t5 = new TouristicSite("baladeA", "sportive", 5, 2);
		TouristicSite t6 = new TouristicSite("muséeA", "culturel", 100, 3);
		ArrayList<TouristicSite> touristicSiteMap2 = new ArrayList<TouristicSite>();
		touristicSiteMap2.add(t4);
		touristicSiteMap2.add(t5);
		touristicSiteMap2.add(t6);

		
		Transport bus = new Bus();
		Transport boat = new Boat();
		Transport foot = new OnFoot();
		
		Transport bus2 = new Bus();
		Transport foot2 = new OnFoot();
		Transport foot3 = new OnFoot();

		ArrayList<Transport> transportList1 = new ArrayList<Transport>();
		transportList1.add(bus);
		transportList1.add(boat);
		transportList1.add(foot);
		
		ArrayList<Transport> transportList2 = new ArrayList<Transport>();
		transportList2.add(bus2);
		transportList2.add(foot2);
		transportList2.add(foot3);

		
		Hotel hotel = new Hotel(comfort ,"Beach of Jimbaran" , comfort*100 );
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		hotelList.add(hotel);
		
		
		Excursion excusion1 = new Excursion(touristicSiteMap1,transportList1);
		Excursion excusion2 = new Excursion(touristicSiteMap2,transportList2);

		ArrayList<Excursion> excusionList = new ArrayList<Excursion>();
		excusionList.add(excusion1);
		excusionList.add(excusion2);
			
		this.stays.add(new Stay( (int)(5000/2) , 1 , excusionList , hotelList));
		this.stays.add(new Stay( (int)(5000-200) , 3 , excusionList , hotelList));
		
		System.out.println(entryBean);


	}
	
	public String showDescription(String name){
		System.out.println("pouette");
		System.out.println(name);
		
		this.description = "Situé à l’Est de l’île, le Mont Agung est un volcan actif culminant à 3142 mètres d’altitude, soit le plus haut sommet de tout Bali. Il assure la fertilité des terres environnantes, c’est pourquoi il est très respecté par la population balinaise tout en étant craint du fait de ses éruptions spectaculaires qui peuvent parfois être meurtrières (près de 2000 victimes en 1963). L’ascension du Mont Agung est obligatoirement encadrée par un guide local et réservée aux sportifs expérimentés car plus longue et physique que celle du Mont Batur. L’expédition complète dure entre 5 et 12h selon votre rythme et le circuit choisi.";
		
		
		
		System.out.println(description);
		this.description = this.description.replaceAll("à|â|ä","a");
		this.description = this.description.replaceAll("é|è|ê|ë","e");
		this.description = this.description.replaceAll("î|ï","i");
		this.description = this.description.replaceAll("ö|ô","o");
		this.description = this.description.replaceAll("ü|û","u");

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


	public EntryBean getEntryBean() {
		return entryBean;
	}


	public void setEntryBean(EntryBean entryBean) {
		this.entryBean = entryBean;
	}
	
	
	



	

	
	

}
