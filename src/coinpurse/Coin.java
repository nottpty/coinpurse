package coinpurse;

/**
 * a coin with a monetary value and currency
 * @author Patinya Yongyai
 */
public class Coin implements Comparable<Coin>{
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
     * Check value of two coins.
     * @param c is coin that want to compare with this coin
     * @return 1 if value of this coin more than value of c, return 0 if value of this coin
     * equal with value coin c, return -1 if value of this coin less than value of coin c
     */
    @Override
    public int compareTo(Coin c) {
    	if(this.value > c.value) return 1;
    	if(this.value == c.value) return 0;
    	if(this.value < c.value) return -1;
    	return 0;
    }
    
    /**
     * Show value and currency of coin.
     */
    public String toString() { 
    	return value+"-"+currency; 
    }

}
