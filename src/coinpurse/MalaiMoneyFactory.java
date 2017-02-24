package coinpurse;

/**
 * Create coins and banknotes according to the table of currency values above.
 * 
 * @author Patinya Yongyai
 *
 */
public class MalaiMoneyFactory extends MoneyFactory {
	private static long nextSerialNumber = 1000000;

	/**
	 * Create a new money object in Malay currency. If the value is not a valid
	 * currency amount, then throw IllegalArgumentException.
	 * 
	 * @return Valuable of money
	 */
	@Override
	Valuable createMoney(double value) {
		Valuable valuable = null;
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50)
			valuable = new Coin(value * 100, "Sen");
		else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100)
			valuable = new BankNote(value, "Ringgit", ++nextSerialNumber);
		else
			throw new IllegalArgumentException();
		return valuable;
	}

}
