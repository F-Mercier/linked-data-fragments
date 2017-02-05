package Step1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {
;
	
	
	public static void main(String[] args) throws IOException, ParseException {
		ParserLog pars = new ParserLog("requestLogEx.log");
		pars.processLineByLine();
		pars.showAll();
	}

}
