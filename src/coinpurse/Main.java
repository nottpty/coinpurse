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
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		ConsoleDialog ui = new ConsoleDialog(purse);
		PurseBalanceObserver balanceObserver = new PurseBalanceObserver();
		PurseStatusObserver statusObserver = new PurseStatusObserver();
		purse.addObserver(balanceObserver);
		purse.addObserver(statusObserver);
		balanceObserver.run();
		statusObserver.run();
		ui.run();
	}
}
