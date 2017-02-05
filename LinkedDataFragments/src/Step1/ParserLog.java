package Step1;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ParserLog {
private String file;
private ArrayList<SeqRequest> sequences;

public ParserLog(String aFileName){
  file = aFileName;
  sequences = new ArrayList<SeqRequest>();

}


public final void processLineByLine() throws IOException, ParseException {
	try (Scanner scanner =  new Scanner(new File(file))){
		sequences.add(new SeqRequest());
		int currentIndex = 0;
		while (scanner.hasNextLine()){
			SingleRequest req = processLine(scanner.nextLine());
			if(sequences.get(currentIndex).getRequests().size()!=0){
				if(sequences.get(currentIndex).getRequests().get(0).sameHour(req)){
					sequences.get(currentIndex).addRequest(req);
				}
				else {
					sequences.add(new SeqRequest());
					currentIndex++;
					sequences.get(currentIndex).addRequest(req);
				}
			}
			else {
				sequences.get(currentIndex).addRequest(req);
			}
		}      
	}
}


protected SingleRequest processLine(String aLine) throws NoSuchElementException{
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(aLine);
	SingleRequest res = new SingleRequest();
	Pattern p = Pattern.compile(" - - \\[|\\] \"GET.*query=|\"");
	scanner.useDelimiter(p);
	if (scanner.hasNext()){
		String iPAdress = scanner.next();
		String date = scanner.next();
		String query = scanner.next();
		res.setIpAdress(iPAdress);
		res.setDate(date);
		res.setQuery(query);
		
	}
	
	return res;
}

public void showAll(){
	System.out.println("*List of Sequeces*");
	for(SeqRequest seq : this.sequences){
		
		seq.showAll();
	}
}

}
