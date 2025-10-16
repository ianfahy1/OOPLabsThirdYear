package ie.atu.sw;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CurRunner {

	public static void main(String[] args) {
		
		//Enums 
		var euro = Currency.EUR;
		var bit = Currency.BTC;
		
		//Enum being used to call a method 
		var res = euro.convertTo(bit, 10_000, 0.000011);
		System.out.println(res);
		
		System.out.println(euro.getSymbol());
		System.out.println(euro.getName());
		System.out.println(euro.getPrecision());
		System.out.println(euro.format(10));
		
		//Currency array
		Currency[] all = Currency.values();
		//Prints enums
		System.out.println(Arrays.toString(all));
	}
}
