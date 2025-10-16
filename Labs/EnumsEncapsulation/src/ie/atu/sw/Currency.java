package ie.atu.sw;

import static  java.lang.Math.*;

public enum Currency {

	//Enums
	USD (840, "$", "US Dollar", 					2),
	EUR (978, "€", "Euro",							2),
	JPY (392, "¥", "Japanese Yen",					0),
	GBP (826, "£", "British Pound Sterling",		2),
	BTC (999, "B", "Bitcoin",						8);

	//Private variables for constructors/getters/setters
	private final int code;
	private final String symbol;
	private final String name;
	private final int precision;
	
	Currency(int code, String symbol, String name, int precision) {
		
		this.code = code;
		this.symbol = symbol;
		this.name = name;
		this.precision = precision;
	}
	
	//Formats whatever value is passed, with a symbol and precision
	public String format(double amount) {
		var format = "%." + precision + "f";
		return symbol + String.format(format, amount);
	}

	//Converts one currency to another
	public double convertTo(Currency target, double amount, double rate) {
		
		if(target == this) return amount;
		
		return round(amount * rate * pow(10, target.precision)) /
				pow(10, target.precision);
	}

	
	public boolean isValid(double amount) {
		var multiplier = pow(10, precision);
		//Absolute value
		return abs(amount * multiplier - round(amount * multiplier)) < 1e-10;
	}
	
	
	public int getCode() {
		return code;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public int getPrecision() {
		return precision;
	}
}
