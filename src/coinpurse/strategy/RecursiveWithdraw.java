package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

/**
 * Recursive withdraw is strategy that use recursive to find the result.
 * 
 * @author Patinya Yongyai
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	/**
	 * Get a list of Valuable objects for money withdrawn.
	 * @return a list of Valuable objects for money withdrawn
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuables) {
		if (amount == 0) {
			return new ArrayList<>();
		}
		if ((amount < 0) || valuables.size() == 0) {
			return null;
		}
		Valuable first = valuables.get(0);
		List<Valuable> result = withdraw(amount - first.getValue(), valuables.subList(1, valuables.size()));
		if (result == null) {
			result = withdraw(amount, valuables.subList(1, valuables.size()));
		} else {
			result.add(first);
		}
		return result;

	}

}
