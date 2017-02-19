package coinpurse;

/**
 * a coupon with a monetary value, currency and color
 * @author Patinya Yongyai
 */
public class Coupon implements Valuable{
	private final String color;
	private final String currency;
	private final double value;

	/**
     * A coupon with given value and currency.
     * @param value is the value of coupon.
     * @param currency is the currency of coupon.
     * @param color is the color of coupon.
     */
	public Coupon(double value, String currency, String color){
		this.color = color;
		this.currency = currency;
		this.value = value;
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
	public String getColor(){
		return this.color;
	}
	
	/**
     * Check two coupons are equal if they have the same value and currency.
     * @param obj is coupon that want to compare with this coupon.
     * @return true if two coupons are equal, return false if two coupon aren't equal.
     */
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(obj.getClass() != this.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if(other.value != this.value && other.currency != this.currency)
			return false;
		return true;
	}
	
	/**
     * Show value, currency and color of coupon.
     */
	public String toString(){
		return this.value+"-"+this.currency+" coupon ["+this.color+"]";
	}


}
