/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier;

/**
 * Class defining the BankAccount
 */
public class BankAccount {
	
	// Attributes
	
	protected int balance;
	
	// Methods
	
	/**
	 * Constructor for the BankAccount class
	 * 
	 * @param amount : int
	 */
	public BankAccount(int amount) {
		this.balance = amount;
	}
	
	
	/**
	 * Returns the amount
	 * @return the amount
	 */
	public int getBalance() {
		return balance;
	}
	
	
	/**
	 * Credit the bank account
	 * @param cash : int (amount of money to credit to the bank account)
	 * @throws {@link IllegalArgumentException} cash must be >= 0
	 */
	public void credit(int cash) throws IllegalArgumentException {
		if(cash < 0)
			throw new IllegalArgumentException("cash must be >= 0");
		this.balance += cash;
	}
	
	
	/**
	 * Debit the bank account
	 * @param cash : int (amount of money to debit from the bank account)
	 * @throws {@link IllegalArgumentException} cash must be >= 0
	 */
	public void debit(int cash) {
		if(cash < 0)
			throw new IllegalArgumentException("debit amount must be >= 0");
		this.balance -= cash;
	}
	
	
	/**
	 * Returns a String defining the BankAccount
	 * 
	 * @return a String defining the BankAccount : <b>String</b>
	 */
	public String toString() {
		return this.balance + " euros";
	}

}
