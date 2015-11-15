/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import courrier.content.Money;
import courrier.content.Text;
import courrier.letter.PromissoryNote;
import courrier.letter.RegisteredLetter;
import courrier.letter.SimpleLetter;
import courrier.letter.UrgentLetter;

public class Main {
	
	protected City city;
	protected List<Inhabitant> inhabitants;
	protected Random random;
	
	private static final String CITY_NAME = "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch";
	private static final int INHABITANTS = 100;
	private static final int DAYS = 6;
	private static final int MINIMUM_MONEY = 10;
	private static final int MAXIMUM_MONEY = 1000;
	
	public Main() {
		random = new Random();
		
		/* Initialisation de la ville */
		System.out.println("Creating " + CITY_NAME + " city");
		city = new City(CITY_NAME);
		
		/* Initialisation des habitants */
		inhabitants = new ArrayList<Inhabitant>();
		System.out.println("Creating " + INHABITANTS + " inhabitants");
		for(int i = 0; i < INHABITANTS; ++i)
			this.inhabitants.add(new Inhabitant("inhabitant-" + (i+1), city, new BankAccount(5000)));
	}
	
	
	/**
	 * Returns city
	 * 
	 * @return city
	 */
	protected City getCity() {
		return this.city;
	}
	
	
	/**
	 * Returns random int between 0 and i
	 * 
	 * @param i : int
	 * @return random int between 0 and i
	 */
	protected int getRandomInt(int i) {
		return this.random.nextInt(i);
	}
	
	
	
	/**
	 * Returns randomly true or false
	 * 
	 * @return true or false (randomly)
	 */
	protected boolean randomBoolean() {
		return this.random.nextBoolean();
	}
	
	
	/**
	 * Create a random type of letter
	 * 
	 * @return a random type of letter
	 */
	protected Letter<?> createRandomLetter() {
		Letter<?> letter;
		boolean isUrgent, isRegistered;
		int rand1, rand2;
		isUrgent = randomBoolean();
		isRegistered = randomBoolean();
		rand1 = getRandomInt(INHABITANTS);
		rand2 = rand1;
		while(rand2 == rand1)
			rand2 = getRandomInt(INHABITANTS);
		
		switch(getRandomInt(2)) {
		
		/* Simple letter */
		case 1:
			letter = new SimpleLetter(this.inhabitants.get(rand1),
							this.inhabitants.get(rand2), new Text("bla bla"));
			break;
			
		/* Promissory Note */
		default:
			letter = new PromissoryNote(this.inhabitants.get(rand1),
							this.inhabitants.get(rand2),
							new Money(getRandomInt(MAXIMUM_MONEY - MINIMUM_MONEY) + MINIMUM_MONEY));
		
		}
		
		if(isRegistered) {
			Letter<?> tmp = letter;
			letter = new RegisteredLetter(tmp.getSender(), tmp.getReceiver(), tmp);
		}
		
		if(isUrgent) {
			Letter<?> tmp = letter;
			letter = new UrgentLetter(tmp.getSender(), tmp.getReceiver(), tmp);
		}
		
		return letter;
	}
	
	public static void main(String args[]) {
		
		int i;
		
		Main main = new Main();
		
		System.out.println("Mailing letters for " + DAYS + " days");
		
		for(i = 0; i < 6; ++i) {
			System.out.println("**************************************************");
			System.out.println("Day " + (i +1));
			
			main.getCity().distributeLetters();

			/* 2 à 4 lettres envoyées par jour */
			for(int j = 0; j < main.getRandomInt(4) + 2; ++j)
				main.getCity().sendLetter(main.createRandomLetter());
		}
		
		/* Pour les lettres de retour au delà de DAYS */
		while(!main.getCity().isEmpty()) {
			
			System.out.println("**************************************************");
			System.out.println("Day " + (i +1));
			main.getCity().distributeLetters();
			++i;
			
		}
		
	}
	
}
