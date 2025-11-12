package ie.atu.sw;

public enum MediaType implements Playable{

	AUDIO ("Audio File", ".mp3") ,
	VIDEO ("Video File", ".mp4");

	private final String display;
	private final String format;
	
	MediaType(String display, String format) {
		this.display = display;
		this.format = format;
	}

	public String getDisplay() {
		return display;
	}

	public String getFormat() {
		return format;
	}

	@Override
	public void play() {
		System.out.println("Playing " + display + ": " + format);
	}

	@Override
	public void stop() {
		System.out.println("Stopping " + display + ": " + format);
	}

	@Override
	public int duration() {
		return 0;
	}
}
