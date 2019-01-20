/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;

import java.util.ArrayList;
import stacks.LinkedStack;
import java.util.Collections;

/**
 *
 * @author storm
 */
public class HoldemYall {

    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<Card>();
        for ( int face = 2; face < Face.ACE + 1; face++ )
        {
            deck.add( new Card( Suit.SPADES, face ) );
        }
        for ( int face = 2; face < Face.ACE + 1; face++ )
        {
            deck.add( new Card( Suit.HEARTS, face ) );
        }
        for ( int face = 2; face < Face.ACE + 1; face++ )
        {
            deck.add( new Card( Suit.CLUBS, face ) );
        }
        for ( int face = 2; face < Face.ACE + 1; face++ )
        {
            deck.add( new Card( Suit.DIAMONDS, face ) );
        }
        
//        for ( Card card : deck )
//        {
//            System.out.println(card.face + card.suit);
//        }
//        
        Collections.shuffle(deck);

        LinkedStack<Card> thisIsTheRealDeck = new LinkedStack<>();
        
        while ( !deck.isEmpty() )
        {
            thisIsTheRealDeck.push(
                    deck.remove( 0 ));
            
        }
        
//        while ( !thisIsTheRealDeck.isEmpty() )
//        {
//            Card card = thisIsTheRealDeck.pop();
//            System.out.println(card.face + card.suit);
//        }



        Card[] firstTwoCards = new Card[2];
        System.out.println("Your First Two Cards : ");
        for ( int cardNumber = 0; cardNumber < firstTwoCards.length; cardNumber++)
        {
            firstTwoCards[cardNumber] = thisIsTheRealDeck.pop();
            System.out.println( firstTwoCards[cardNumber].face + firstTwoCards[cardNumber].suit);
        }
        
        
        Card[] middleStack = new Card[5];
        System.out.println("Middle Cards : ");
        for ( int cardNumber = 0; cardNumber < middleStack.length; cardNumber++ )
        {
            middleStack[cardNumber] = thisIsTheRealDeck.pop();
            System.out.println( middleStack[cardNumber].face + middleStack[cardNumber].suit);
        }
        HoldemHand myHand = new HoldemHand(firstTwoCards, middleStack);
        Card[] goodHand = myHand.getBestPossibleHand().sortCards();
        Card[] bestHand =  goodHand;
        
        System.out.print("**************BEST HAND : ");
        for(Card c : bestHand)
        {
            System.out.print(c.face + c.suit + " ");
        }
        System.out.println("RANK : " + myHand.getBestPossibleHand().getHandRank() + "***************");
        Card[] opponentsPossibleCards = new Card[45];
        for ( int cardNumber = 0; cardNumber < opponentsPossibleCards.length; cardNumber++)
        {
            opponentsPossibleCards[cardNumber] = thisIsTheRealDeck.pop();
        }
        
        OpponentHoldemHand opponentsHands = new OpponentHoldemHand(opponentsPossibleCards, middleStack);
        System.out.println("********OPPONENT************");
        
        int timesWon = 0;
        int timesLost = 0;
        int timesTied = 0;
        for (int i = 0; i < 990; i++)
        {
            
            Card[] currentOppositionHand = opponentsHands.allOpponentHands()[i].getHand();
            for(Card c : currentOppositionHand)
            {
                System.out.print(c.face + c.suit + " ");
            }
    
            System.out.print(" RANK : " + opponentsHands.allOpponentHands()[i].getHandRank());
            
            if (myHand.getBestPossibleHand().compareTo(opponentsHands.allOpponentHands()[i]) == 1)
            {
                timesWon++;
                System.out.println(" WIN!!!!");
            }
            else if(myHand.getBestPossibleHand().compareTo(opponentsHands.allOpponentHands()[i]) == -1)
            {
                System.out.println(" LOSE");
                timesLost++;
            }
            else if(myHand.getBestPossibleHand().compareTo(opponentsHands.allOpponentHands()[i]) == 0)
            {
                System.out.println(" TIE");
                timesTied++;
            }
            else
            {
                System.out.println(" ERROR");
            }
            
        }
        double oddsOfWinning = (timesWon / 990.00) * 100;
        double oddsOfLosing = (timesLost / 990.00) * 100;
        double oddsOfTie = (timesTied / 990.00) * 100;
        System.out.printf("ODDS OF WINNING : %.2f%% \nODDS OF LOSING : %.2f%% \nODDS OF TIE : %.2f%% \n", oddsOfWinning, oddsOfLosing, oddsOfTie);
        
    }   
    
   
}
