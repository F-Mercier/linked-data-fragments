package Step3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Prefix {
	public HashMap<String, String> prefixMap = new HashMap<>();
	
	public Prefix(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner input = new Scanner(file);
		while(input.hasNext()) {	
			String nextLine = input.nextLine();
			String clePrefix;
			String etendu;
			String parts[] = nextLine.split("\t");  
			
			clePrefix = parts[0];
			//System.out.println(clePrefix);
			etendu = parts[1];
			//System.out.println(etendu);
			prefixMap.put(clePrefix, etendu);
		}
		input.close();
	}
}
