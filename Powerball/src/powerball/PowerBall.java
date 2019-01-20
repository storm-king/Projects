package powerball;

import linkedbag.LinkedBag;
import arraybag.ArrayBag;

import java.util.Random;

/**
 *
 * @author etcharn1
 * @author storm
 */
public class PowerBall {
    static final int TICKET_PRICE = 1;
    
    private int[] whiteBalls;
    private int redBall;
    
    public PowerBall()
    {
        Random random = new Random();
        whiteBalls = new int[5];
        redBall = random.nextInt(15) + 1;
        
        int[] bucket = new int[75];
        for( int number = 0; number < bucket.length; number++)
        {
            bucket[number] = number+1;
        }
        
        for ( int whiteBallIndex = 0; whiteBallIndex < whiteBalls.length; whiteBallIndex++ )
        {
            int randomBall = random.nextInt( bucket.length );
            while ( bucket[randomBall] == 0 )
            {
                randomBall = random.nextInt( bucket.length );
            }
            
            whiteBalls[whiteBallIndex] =  bucket[randomBall];
            bucket[randomBall] = 0;
        }
    }
    
    public PowerBall(int[] whiteBalls, int redBall)
    {
        // TODO - this is bad - we should check for dupes
        for ( int index = 1; index < whiteBalls.length; index++ )
        {
            for ( int ballToCheck = 0; ballToCheck < index; ballToCheck++ )
            {
                if (whiteBalls[ballToCheck] == whiteBalls[index])
                {
                    // do something here
                }
            }
        
        }
        
        this.whiteBalls = whiteBalls;
        this.redBall = redBall;
    }
    
    public int getWinnings( PowerBall winningTicket )
    {
        int winnings = 0;
        
        boolean redMatches = winningTicket.redBall == this.redBall;
        
        int whiteMatches = 0;
        
        for ( int myWhiteBall : whiteBalls )
        {
            for ( int winningWhiteBall : winningTicket.whiteBalls )
            {
                if (myWhiteBall == winningWhiteBall)
                {
                    whiteMatches++;
                }
            }
        }
        
        if ( whiteMatches == 5 && redMatches )
        {
            winnings = 1000000000;
        }
        else if ( whiteMatches == 5 )
        {
            winnings = 1000000;
        }
        else if ( whiteMatches == 4 && redMatches )
        {
            winnings = 5000;
        }
        else if ( whiteMatches == 4 )
        {
            winnings = 500;
        }
        else if ( whiteMatches == 3 && redMatches )
        {
            winnings = 50;
        }
        else if( whiteMatches == 3 || (whiteMatches == 2 && redMatches))
        {
            winnings = 5;
        }
        else if( whiteMatches == 1 && redMatches)
        {
            winnings = 2;
        }
        else if ( redMatches )
        {
            winnings = 1;
        }
        
        return winnings;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for ( int whiteBall : whiteBalls )
        {
            builder.append(whiteBall);
            builder.append(" ");
        }
        builder.append("PowerBall: ");
        builder.append( redBall );
        
        return builder.toString();
    }

}