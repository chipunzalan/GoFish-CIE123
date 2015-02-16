/**Go Fish!

 * CIE 123 Program by Chi Punzalan (developer of game.java)
 * and Gela Magnaye (developer of gameTest.java)
 */

import java.util.Random;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays.*;

public class game {
	public static boolean gofish = true;

	//Integer ArrayList to store randomly generated integers for each hand
	public ArrayList<Integer> human = new ArrayList<Integer>();
	public ArrayList<Integer> pc = new ArrayList<Integer>();
	public ArrayList<Integer> deck = new ArrayList<Integer>();
	public ArrayList<Integer> cards = new ArrayList<Integer>();

	//String arraylist to hold string values of cards currently held
	public ArrayList<String> humanhand = new ArrayList<String>();
	public ArrayList<String> pchand = new ArrayList<String>();
	public ArrayList<String> deckstack = new ArrayList<String>();
	public ArrayList<String> humandroppedbooks = new ArrayList<String>();
	public ArrayList<String> pcdroppedbooks = new ArrayList<String>();
	public String[] cardletter = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	public int[] humanbooks = new int[14];
	public int[] pcbooks = new int[14];
	public String response;
	public boolean drawcard;
	public Integer bookcount;

	public static void main(String[] args) {
		game goFish = new game();
		// Program initialization
		System.out.println("GoFish!");
		System.out.println("Dealing cards...");
		
		//Initialization of local variables
		Integer turnNum = 0;
		boolean booksdone = false;
		
		/*generates random numbers and places them in an array representing
		 * the deck. the deck is then distributed as follows:
		 * -1st 7 cards goes to the player
		 * -2nd 7 cards goes to the opponent
		 * -remaining cards get left in the deck
		 */
		goFish.randomCards();
		goFish.moveCards();

		/* Main game loop wherein player and PC take turns in asking for cards.
		The loop automates the transferring and drawing of cards from the deck if necessary
		*/
		while(!booksdone) {
			if(turnNum==0) {
				goFish.askCard();
				goFish.checkCard();
				goFish.checkHumanBooks();
				goFish.dropHumanBooks();
				turnNum = 1;
			}
			else if(turnNum == 1) {
				goFish.askCardPC();
				goFish.checkPCBooks();
				turnNum = 0;
			}
		}
		
	}
	
	/* Creates a randomized set of values from 1-52 to represent each card.
	Cards are then "shuffled" into ArrayLists for the player, the PC and the remaining card deck.
	*/
	public void randomCards() {
		boolean same = false;
		Random randomGenerator = new Random(); //random number constructor
		for (int i=0; i<52; i++) {
			int newnum = randomGenerator.nextInt(52); //generates a number from 1-52
			int limit = cards.size();
			for (int j=0; j<limit; j++) { //checks if the newnum has been generated before
				if(newnum == cards.get(j)) {
					same = true;
					break;
				}
				else same = false;
			}
			if(same) i--; //generate a new number
			else {
				cards.add(i,newnum); //list the generated number into the deck
			}
		}

		for(int i=0; i<52; i++) {
			if(i<7) human.add(cards.get(i)); //distribute cards to player
			else if(i>=7 && i<=13) pc.add(cards.get(i)); //distribute cards to opponent
			else deck.add(cards.get(i)); //remaining cards go back to the deck
		}
	}

	// Converts the integer valued cards into string lists
	public void moveCards() {
		System.out.print("Player's deck: ");
		for(int i=0; i<human.size(); i++) { //converting integer values for the human hand into string
			humanhand.add(getCard(human.get(i)));
		}
		System.out.println(humanhand+" // "+humanhand.size());
		System.out.print("PC's deck: ");
		for(int i=0; i<pc.size(); i++) { //converting integer values for the PC hand into string
			pchand.add(getCard(pc.get(i)));
		}
		System.out.println(pchand+" // "+pchand.size());
		System.out.print("Cards: ");
		for(int i=0; i<deck.size(); i++) { //converting integer values for the deck into string
			deckstack.add(getCard(deck.get(i)));
		}
		System.out.println(deckstack +" // "+deckstack.size());
	}

	//Outputs the current deck of the human and opponent
	//For checking purposes
	public void printCards() {
		System.out.println("Player: "+humanhand+" //"+humanhand.size());
		System.out.println("PC: "+pchand+" //"+pchand.size());
		// System.out.println("Deck: "+deckstack+" //"+deckstack.size());
	}

	//Requests a string input from the user representing requested card
	public void askCard() {
		System.out.print("Ask opponent for card:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			response = br.readLine();
			response.toUpperCase(); //capitalizes string input
			System.out.println("You asked for: " + response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO error trying to read your name!");
	        System.exit(1);
		}
	}

	//For checking the PC's deck for human's requested card
	public void checkCard() {
		for (int i=0; i < pchand.size();i++) {
			if(pchand.get(i).equals(response)) { //for checking opponent's deck
				humanhand.add(pchand.get(i));
				pchand.remove(i);
				drawcard = false;
				break;
			}
			else drawcard= true;				
		}
		if(drawcard) {
			getFromDeck(0); //draws card from deck if requested card is not with opponent
		}
		else printCards();
	}

	/*Automation of the process wherein the PC requests a card from the human
	*The request is randomly generated as well
	*/
	public void askCardPC() {
		Random randomGenerator = new Random();
		response = getCard(randomGenerator.nextInt(52));
		System.out.println("PC asked for: "+response);
		for(int i=0; i<humanhand.size();i++) { //for checking opponent's deck
			if(humanhand.get(i).equals(response)) {
				pchand.add(humanhand.get(i));
				humanhand.remove(i);
				drawcard = false;
				break;
			}
			else drawcard = true;
		}
		if(drawcard) {
			getFromDeck(1); //draws card from deck if requested card is not with opponent
		}
		else printCards();
	}

	public void getFromDeck(int turn) {
		if(turn == 0) {
			humanhand.add(deckstack.get(0)); //top card is added to human's hand
			deckstack.remove(0); //top card is removed from deck
		}
		else if(turn==1) {
			pchand.add(deckstack.get(0)); //top card is added to PC's hand
			deckstack.remove(0); //top card is removed from deck
		}
		printCards();
	}

	//Converts the randomly-generated number into a corresponding string value
	public static String getCard(int cardnumber) {
		int suit = cardnumber/13;
		int card = cardnumber%13;
		String cardname = "";
		if(suit == 0) cardname = cardname.concat("D"); //diamonds
		else if(suit==1) cardname = cardname.concat("H"); //hearts
		else if(suit==2) cardname = cardname.concat("S"); //spade
		else if(suit==3) cardname = cardname.concat("C"); //club

		if (card == 0) cardname = cardname.concat("A"); //Ace
		else if (card == 1) cardname = cardname.concat("2");
		else if (card == 2) cardname = cardname.concat("3");
		else if (card == 3) cardname = cardname.concat("4");
		else if (card == 4) cardname = cardname.concat("5");
		else if (card == 5) cardname = cardname.concat("6");
		else if (card == 6) cardname = cardname.concat("7");
		else if (card == 7) cardname = cardname.concat("8");
		else if (card == 8) cardname = cardname.concat("9");
		else if (card == 9) cardname = cardname.concat("T"); //Ten
		else if (card == 10) cardname = cardname.concat("J"); //Jack
		else if (card == 11) cardname = cardname.concat("Q"); //Queen
		else if (card == 12) cardname = cardname.concat("K"); //King

		return cardname;
	}	

	//Checks the number of books formed by cards from human's deck
	//Prints out a count of cards per kind
	public void checkHumanBooks() {
		System.out.print("Human Books|");
		for (int i=0; i < cardletter.length; i++) {
			humanbooks[i]=0;
			for(int j = 0; j<humanhand.size(); j++) {
				String thiscard= humanhand.get(j);
				String currentcard = thiscard.substring(1);
				if(currentcard.equals(cardletter[i])) {
					humanbooks[i]++;
				}
			}
			System.out.print(cardletter[i]+":"+humanbooks[i]+"|");
		}
		System.out.println();
	}

	public void dropHumanBooks() {
		for(int i=0;i<cardletter.length; i++){
			if(humanbooks[i]==4) {
				for(int j=0; j<humanhand.size();j++) {
					String cardnow = humanhand.get(j);
					String currentcard = cardnow.substring(1);
					if(currentcard.equals(cardletter[i])) {
						humanhand.remove(j);
					}
				}
				humandroppedbooks.add(cardletter[i]);
			}
		}
		System.out.println(humandroppedbooks);
	}

	//Checks the number of books formed by cards from PC's deck
	//Prints out a count of cards per kind
	public void checkPCBooks() {
		System.out.print("PC Books|");
		for (int i=0; i < cardletter.length; i++) {
			pcbooks[i]=0;
			for(int j = 0; j<pchand.size(); j++) {
				String thiscard= pchand.get(j);
				String currentcard = thiscard.substring(1);
				if(currentcard.equals(cardletter[i])) {
					pcbooks[i]++;
				}
			}
			System.out.print(cardletter[i]+":"+pcbooks[i]+"|");
		}
		System.out.println();
	}


}
