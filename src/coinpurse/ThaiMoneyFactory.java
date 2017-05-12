package coinpurse;

/**
 * Create coins and banknotes according to the table of currency values above.
 * 
 * @author Patinya Yongyai
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private static long nextSerialNumber = 1000000;

	/**
	 * Create a new money object in Thai currency. If the value is not a valid
	 * currency amount, then throw IllegalArgumentException.
	 * 
	 * @return Valuable of money
	 */
	@Override
	Valuable createMoney(double value) {
		if (value == 1 || value == 2 || value == 5 || value == 10)
			return new Coin(value);
		else if (value < 1)
			return new Coin(value, "Satang");
		else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
			return new BankNote(value, ++nextSerialNumber);
		else
			throw new IllegalArgumentException();
	}
	
	/**
	 * Get next serial number for a bank note.
	 * @return next serial number for a bank note.
	 */
	public long getNextSerialNumber() {
		return nextSerialNumber;
	}

}
