package lotterysimulatordemo;
import java.util.Random;

/**
 *
 * @author storm
 */
public class LotteryClass 
 {
    private int i, j, row, l;
    private final int NUMBER_WHITE = 5;
    private final int TICKET_ELEMENTS = 6;
    private int[] winningTicket = new int[6];
    private int[][] userTickets;
    private int numberTicketsBought;
    private boolean[] redMatch;
    private int[] ballsMatched;
    private int winnings;
    private int losses;
    private int total;
    private int[] moneyStat;
    
   
    public LotteryClass(int tick)
    {
       numberTicketsBought = tick;
    }
    
    private void generateWinningNumbers()
    {
        Random num = new Random();
        
        //for loop assigns 6 winning lottery ticket numbers
        for(i = 0; i < 5; i++)
        {
            winningTicket[i] = num.nextInt(69) + 1;
        }
        winningTicket[5] = num.nextInt(26) + 1;
        
        //For loops to make sure first five numbers aren't identical
        for(i = 0; i < NUMBER_WHITE; i++)
        {
            for(j = i + 1; j < NUMBER_WHITE; j++)
            {
               while (winningTicket[i] == winningTicket[j])
                {
                    winningTicket[j] = num.nextInt(69) + 1;
                }
            }
        } 
    }
        
        
    
    private void generateUserTickets()
    {
        Random num = new Random();
        userTickets = new int[numberTicketsBought][TICKET_ELEMENTS];
        //Loop to create user's tickets
        for(row = 0; row < numberTicketsBought; row++)
        {
            for(i = 0; i < NUMBER_WHITE; i++)
            {
                userTickets[row][i] = num.nextInt(69) + 1;
            }
            userTickets[row][5] = num.nextInt(26) + 1;
        }
        //Loop to make sure first five numbers aren't identical
        for(row = 0; row < numberTicketsBought; row++)
        {
            for(i = 0; i < NUMBER_WHITE; i++)
            {
                for(j = i + 1; j < NUMBER_WHITE; j++)
                {
                    if (userTickets[row][i] == userTickets[row][j])
                    {
                        userTickets[row][j] = num.nextInt(69) + 1;
                    }
                }
            }
        }
        
        
        
        
    }
    
    private void compareUserToWinner()
    {
        generateWinningNumbers();
        generateUserTickets();
        ballsMatched = new int[numberTicketsBought];
        redMatch = new boolean[numberTicketsBought];
        
        for(row = 0; row < numberTicketsBought; row++)
        {
            for(i = 0; i < NUMBER_WHITE; i++)
            {
                for(j = 0; j < NUMBER_WHITE; j++)
                {
                    if(userTickets[row][i] == winningTicket[j])
                    {
                        ballsMatched[row] += 1;
                    }
                }
            }
            
            if(userTickets[row][5] == winningTicket[5])
            {
                redMatch[row] = true;
            }
        }
    }
    
    private void getWinnings()
    {
        compareUserToWinner();
        winnings = 0;
        for(row = 0; row < numberTicketsBought; row++)
        {
            if(ballsMatched[row] == 5 && redMatch[row] == true)
            {
                System.out.println("GRAND PRIZE!!!!");
                winnings += 500000000;
            }
            else if(ballsMatched[row] == 5)
            {
                winnings += 1000000;
            }
            else if(ballsMatched[row] == 4 && redMatch[row] == true)
            {
                winnings += 50000;
            }
            else if(ballsMatched[row] == 4 || ballsMatched[row] == 3 && redMatch[row] == true)
            {
                winnings += 100;
            }
            else if(ballsMatched[row] == 3 || ballsMatched[row] == 2 && redMatch[row] == true )
            {
                winnings += 7;
            }
            else if(ballsMatched[row] == 1 && redMatch[row] == true)
            {
                winnings += 4;
            }
            else if(redMatch[row] == true)
            {
                winnings += 4;
            }
            else
            {
                winnings += 0;
            }
        }
    }
    
    public int[] moneyStats()
    {
        getWinnings();
        losses = numberTicketsBought * 2;
        total = winnings - losses;
        moneyStat = new int[] {winnings, losses, total};
        return moneyStat;
    }
}   

