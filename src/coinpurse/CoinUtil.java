package coinpurse;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Patinya Yongyai
 */
public class CoinUtil {

	/**
	 * Method that examines all the valuables in a List and returns only the
	 * valuables that have a currency that matches the parameter value.
	 * 
	 * @param <E>
	 * 
	 * @param valuablelist
	 *            is a List of valuable objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from valuablelist that
	 *         have the requested currency.
	 */
	public static <E extends Valuable> List<E> filterByCurrency(final List<E> valuablelist, String currency) {
		if (currency == null) {
			throw new IllegalArgumentException();
		}
		Predicate<E> predicated = (s) -> s.getCurrency().equals(currency);
		return valuablelist.stream().filter(predicated).collect(Collectors.toList());
	}

	/**
	 * Method to sort a list of valuables by currency. On return, the list
	 * (valuables) will be ordered by currency.
	 * 
	 * @param valuables
	 *            is a List of Valuable objects we want to sort.
	 */
	public static void sortByCurrency(List<? extends Valuable> money) {
		class CompareByCurrency implements Comparator<Valuable> {
			@Override
			public int compare(Valuable valuable1, Valuable valuable2) {
				return valuable1.getCurrency().compareTo(valuable2.getCurrency());
			}
		}
		Collections.sort(money, new CompareByCurrency());
	}

	/**
	 * Sum valuables by currency and print the sum for each currency.
	 */
	public static void sumByCurrency(List<Valuable> valuables) {
		Map<String, Double> sumByCurrencyMap = new HashMap<>();
		for (Valuable v : valuables) {
			if (sumByCurrencyMap.containsKey(v.getCurrency()))
				sumByCurrencyMap.put(v.getCurrency(), v.getValue() + sumByCurrencyMap.get(v.getCurrency()));
			else
				sumByCurrencyMap.put(v.getCurrency(), v.getValue());
		}
		for (String currency : sumByCurrencyMap.keySet()) {
			double sum = sumByCurrencyMap.get(currency);
			System.out.println(sum + " " + currency);
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter valuables by currency of " + currency);
		List<Valuable> valuables = makeInternationalValuables();
		int size = valuables.size();
		System.out.print(" INPUT: ");
		printList(valuables, " ");
		List<Valuable> rupees = filterByCurrency(valuables, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (valuables.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort valuables by currency");
		valuables = makeInternationalValuables();
		System.out.print(" INPUT: ");
		printList(valuables, " ");
		sortByCurrency(valuables);
		System.out.print("RESULT: ");
		printList(valuables, " ");

		System.out.println("\nSum valuables by currency");
		valuables = makeInternationalValuables();
		System.out.print("valuables= ");
		printList(valuables, " ");
		sumByCurrency(valuables);

	}

	/** Make a list of valuables containing different currencies. */
	public static List<Valuable> makeInternationalValuables() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeValuables("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeValuables("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeValuables("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of valuables using given values. */
	public static List<Valuable> makeValuables(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}

	/**
	 * Return the larger of a  and b, according to the natural
	 * ordering (defined by compareTo).
	 */
	public static <E extends Comparable<? super E>> E max(E ... a) {
		E max = null;
		for (int i = 0 ; i < a.length ; i++)
			if (i == 0) {
				max = a[i];
			if (a[i].compareTo(max) > 0) 
				max = a[i];
		}
		return max;
	}

}
