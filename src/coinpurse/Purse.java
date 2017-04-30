package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.WithdrawStrategy;

/**
 * A coin purse contains coins, bank notes, coupons. You can insert coins, bank
 * notes or coupons, withdraw money, check the balance, and check if the purse
 * is full. When you withdraw money, the coin purse decides which valuables to
 * remove.
 * 
 * @author Patinya Yongyai
 */
public class Purse extends Observable {
	/** Collection of objects in the purse. */
	private List<Valuable> money;
	/**
	 * Capacity is maximum number of valuables the purse can hold. Capacity is
	 * set when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private WithdrawStrategy strategy;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuables you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>();
	}

	/**
	 * Count and return the number of valuables in the purse. This is the number
	 * of valuables, not their value.
	 * 
	 * @return the number of valuables in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (Valuable v : money)
			balance += v.getValue();
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (count() >= capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a valuable into the purse. The valuable is only inserted if the
	 * purse has space for it and the valuable has positive value. No worthless
	 * valuable!
	 * 
	 * @param valuable
	 *            is a Valuable object to insert into purse
	 * @return true if valuable inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (valuable == null)
			return false;
		if (isFull() || valuable.getValue() <= 0)
			return false;
		money.add(valuable);
		this.setChanged();
		this.notifyObservers();
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount < 0)
			return null;
		if (amount > 0) {
			List<Valuable> tempMoney = new ArrayList<Valuable>(money);
			List<Valuable> result = strategy.withdraw(amount, tempMoney);
			if (result != null) {
				for (Valuable v : result) {
					money.remove(v);
				}
				this.setChanged();
				this.notifyObservers();
				return result.toArray(new Valuable[0]);
			}
		}
		return null;
	}

	/**
	 * Set strategy of withdrawal.
	 * @param strategy is strategy that you want to use
	 */
	public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return this.count() + " valuable with value " + this.getBalance();
	}

}