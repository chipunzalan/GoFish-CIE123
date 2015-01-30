/**Go Fish!

 * CIE 123 Program by Chi Punzalan (developer of game.java)
 * and Gela Magnaye (developer of gameTest.java)
 */


import java.util.Random;
import java.io.*;

public class game {
	public static boolean gofish = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("GoFish!");
		System.out.println("Dealing cards...");
		
		//Initialization of arrays to be used
		int cards[]= new int[52] ;
		int player[] = new int[7];
		String playercards[] = new String[7];
		int opponent[] = new int[7];
		String opponentcards[] = new String[7];
		int deck[] = new int[39];
		String deckcards[] = new String[39];
		for(int i=0; i<52; i++) cards[i]=0;
		for(int i=0;i<7; i++) player[i]=0;
		for(int i=0; i<7; i++) opponent[i]=0;
		boolean same = false; //checks if there are repeated cards
		Random randomGenerator = new Random(); //random number constructor
		boolean gofish = false;
		String response = null;
		
		/**generates random numbers and places them in an array representing
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
			playercards[i]=getCard(player[i]);
			System.out.print(",");
		}
		//Prints out the opponent's cards-on-hand
		System.out.println("");
		System.out.print("Opponent's hand: ");
		for(int i=0; i<7;i++) {
			opponentcards[i] = getCard(opponent[i]);
			System.out.print(",");
		}
		//Prints out the cards left on the deck
		System.out.println("");
		System.out.println("Deck:");
		for(int i=0; i<38;i++) {
			deckcards[i] = getCard(deck[i]);
			System.out.print(",");
		}
		
		/* For double checking the arrays
		System.out.println("");
		for(int i=0; i<7; i++) {
			System.out.print(playercards[i]+ ", ");
		}
		System.out.println("");
		for(int i=0; i<7; i++) {
			System.out.print(opponentcards[i]+ ", ");
		}
		System.out.println("");
		for(int i=0; i<38;i++) {
			System.out.print(deckcards[i]+", ");
		}
		*/
		
		//for asking user for card input
		System.out.println("");
		System.out.print("Ask opponent for card:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			response = br.readLine();
			System.out.println("You asked for: " + response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO error trying to read your name!");
	        System.exit(1);
		}
		
		//checking opponent's deck for the card
		for (int i=0; i < opponentcards.length;i++) {
			if(opponentcards[i].equals(response)) {
				System.out.println("FOUND! " + response);
				opponentcards[i] = "";
				gofish = false;
				break;
			}
			else gofish = true;				
			}
		
		
		//prints out "Go Fish!" if card isn't found
		if(gofish) System.out.println("Go Fish!");
		else {
			System.out.println("");
			System.out.println("Player's new hand: ");
			for(int i=0; i<playercards.length; i++) {
				System.out.print(playercards[i]+ ", ");
			}
			System.out.println("");
			System.out.println("Opponent's new hand: ");
			for(int i=0; i<opponentcards.length; i++) {
				System.out.print(opponentcards[i]+ ", ");
			}
		}
		
	}
	
	/** getCard: Converts the randomly-generated number into a corresponding
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
			System.out.print("10"); //ten
			cardname = cardname.concat("10");
		}
		else if (card == 10) {
			System.out.print("J"); //jack
			cardname = cardname.concat("J");
		}
		else if (card == 11) {
			System.out.print("Q"); //queen
			cardname = cardname.concat("Q");
		}
		else if (card == 12) {
			System.out.print("K"); //king
			cardname = cardname.concat("K");
		}
		return cardname;
	}

	
}
