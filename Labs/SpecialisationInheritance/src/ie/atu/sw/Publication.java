package ie.atu.sw;

import java.time.Year;

public abstract class Publication {

	private String title;
	private Year year;
	
	public Publication(String title, Year year) {
		super();
		this.title = title;
		this.year = year;
	}

	//Abstract Method
	public abstract String citation();
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}
	
	
}
