package Step3;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		FileParser fp = new FileParser("brad1.txt");
		
		if (fp.bgpList.isEmpty()) System.out.println("Aucun BGP à afficher");
		else {
			for (BGP bgp : fp.bgpList) {
				//System.out.println("=== BGP : " + bgp.getNumero() + " ===");
				for (Triple t : bgp.tripleList) {
					//System.out.println("--- Triple : " + t.getNumero() + " ---");
					System.out.println(t.getSubject() + " " + t.getPredicate() + " " + t.getObject() + " .");
				}
				//System.out.println("");
			}
		}
	}
}
