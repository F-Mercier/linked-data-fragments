package Step1;

import java.util.Scanner;

public class ParserQuery {
	public static String parse(String original){
		String res = "";
		boolean ac = false;
		Scanner scanner = new Scanner(original);
		scanner.useDelimiter("\n");
		
		while(scanner.hasNext()){
			String line = scanner.next();
			if(line.contains("WHERE")){
				ac =!ac;
				line = scanner.next();
			}
			
			
			if((line.contains("}"))||(line.contains("OPTIONAL"))) line = scanner.next();
			if(ac){
				if(!line.contains("FILTER")){
					res = res + "\n" + line.trim().replaceAll("\\?", "_:");
				}
			}
		
			
		}
		
		return res;
	}
}
