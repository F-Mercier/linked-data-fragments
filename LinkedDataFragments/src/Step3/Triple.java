package Step3;

public class Triple {
	private String subject;
	private String predicate;
	private String object;
	
	public Triple (String s, String p, String o) {
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
}
