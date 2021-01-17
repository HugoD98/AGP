package bde;

import java.sql.ResultSet;
import java.util.ArrayList;

import environment.TouristicSite;

public class MixtRequest {

	SQLRequest requeteSQL;
	TextRequest requeteTextuelle;
	ArrayList<TouristicSite> results;
	TouristicSite current;
	int index = -1;
	
	public MixtRequest() {
		
		requeteSQL = new SQLRequest();
		requeteTextuelle = new TextRequest();
		results = new ArrayList<>();
	}
	
	public void init(String requete) throws Exception {
		
		String text;
		String sqlText;
		ResultSet res;
		
		if(requete.contains("with")) {
			
			String[] word = requete.split("with", 2);
			text = word[1];
			sqlText = word[0];
			
			requeteSQL.init(sqlText);
			requeteTextuelle.init(text);
			
			String resText;
			
			while(requeteSQL.next()) {
				
				res = requeteSQL.get();
				
				String name = res.getNString("name");
				String type = res.getNString("type");
				int price = res.getInt("price");
				int visitDuration = res.getInt("visitDuration");
				
				while(requeteTextuelle.next()) {
					
					resText = requeteTextuelle.get();
					if (name.contentEquals(resText)) {
						TouristicSite ts = new TouristicSite(name, type, price, visitDuration);
						results.add(ts);
					}
				}
			}
		}
	}
	
	public Boolean next() {
		
		if (results.size() ==0)
			return false;
		else if(index < 0) {
			index = 0;
			current = results.get(index);
			return true;
		} else if(index >= results.size()) {
			index = -1;
			return false;
		} else {
			current = results.get(index);
			index = index+1;
		}		
		return true;
	}
	
	public TouristicSite get() {
		
		return current;
	}
	
}
