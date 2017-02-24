package coinpurse;

/**
 * a coupon with a monetary value, currency and color
 * 
 * @author Patinya Yongyai
 */
public class Coupon extends AbstractValuable {
	private final String color;

	/**
	 * A coupon with given value and currency.
	 * 
	 * @param value
	 *            is the value of coupon.
	 * @param currency
	 *            is the currency of coupon.
	 * @param color
	 *            is the color of coupon.
	 */
	public Coupon(double value, String currency, String color) {
		super(value, currency);
		this.color = color;
	}

	/**
	 * @return value of coupon
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * @return currency of coupon
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * @return the color of coupon
	 */
	public String getColor() {
		return this.color;
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

	/**
	 * Show value, currency and color of coupon.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " coupon [" + this.color + "]";
	}

}
