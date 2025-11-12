package ie.atu.sw;

public interface Downloadable {

	byte[] download() throws Exception;
	long getFileSizeBytes();
}
