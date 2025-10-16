package ie.atu.sw;

import java.util.List;

public class PaymentService {

	
	//Polymorphic method. What is it? It depends on whats on the list @ runtime
	public void processAll(List<PaymentProcessor> processors, double amount, String currency) {
		
		System.out.println("Processing " + processors.size());
		
		//For pp in processors (":" = in)
		for (PaymentProcessor pp : processors) {
			boolean success = pp.processPayment(amount, currency);
			
			if(success) {
				System.out.println("Payment Processed Successfully");
			}
			else {
				System.out.println("Payment Failed");
			}
		}
	}
}
