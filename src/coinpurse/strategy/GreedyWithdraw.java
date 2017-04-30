package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import coinpurse.Valuable;

/**
 * Greedy withdraw is algorithm that choose from most value first then order by value.
 * @author Patinya Yongyai
 *
 */
public class GreedyWithdraw extends Observable implements WithdrawStrategy {

	/**
	 * Get a list of Valuable objects for money withdrawn.
	 * @return a list of Valuable objects for money withdrawn
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuables) {
		Collections.sort(valuables);
		Collections.reverse(valuables);
		List<Valuable> tempList;
		double temp = 0;
		double value = 0;
		tempList = new ArrayList<Valuable>();
		int count = valuables.size();
		for(int i = 0 ; i < count ; i++){
			value = valuables.get(i).getValue();
			if(temp+value <= amount){
				temp += value;
				tempList.add(valuables.get(i));
			}
			else if(temp+value > amount){
				continue;
			}
			if(temp == amount){
				for (int k = 0; k < tempList.size(); k++)
					valuables.remove(tempList.get(k));
				return tempList;
			}
		}
		return null;
	}

}
