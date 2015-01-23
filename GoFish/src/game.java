/**Go Fish!

 * CIE 123 Program by Chi Punzalan (developer of game.java)
 * and Gela Magnaye (developer of gameTest.java)
 */


import java.util.Random;

public class game {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("GoFish!");
		System.out.println("Dealing cards...");
		
		//Initialization of arrays to be used
		int cards[]= new int[52] ;
		int player[] = new int[7];
		int opponent[] = new int[7];
		int deck[] = new int[39];
		for(int i=0; i<52; i++) cards[i]=0;
		for(int i=0;i<7; i++) player[i]=0;
		for(int i=0; i<7; i++) opponent[i]=0;
		boolean same = false; //checks if there are repeated cards
		Random randomGenerator = new Random(); //random number constructor
		
		/*generates random numbers and places them in an array representing
		 * the deck. the deck is then distributed as follows:
		 * -1st 7 cards goes to the player
		 * -2nd 7 cards goes to the opponent
		 * -remaining cards get left in the deck
		 */
		for (int i=0; i<52; i++) {
			int newnum = randomGenerator.nextInt(52); //generates a number from 1-52
			for (int j=1; j<i; j++) { //checks if the newnum has been generated before
				if(newnum == cards[j]) {
					same = true;
					break;
				}
				else same = false;
			}
			if(same) i--; //generate a new number
			else {
				cards[i] = newnum; //list the generated number into the deck
			}
			if(i<7) player[i] =cards[i]; //distribute cards to player
			else if(i>=7 && i<=13) opponent[i-7] = cards[i]; //distribute cards to opponent
			else deck[i-13]=cards[i]; //remaining cards go back to the deck
		}
		//Prints out the player's cards-on-hand
		System.out.print("Player's hand: ");
		for(int i=0; i<7; i++) {
			getCard(player[i]);
			System.out.print(",");
		}
		//Prints out the opponent's cards-on-hand
		System.out.println("");
		System.out.print("Opponent's hand: ");
		for(int i=0; i<7;i++) {
			getCard(opponent[i]);
			System.out.print(",");
		}
		//Prints out the cards left on the deck
		System.out.println("");
		System.out.println("Deck:");
		for(int i=0; i<38;i++) {
			getCard(deck[i]);
			System.out.print(",");
		}
	}
	
	/*Converts the randomly-generated number into a corresponding
	 * card by printing out the characters
	 */
	public static String getCard(int cardnumber) {
		int suit = cardnumber/13;
		int card = cardnumber%13;
		String cardname = "";
		if(suit == 0) {
			System.out.print("D"); //diamonds
			cardname = cardname.concat("D");
		}
		else if(suit==1) {
			System.out.print("H"); //hearts
			cardname = cardname.concat("H");
		}
		else if(suit==2) {
			System.out.print("S"); //spades
			cardname = cardname.concat("S");
		}
		else if(suit==3) {
			System.out.print("C"); //clubs
			cardname = cardname.concat("C");
		}
		
		if (card == 0) {
			System.out.print("A");
			cardname = cardname.concat("A");
		}
		else if (card == 1) {
			System.out.print("2");
			cardname = cardname.concat("2");
		}
		else if (card == 2) {
			System.out.print("3");
			cardname = cardname.concat("3");
		}
		else if (card == 3) {
			System.out.print("4");
			cardname = cardname.concat("4");
		}
		else if (card == 4) {
			System.out.print("5");
			cardname = cardname.concat("5");
		}
		else if (card == 5) {
			System.out.print("6");
			cardname = cardname.concat("6");
		}
		else if (card == 6) {
			System.out.print("7");
			cardname = cardname.concat("7");
		}
		else if (card == 7) {
			System.out.print("8");
			cardname = cardname.concat("8");
		}
		else if (card == 8) {
			System.out.print("9");
			cardname = cardname.concat("9");
		}
		else if (card == 9) {
			System.out.print("10"); //jack
			cardname = cardname.concat("10");
		}
		else if (card == 10) {
			System.out.print("J"); //queen
			cardname = cardname.concat("J");
		}
		else if (card == 11) {
			System.out.print("Q"); //king
			cardname = cardname.concat("Q");
		}
		else if (card == 12) {
			System.out.print("K"); //joker
			cardname = cardname.concat("K");
		}
		return cardname;
		}
}
