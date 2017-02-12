package coinpurse;

/**
 * a coin with a monetary value and currency
 * @author
 */
public class Coin implements Comparable<Coin>{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value ) {
        this.value = value;
        this.currency = DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	this.value = value;
    	this.currency = currency;
    }

    public double getValue( ) { return value; } 
    
    public String getCurrency() { return currency; }
    
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
    
    @Override
    public int compareTo(Coin c) {
    	if(this.value > c.value) return 1;
    	if(this.value == c.value) return 0;
    	if(this.value < c.value) return -1;
    	return 0;
    }
    
    public String toString() { return value+"-"+currency; }

}
