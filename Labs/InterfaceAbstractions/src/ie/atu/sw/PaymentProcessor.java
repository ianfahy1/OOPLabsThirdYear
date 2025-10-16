package ie.atu.sw;

//All interfaces Implicitly public + abstract
public interface PaymentProcessor {
	
	//Automatically static+final variables, hence italics and caps lock
	static final double MAX_TRANSACTION_AMOUNT = 10_000.00d;
	static final String DEFAULT_CURRENCY = "EUR";
	
	//Abstract method
	boolean processPayment(double amount, String currency);
	
	//Non abstract method in an interface needs default clarifier
	default String getPaymentMethod() {
		return "Credit Card";
	}
	
	//Another method in an interface
	default boolean validatePayment(double amount) {
		return amount > 0;
	}
}