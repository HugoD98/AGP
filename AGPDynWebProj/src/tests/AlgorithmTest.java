package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import algorithm.Algorithm;
import algorithm.AlgorithmUtility;
import environment.TouristicSite;
import environment.Transport;
import organisation.Excursion;
import organisation.Stay;


public class AlgorithmTest {

	public void testFillProgram() throws Exception {
		
		Algorithm algo = new Algorithm("nager peintre", 4, 3, 10000, 3);
		
		algo.fillProgram();
		
		for(int i=0; i<algo.getProgram().length; i++) {
			
			System.out.println("pour le jour : "+i+" on a "+algo.getProgram()[i]+" excursions.");
		}	
	}
	
	public void testCloserSite() {
		
		TouristicSite t1 = new TouristicSite("templeA", "culturel", 25, 2, 10, 10);
		TouristicSite t2 = new TouristicSite("templeB", "culturel", 25, 3, 1, 1);
		TouristicSite t3 = new TouristicSite("surf", "sportive", 200, 2, 9, 9);
		ArrayList<TouristicSite> touristicSiteMap1 = new ArrayList<TouristicSite>();
		touristicSiteMap1.add(t1);
		touristicSiteMap1.add(t2);
		
		TouristicSite t = AlgorithmUtility.getCloserSite(t3, touristicSiteMap1);
		
		assertEquals(t1, t);
	}
	
	public void testCreateExcursion() throws Exception {
		
		Algorithm algo = new Algorithm("nager peintres panoramique plongée cyclisme mer volcan jet ski danse", 4, 3, 1000, 3);
		
		Excursion exc = algo.createExcursion(100, 180);
		
		ArrayList<Transport> trans = exc.getTransports();
		ArrayList<TouristicSite> sites = exc.getTouristicSites();
		int comfort = exc.getComfort();
		int price = exc.getPrice();
		
		for(TouristicSite t : sites) {
			
			System.out.println(t.getName());
		}
		
		for(Transport t : trans) {
			
			System.out.println(t.getName());
		}
		System.out.println(comfort);
		System.out.println(price);
		
	}

	
	public void testSetHotel() throws Exception{
		
		Algorithm algo = new Algorithm("nager peintres panoramique plongée cyclisme nature ", 4, 4, 100, 3);
	
		algo.addHotel(100);
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getName());
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getStar());
		algo.addHotel(100);
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getName());
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getStar());
		algo.addHotel(100);
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getName());
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getStar());
		algo.addHotel(100);
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getName());
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getStar());
		algo.addHotel(100);
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getName());
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getStar());
		algo.addHotel(100);
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getName());
		System.out.println(algo.getHotels().get(algo.getHotels().size()-1).getStar());
	}

	
	public void testAlgo() throws Exception {
		
		Algorithm algo = new Algorithm("nager peintres panoramique plongée cyclisme volcanique nature Quad mer jet ski danse falaise", 3, 3, 500, 1);
		
		ArrayList<Stay> test = algo.launch(3);
		
		ArrayList<Stay> test2 = AlgorithmUtility.stays;
		
		assertEquals(test, test2);
	}

	@Test
	public void testRecupText() throws Exception {
		
		String s = AlgorithmUtility.getText("Mont Batur");
	
		System.out.println("test "+s);
	}

}
