package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * An interface for objects that is strategy of withdrawal.
 * 
 * @author Patinya Yongyai
 *
 */
public interface WithdrawStrategy {
	/**
	 * 
	 * @param amount is the amount to withdraw
	 * @param valuables list of Valuable objects for money withdrawn
	 * @return a list of Valuable objects for money withdrawn
	 */
	public List<Valuable> withdraw(double amount, List<Valuable> valuables);
}
