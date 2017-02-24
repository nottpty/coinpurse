package coinpurse;

/**
 * To create Thai money factory or Malay money factory.
 * 
 * @author Patinya Yongyai
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory factory = null;

	/**
	 * Get an instance of MoneyFactory. This method returns an of a subclass
	 * (Thai or Malay).
	 * 
	 * @return an of a subclass (Thai or Malay).
	 */
	static MoneyFactory getInstance() {
		if (factory == null)
			factory = new ThaiMoneyFactory();
		return factory;
	}

	/**
	 * Create a new money object in the local currency. If the value is not a
	 * valid currency amount, then throw IllegalArgumentException
	 * 
	 * @param value
	 *            to create the money
	 * @return valuable of money
	 */
	abstract Valuable createMoney(double value);

	/**
	 * Accepts money value as a String, e.g. createMoney("10"). This method is
	 * for convenience of the U.I. The default implementation of this method
	 * converts parameter to a double and calls createMoney(double), but a
	 * subclass may override it to permit other parameter values. If value is
	 * not a valid number, then throw IllegalArgumentException.
	 * 
	 * @param value
	 *            to create the money
	 * @return valuable of money
	 */
	Valuable createMoney(String value) {
		double newValue = 0;
		try {
			newValue = Double.parseDouble(value);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		return createMoney(newValue);
	}

	/**
	 * In the Main (application) class create the concrete factory object using
	 * code and call setMoneyFactory(). The Main needs to do this before
	 * starting the rest of the application.
	 * 
	 * @param newFactory
	 *            to create the new factory
	 */
	static void setMoneyFactory(MoneyFactory newFactory) {
		factory = newFactory;
	}

}
