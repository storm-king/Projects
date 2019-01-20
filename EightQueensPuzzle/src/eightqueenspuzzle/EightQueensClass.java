/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueenspuzzle;

import java.util.ArrayList;

/**
 *
 * @author storm
 */

public class EightQueensClass 
{
    public String[][] chessBoard;
    public static final int TOTAL_QUEENS = 8;
    public static final String QUEEN_SQUARE = "|Q|";
    public final static String EMPTY_SQUARE = "|*|";
    public int currentQueen = 0;

    
    public EightQueensClass(String[][] board)
    {
        chessBoard = board; 
    }
    
    public void placeQueens(int currentQueen, int startX,  int startY)
    {
        int currentColumn = startY;
        int rowBegin = startX;
        int queenIndex = currentQueen;
        
        if (queenIndex != chessBoard.length)
        { 
            for(int row = rowBegin; row < chessBoard.length; row++)
            {
                queenIndex = assignSquare(row, currentColumn, queenIndex);
                if(chessBoard[row][currentColumn].equals(QUEEN_SQUARE))
                {
                    break;
                }
                
                if(currentColumn == 0 && rowBegin == 7 && !isQueenThere(currentColumn))
                {
                    rowBegin = 0;
                }
            }
            
            while (!isQueenThere(currentColumn) && currentColumn > 0 )
            {
                currentColumn--;
                int rowStart = findQueenIndex(currentColumn);
                chessBoard[rowStart][currentColumn] = EMPTY_SQUARE;
                queenIndex--;
               
                for(int row1 = (rowStart + 1); row1 < chessBoard.length; row1++ )
                {
                    queenIndex = assignSquare(row1, currentColumn, queenIndex);
                    if(chessBoard[row1][currentColumn].equals(QUEEN_SQUARE))
                    {
                        break;
                    }
                }    
            }
              
            if(isQueenThere(currentColumn))
            {
                currentColumn++;
            }
            
            displaySolvingPuzzle();
            rowBegin = 0;
            
            placeQueens(queenIndex, rowBegin, currentColumn);           
        }
        else
        {
            displaySolvedPuzzle();
        }     
    }
    
    private int assignSquare(int row, int column, int queenIndex)
    {
        if(checkQueen(row, column))
        {
            chessBoard[row][column] = QUEEN_SQUARE;
            queenIndex++;
        }
        else
        {
            chessBoard[row][column] = EMPTY_SQUARE;
        }
        return queenIndex;
    }
    
    int findQueenIndex(int currentColumn)
    {
        int queensIndex = -1;
        for( int row = 0; row < chessBoard.length; row++)
        {
            if(chessBoard[row][currentColumn].equals(QUEEN_SQUARE))
            {
                queensIndex = row;
            }
        }
        return queensIndex;
    }
    
    private boolean isQueenThere(int currentColumn)
    {
        boolean  queenFound = false;
        for( int row = 0; row < chessBoard.length; row++)
        {
            if(chessBoard[row][currentColumn].equals(QUEEN_SQUARE))
            {
                queenFound = true;
            }
        }
        return queenFound;
    }
    
    private boolean checkQueen(int row, int col)
    {
        boolean canPlace = false;
                      
        if(checkQueenUpAndDown(row, col))
        {
            if(checkQueenLeft(row, col))
            {
                if(checkQueenRight(row, col))
                {
                    if(checkQueenDiagonals(row, col))
                    {
                        canPlace = true;
                    }
                }
            }   
        }
                
        return canPlace;
    }
    
    private boolean checkQueenDiagonals(int row, int col)
    {
        boolean canPlace = false; 
        
        if(checkQueenDiagonalUpRight(row, col))
        {
            if(checkQueenDiagonalDownLeft(row, col))
            {
                if(checkQueenDiagonalUpLeft(row, col))
                {
                    if(checkQueenDiagonalDownRight(row, col))
                    {
                        canPlace = true;
                    }
                }
            }
        }
        
        return canPlace;
    }
    
    private boolean checkQueenDiagonalUpRight(int r, int col)
    {
        int row = r;
        boolean goodSpot;
        ArrayList<Boolean> spotsArray = new ArrayList<>();
        boolean finalDecision = false;
        int trueCount = 0;
        
        
        if(col == 7 && !isQueenThere(col) || (row == 0 && !isQueenThere(col)))
        {
            finalDecision = true;
        }
        
        else
        {
            for(int column = (col + 1); column < chessBoard.length; column++)
            {
                if(row > 0)
                {
                    row--;
                }
                else
                {
                    break;
                }
                      
                if(chessBoard[row][column].equals(QUEEN_SQUARE))
                {
                    goodSpot = false;
                }
                else
                {
                    goodSpot = true;      
                } 

                spotsArray.add(goodSpot);
            }
            
                
            for(boolean array : spotsArray)
            {
                if(array == true)
                {
                    trueCount++;
                }
            }
            
            if(trueCount == spotsArray.size() )
            {
                finalDecision = true;
            }
        }
        return finalDecision;
    }
    
    private boolean checkQueenDiagonalUpLeft(int r, int col)
    {
        int row = r;
        boolean goodSpot;
        ArrayList<Boolean> spotsArray = new ArrayList<>();
        boolean finalDecision = false;
        int trueCount = 0;
        
        
        if(col == 0 && !isQueenThere(col) || (row == 0 && isQueenThere(col)))
        {
            finalDecision = true;
        }
        
        else
        {
            for(int column = (col - 1); column >= 0; column--)
            {
                if(row > 0)
                {
                    row--;
                }
                else
                {
                    break;
                }
                      

                if(chessBoard[row][column].equals(QUEEN_SQUARE))
                {
                    goodSpot = false;
                }
                else
                {
                    goodSpot = true;      
                } 

                spotsArray.add(goodSpot);
            }
            
            
            for(boolean array : spotsArray)
            {
                if(array == true)
                {
                    trueCount++;
                }
            }
            
            if(trueCount == spotsArray.size() )
            {
                finalDecision = true;
            }
        }
        return finalDecision;
    }
    
    private boolean checkQueenDiagonalDownLeft(int r, int col)
    {
        int row = r;
        boolean goodSpot;
        ArrayList<Boolean> spotsArray = new ArrayList<>();
        boolean finalDecision = false;
        int trueCount = 0;
        
        
        if(col == 0 && !isQueenThere(col) || (row == 7 && !isQueenThere(col)))
        {
            finalDecision = true;
        }
        
        else
        {
            for(int column = (col - 1); column >= 0; column--)
            {
                if(row < 7)
                {
                    row++;
                }
                else
                {
                    break;
                }
                        

                if(chessBoard[row][column].equals(QUEEN_SQUARE))
                {
                    goodSpot = false;
                }
                else
                {
                    goodSpot = true;      
                } 

                spotsArray.add(goodSpot);    
            }
         

            for(boolean array : spotsArray)
            {
                if(array == true)
                {
                    trueCount++;
                }
            }
            
            if(trueCount == spotsArray.size() )
            {
                finalDecision = true;
            }
        }
        return finalDecision;
    }
    
    private boolean checkQueenDiagonalDownRight(int r, int col)
    {
        int row = r;
        boolean goodSpot;
        ArrayList<Boolean> spotsArray = new ArrayList<>();
        boolean finalDecision = false;
        int trueCount = 0;
        
        
        if(col == 7 && !isQueenThere(col) || (row == 7 && !isQueenThere(col)))
        {
            finalDecision = true;
        }
        
        else
        {
            for(int column = (col + 1); column < chessBoard.length; column++)
            {
                if(row < 7)
                {
                    row++;
                }
                else
                { 
                    break;
                }
                        
                if(chessBoard[row][column].equals(QUEEN_SQUARE))
                {
                    goodSpot = false;
                }
                else
                {
                    goodSpot = true;      
                } 
                
                spotsArray.add(goodSpot);    
            }
         

            for(boolean array : spotsArray)
            {
                if(array == true)
                {
                    trueCount++;
                }
            }
            
            if(trueCount == spotsArray.size() )
            {
                finalDecision = true;
            }
        }
        return finalDecision;
    }
    
    private boolean checkQueenLeft(int r, int col)
    {
        boolean goodSpot;
        boolean finalDecision = false;
        int trueCount = 0;
        ArrayList<Boolean> spotsArray = new ArrayList<>();
      
        if (col == 0 && !isQueenThere(col))
        {
            finalDecision = true;
        }
        
        else
        {
            for(int column = (col - 1); column >= 0; column--)
            {
                if(chessBoard[r][column].equals(QUEEN_SQUARE))
                {
                    goodSpot = false;
                }
                else
                {
                    goodSpot = true;
                }
                spotsArray.add(goodSpot);  
            }
            
            for(boolean array : spotsArray)
            {
                if(array == true)
                {
                    trueCount++;
                }
            }
                
            if (spotsArray.size() == trueCount)
            {
                finalDecision = true;
            }     
        }
        
        return finalDecision;    
    }
    
    private boolean checkQueenRight(int r, int col)
    {
        boolean goodSpot;
        boolean finalDecision = false;
        ArrayList<Boolean> spotsArray = new ArrayList<>();
        int trueCount = 0;
        
        if(col == 7 && !isQueenThere(col))
        {
            finalDecision = true;
        }
        
        else
        {
            for(int column = (col + 1); column < chessBoard.length; column++ )
            {
                if(chessBoard[r][column].equals(QUEEN_SQUARE))
                {
                    goodSpot = false;
                }
                else
                {
                    goodSpot = true;
                }
                spotsArray.add(goodSpot);
            }
        }
        
        for(boolean array : spotsArray)
        {
            if(array == true)
            {
                trueCount++;
            }
        }
        
        if (spotsArray.size() == trueCount)
        {
            finalDecision = true;
        }
            
        return finalDecision;
    }
    
    private boolean checkQueenUpAndDown(int r, int col)
    {
        boolean goodSpot = false;
        if(!isQueenThere(col))
        {
            goodSpot = true;
        }
        return goodSpot;
    }
    
    private void displaySolvingPuzzle()
    {
        int squareCounter = 0;
        System.out.println("SOLVING PUZZLE...");
            System.out.println("   a   b   c   d   e   f   g   h  ");
            for (String[] array : chessBoard) 
            {
                System.out.print(squareCounter + " ");
                for (String chessSquare : array) 
                {
                    System.out.print(chessSquare + " ");
                }
                squareCounter++;
                System.out.println();
            }
            System.out.println("*********************************");
    }
    
    private void displaySolvedPuzzle()
    {
        int squareCounter = 0;
        System.out.println("PUZZLE SOLVED!!!!!");
            System.out.println("   a   b   c   d   e   f   g   h  ");
            for (String[] array : chessBoard) 
            {
                System.out.print(squareCounter + " ");
                for (String chessSquare : array) 
                {
                    System.out.print(chessSquare + " ");
                }
                squareCounter++;
                System.out.println();
            }
            System.out.println("");
    }
   
}
