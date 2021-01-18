package beans;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import environment.TouristicSite;



@ManagedBean
@SessionScoped
public class ResultBean {

	private int budget; // budget per person for one week (500-8000) 
	private int duration; // duration in week (1-4)
	private int comfort; // in stars (1-5)
	private int activityIntensity; // number of activity (1-3)
	private int numberOfPerson; // number of person
	
	private List<TouristicSite> activities1 = new ArrayList<TouristicSite>();
	private List<TouristicSite> activities2 = new ArrayList<TouristicSite>();


	
	public ResultBean() {
		TouristicSite t1 = new TouristicSite("temple A", "culturel", 25, 2);
		TouristicSite t2 = new TouristicSite("temple B", "culturel", 25, 3);
		TouristicSite t3 = new TouristicSite("surf", "sportive", 200, 2);
		activities1.add(t1);
		activities1.add(t2);
		activities1.add(t3);
		
		
		TouristicSite t4 = new TouristicSite("temple A", "culturel", 25, 2);
		TouristicSite t5 = new TouristicSite("balade A", "sportive", 5, 2);
		TouristicSite t6 = new TouristicSite("musée A", "culturel", 100, 3);
		activities2.add(t4);
		activities2.add(t5);
		activities2.add(t6);
			
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

	public List<TouristicSite> getActivities1() {
		return activities1;
	}

	public void setActivities1(List<TouristicSite> activities1) {
		this.activities1 = activities1;
	}

	public List<TouristicSite> getActivities2() {
		return activities2;
	}

	public void setActivities2(List<TouristicSite> activities2) {
		this.activities2 = activities2;
	}



	

	
	

}
