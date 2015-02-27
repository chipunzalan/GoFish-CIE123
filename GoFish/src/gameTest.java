import static org.junit.Assert.*;

import org.junit.Test;


public class gameTest {

	@Test
	public void testMain() {
		//test main function
		/*
		 * No bug in input of any character in "You asked for:"
		 * because the response is getting a card regardless any character besides the card characters that
		 * are in the PC hand.
		 * 
		 */
	}

	@Test
	public void testRandomCards() {
		/*
		 * RandomCards are tested by checking if any cards distributed to the player hand, PC hand and deck are repeated.
		 * Manually checked: 
		 * 1. All 52 cards are present
		 * 2. No cards are repeating
		 * 3. No cards are repeating from deck, player hand and PC hand
		 * 
		 */
	}

	@Test
	public void testMoveCards() {
		/*
		 * MoveCards() are tested if the cards moved from hand to hand and deck to hand are consistent.
		 * So far, no bugs are reported.
		 */
	}

	@Test
	public void testPrintCards() {
		/*
		 * PrintCards() were able to execute the printing of cards on player hand, PC hand, and deck.
		 */
	}

	@Test
	public void testAskCard() {
		/*
		 * AskCard is successful in noting the particular card to be asked.
		 * 
		 */
	}

	@Test
	public void testCheckCard() {
		/*
		 * CheckCard() is successful to check if PC hand has the asked particular card.
		 * Bugs in function:
		 * 1. lower case letters are not recognized as the same as the card characters.
		 * For example: sA !=SA
		 * 2. space in between number and suit is not recognized as the same as the card characters.
		 * For example: S A != SA 
		 */
	}

	@Test
	public void testAskCardPC() {
		/*
		 * No bug in input of any character in "You asked for:"
		 * because the response is getting a card regardless any character besides the card characters that
		 * are in the PC hand.
		 */
	}

	@Test
	public void testGetFromDeck() {
		/*
		 * 1. Cards from deck are received from the top pile first.
		 */
	}

	@Test
	public void testGetCard() {
		assertEquals("0", "DA", game.getCard(0));
		assertEquals("1", "D2", game.getCard(1));
		assertEquals("2", "D3", game.getCard(2));
		assertEquals("3", "D4", game.getCard(3));
		assertEquals("4", "D5", game.getCard(4));
		assertEquals("5", "D6", game.getCard(5));
		assertEquals("6", "D7", game.getCard(6));
		assertEquals("7", "D8", game.getCard(7));
		assertEquals("8", "D9", game.getCard(8));
		assertEquals("9", "D10", game.getCard(9));
		assertEquals("10", "DJ", game.getCard(10));
		assertEquals("11", "DQ", game.getCard(11));
		assertEquals("12", "DK", game.getCard(12));
		assertEquals("13", "HA", game.getCard(13));
		assertEquals("14", "H2", game.getCard(14));
		assertEquals("15", "H3", game.getCard(15));
		assertEquals("16", "H4", game.getCard(16));
		assertEquals("17", "H5", game.getCard(17));
		assertEquals("18", "H6", game.getCard(18));
		assertEquals("19", "H7", game.getCard(19));
		assertEquals("20", "H8", game.getCard(20));
		assertEquals("21", "H9", game.getCard(21));
		assertEquals("22", "H10", game.getCard(22));
		assertEquals("23", "HJ", game.getCard(23));
		assertEquals("24", "HQ", game.getCard(24));
		assertEquals("25", "HK", game.getCard(25));
		assertEquals("26", "SA", game.getCard(26));
		assertEquals("27", "S2", game.getCard(27));
		assertEquals("28", "S3", game.getCard(28));
		assertEquals("29", "S4", game.getCard(29));
		assertEquals("30", "S5", game.getCard(30));
		assertEquals("31", "S6", game.getCard(31));
		assertEquals("32", "S7", game.getCard(32));
		assertEquals("33", "S8", game.getCard(33));
		assertEquals("34", "S9", game.getCard(34));
		assertEquals("35", "S10", game.getCard(35));
		assertEquals("36", "SJ", game.getCard(36));
		assertEquals("37", "SQ", game.getCard(37));
		assertEquals("38", "SK", game.getCard(38));
		assertEquals("39", "CA", game.getCard(39));
		assertEquals("40", "C2", game.getCard(40));
		assertEquals("41", "C3", game.getCard(41));
		assertEquals("42", "C4", game.getCard(42));
		assertEquals("43", "C5", game.getCard(43));
		assertEquals("44", "C6", game.getCard(44));
		assertEquals("45", "C7", game.getCard(45));
		assertEquals("46", "C8", game.getCard(46));
		assertEquals("47", "C9", game.getCard(47));
		assertEquals("48", "C10", game.getCard(48));
		assertEquals("49", "CJ", game.getCard(49));
		assertEquals("50", "CQ", game.getCard(50));
		assertEquals("51", "CK", game.getCard(51));
		//test for bugs, errors
		assertEquals("52", "D2", game.getCard(1)); //52 is beyond the random number generator
		assertEquals("0", "dA", game.getCard(0)); //lower case issue
		assertEquals("0", "D A", game.getCard(0)); //space issue
		
	}

}
