package algorithm;

import java.util.ArrayList;

import environment.Hotel;
import environment.TouristicSite;
import environment.Transport;
import organisation.Excursion;
import organisation.Stay;

public class Algorithm {
	
	private int budget;
	private int dailyBudget;
	private int rythm;
	private int duration;
	private int comfort;
	private int[] program;
	private ArrayList<Excursion> excursions;
	private ArrayList<TouristicSite> sites;
	private ArrayList<Hotel> hotelsList;
	private ArrayList<Hotel> hotels;
	
	public Algorithm(String filter) throws Exception {
		
		program = new int[this.duration];
		excursions = new ArrayList<>();
		sites = AlgorithmUtility.getSites(filter);
		hotels = AlgorithmUtility.getHotels();
		
	}
	
	public Stay launch() {
		
		fillProgram();
		fill();
		Stay s = new Stay(duration, excursions, hotels);
		return s;
	}
	
	public void fillProgram() {
		
		for(int i=0; i<duration;i++) {
			if(rythm == 1) {
				
				int nb = AlgorithmUtility.getRandom(0, 1);
				program[i] = nb;
			}
			else if(rythm == 2) {
				
				int nb = AlgorithmUtility.getRandom(1, 2);
				program[i] = nb;
			}
			else {
				program[i] = 1;
			}
		}
	}
	
	public void setHotel(int budget) {
		
		Boolean good = false;
		
		if((hotels.size()==0) || (AlgorithmUtility.proba(1, 10))){
			
			int searchStar = comfort;
			
			while(!good) {
				
				for(Hotel h : hotelsList) {
					
					if (h.getStar() == searchStar) {
						
						if (h.getPrice() <= budget) {
							
							hotels.add(h);
							hotelsList.remove(h);
							good = true;
						}
					}
				}	
				searchStar -= 1;
			}
		}
		
		else {
			
			hotels.add(hotels.get(hotels.size()-1));
		}
	}
	
	public void fill() {
		
		for(int day=0; day<duration; day++) {
			
			dailyBudget = budget / (duration-day);
			int excBudget = (int)((2/3)*dailyBudget);
			int hotelBudget = dailyBudget - excBudget;
			
			for(int i=1; i<=program[day]; i++) {
				
				int budgetExc = (int)(excBudget/(program[day]-(i+1)));
				
				Excursion excursion = createExcursion(budgetExc, 180);
				
				excursions.add(excursion);
				
				if(excursion.getPrice() != budgetExc) {
					
					excBudget -= excursion.getPrice();
				}
			}
			
			setHotel(hotelBudget);
			budget-= hotels.get(hotels.size()-1).getPrice();
		}
	}
	
	public Excursion createExcursion(int budget, int duration) {
		
		Excursion excursion = new Excursion();
		
		TouristicSite site = AlgorithmUtility.getRandomSite(sites);
		
		excursion.addSite(site);
		sites.remove(site);
		
		while(excursion.getDuration()<=duration  && excursion.getPrice()<=budget) {
			
			TouristicSite lastSite = excursion.getLastSite();
			site = AlgorithmUtility.getCloserSite(lastSite, sites);
			
			excursion.addSite(site);
			sites.remove(site);
			
			Transport t = AlgorithmUtility.getBestTransport(AlgorithmUtility.getDistance(lastSite, site));
		
			excursion.addTransport(t);
		}
		
		excursion.actualizeComfort();
		
		return excursion;
	}
}













