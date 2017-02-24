package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Patinya Yongyai
 */
public class Coin extends AbstractValuable {

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is the value of coin.
	 */
	public Coin(double value) {
		super(value);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is the value of coin.
	 * @param currency
	 *            is the currency of coin.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Show value and currency of coin.
	 */
	public String toString() {
		return value + "-" + currency;
	}

}
