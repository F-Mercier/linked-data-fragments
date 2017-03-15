package Step1;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
		int reqNum = 0;
		while (scanner.hasNextLine()){
			SingleRequest req = processLine(scanner.nextLine());
			reqNum++;
			System.out.println("Query #" + reqNum + "    seq #" + currentIndex);
			if(sequences.get(currentIndex).getRequests().size()!=0){
				if(sequences.get(currentIndex).getRequests().get(0).sameHour(req)){
				//if(sequences.get(currentIndex).getRequests().size()<10000){
					sequences.get(currentIndex).addRequest(req);
				}
				else {
					sequences.add(new SeqRequest());
					currentIndex++;
					System.out.println("Seq #" + currentIndex);
					sequences.get(currentIndex).addRequest(req);
				}
			}
			else {
				sequences.get(currentIndex).addRequest(req);
			}
		}      
	}
}

public final void parseIntoFile() throws IOException, ParseException{
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(new File(file));
	BufferedWriter bw = null;
	FileWriter fw = null;
	int nbFile = 0;
	int nbQuery = 0;
	int nbQuerytot = 0;
	SingleRequest firstReq = null;
	while (scanner.hasNextLine()){
		SingleRequest req = processLine(scanner.nextLine());
		if(nbQuery == 0){ //first query in sequence
			firstReq = req;
			File file = new File("FragmentedFiles/Seq_" + req.getDate().replaceAll("\\s+", "").replaceAll("/", "") + ".txt");
			file.createNewFile();
			fw = new FileWriter(file.getPath());
			bw = new BufferedWriter(fw);
			bw.write(req.toString());	
			bw.newLine();
			nbFile++;
			nbQuery++;
		}
		else {
			if(req.sameHour(firstReq)){
				bw.write(req.toString());
				bw.newLine();
				nbQuery++;
			}
			else {
				bw.close();
				fw.close();
				File file = new File("FragmentedFiles/Seq_" + req.getDate().replaceAll("\\s+", "").replaceAll("/", "") + ".txt");
				file.createNewFile();
				fw = new FileWriter(file.getPath());
				bw = new BufferedWriter(fw);
				bw.write(req.toString());
				bw.newLine();
				firstReq = req;
				nbFile++;
				nbQuery = 1;
			}
		}
		nbQuerytot++;
		System.out.println("Query #" + nbQuerytot + "      File #" + nbFile);
	}
	bw.close();
	fw.close();
	System.out.println(nbFile + " file(s) created !");
	System.out.println(nbQuerytot);
}





protected SingleRequest processLine(String aLine) throws NoSuchElementException{
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(aLine);
	SingleRequest res = new SingleRequest();
	Pattern p = Pattern.compile(" - - \\[|\\] \".*query=|\"");
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


public ArrayList<SeqRequest> getSequences() {
	return sequences;
}


public void setSequences(ArrayList<SeqRequest> sequences) {
	this.sequences = sequences;
}

}
