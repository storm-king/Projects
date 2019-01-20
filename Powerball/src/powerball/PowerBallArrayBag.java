package powerball;

import arraybag.ArrayBag;

import java.util.Random;

/**
 *
 * @author etcharn1
 * @author storm
 */
public class PowerBallArrayBag {
    static final int TICKET_PRICE = 1;
    
    private ArrayBag<Integer> whiteBalls;
    private int redBall;
    
    public PowerBallArrayBag()
    {
        Random random = new Random();
        whiteBalls = new ArrayBag<Integer>(5);
        redBall = random.nextInt(15) + 1;
        
        int[] bucket = new int[75];
        for( int number = 0; number < bucket.length; number++)
        {
            bucket[number] = number+1;
        }
        
        while ( whiteBalls.getCurrentSize() < 5 )
        {
            int randomBall = random.nextInt( bucket.length );
            while ( bucket[randomBall] == 0 )
            {
                randomBall = random.nextInt( bucket.length );
            }
            
            whiteBalls.add(bucket[randomBall]);
            bucket[randomBall] = 0;
        }
    }
    
    public PowerBallArrayBag(ArrayBag<Integer> whiteBalls, int redBall)
    {
        // TODO - this is bad - we should check for dupes
       
        
        this.whiteBalls = whiteBalls;
        this.redBall = redBall;
    }
    
    public int getWinnings( PowerBallArrayBag winningTicket )
    {
        int winnings = 0;
        
        boolean redMatches = winningTicket.redBall == this.redBall;
        
        int whiteMatches = 0;
        
        while ( !whiteBalls.isEmpty() )
        {
            if ( winningTicket.whiteBalls.contains(whiteBalls.remove()))
            {
                whiteMatches++;
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
}
