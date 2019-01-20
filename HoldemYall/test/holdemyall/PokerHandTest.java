/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author storm
 */
public class PokerHandTest {
    
    public PokerHandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compareTo method, of class PokerHand.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        PokerHand opponentHand = null;
        PokerHand instance = null;
        int expResult = 0;
        int result = instance.compareTo(opponentHand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortCards method, of class PokerHand.
     */
    @Test
    public void testSortCards() {
        System.out.println("sortCards");
        PokerHand instance = null;
        Card[] expResult = null;
        Card[] result = instance.sortCards();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaceValue method, of class PokerHand.
     */
    @Test
    public void testGetFaceValue() {
        System.out.println("getFaceValue");
        Card card = null;
        PokerHand instance = null;
        int expResult = 0;
        int result = instance.getFaceValue(card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuit method, of class PokerHand.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Card card = null;
        PokerHand instance = null;
        String expResult = "";
        String result = instance.getSuit(card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHand method, of class PokerHand.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        PokerHand instance = null;
        Card[] expResult = null;
        Card[] result = instance.getHand();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHandRank method, of class PokerHand.
     */
    @Test
    public void testGetHandRank() {
        System.out.println("getHandRank");
        Card card1 = new Card("Spades", 1);
        Card card2 = new Card("Spades", 7);
        Card card3 = new Card("Spades", 4);
        Card card4 = new Card("Spades", 5);
        Card card5 = new Card("Spades", 4);
        Card[] hand = new Card[] {card1, card2, card3, card4, card5};
        PokerHand instance = new PokerHand(hand);
        int expResult = 6;
        int result = instance.getHandRank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isFourOfAKind method, of class PokerHand.
     */
    @Test
    public void testIsFourOfAKind() {
        System.out.println("isFourOfAKind");
        PokerHand instance = null;
        boolean expResult = false;
        boolean result = instance.isFourOfAKind();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFullHouse method, of class PokerHand.
     */
    @Test
    public void testIsFullHouse() {
        System.out.println("isFullHouse");
        PokerHand instance = null;
        boolean expResult = false;
        boolean result = instance.isFullHouse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFlush method, of class PokerHand.
     */
    @Test
    public void testIsFlush() {
        System.out.println("isFlush");
        PokerHand instance = null;
        boolean expResult = false;
        boolean result = instance.isFlush();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isStraight method, of class PokerHand.
     */
    @Test
    public void testIsStraight() {
        System.out.println("isStraight");
        PokerHand instance = null;
        boolean expResult = false;
        boolean result = instance.isStraight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isThreeOfAKind method, of class PokerHand.
     */
    @Test
    public void testIsThreeOfAKind() {
        System.out.println("isThreeOfAKind");
        PokerHand instance = null;
        boolean expResult = false;
        boolean result = instance.isThreeOfAKind();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTwoPair method, of class PokerHand.
     */
    @Test
    public void testIsTwoPair() {
        System.out.println("isTwoPair");
        PokerHand instance = null;
        boolean expResult = false;
        boolean result = instance.isTwoPair();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOnePair method, of class PokerHand.
     */
    @Test
    public void testIsOnePair() {
        System.out.println("isOnePair");
        PokerHand instance = null;
        boolean expResult = false;
        boolean result = instance.isOnePair();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighestCard method, of class PokerHand.
     */
    @Test
    public void testGetHighestCard() {
        System.out.println("getHighestCard");
        PokerHand hand = null;
        int index = 0;
        PokerHand instance = null;
        int expResult = 0;
        int result = instance.getHighestCard(hand, index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testIsTie() {
        System.out.println("isTie");
        Card card1 = new Card("Spades", 1);
        Card card2 = new Card("Spades", 2);
        Card card3 = new Card("Spades", 3);
        Card card4 = new Card("Spades", 4);
        Card card5 = new Card("Spades", 13);
        Card card6 = new Card("Spades", 1);
        Card card7 = new Card("Spades", 2);
        Card card8 = new Card("Spades", 3);
        Card card9 = new Card("Spades", 4);
        Card card10 = new Card("Spades", 13);
        Card[] hand = new Card[] {card1, card2, card3, card4, card5};
        Card[] opponentHand = new Card[] {card6, card7, card8, card9, card10};
        PokerHand instance = new PokerHand(hand);
        PokerHand instance2 = new PokerHand(opponentHand);
        instance.compareTo(instance2);
        int expResult = 0;
        int result = instance.compareTo(instance2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
