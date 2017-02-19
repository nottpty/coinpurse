package coinpurse;


/**
 * a coin with a monetary value and currency
 * @author Patinya Yongyai
 */
public class Coin implements Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value is the value of coin.
     */
    public Coin( double value ) {
        this.value = value;
        this.currency = DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value is the value of coin.
     * @param currency is the currency of coin.
     */
    public Coin( double value, String currency ) {
    	this.value = value;
    	this.currency = currency;
    }

    /**
     * @return value of coin
     */
    public double getValue( ) {
    	return value; 
    } 
    
    /**
     * @return currency of coin
     */
    public String getCurrency() { 
    	return currency; 
    }
    
    /**
     * Check two coins are equal if they have the same value and currency.
     * @param obj is coin that want to compare with this coin.
     * @return true if two coins are equal, return false if two coins aren't equal.
     */
    public boolean equals(Object obj) {
    	if(obj == null)
    		return false;
    	if(obj.getClass() != this.getClass())
    		return false;
    	Coin other = (Coin) obj;
    	if(value == other.value && currency == other.currency) 
    		return true;
    	return false;

    }

    /**
     * Show value and currency of coin.
     */
    public String toString() { 
    	return value+"-"+currency; 
    }

}
