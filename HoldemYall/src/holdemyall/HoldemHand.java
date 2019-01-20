/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;
import java.util.Arrays;

/**
 *
 * @author storm
 */
public class HoldemHand {
    private Card[] middleCards;
    private Card[] initialTwo;
    PokerHand[] possibilities = new PokerHand[21];
    
    public HoldemHand( Card[] initialHand, Card[] middleFive )
    {
        middleCards = middleFive;
        initialTwo = initialHand;
        
    }
    
    public PokerHand getBestPossibleHand()
    {
        
        Card[] sevenCards = new Card[7];
        System.arraycopy(initialTwo, 0, sevenCards, 5, initialTwo.length);
        System.arraycopy(middleCards, 0, sevenCards, 0, middleCards.length);
        int loopCounter  = 0;
        
        for( int slot1 = 0; slot1 < 3; slot1++)
           {
               for ( int slot2 = slot1 + 1; slot2 < 4; slot2++)
               {
                   for (int slot3 = slot2 + 1; slot3 < 5; slot3++)
                   {
                       for (int slot4 = slot3 + 1; slot4 < 6; slot4++)
                       {
                           for(int slot5 = slot4 + 1; slot5 < 7; slot5++)
                           {
                               Card[] tempHand1 = new Card[5];
                               
                               
                               tempHand1[0] = sevenCards[slot1];
                               tempHand1[1] = sevenCards[slot2];
                               tempHand1[2] = sevenCards[slot3];
                               tempHand1[3] = sevenCards[slot4];
                               tempHand1[4] = sevenCards[slot5];


                               possibilities[loopCounter] = new PokerHand(tempHand1);
                               loopCounter++;

//                       System.out.println("(INSISDE LOOP)THIS HAND : ");
//                       for ( Card card : tempHand1)
//                       {
//                           System.out.print(card.face + card.suit + " ");
//                       }
//                       System.out.print(" COMPARES TO : ");
//                       for ( Card card : tempHand2)
//                       {
//                           System.out.print(card.face + card.suit + " ");
//                       }
//                       System.out.println("");
//                      
                           }
                       }         
                   }
               }
           }
        
        
        PokerHand bestHand = possibilities[0];
        for(int ind = 0; ind < possibilities.length - 1; ind++)
        {
            if(bestHand.getHandRank() <= possibilities[ind + 1].getHandRank())
            {
                bestHand = possibilities[ind + 1];
                bestHand.sortCards();
            }
        }
        
        return bestHand;
    }
    

}
