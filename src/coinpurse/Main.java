package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Patinya Yongyai
 */
public class Main {
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		Purse purse = new Purse(CAPACITY);
		ResourceBundle bundle = ResourceBundle.getBundle("coinpurse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory instance = null;
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		try {
			instance = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating Moneyfactory " + ex.getMessage());
		}
		if (instance == null)
			System.exit(1);
		ConsoleDialog ui = new ConsoleDialog(purse);
		ui.run();
	}
}
