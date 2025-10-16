package ie.atu.sw;

//Allows removal of "System."
import static java.lang.System.*;

//Implementing interface 
public class CreditCardProcessor implements PaymentProcessor{

	private String cardNumber;
	private String cardHolderName;
	
	//Constructor
	public CreditCardProcessor(String cardNumber, String cardHolderName) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
	}

	//Overriding getPaymentMethof
	@Override
	public String getPaymentMethod() {
		
		//Super type is interface
		return PaymentProcessor.super.getPaymentMethod() + " - EU";
	}

	//Overriding abstract method
	@Override
	public boolean processPayment(double amount, String currency) {
		
		if(!validatePayment(amount)) 			return false;
		if(amount > MAX_TRANSACTION_AMOUNT) 	return false;
		
		out.println("Processing credit card " + cardNumber);
		out.println(cardHolderName + " amount:" + amount);
		
		return true;
	}
	
}
