package ie.atu.sw;

public record Point(int x, int y) {

	//Null constructor	
	public Point() {
		this(0,0);
	}
}
