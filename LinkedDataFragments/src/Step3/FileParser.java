package Step3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
	private Boolean reachedBGPs = false;
	private Triple tempTriple;
	private BGP tempBGP;
	private int nBGP, nTriple;
	List<BGP> bgpList = new ArrayList<BGP>();
	
	public FileParser(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner input = new Scanner(file);
		
		while(input.hasNext()) {
		    String nextLine = input.nextLine();
		    if (nextLine.contains("Deduced BGPs")) {
		    	nextLine = input.nextLine();
		    	reachedBGPs = !reachedBGPs;
		    }
		    if (reachedBGPs) {
		    	//System.out.println(nextLine);
		    	if (nextLine.contains("BGP [no")) {
		    		int start = nextLine.indexOf("o");
		    		int finish = nextLine.indexOf("]", start);
		    		nBGP = Integer.parseInt(nextLine.substring(start + 1, finish));
		    		tempBGP = new BGP(nBGP);
		    		bgpList.add(tempBGP);
		    	}
		    	else {
		    		if (nextLine.contains("Deduced LDF_")) {
		    			tempTriple = new Triple(0, "", "", "");
		    			int start = nextLine.indexOf("Deduced LDF_");
			    		int finish = nextLine.indexOf(": ", start);
			    		nTriple = Integer.parseInt(nextLine.substring(start + 12, finish));
			    		tempTriple.setNumero(nTriple);
		    			start = finish;
			    		finish = nextLine.indexOf("     ", start + 1);
			    		tempTriple.setSubject(nextLine.substring(start + 2, finish));
			    		tempTriple.convertSubject();
		    			start = finish;
		    			finish = nextLine.indexOf("     ", start + 1);
			    		tempTriple.setPredicate(nextLine.substring(start + 5, finish));
		    			start = finish;
		    			finish = nextLine.length();
			    		tempTriple.setObject(nextLine.substring(start + 5, finish));
			    		tempTriple.convertObject();
		    			tempBGP.addToTripleList(tempTriple);
		    		}
		    	}
		    }
		}
		input.close();
		
		for (BGP bgp : bgpList) {
			System.out.println("\n\nnBGP : " + bgp.getNumero());
			for (Triple t : bgp.tripleList) {
				System.out.println("\nnTriple : " + t.getNumero());
				System.out.println(t.getSubject());
				System.out.println(t.getPredicate());
				System.out.println(t.getObject());
			}
		}
	}
}
