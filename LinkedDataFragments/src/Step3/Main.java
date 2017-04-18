package Step3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args){
		try {
			File repertory = new File(args[0]);
			File[] files = repertory.listFiles();
			System.out.print("Opening new BufferedWriter...");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
			    new FileOutputStream(repertory.getName() + "-res.xml"), "utf-8"));
			System.out.println("OK");
			bw.write("<log>\n");
			for (File f : files) {
				System.out.println("Starting reading file " + f.toString());
				writeInFile(f, bw, "");
			}
			bw.write("</log>");
			System.out.print("Closing BufferedWriter...");
			bw.close();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeInFile(File f, BufferedWriter bw, String tabul) throws Exception {
		FileParser fp = new FileParser(f);
		
		if (!fp.bgpList.isEmpty()) {
			String tab = tabul;
			String log = "";
			for (BGP bgp : fp.bgpList) {
				log = log + tab + "<entry>\n";
				
				String graph = "";
				for (Triple t : bgp.tripleList) {
					String triple = t.getSubject() + " " + t.getPredicate() + " " + t.getObject() + " . ";
					graph = graph + triple;
				}
				graph = toRequest(tab, graph);
				tab = tab + "\t";
				log = log + tab + "<request>" + graph + "</request>\n" + tab + "<bgp>\n";
				tab = tab + "\t";
				for (Triple t : bgp.tripleList) {
					String triple = t.getSubject() + " " + t.getPredicate() + " " + t.getObject() + " . ";
					log = log + tab + "<tp>" + triple + "</tp>\n";
				}
				tab = tab.substring(0, tab.length() - 1);
				log = log + tab + "</bgp>\n";
				tab = tab.substring(0, tab.length() - 1);
				log = log + tab + "</entry>\n";
				bw.write(log);
			}
		}
	}
	
	public static String toRequest(String tab, String graph) {
		return "Select * Where {" + graph + "}";
	}
}
