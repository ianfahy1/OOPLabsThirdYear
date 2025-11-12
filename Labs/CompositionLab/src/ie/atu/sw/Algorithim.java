package ie.atu.sw;

public enum Algorithim {
	//Different constants
	GZIP 	("gz"), 
	ZIP 	("zip"),
	NONE 	("txt");
	
	private final String extension;
	
	Algorithim(String extension){
		this.extension = extension;
	}
	
	public String extension() {
		return extension;
	}
}
