package Step1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleRequest {
	private String ipAdress;
	private String date;
	private String query;
	
	public SingleRequest(){
		
	}
	public SingleRequest(String ipAdress, String date, String query) {
		super();
		this.ipAdress = ipAdress;
		this.date = date;
		this.query = query;
	}


	public String getIpAdress() {
		return ipAdress;
	}


	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getQuery() {
		return query;
	}


	public void setQuery(String query) {
		this.query = query;
	}
	
	public boolean sameHour(SingleRequest req) throws ParseException{
		DateFormat formater = new SimpleDateFormat("dd/MMM/yyyy HH:MM:ss");
		Date date1 = formater.parse(this.date.substring(0,20));
		Date date2 = formater.parse(req.date.substring(0,20));	
		if(Math.abs(date1.getTime() - date2.getTime())<3600000) return true;
		else return false;
		
	}
	
	public String toString(){
		String res = "Ip : " + ipAdress + "    Date : " + date + "     query : " + query;
		return res;
	}
	

	
}
