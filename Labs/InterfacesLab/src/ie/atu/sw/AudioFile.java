package ie.atu.sw;

import java.io.File;
import java.io.FileInputStream;

//Multiple specification inheritance
public class AudioFile implements Playable, Downloadable {

	private File f;
	private int duration;
	private boolean isPlaying;
	
	//Constructor
	public AudioFile(String name, int duration, boolean isPlaying) {
		super();
		this.f = new File(name);
		this.duration = duration;
		this.isPlaying = isPlaying;
	}

	public byte[] download() throws Exception {
		//Casting long to int
		byte[] bytes = new byte[(int)f.length()];
		
		//Input stream to read bytes
		try(var in = new FileInputStream(f)){
			in.read(bytes);
		}
		
		//Returning downloaded bytes
		return bytes;
	}

	public long getFileSizeBytes() {
		//Returning length of file size in bytes
		return f.length();
	}

	public void play() {

		//Playing audio
		if(!isPlaying) {
			System.out.println("Playing");
			isPlaying = true;
		}
	}

	public void stop() {

		//Stopping audio
		if(isPlaying) {
			System.out.println("Stopping");
			isPlaying = false;
		}
	}

	public int duration() {
		//Getting duration
		return this.duration;
	}

}
