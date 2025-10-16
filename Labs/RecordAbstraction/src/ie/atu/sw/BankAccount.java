package ie.atu.sw;

public record BankAccount(String accountNum, double balance) {

	//Canonical constructor, doesn't need args
	public BankAccount{
		//Unchecked exception doesnt need try 
		if(balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
		accountNum = accountNum.toUpperCase().trim();
	}
	
}
