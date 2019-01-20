/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;

/**
 *
 * @author storm
 */
public class OpponentHoldemHand {
    private Card[] middleCards;
    private Card[] restOfDeck;
    private PokerHand[] possibilities = new PokerHand[990];
    
    public OpponentHoldemHand( Card[] restOfDeck, Card[] middleFive )
    {
        this.restOfDeck = restOfDeck;
        middleCards = middleFive;
    }
    
    public PokerHand[] allOpponentHands()
    {
        int loopCounter  = -1;
        for(int initial1 = 0; initial1 < 44; initial1++)
        {
            for (int initial2 = 1; initial2 < 45; initial2++)
            {
                while (initial2 <= initial1)
                {
                    initial2++;
                }
                Card[] initialTwo = new Card[2];
                initialTwo[0] = restOfDeck[initial1];
                initialTwo[1] = restOfDeck[initial2];
                loopCounter++;
        
                for( int slot1 = 0; slot1 < 3; slot1++)
                   {
                       for ( int slot2 = 1; slot2 < 4; slot2++)
                       {
                           while (slot1 >= slot2 )
                           {
                               slot2++;
                           }
                           for (int slot3 = 2; slot3 < 5; slot3++)
                           {
                               Card[] tempHand1 = new Card[5];

                               System.arraycopy(initialTwo, 0, tempHand1, 0, initialTwo.length);

                               while (slot2 >= slot3)
                               {
                                   slot3++;
                               }

                               tempHand1[2] = middleCards[slot1];
                               tempHand1[3] = middleCards[slot2];
                               tempHand1[4] = middleCards[slot3];


                               possibilities[loopCounter] = new PokerHand(tempHand1);
                               
                           }
                       }
                   }
            }
        }
        
        for (int ind = 0; ind < 990; ind++)
        {
            possibilities[ind].sortCards();
        }
        return possibilities;
    }
    
    
}
