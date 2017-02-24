package coinpurse;

/**
 * a BankNote with a monetary value, currency and serial number
 * 
 * @author Patinya Yongyai
 */
public class BankNote extends AbstractValuable {
	private final long serialNumber;

	/**
	 * A BankNote with given value using the default currency.
	 */
	public BankNote(double value, long serialNumber) {
		super(value);
		this.serialNumber = serialNumber;
	}

	/**
	 * A BankNote with given value and currency.
	 * 
	 * @param value
	 *            is the value of BankNote.
	 * @param currency
	 *            is the currency of BankNote.
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * @return value of BankNote
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * @return currency of BankNote
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * @return the serial number
	 */
	public long getSerial() {
		return this.serialNumber;
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
	 * Show value, currency and serial number of BankNote.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}

}
