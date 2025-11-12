package ie.atu.sw;

import java.time.Year;

public class Book extends Publication{

	private String publisher;
	private String city;
	private int edition;
	private String isbn;
	
	public Book(String title, Year year, String publisher, String city, int edition, String isbn) {
		super(title, year);
		this.publisher = publisher;
		this.city = city;
		this.edition = edition;
		this.isbn = isbn;
	}
	
	public String citation() {
		return publisher + ", " + city + ", ISBN: " + isbn;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
