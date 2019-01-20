/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueenspuzzle;

import java.util.Scanner;

/**
 *
 * @author storm
 */
public class EightQueensPuzzle {

    public final static String EMPTY_SQUARE = "|*|";
    
    public static void main(String[] args) 
    {
        String[][] chessBoard = new String[8][8];
        for(int row = 0; row < chessBoard.length; row++)
        {
            for(int col = 0; col < chessBoard.length; col++)
            {
                chessBoard[row][col] = EMPTY_SQUARE;
            }
        }
        
        EightQueensClass queenBoard = new EightQueensClass(chessBoard);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("**********************************************************");
        System.out.println("\tWELCOME TO THE EIGHT QUEENS PUZZLE SOLVER!" + 
                         "\n**********************************************************");
                 
        System.out.println("\t      a   b   c   d   e   f   g   h  \n" +
                           "\t   0 |*| |*| |*| |*| |*| |*| |*| |*| \n" +
                           "\t   1 |*| |*| |*| |*| |*| |*| |*| |*| \n" +
                           "\t   2 |*| |*| |*| |*| |*| |*| |*| |*| \n" +
                           "\t   3 |*| |*| |*| |*| |*| |*| |*| |*| \n" +
                           "\t   4 |*| |*| |*| |*| |*| |*| |*| |*| \n" +
                           "\t   5 |*| |*| |*| |*| |*| |*| |*| |*| \n" +
                           "\t   6 |*| |*| |*| |*| |*| |*| |*| |*| \n" +
                           "\t   7 |*| |*| |*| |*| |*| |*| |*| |*| \n");
        System.out.println("Which square would you like to start at? (0-7)");
        while(!keyboard.hasNextInt())
        {
            System.out.println("Invalid Input. Only numbers accepted. Try Again.");
            keyboard.next();
        }
        
        int startingSquare = keyboard.nextInt();
        
        while(startingSquare < 0 || startingSquare > 7)
        {
            System.out.println("Invalid Input. Only numbers 0 - 7 accepted. Try Again.");
            startingSquare = keyboard.nextInt();
        }
        System.out.println("Placing first Queen at Square a" + startingSquare);
        queenBoard.placeQueens(0, startingSquare, 0);       
    }   
}
