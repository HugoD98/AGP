package bde;

import java.sql.ResultSet;

import environment.TouristicSite;

public class Request {
	
	MixtRequest mixtReq;
	SQLRequest req;
	Boolean mixt = false;
	
	public void init(String request) throws Exception {
		
		if(request.contains("with")) {
			
			mixt = true;
			mixtReq = new MixtRequest();
			mixtReq.init(request);
		}
		else {
			
			req = new SQLRequest();
			req.init(request);
		}
	}
	
	public Boolean next() throws Exception {
		
		if(mixt) {
			if(mixtReq.next())
				return true;
		} else if(!mixt) {
			if(req.next())
				return true;
		}
		return false;
	}
	
	public Object get(){
		
		if(mixt)
			return mixtReq.get();
		else
			return req.get();
	}
	
}
