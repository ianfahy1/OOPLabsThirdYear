package ie.atu.sw;

import java.net.URL;
import java.time.LocalDate;
import java.time.Year;

public class Website extends Publication{

	private String siteName;
	private URL url;
	private LocalDate retrievedDate;
	
	public Website(String title, Year year, String siteName, URL url, LocalDate retrievedDate) {
		super(title, year);
		this.siteName = siteName;
		this.url = url;
		this.retrievedDate = retrievedDate;
	}

	public String citation() {
		
		return siteName + " Available @ " + url +
					" (Accessed: " + retrievedDate;
	}
	
}
