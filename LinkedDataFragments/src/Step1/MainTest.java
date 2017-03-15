package Step1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainTest {

	
	public static void main(String[] args) throws IOException, ParseException, ScriptException {
		//ParserLog pars = new ParserLog("access.log-20151103");
		//ParserLog pars = new ParserLog("requestLogEx.log");
		
		/*pars.parseIntoFile();
		String url = "%20SELECT%20%3Fv%0A%20WHERE%20%7B%20%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FMississippi%3E%20%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23comment%3E%20%3Fv%20.%20%7D&maxrows=10000000 HTTP/1.1";
		String result = java.net.URLDecoder.decode(url, "UTF-8");
		System.out.println(result);*/
		/*ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("script.js"));
		engine.eval("He");
		*/
		//Process process = Runtime.getRuntime().exec("/usr/local/bin/phantomjs script.js");
		//LinkedDataFragmentGraph ldfg = new LinkedDataFragmentGraph("http://data.linkeddatafragments.org/dbpedia");
		//Model model = ModelFactory.createModelForGraph(ldfg);
	}

}
