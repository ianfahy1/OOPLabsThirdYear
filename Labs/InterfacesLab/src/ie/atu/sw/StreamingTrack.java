package ie.atu.sw;

public record StreamingTrack(String title, String artist, int duration, MediaType media) implements Playable{

	public void play() {
		System.out.println("Playing: " + title + " by " + artist);
	}

	public void stop() {
		System.out.println("Stopping: " + title + " by " + artist);
	}
	
	//Duration does not need to be implemented as we already have a duration method
}
