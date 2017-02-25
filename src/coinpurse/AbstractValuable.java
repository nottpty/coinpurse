package coinpurse;

/**
 * 
 * This will be the parent class for Coin, Banknote and Coupon (and may be used
 * by other kinds of money).
 * 
 * @author Patinya Yongyai
 *
 */
public class AbstractValuable implements Valuable {
	/** The default of currency. */
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the valuable. */
	double value;
	/** The currency of valuable. */
	String currency;

	/**
	 * Create a valuable with a specified value and default currency.
	 * 
	 * @param value
	 */
	public AbstractValuable(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * Create a valuable with a specified value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Check two valuables are equal if they have the same value and currency.
	 * 
	 * @param obj
	 *            is other valuable that want to compare with this valuable.
	 * @return true if two valuables are equal, return false if two valuables
	 *         aren't equal.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Valuable other = (Valuable) obj;
		if (value == other.getValue() && currency.equals(other.getCurrency()))
			return true;
		return false;
	}

	/**
	 * @return value of valuable
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * @return currency of valuable
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check value of two valuables.
	 * 
	 * @param v
	 *            is other valuable that want to compare with this valuable
	 * @return 1 if value of this valuable more than value of v, return 0 if
	 *         value of this valuable equal with value valuable v, return -1 if
	 *         value of this valuable less than value of valuable v.
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