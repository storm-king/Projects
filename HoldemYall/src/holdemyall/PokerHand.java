/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;

import java.util.Arrays;

/**
 *
 * @author etcharn1
 */
public class PokerHand implements Comparable<PokerHand>{
    
    
    public static final int STRAIGHT_FLUSH = 9;
    public static final int FOUR_OF_A_KIND = 8;
    public static final int FULL_HOUSE = 7;
    public static final int FLUSH = 6;
    public static final int STRAIGHT = 5;
    public static final int THREE_OF_A_KIND = 4;
    public static final int TWO_PAIR = 3;
    public static final int ONE_PAIR = 2;
    public static final int HIGH_CARD = 1;
    
    
    
    private Card[] cards;
    
    public PokerHand(Card[] cards)
    {
        this.cards = cards;       
    }

    @Override
    public int compareTo(PokerHand opponentHand) {
       int winOrLose = -2; 
        if( getHandRank() > opponentHand.getHandRank())
        {
            winOrLose = 1;
        }
        
        else if ( getHandRank() == opponentHand.getHandRank() )
        {
            boolean highCard = false;
            for(int highestCard = 4; highestCard >= 0; highestCard--)
            {
                if(getHighestCard(this, highestCard) > getHighestCard(opponentHand, highestCard))
                {
                    highCard = true;
                    break;
                }
                else if (getHighestCard(this, highestCard) < getHighestCard(opponentHand, highestCard))
                {
                    highCard = false;
                    winOrLose = -1;
                    break;
                }
                else if(getHighestCard(this, highestCard) == getHighestCard(opponentHand, highestCard) && highestCard > 0)
                {
                    highCard = false;
                }
                else if(highestCard == 0)
                {
                    if(getHighestCard(this, 0) == getHighestCard(opponentHand, 0))
                    {
                        winOrLose = 0;
                        break;
                    }
                    else if (getHighestCard(this, 0) < getHighestCard(opponentHand, 0))
                    {
                        highCard = false;
                        winOrLose = -1;
                        break;
                    }
                    else if (getHighestCard(this, 0) > getHighestCard(opponentHand, 0))
                    {
                        highCard = true;
                        break;
                    }
                    
                }
            }
            if(highCard)
            {
                winOrLose = 1;
            }
            
        }
        else 
        {
            winOrLose = -1;
        }
        return winOrLose;
        
    }
    
    public Card[] sortCards()
    {
        Arrays.sort(cards);
        return cards;
    }
    
    public int getFaceValue(Card card)
    {
        return card.face;
    }
    
    public String getSuit(Card card)
    {
        return card.suit;
    }
    
    public Card[] getHand()
    {
        return cards;
    }
    
    public int getHandRank()
    {
        if (isStraightFlush())
            return STRAIGHT_FLUSH;
        else if (isFourOfAKind())
            return FOUR_OF_A_KIND;
        else if(isFullHouse())
            return FULL_HOUSE;
        else if(isFlush())
            return FLUSH;
        else if(isStraight())
            return STRAIGHT;
        else if(isThreeOfAKind())
            return THREE_OF_A_KIND;
        else if(isTwoPair())
            return TWO_PAIR;
        else if(isOnePair())
            return ONE_PAIR;
        return 0;
    }
    
    private boolean isStraightFlush()
    {
        return isFlush() && isStraight();
    }
    
    public boolean isFourOfAKind() 
    {
        boolean fourOfAKind = false;
        int[] faceCounterArray = new int[cards.length];
        
        for( int index = 0; index < cards.length; index++)
        {
            int faceCounter = 0;
            if(index < 2 && cards[index].face == cards[ index + 1 ].face )
            {
                faceCounter++;
                if(index < 2 && cards[index + 1].face == cards[index + 2].face)
                {
                    faceCounter++;
                    if(index < 2 && cards[index + 2].face == cards[index + 3].face)
                    {
                        faceCounter++;
                    }
                }
            }
            faceCounterArray[index] = faceCounter;
        }
        for( int index = 0; index < cards.length - 1; index++)
        {
            if(faceCounterArray[index] == 3)
            {
                fourOfAKind = true;
                break;
            }
        }
        
        return fourOfAKind;
    }
    
    public boolean isFullHouse()
    {
        boolean fullHouse = false;
        int counter1 = 0;
        int counter2 = 0;
        
        for( int index = 0; index < cards.length - 3; index++)
        {
            if(cards[index].face == cards[ index + 1 ].face)
            {
                counter1++;
            }
        }
        for( int index2 = 2; index2 < cards.length - 1; index2++)
        {
            if(cards[index2].face == cards[ index2 + 1 ].face)
            {
                counter2++;
            }
        }
        if ( (counter1 == 1 && counter2 == 2) || (counter1 == 2 && counter2 == 1))
        {
            fullHouse = true;
        }
        return fullHouse;
    }
    
    public boolean isFlush() 
    {
        boolean flush = false;
        int suitCounter = 0;
        for( int index = 0; index < cards.length - 1; index++)
        {
            if(cards[index].suit.equals(cards[ index + 1 ].suit))
            {
                suitCounter++;
            }
        }
        if (suitCounter == 4)
        {
            flush = true;
        }
        
        return flush;
    }
    
    public boolean isStraight()
    {
        boolean straightHand = false;
        int consecutiveCounter = 0;
        
        for ( int index = 0; index < cards.length - 1; index++)
        {
            if(cards[index + 1].face == ((cards[index].face) + 1))
            {
                consecutiveCounter++;
            }
        }
        if (consecutiveCounter == 4)
        {
            straightHand = true;
        }
        return straightHand;
    }
    
    public boolean isThreeOfAKind()
    {
        boolean threeOfAKind = false;
        int[] faceCounterArray = new int[cards.length];
        
        for( int index = 0; index < cards.length - 1; index++)
        {
            int faceCounter = 0;
            if(index < 3 && cards[index].face == cards[ index + 1 ].face )
            {
                faceCounter++;
                if(index < 3 && cards[index + 1].face == cards[index + 2].face)
                {
                    faceCounter++;
                }
            }
            faceCounterArray[index] = faceCounter;
        }
        for( int index = 0; index < cards.length - 1; index++)
        {
            if(faceCounterArray[index] == 2)
            {
                threeOfAKind = true;
                break;
            }
        }
        return threeOfAKind;
    }
    
    public boolean isTwoPair()
    {
        boolean twoPair = false;
        int counter1 = 0;
        int counter2 = 0;
        
        for( int index = 0; index < cards.length - 3; index++)
        {
            if(cards[index].face == cards[ index + 1 ].face)
            {
                counter1++;
            }
        }
        for( int index2 = 2; index2 < cards.length - 1; index2++)
        {
            if(cards[index2].face == cards[ index2 + 1 ].face)
            {
                counter2++;
            }
        }
        if ( counter1 == 1 && counter2 == 1)
        {
            twoPair = true;
        }
        return twoPair;
    }
    
    public boolean isOnePair()
    {
        boolean onePair = false;
        int faceCounter = 0;
        for( int index = 0; index < cards.length - 1; index++)
        {
            if(cards[index].face == cards[ index + 1 ].face)
            {
                faceCounter++;
            }
        }
        if (faceCounter == 1)
        {
            onePair = true;
        }
        
        return onePair;
    }
   
    
   
   public int getHighestCard(PokerHand hand, int index)
   {
       int highestFaceValue = hand.getHand()[index].face;
       return highestFaceValue;
   }
    
    
      
}
