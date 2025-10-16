package ie.atu.sw;

import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		PaymentProcessor pp = new CreditCardProcessor("12345", "John");
		boolean out = pp.processPayment(1000, "USD");
		System.out.println(out);
		
		//boolean processPayment(double amount, String currency);
		
		/*Lambda expressions
		 * takes above method and inserts amount and currency type:
		 * 	if payment is JPN return false
		 * 	else return true
		 * 
		 * No need to specify types as compiler already 
		 * knows they are double and string respectively
		 * 
		 * Actual instance of interface \/
		 */
		PaymentProcessor pp1 = (amount, currency) -> currency.equals("JPN")? false : true;

		List<PaymentProcessor> list = List.of(pp, pp1);	
		//Instance of payment service
		var service = new PaymentService();
		service.processAll(list, 100.00, "EUR");
	}
}
