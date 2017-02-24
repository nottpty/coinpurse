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
		Valuable valuable = null;
		if (value == 1 || value == 2 || value == 5 || value == 10)
			valuable = new Coin(value);
		else if (value < 1)
			valuable = new Coin(value, "Satang");
		else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
			valuable = new BankNote(value, ++nextSerialNumber);
		else
			throw new IllegalArgumentException();
		return valuable;
	}

}
