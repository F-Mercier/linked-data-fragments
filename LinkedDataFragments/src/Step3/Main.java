package Step3;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		Prefix p = new Prefix();
		FileParser fp = new FileParser("brad1.txt");
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
	    		new FileOutputStream("bradres.txt"), "utf-8"));
		
		if (fp.bgpList.isEmpty()) System.out.println("Aucun BGP à afficher");
		else {
			for (BGP bgp : fp.bgpList) {
				//System.out.println("=== BGP : " + bgp.getNumero() + " ===");
				for (Triple t : bgp.tripleList) {
					//System.out.println("--- Triple : " + t.getNumero() + " ---");
					String triple = t.getSubject() + " " + t.getPredicate() + " " + t.getObject() + " .";
					System.out.println(triple);
					bw.write(triple);
					bw.newLine();
				}
				//System.out.println("");
			}
		}
		bw.close();
	}
}
