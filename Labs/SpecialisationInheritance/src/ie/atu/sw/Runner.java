package ie.atu.sw;

import java.time.Year;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		var auth1 = new Author("Joe", "F", "Bloggs");
		var auth2 = new Author("Jane", "F", "Doe");
		var list = List.of(auth1, auth2);
		
		Publication pub = new JournalArticle(" Study of Abstract stuff", Year.now(), " Journal of computing", 1, 2, " 27-55", " 10.1000/example");
		
		var citation = new Citation(pub, list);
		
		System.out.println(citation.getCitation());
	}
}
