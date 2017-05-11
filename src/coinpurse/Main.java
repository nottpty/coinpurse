package coinpurse;

import coinpurse.gui.PurseBalanceObserver;
import coinpurse.gui.PurseStatusObserver;
import coinpurse.strategy.RecursiveWithdraw;

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
		purse.setWithdrawStrategy(new RecursiveWithdraw());
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
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
