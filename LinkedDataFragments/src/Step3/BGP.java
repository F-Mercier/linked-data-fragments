package Step3;

import java.util.ArrayList;
import java.util.List;

public class BGP {
	private int numero;
	List<Triple> tripleList = new ArrayList<Triple>();
	
	public BGP(int n) {
		setNumero(n);
	}
	
	public BGP(int n, String s, String p, String o) {
		setNumero(n);
		tripleList.add(new Triple(0, s, p, o));
	}
	
	public void addToTripleList(Triple t) {
		tripleList.add(t);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
