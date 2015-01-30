import static org.junit.Assert.*;

import org.junit.Test;



public class gameTest {

	@Test
	public void testMain() {
	}

	@Test
	public void testGetCard() {
		assertEquals("0", "DA", game.getCard(0));
		System.out.println(",");
		assertEquals("1", "D2", game.getCard(1));
		System.out.println(",");
		assertEquals("2", "D3", game.getCard(2));
		System.out.println(",");
		assertEquals("3", "D4", game.getCard(3));
		System.out.println(",");
		assertEquals("4", "D5", game.getCard(4));
		System.out.println(",");
		assertEquals("5", "D6", game.getCard(5));
		System.out.println(",");
		assertEquals("6", "D7", game.getCard(6));
		System.out.println(",");
		assertEquals("7", "D8", game.getCard(7));
		System.out.println(",");
		assertEquals("8", "D9", game.getCard(8));
		System.out.println(",");
		assertEquals("9", "D10", game.getCard(9));
		System.out.println(",");
		assertEquals("10", "DJ", game.getCard(10));
		System.out.println(",");
		assertEquals("11", "DQ", game.getCard(11));
		System.out.println(",");
		assertEquals("12", "DK", game.getCard(12));
		System.out.println(",");
		assertEquals("13", "HA", game.getCard(13));
		System.out.println(",");
		assertEquals("14", "H2", game.getCard(14));
		System.out.println(",");
		assertEquals("15", "H3", game.getCard(15));
		System.out.println(",");
		assertEquals("16", "H4", game.getCard(16));
		System.out.println(",");
		assertEquals("17", "H5", game.getCard(17));
		System.out.println(",");
		assertEquals("18", "H6", game.getCard(18));
		System.out.println(",");
		assertEquals("19", "H7", game.getCard(19));
		System.out.println(",");
		assertEquals("20", "H8", game.getCard(20));
		System.out.println(",");
		assertEquals("21", "H9", game.getCard(21));
		System.out.println(",");
		assertEquals("22", "H10", game.getCard(22));
		System.out.println(",");
		assertEquals("23", "HJ", game.getCard(23));
		System.out.println(",");
		assertEquals("24", "HQ", game.getCard(24));
		System.out.println(",");
		assertEquals("25", "HK", game.getCard(25));
		System.out.println(",");
		assertEquals("26", "SA", game.getCard(26));
		System.out.println(",");
		assertEquals("27", "S2", game.getCard(27));
		System.out.println(",");
		assertEquals("28", "S3", game.getCard(28));
		System.out.println(",");
		assertEquals("29", "S4", game.getCard(29));
		System.out.println(",");
		assertEquals("30", "S5", game.getCard(30));
		System.out.println(",");
		assertEquals("31", "S6", game.getCard(31));
		System.out.println(",");
		assertEquals("32", "S7", game.getCard(32));
		System.out.println(",");
		assertEquals("33", "S8", game.getCard(33));
		System.out.println(",");
		assertEquals("34", "S9", game.getCard(34));
		System.out.println(",");
		assertEquals("35", "S10", game.getCard(35));
		System.out.println(",");
		assertEquals("36", "SJ", game.getCard(36));
		System.out.println(",");
		assertEquals("37", "SQ", game.getCard(37));
		System.out.println(",");
		assertEquals("38", "SK", game.getCard(38));
		System.out.println(",");
		assertEquals("39", "CA", game.getCard(39));
		System.out.println(",");
		assertEquals("40", "C2", game.getCard(40));
		System.out.println(",");
		assertEquals("41", "C3", game.getCard(41));
		System.out.println(",");
		assertEquals("42", "C4", game.getCard(42));
		System.out.println(",");
		assertEquals("43", "C5", game.getCard(43));
		System.out.println(",");
		assertEquals("44", "C6", game.getCard(44));
		System.out.println(",");
		assertEquals("45", "C7", game.getCard(45));
		System.out.println(",");
		assertEquals("46", "C8", game.getCard(46));
		System.out.println(",");
		assertEquals("47", "C9", game.getCard(47));
		System.out.println(",");
		assertEquals("48", "C10", game.getCard(48));
		System.out.println(",");
		assertEquals("49", "CJ", game.getCard(49));
		System.out.println(",");
		assertEquals("50", "CQ", game.getCard(50));
		System.out.println(",");
		assertEquals("51", "CK", game.getCard(51));		
		System.out.println(",");
	}
}
