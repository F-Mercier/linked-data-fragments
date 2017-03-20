package Step3;

public class Triple {
	private String subject;
	private String predicate;
	private String object;
	private int numero;
	
	public Triple(int n, String s, String p, String o) {
		setNumero(n);
		setSubject(s);
		setPredicate(p);
		setObject(o);
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getPredicate() {
		return predicate;
	}
	
	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}
	
	public String getObject() {
		return object;
	}
	
	public void setObject(String object) {
		this.object = object;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void convertSubject() {
		if (this.subject.equals("subject")) {
			setSubject("INJECTEDsubj(LDF_" + numero + ")");
		}
	}
	
	public void convertObject() {
		if (this.object.equals("object")) {
			setSubject("INJECTEDobj(LDF_" + numero + ")");
		}
	}

}
