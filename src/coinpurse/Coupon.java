package coinpurse;

/**
 * A coupon with a monetary value, currency and color.
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
	 * @return the color of coupon
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Show value, currency and color of coupon.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " coupon [" + this.color + "]";
	}

}
