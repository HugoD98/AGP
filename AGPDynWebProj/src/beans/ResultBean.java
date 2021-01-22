package beans;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import algorithm.Algorithm;
import algorithm.AlgorithmUtility;
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
		
		System.out.println("me voici au debut de la creation de la page web");
		stays = AlgorithmUtility.stays;
		if(stays.size() > 0){
			System.out.println(stays);
			System.out.println("voici les hotels");
	
			System.out.println(stays.get(0).getExcursions().size());
			System.out.println(entryBean);
		}


	}
	
	public String showDescription(String name){
		System.out.println("pouette");
		System.out.println(name);
		
		try {
			this.description = AlgorithmUtility.getText(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(description);
		this.description = this.description.replaceAll("�|�|�","a");
		this.description = this.description.replaceAll("�|�|�|�","e");
		this.description = this.description.replaceAll("�|�","i");
		this.description = this.description.replaceAll("�|�","o");
		this.description = this.description.replaceAll("�|�","u");

		return description;
		
	}
	
	public int hotelPrice(ArrayList<Hotel> hotels, int index){
		if(hotels.size()>index)return hotels.get(index).getPrice();
		
		return 0;
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
