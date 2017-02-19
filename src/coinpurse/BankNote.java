package coinpurse;

/**
 * a BankNote with a monetary value, currency and serial number
 * 
 * @author Patinya Yongyai
 */
public class BankNote implements Valuable {
	private static long nextSerialNumber = 1000000;
	public static final String DEFAULT_CURRENCY = "Baht";
	private final String currency;
	private final long serialNumber;
	private final double value;

	/**
	 * A BankNote with given value using the default currency.
	 */
	public BankNote(double value) {
		this.value = value;
		this.serialNumber = nextSerialNumber;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A BankNote with given value and currency.
	 * 
	 * @param value
	 *            is the value of BankNote.
	 * @param currency
	 *            is the currency of BankNote.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
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
	 * Check two BankNotes are equal if they have the same value and currency.
	 * 
	 * @param obj
	 *            is other BankNote that want to compare with this BankNote.
	 * @return true if two BankNotes are equal, return false if two BankNotes
	 *         aren't equal.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) obj;
		if (other.currency != this.currency && other.value != this.value)
			return false;
		return true;
	}

	/**
	 * Show value, currency and serial number of BankNote.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}

}
