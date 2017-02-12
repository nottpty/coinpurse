package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * @author Patinya Yongyai
 */
public class CoinUtil{

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist
	 *     that have the requested currency.  
	 */
	public static List<Coin> filterByCurrency(final List<Coin> coinlist, String currency) {
		List<Coin> tempList = new ArrayList<Coin>();
		for(Coin c : coinlist){
			if(c.getCurrency().equals(currency))
				tempList.add(c);
		}
		return tempList;
	}
	

	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	public static void sortByCurrency(List<Coin> coins) {
		class CompareByCurrency implements Comparator<Coin> {
			@Override
			public int compare(Coin coin1, Coin coin2) {
				return coin1.getCurrency().compareTo(coin2.getCurrency());
			}	
		}
		Collections.sort(coins, new CompareByCurrency());
	}
	
	/**
	 * Sum coins by currency and print the sum for each currency.
	 */
	public static void sumByCurrency(List<Coin> coins) {
		sortByCurrency(coins);
		String currency = "";
		double tempValue = 0;
		int index = 0;
		List<Coin> tempCurrency = new ArrayList<Coin>();
		for(int i = 0 ; i < coins.size() ; i++){
			if(i == 0){
				currency = coins.get(i).getCurrency();
				tempValue = coins.get(i).getValue();
				tempCurrency.add(coins.get(i));
			}
			else if(currency != coins.get(i).getCurrency()){
				System.out.println(tempValue+" "+tempCurrency.get(index).getCurrency());
				currency = coins.get(i).getCurrency();
				tempValue = coins.get(i).getValue();
				tempCurrency.add(coins.get(i));
				++index;
			}
			else
				tempValue += coins.get(i).getValue();
		}
		System.out.println(tempValue+" "+tempCurrency.get(index).getCurrency());
	}
	
	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Coin> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Coin> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");
		
		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);
		
	}
	
	/** Make a list of coins containing different currencies. */
	public static List<Coin> makeInternationalCoins( ) {
		List<Coin> money = new ArrayList<Coin>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Coin> makeCoins(String currency, double ... values) {
		List<Coin> list = new ArrayList<Coin>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
			
		}
		System.out.println(); // end the line
	}

}
