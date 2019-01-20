/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueenspuzzle;

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
public class EightQueensClassTest {
    
    public EightQueensClassTest() {
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
     * Test of placeQueens method, of class EightQueensClass.
     */
    @Test
    public void testPlaceQueens() {
        System.out.println("placeQueens");
        int currentQueen = 0;
        String[][] chessBoard = {{"|*|","|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|","|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|","|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|","|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|","|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|","|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|","|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|","|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        instance.placeQueens(currentQueen, 3, 0);
        
        
    }

    /**
     * Test of findQueenIndex method, of class EightQueensClass.
     */
    @Test
    public void testFindQueenIndex() {
        System.out.println("findQueenIndex");
        int currentColumn = 1;
        String[][] chessBoard = {{"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|Q|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        int expResult = -1;
        int result = instance.findQueenIndex(currentColumn);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isQueenThere method, of class EightQueensClass.
     */
    @Test
    public void testIsQueenThere() {
        System.out.println("isQueenThere");
        int currentColumn = 0;
        String[][] chessBoard = {{"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|Q|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
                
        
        EightQueensClass instance = new EightQueensClass(chessBoard);
        boolean expResult = true;
        boolean result = instance.isQueenThere(currentColumn);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkQueen method, of class EightQueensClass.
     */
    @Test
    public void testCheckQueen() {
        System.out.println("checkQueen");
        int row = 2;
        int col = 1;
        String[][] chessBoard = {{"|Q|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        boolean expResult = true;
        boolean result = instance.checkQueen(row, col);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkQueenDiagonalUp method, of class EightQueensClass.
     */
    @Test
    public void testCheckQueenDiagonalUpRight() {
        System.out.println("checkQueenDiagonalUp");
        int r = 5;
        int col = 2;
        String[][] chessBoard = {{"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|Q|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        boolean expResult = false;
        boolean result = instance.checkQueenDiagonalUpRight(r, col);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkQueenDiagonalDown method, of class EightQueensClass.
     */
    @Test
    public void testCheckQueenDiagonalDownLeft() {
        System.out.println("checkQueenDiagonalDown");
        int r = 0;
        int col = 4;
        String[][] chessBoard = {{"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|Q|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        boolean expResult = false;
        boolean result = instance.checkQueenDiagonalDownLeft( r, col);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkQueenLeft method, of class EightQueensClass.
     */
    @Test
    public void testCheckQueenLeft() {
        System.out.println("checkQueenLeft");
        int r = 3;
        int col = 5;
        String[][] chessBoard = {{"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|Q|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        boolean expResult = false;
        boolean result = instance.checkQueenLeft(r, col);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkQueenRight method, of class EightQueensClass.
     */
    @Test
    public void testCheckQueenRight() {
        System.out.println("checkQueenRight");
        int r = 2;
        int col = 0;
        String[][] chessBoard = {{"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|Q|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|Q|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        boolean expResult = false;
        boolean result = instance.checkQueenRight(r, col);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of checkQueenUpAndDown method, of class EightQueensClass.
     */
    @Test
    public void testCheckQueenUpAndDown() {
        System.out.println("checkQueenUpAndDown");
        int r = 0;
        int col = 3;
        String[][] chessBoard = {{"|*|", "|Q|","|*|","|*|","|*|","|*|","|*|","|Q|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|Q|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|Q|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        boolean expResult = false;
        boolean result = instance.checkQueenUpAndDown(r, col);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkQueenDiagonalUpLeft method, of class EightQueensClass.
     */
    @Test
    public void testCheckQueenDiagonalUpLeft() {
        System.out.println("checkQueenDiagonalUpLeft");
        int r = 5;
        int col = 4;
        String[][] chessBoard = {{"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|Q|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"},
                                 {"|*|", "|*|","|*|","|*|","|*|","|*|","|*|","|*|"}};
        EightQueensClass instance = new EightQueensClass(chessBoard);
        boolean expResult = false;
        boolean result = instance.checkQueenDiagonalUpLeft(r, col);
        assertEquals(expResult, result);
    }
    
}
