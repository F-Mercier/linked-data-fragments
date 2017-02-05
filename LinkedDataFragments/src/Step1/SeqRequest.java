package Step1;

import java.util.ArrayList;

public class SeqRequest {
	private ArrayList<SingleRequest> requests;
	
	public SeqRequest() {
		this.requests = new ArrayList<SingleRequest>();
	}

	public ArrayList<SingleRequest> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<SingleRequest> requests) {
		this.requests = requests;
	}
	
	public void addRequest(SingleRequest req){
		this.requests.add(req);
	}
	
	public void showAll(){
		
		for(SingleRequest req : requests){
			System.out.println(req.toString());
		}
		System.out.println("**********************");
	}
	
}
