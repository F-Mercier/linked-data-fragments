package Step3;

import java.util.ArrayList;
import java.util.List;

public class BGP {
	int numero;
	String rawText;
	List<Triple> tripleList = new ArrayList<Triple>();
	
	public BGP(int n, String s, String p, String o) {
		setNumero(n);
		tripleList.add(new Triple(s, p, o));
	}
	
	public BGP(int n, String raw) {
		setNumero(n);
		rawText = raw;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRawText() {
		return rawText;
	}

	public void setRawText(String rawText) {
		this.rawText = rawText;
	}
}
