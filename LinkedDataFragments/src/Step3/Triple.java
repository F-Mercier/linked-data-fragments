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
	
	/**
	 * 
	 * @brief replaces the subject with "?subject" plus the identifier of the LDF or with "?object" if it's an injected object
	 */
	public void convertSubject() {
		if (this.subject.equals("subject")) {
			setSubject("INJECTEDsubj(LDF_" + numero + ")");
		}
		if (this.subject.contains("INJECTEDsubj(LDF_")) {
			int start = this.subject.indexOf("_");
			int finish = this.subject.indexOf(")");
			setSubject("?subject" + this.subject.substring(start + 1, finish));
		} else {
			if (this.subject.contains("INJECTEDobj(LDF_")) {
				int start = this.subject.indexOf("_");
				int finish = this.subject.indexOf(")");
				setSubject("?object" + this.subject.substring(start + 1, finish));
			}
			else {
				setSubject("<" + getSubject() + ">");
			}
		}
	}
	
	/**
	 * 
	 * @brief replaces the object with "?object" plus the identifier of the LDF or with "?subject" if it's an injected subject
	 */
	public void convertObject() {
		if (this.object.equals("object")) {
			setObject("INJECTEDobj(LDF_" + numero + ")");
		}
		if (this.object.contains("INJECTEDobj(LDF_")) {
			int start = this.object.indexOf("_");
			int finish = this.object.indexOf(")");
			setObject("?object" + this.object.substring(start + 1, finish));
		}
		else {
			if (this.object.contains("INJECTEDsubj(LDF_")) {
				int start = this.object.indexOf("_");
				int finish = this.object.indexOf(")");
				setObject("?subject" + this.object.substring(start + 1, finish));
			}
			else {
				if (!this.object.contains("\"")) {
					setObject("<" + getObject() + ">");
				}
			}
		}
	}
	/**
	 * 
	 * @brief convert the URI predicate to a NT format
	 */
	public void convertPredicate() {
		setPredicate("<" + getPredicate() + ">");
	}
}
