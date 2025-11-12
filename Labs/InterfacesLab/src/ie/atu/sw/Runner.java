package ie.atu.sw;

import java.util.List;
import java.util.stream.Collectors;

public class Runner {

	//Filter out everything on list that isnt of type filter
	public List<Playable> filterMedia(List<Playable> list, MediaFilter filter){
		
		return list.stream()
				.filter(media -> filter.where(media))
				.collect(Collectors.toList());
	}
	
	public void go() {
		List<Playable> list = List.of(
				new StreamingTrack("Bohemian Rhapsody", "Queen", 355, MediaType.AUDIO),
				new StreamingTrack("One", "U2", 234, MediaType.AUDIO),
				//Polymorphism
				new AudioFile("Short Clip", 10, false)
		);
		
		//Short stuff filter
		var s = filterMedia(list, (m) -> m.duration() < 60);
		//Long stuff filter
		var l = filterMedia(list, (m) -> m.duration() > 300);
		
		System.out.println(s.size());
		System.out.println(l.size());
	}
	
	public static void main(String[] args) {
		new Runner().go();
	}
}
