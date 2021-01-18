package bde;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class MixtRequest {

	SQLRequest requeteSQL;
	TextRequest requeteTextuelle;
	ArrayList<String> labels;
	ArrayList<ArrayList<Object>> results;
	ArrayList<Object> current;
	int index = -1;
	
	public MixtRequest() {
		
		requeteSQL = new SQLRequest();
		requeteTextuelle = new TextRequest();
		results = new ArrayList<ArrayList<Object>>();
		current = new ArrayList<Object>();
		labels = new ArrayList<String>();
	}
	
	public void init(String requete) throws Exception {
		
		String text;
		String sqlText;
		
		if(requete.contains("with")) {
			
			String[] word = requete.split("with", 2);
			text = word[1];
			sqlText = word[0];
			
			requeteSQL.init(sqlText);
			requeteTextuelle.init(text);
			
			String resText;
			
			ResultSetMetaData meta = requeteSQL.getMetaData();
			
			//System.out.println(meta.getColumnCount());
			
			for(int i=1; i<=meta.getColumnCount(); i++) {
				labels.add(meta.getColumnLabel(i));
			}
			
			while(requeteSQL.next()) {
				
				String key = requeteSQL.getString(BdeEntry.c);
				ArrayList<Object> res = new ArrayList<Object>();
				
				while(requeteTextuelle.next()) {
					
					resText = requeteTextuelle.get();
				
					if (key.contentEquals(resText)) {
						
						
						for(int i=1; i<=meta.getColumnCount(); i++) {
							res.add(requeteSQL.getObject(i));			
						}
					}
				}
				
				//System.out.println(res.size());
				
				if(res.size() > 0)
					results.add(res);
			}
		}
	}
	
	public Boolean next() {
		
		//System.out.println(index);
		
		if (results.size() ==0)
			return false;
		else if(index < 0) {
			index = 0;
			current = results.get(index);
			index ++;
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
	
	public String getString(String label) {
		
		int column = labels.indexOf(label);
		return (String)current.get(column);
	}
	
	public int getInt(String label) {
		
		int column = labels.indexOf(label);
		return (int)current.get(column);
	}
	
}
