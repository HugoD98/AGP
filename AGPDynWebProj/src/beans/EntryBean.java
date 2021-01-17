package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EntryBean implements Serializable {

	/**
	 * A session scoped bean must be serializable.
	 */
	private static final long serialVersionUID = 6955508471291131930L;

	private int budget = 500; // budget per person for one week (500-8000) 
	private int duration = 1; // duration in week (1-4)
	private int comfort = 5; // in stars (1-5)
	private int activityIntensity = 2; // number of activity (1-3)
	private int numberOfPerson = 4; //
	
	public String verify() {
		String results = "valid";
		// ici on peut faire un appel de notre main avec tout nos params
		// Main main = new Main();
		// main.start(budget,duration,comfort,activityIntensity,numberOfPerson);
		
		/*
		results = "invalid";
		results = "no-such-user";
		
		 */
		return results;
	}


	
	public EntryBean() {
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

	
	

}
