package beans;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import algorithm.Algorithm;
import algorithm.AlgorithmUtility;
import environment.TouristicSite;
import organisation.Stay;

@ManagedBean(name="entryBean")
@SessionScoped
public class EntryBean {

	private int budget = 700; // budget per person for one week (500-8000) 
	private int duration = 4; // duration in week (1-4)
	private int comfort = 5; // in stars (1-5)
	private int activityIntensity = 2; // number of activity (1-3)
	private int numberOfPerson = 4; // number of person for calculate the bill 

	private String critereArea = "nager peintres panoramique plongee cyclisme volcanique nature quad mer jet ski danse falaise";
	private boolean hotelChange=false;
	
	private String research ="";
	private ArrayList<TouristicSite> touristicSiteList = new ArrayList<TouristicSite>();
	
	public String startStays() {		
		// ici on peut faire un appel de notre main avec tout nos params

		Algorithm algo = new Algorithm(critereArea, duration,comfort, budget , activityIntensity);

		//System.out.println("algo cree");
		
		try {
			algo.launch(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "list";
	}

	public String startResearch() {		
		if(this.research == "")return "index";
		
		//System.out.println(research);

		try {
			touristicSiteList  = AlgorithmUtility.getSites(research);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return "search";
	}
	
	public EntryBean() {
		//System.out.println("main pouette");
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



	public String getCritereArea() {
		return critereArea;
	}



	public void setCritereArea(String critereArea) {
		this.critereArea = critereArea;
	}



	public String getResearch() {
		return research;
	}



	public void setResearch(String research) {
		this.research = research;
	}

	public ArrayList<TouristicSite> getTouristicSiteList() {
		return touristicSiteList;
	}

	public void setTouristicSiteList(ArrayList<TouristicSite> touristicSiteList) {
		this.touristicSiteList = touristicSiteList;
	}

	public boolean isHotelChange() {
		return hotelChange;
	}

	public void setHotelChange(boolean hotelChange) {
		this.hotelChange = hotelChange;
	}

	
	

}
