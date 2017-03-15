package Step3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
	private Boolean reachedBGPs = false;
	private BGP tempBGP;
	private int nBGP;
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
		    	System.out.println(nextLine);
		    	
		    	if (nextLine.contains("BGP [no")) {
		    		int start = nextLine.indexOf("o");
		    		int finish = nextLine.indexOf("]", start);
		    		nBGP = Integer.parseInt(nextLine.substring(start + 1, finish));
		    		tempBGP.setNumero(nBGP);
		    		bgpList.add(tempBGP);
		    	}
		    	else {
		    		tempBGP.setRawText(tempBGP.getRawText() + nextLine);
		    	}
		    }
		}

		input.close();
	}
}
