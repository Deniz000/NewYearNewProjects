package Kodlama.io.Devs.findADev.entities.concretes;

public class ProgrammingLanguage {
	private int id;
	private String languageName;
	
	public ProgrammingLanguage() {
		super();
	}
	
	public ProgrammingLanguage(int id, String language) {
		super();
		this.id = id;
		this.languageName = language;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguage(String language) {
		this.languageName = language;
	}
}
