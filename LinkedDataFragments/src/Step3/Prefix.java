package Step3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Prefix {
	public static HashMap<String, String> prefixMap = new HashMap<>();
	
	public Prefix() throws FileNotFoundException {
		File file = new File("prefix");
		Scanner input = new Scanner(file);
		while(input.hasNext()) {	
			String nextLine = input.nextLine();
			String clePrefix;
			String etendu;
			String parts[] = nextLine.split("\t");  
			
			clePrefix = parts[0];
			etendu = parts[1];
			prefixMap.put(clePrefix, etendu);
			
		}
		input.close();
	}
	
	public static void getAllPrefix(){
		for(String c: prefixMap.keySet()){
			System.out.println("cle : " + c + " ; etendu : " + prefixMap.get(c));
		}
	}
	
	public static String getPrefix(String cle){
		return prefixMap.get(cle); 
	}
}
