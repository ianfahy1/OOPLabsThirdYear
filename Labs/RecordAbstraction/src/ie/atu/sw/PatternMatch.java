package ie.atu.sw;

import org.w3c.dom.css.Rect;

public class PatternMatch {

	//Using records in records
	record Point(int x, int y) {}
	record Circle(Point centre, int radius) {}
	record Rectangle(Point topLeft, Point bottomRight) {}
	
	
	
	
	public static double are(Object shape) {
		
		//NEW SWITCH STATEMENT
		return switch(shape) {
			case Circle(Point centre, int radius) -> Math.PI * radius * radius;
			
			case Rectangle(Point(int x1, int y1), Point(int x2, int y2)) -> 
				           Math.abs((x2 - x1) * (y2 - y1)) ;
							
			case Point(int x, int y) -> 0.0;
			
			default -> throw new IllegalArgumentException("Unknown shape");
		};
	}
}
