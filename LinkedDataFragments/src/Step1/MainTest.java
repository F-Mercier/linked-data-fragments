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
		Prefix p = new Prefix();
		//ParserLog pars = new ParserLog("access.log-20151103");
		//ParserLog pars = new ParserLog("requestLogEx.log");
		
		//pars.parseIntoFile();
		String url = " %0A++++SELECT+%3Fproperty+%3FpropertyLabel+%3FpropertyVal+%3FpropertyValLabel%0A++++WHERE+%7B%0A++++++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FNorwich_Grammar_School%3E+%3Fproperty+%3FpropertyVal.%0A++++++%3Fproperty+rdfs%3Alabel+%3FpropertyLabel.%0A++++++FILTER%28lang%28%3FpropertyLabel%29+%3D+%22en%22%29.%0A++++++OPTIONAL+%7B%0A++++++++%3FpropertyVal+rdfs%3Alabel+%3FpropertyValLabel.%0A++++++++FILTER%28lang%28%3FpropertyValLabel%29+%3D+%22en%22%29.%0A++++++%7D%0A++++++FILTER%28regex%28%3Fproperty%2C+%22..%22%29%29.%0A++++++FILTER%28%21regex%28%3Fproperty%2C+%22%28ID%7Cid%7CId%7Cimage%7CImage%7Cgray%7Cdorlands%7Cwiki%7Clat%7Clong%7Ccolor%7Cinfo%7CInfo%7Chomepage%7Cmap%7CMap%7Cupdated%7CUpdated%7Clogo%7CLogo%7Cpushpin%7Clabel%7CLabel%7Cphoto%7CPhoto%29%22%29%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FwikiPageRevisionID%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FwikiPageID%3E%29.+++%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2Fabstract%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FwikiPageExternalLink%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2Ffilename%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2FimageSize%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fimagesize%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2FlogoImage%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fwebpage%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fname%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fimage%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2Fthumbnail%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fgraypage%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FgrayPage%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2FimageCaption%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fid%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fphoto%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fcaption%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FgraySubject%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fgraysubject%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fwebsite%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2FimageName%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FdorlandsSuffix%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fdorlandssuf%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fsignature%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FviafId%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fpixels%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2FmapCaption%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fpicture%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2FimageFlag%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fneurolexid%3E%29.+%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fgnd%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FdorlandsPrefix%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fdorlandspre%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2FimageWidth%3E%29.%0A++++++FILTER%28%3Fproperty+%21%3D+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fverifiedrevid%3E%29.%0A++++%7D%0A++++";
		String result = java.net.URLDecoder.decode(url, "UTF-8");
		//System.out.println(result);
		System.out.println(ParserQuery.parse(result));
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		//engine.eval(new FileReader("script.js"));
		
		
		
		
		//Process process = Runtime.getRuntime().exec("/usr/local/bin/phantomjs script.js");
		//LinkedDataFragmentGraph ldfg = new LinkedDataFragmentGraph("http://data.linkeddatafragments.org/dbpedia");
		//Model model = ModelFactory.createModelForGraph(ldfg);
	}

}
