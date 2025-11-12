package ie.atu.sw;

import java.util.ArrayList;
import java.util.List;

public class Citation {
	private Publication publication;
	private List<Author> authors;

	public String getCitation() {
		var sb = new StringBuilder();
		
		//Formatting Authors
		sb.append(authors.getFirst().getHarvardName());
		
		for(int i = 1; i < authors.size(); i++) {
			sb.append(" and ");
			sb.append(authors.get(i).getHarvardName());
		}
		
		//Publication Year
		sb.append(publication.getYear());
		sb.append(publication.getTitle());
		//Add citation
		sb.append(publication.citation());
		
		return sb.toString();
	}
	
	public Citation(Publication publication, List<Author> authors) {
		super();
		this.publication = publication;
		this.setAuthors(authors);;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = new ArrayList<Author>(authors);
	}

}
