/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier;

import java.util.LinkedList;

import courrier.letter.UrgentLetter;

public class City {
	
	// Attributes
	protected String name;
	protected LinkedList<Letter<?>> postBox;
	
	
	//Methods
	
	/**
	 * Constructor for the City class
	 * 
	 * @param name : String
	 */
	public City(String name) {
		this.name = name;
		postBox = new LinkedList<Letter<?>>();
	}
	
	
	/**
	 * Returns the name of the city
	 * 
	 * @return The name of the city
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Adds a letter in the postBox
	 * 
	 * @param l : Letter
	 */
	public void sendLetter(Letter<?> l) {
		this.postBox.add(l);
		System.out.print("-> " + l.getSender() + " mails " + l + " to "
						+ l.getReceiver() + " for a cost of " + l.getCost() + " euro");
		if(l.getCost() > 1)
			System.out.println("s");
		else
			System.out.println("");
		l.getSender().debit(l.getCost());
	}
	
	
	/**
	 * Distributes all the letters in the postBox to their receiver<br>
	 * Urgent letters have priority
	 */
	public void distributeLetters() {
		LinkedList<Letter<?>> tmp = new LinkedList<Letter<?>>();
		LinkedList<Letter<?>> notUrgent = new LinkedList<Letter<?>>();
		Letter<?> l;
		while(!this.postBox.isEmpty()) {
			l = this.postBox.pop();
			if(l instanceof UrgentLetter)
				tmp.add(l);
			else
				notUrgent.add(l);
		}

		this.postBox.clear();
		
		while(!notUrgent.isEmpty())
			tmp.add(notUrgent.pop());
		
		while(!tmp.isEmpty()) {
			l = tmp.pop();
			l.getReceiver().receiveLetter(l);
		}
	}
	
	
	/**
	 * Return true if the postBox is empty
	 * 
	 * @return true if the postBox is empty
	 */
	public boolean isEmpty() {
		return this.postBox.isEmpty();
	}

}
