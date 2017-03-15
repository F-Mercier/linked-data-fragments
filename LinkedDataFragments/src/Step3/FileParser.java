package Step3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
	private Boolean reachedBGPs = false;
	
	public FileParser(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner input = new Scanner(file);
		
		while(input.hasNext()) {
		    String nextLine = input.nextLine();
		    if (nextLine.contains("Deduced BGPs")) reachedBGPs = !reachedBGPs;
		    if (reachedBGPs) System.out.println(nextLine);
		}

		input.close();
	}
}
