/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier;

/**
 * Class defining the Inhabitant
 */
public class Inhabitant {
	
	// Attributes
	protected String name;
	protected City city;
	protected BankAccount bankAccount;
	
	// Methods
	
	/**
	 * Constructor for the Inhabitant class
	 * 
	 * @param name : String
	 * @param city : City
	 * @param bankAccount : BankAccount
	 */
	public Inhabitant(String name, City city, BankAccount bankAccount) {
		this.name = name;
		this.city = city;
		this.bankAccount = bankAccount;
	}
	
	
	/**
	 * Returns the city
	 * 
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	
	
	/**
	 * Returns the bank account
	 * 
	 * @return the bank account
	 */
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
	
	/**
	 * Send a letter
	 * 
	 * @param l : Letter
	 */
	public void sendLetter(Letter<Content> l) {
		this.city.sendLetter(l);
	}
	
	
	/**
	 * Receive the letter (execute the method doAction() of the letter)
	 * @param l
	 */
	public void receiveLetter(Letter<?> l) {
		System.out.println("<- " + this.name + " receives " + l +  " from "
				+ l.getSender());
		l.doAction();
	}
	
	
	/**
	 * Debit the inhabitant bank account
	 * 
	 * @param i : int
	 */
	public void debit(int i) {
		this.bankAccount.debit(i);
		if(i > 1)
			System.out.print("   - " + i + " euros are ");
		else
			System.out.print("   - " + i + " euro is ");
		System.out.print("debited from " + this.name + " account whose balance is now "
						+ this.bankAccount.getBalance() + " euro");
		if(this.bankAccount.getBalance() > 1)
			System.out.println("s");
		else
			System.out.println("");
	}
	
	
	/**
	 * Credit the inhabitant bank account
	 * 
	 * @param i : int
	 */
	public void credit(int i) {
		this.bankAccount.credit(i);
		System.out.println("   + " + this.name + "'s account is credited with "
						+ i + "; its balance is now " + this.bankAccount);
	}
	
	
	/**
	 * Returns a String defining the Inhabitant
	 * 
	 * @return a String defining the Inhabitant
	 */
	public String toString() {
		return name;
	}

}
