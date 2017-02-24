package coinpurse;

public class AbstractValuable implements Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	double value;
	String currency;

	public AbstractValuable(double value){
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}
	
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Check two coins are equal if they have the same value and currency.
	 * 
	 * @param obj
	 *            is coin that want to compare with this coin.
	 * @return true if two coins are equal, return false if two coins aren't
	 *         equal.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin other = (Coin) obj;
		if (value == other.value && currency.equals(other.currency))
			return true;
		return false;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check value of two valuables.
	 * 
	 * @param v
	 *            is other valuable that want to compare with this valuable
	 * @return 1 if value of this valuable more than value of v, return 0 if value
	 *         of this valuable equal with value valuable v, return -1 if value of this
	 *         valuable less than value of valuable v.
	 */
	@Override
	public int compareTo(Valuable v) {
		if (this.value > v.getValue())
			return 1;
		if (this.value == v.getValue())
			return 0;
		if (this.value < v.getValue())
			return -1;
		return 0;
	}



}