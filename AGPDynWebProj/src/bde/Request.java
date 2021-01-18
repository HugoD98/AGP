package bde;

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
	
	public String getString(String label) throws Exception{
		
		if(mixt)
			return mixtReq.getString(label);
		else
			return req.getString(label);
	}
	
	public int getInt(String label) throws Exception{
		
		if(mixt)
			return mixtReq.getInt(label);
		else
			return req.getInt(label);
	}
	
}
