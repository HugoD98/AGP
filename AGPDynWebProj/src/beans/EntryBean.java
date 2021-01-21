package beans;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import algorithm.Algorithm;
import environment.TouristicSite;
import organisation.Stay;

@ManagedBean(name="entryBean")
@SessionScoped
public class EntryBean {

	private int budget = 1000; // budget per person for one week (500-8000) 
	private int duration = 3; // duration in week (1-4)
	private int comfort = 5; // in stars (1-5)
	private int activityIntensity = 2; // number of activity (1-3)
	private int numberOfPerson = 4; // number of person for calculate the bill 
	private String critereArea = "nager peintres panoramique plong�e cyclisme volcanique nature Quad mer jet ski danse falaise";
	private boolean hotelChange=false;
	
	private String research ="";
	private ArrayList<TouristicSite> touristicSiteList = new ArrayList<TouristicSite>();
	
	public String startStays() {		
		// ici on peut faire un appel de notre main avec tout nos params
		//Algorithm algo = new Algorithm("nager peintres panoramique plong�e cyclisme volcanique nature Quad mer jet ski danse falaise", duration,comfort, budget , activityIntensity);
		Algorithm algo = new Algorithm("nager peintres panoramique plongée cyclisme volcanique nature Quad mer jet ski danse falaise", 3, 3, 500, 1);

		System.out.println("algo cree");
		
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
		
		System.out.println(research);
		String[] researchTab = research.split("\\s+");
		List<String> researchList = new ArrayList<String>();
		researchList = Arrays.asList(researchTab);
		System.out.println(researchList);
		
		touristicSiteList  = new ArrayList<TouristicSite>();

		//touristicSiteList = bd.getLesSite(research)
		/*
		TouristicSite t1 = new TouristicSite("templeA", "culturel", 25, 2);
		TouristicSite t2 = new TouristicSite("templeB", "culturel", 25, 3);
		TouristicSite t3 = new TouristicSite("surf", "sportive", 200, 2);		
		TouristicSite t4 = new TouristicSite("templeC", "culturel", 25, 2);
		TouristicSite t5 = new TouristicSite("baladeA", "sportive", 5, 2);
		TouristicSite t6 = new TouristicSite("mus�eA", "culturel", 100, 3);

		if(researchList.contains("sportive")){
			touristicSiteList.add(t3);
			touristicSiteList.add(t5);
		}
		if(researchList.contains("culturel")){
			touristicSiteList.add(t1);
			touristicSiteList.add(t2);			
			touristicSiteList.add(t4);
			touristicSiteList.add(t6);
		}
		*/
		
		return "search";
	}
	
	public EntryBean() {
		System.out.println("main pouette");
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
