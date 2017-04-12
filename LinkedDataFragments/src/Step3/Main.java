package Step3;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		FileParser fp = new FileParser("brad1.txt");
		
		if (fp.bgpList.isEmpty()) System.out.println("Aucun BGP à afficher");
		else {
			for (BGP bgp : fp.bgpList) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
			    	new FileOutputStream("brad" + bgp.getNumero() + "res.txt"), "utf-8"));
				String graph = "";
				//System.out.println("=== BGP : " + bgp.getNumero() + " ===");
				for (Triple t : bgp.tripleList) {
					//System.out.println("--- Triple : " + t.getNumero() + " ---");
					String triple = t.getSubject() + " " + t.getPredicate() + " " + t.getObject() + " .";
					System.out.println(triple);
					graph = graph + triple + "\n";
				}
				//System.out.println("");
				graph = toRequest(graph);
				bw.write(graph);
				bw.close();
			}
		}
	}
	
	public static String toRequest(String graph) {
		return "Select * Where {\n" + graph + "}";
	}
}
