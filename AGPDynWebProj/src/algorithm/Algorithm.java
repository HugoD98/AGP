package algorithm;

import java.util.ArrayList;

import environment.Hotel;
import environment.TouristicSite;
import environment.Transport;
import organisation.Excursion;
import organisation.Stay;

public class Algorithm {
	
	private int initBudget;
	private String filter;
	private int budget;
	private int dailyBudget;
	private int rythm;
	private int duration;
	private int comfort;
	private int[] program;
	private ArrayList<Excursion> excursions;
	private ArrayList<TouristicSite> sites;
	private ArrayList<TouristicSite> siteNonChoisi;
	private ArrayList<Hotel> hotelsList;
	private ArrayList<Hotel> hotels;
	
	public Algorithm(String filter, int duration, int comfort, int budget, int rythm) {
		
		this.filter = filter;
		this.initBudget = budget;
		this.duration = duration;
		this.comfort = comfort;
		this.rythm = rythm;
	}
	
	public void init() throws Exception {
		
 
		this.budget = this.initBudget;
		program = new int[this.duration];
		excursions = new ArrayList<>();
		sites = AlgorithmUtility.getSites(filter);
		siteNonChoisi = AlgorithmUtility.getSites(sites);
		hotelsList = AlgorithmUtility.getHotels();
		hotels = new ArrayList<>();
	}
	
	public ArrayList<Stay> launch(int n) throws Exception {
		
		ArrayList<Stay> stays = new ArrayList<>();
		
		Boolean b = true;
		
		for(int i=0; i<n; i++) {
			
			b = true;
			
			while(b) {
				
				init();
				fillProgram();
				fill();
				Stay s = new Stay(duration, excursions, hotels);
				if(s.getPrice() <= this.initBudget) {
					stays.add(s);
					b = !b;
				}
			}	
		}
		
		AlgorithmUtility.stays = stays;
		return stays;
	}
	
	public void fillProgram() {
		
		for(int i=0; i<duration;i++) {
			if(rythm == 1) {
				
				if(AlgorithmUtility.proba(7, 10)) {
					
					program[i] = 1;
				} else {
					program[i] = 0;
				}
				
			}
			else if(rythm == 3) {
				
				if(AlgorithmUtility.proba(3, 10)) {
					
					program[i] = 2;
				} else {
					program[i] = 1;
				}
			}
			else {
				
				program[i] = 1;
			}
		}
	}
	
	public void addHotel(int budget) {
		
		Boolean good = false;
		
		if((hotels.size()==0) || (AlgorithmUtility.proba(1, 10))){
			
			int searchStar = comfort;
			
			while(!good) {
				
				for(Hotel h : hotelsList) {
					
					if (h.getStar() == searchStar) {
						if(searchStar != 1) {
							if (h.getPrice() <= budget) {
								
								addAnHotel(h);
								good = true;
								break;
							} 
						} else {
							
							addAnHotel(h);
							good = true;
							break;
						}	
					}
				}
 
				if (searchStar > 1)
					searchStar -= 1;
			}
		}
		
		else {
			hotels.add(hotels.get(hotels.size()-1));
			this.budget -= hotels.get(hotels.size()-1).getPrice();
		}
	}
	
	public void fill() {
		
 
		
		for(int day=0; day<duration; day++) {
			
 
			
 
			
			dailyBudget = budget / (duration-day);
			
 
			
			int hotelBudget;
			if(day < duration-1) {
				
				hotelBudget = (int)(dailyBudget/3);
				
 
				
 
				
				addHotel(hotelBudget);
				
 
			} else {
				
				hotelBudget = 0;
			}
				
			int excBudget = dailyBudget - hotelBudget;
			
 
			
			for(int i=0; i<program[day]; i++) {
				
				int budgetExc = (int)(excBudget/(program[day]-i));
				
 
				
 
				
				Excursion excursion = createExcursion(budgetExc, 100);
				
 
				
				addExcursion(excursion);
				
				if(excursion.getPrice() != budgetExc) {
					
					excBudget -= excursion.getPrice();
				}	
			}
			
 			
		}
	}
	
	public void addExcursion(Excursion exc) {
		
		excursions.add(exc);
		budget -= exc.getPrice();
	}
	
	public void addAnHotel(Hotel h) {
		
		hotels.add(h);
		hotelsList.remove(h);
		this.budget -= h.getPrice();
	}
	
	public Excursion createExcursion(int budget, int duration) {
		
 
		
		Excursion excursion = new Excursion();
		TouristicSite site;
		if(sites.size()>0)
			site = AlgorithmUtility.getRandomSite(sites);
		else
			site = AlgorithmUtility.getRandomSite(siteNonChoisi);
		
		excursion.addSite(site);
		sites.remove(site);
		
		Transport t = AlgorithmUtility.getBestTransport(AlgorithmUtility.getDistance(hotels.get(hotels.size()-1), site));
		excursion.addTransport(t);
		
 
 
		
		while(excursion.getDuration()<=duration  && excursion.getPrice()<=budget) {
			
 
			
			TouristicSite lastSite = excursion.getLastSite();
			
			if(sites.size()>0)
				site = AlgorithmUtility.getCloserSite(lastSite, sites);
			else
				site = AlgorithmUtility.getCloserSite(lastSite, siteNonChoisi);
			
			excursion.addSite(site);
			sites.remove(site);
			
 
			
			Transport t2 = AlgorithmUtility.getBestTransport(AlgorithmUtility.getDistance(lastSite, site));
		
			excursion.addTransport(t2);
		}
		
		excursion.addTransport(t);
		
		excursion.actualizeComfort();
		
 
		
		return excursion;
	}
	
	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getDailyBudget() {
		return dailyBudget;
	}

	public void setDailyBudget(int dailyBudget) {
		this.dailyBudget = dailyBudget;
	}

	public int getRythm() {
		return rythm;
	}

	public void setRythm(int rythm) {
		this.rythm = rythm;
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

	public int[] getProgram() {
		return program;
	}

	public void setProgram(int[] program) {
		this.program = program;
	}

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
	}

	public ArrayList<TouristicSite> getSites() {
		return sites;
	}

	public void setSites(ArrayList<TouristicSite> sites) {
		this.sites = sites;
	}

	public ArrayList<Hotel> getHotelsList() {
		return hotelsList;
	}

	public void setHotelsList(ArrayList<Hotel> hotelsList) {
		this.hotelsList = hotelsList;
	}

	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}
}













