 package powerball;

import javax.swing.JOptionPane;

/**
 *powerball, arraybag, and linkedbag packages imported from etcharn1 and modified
 * @author etcharn1
 * @author storm
 */
public class PowerBallSimulator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int totalSpent = 0;
        int totalWon = 0;
        int totalWon2 = 0;
        int totalWon3 = 0;
        
        int numberOfTicketsToPurchase = Integer.parseInt(
                JOptionPane.showInputDialog(
                "Please enter the number of tickets you want to buy, or 0 to quit") );
        
        
        
        while ( numberOfTicketsToPurchase != 0 )
        {
            /**
             * Array Test
             */
            totalSpent = 0;
            JOptionPane.showMessageDialog(null, "ARRAY TEST");
            long startTime = System.nanoTime();
            
            totalSpent += numberOfTicketsToPurchase * PowerBallArrayBag.TICKET_PRICE;
            PowerBall winningTicket = new PowerBall();
            
            
            for ( int ticketNumber = 0; ticketNumber < numberOfTicketsToPurchase; ticketNumber++ )
            {
                PowerBall myTicket = new PowerBall();
                totalWon += myTicket.getWinnings( winningTicket );
                if ( myTicket.getWinnings(winningTicket ) == 1000000000 )
                {
                    JOptionPane.showMessageDialog(null, "JACKPOT");
                }
            }
            
            long endTime = System.nanoTime();
            
            double totalTime = (endTime - startTime) / 100000000.0;
            
            String message = String.format("Total Spent: %d - Total Won: %d - Net Loss: %d", 
                    totalSpent, totalWon, totalWon - totalSpent );
            JOptionPane.showMessageDialog(null, message);
            
            /**
             * ArrayBag Test
            */
            totalSpent = 0;
            JOptionPane.showMessageDialog(null, "ARRAYBAG TEST");
            long startTime2 = System.nanoTime();
            
            totalSpent += numberOfTicketsToPurchase * PowerBallArrayBag.TICKET_PRICE;
            PowerBallArrayBag winningTicket2 = new PowerBallArrayBag();
            
            
            for ( int ticketNumber = 0; ticketNumber < numberOfTicketsToPurchase; ticketNumber++ )
            {
                PowerBallArrayBag myTicket = new PowerBallArrayBag();
                totalWon2 += myTicket.getWinnings( winningTicket2 );
                if ( myTicket.getWinnings(winningTicket2 ) == 1000000000 )
                {
                    JOptionPane.showMessageDialog(null, "JACKPOT");
                }
            }
            
            long endTime2 = System.nanoTime();
            
            double totalTime2 = (endTime2 - startTime2) / 100000000.0;
            
            String message2 = String.format("Total Spent: %d - Total Won: %d - Net Loss: %d", 
                    totalSpent, totalWon2, totalWon2 - totalSpent );
            JOptionPane.showMessageDialog(null, message2);
            
            /**
             * LinkedBag Test
             */
            totalSpent = 0;
            JOptionPane.showMessageDialog(null, "LINKEDBAG TEST");
            long startTime3 = System.nanoTime();
            
            totalSpent += numberOfTicketsToPurchase * PowerBallArrayBag.TICKET_PRICE;               
            PowerBallLinkedBag winningTicket3 = new PowerBallLinkedBag();
            
            for ( int ticketNumber = 0; ticketNumber < numberOfTicketsToPurchase; ticketNumber++ )
            {
                PowerBallLinkedBag myTicket = new PowerBallLinkedBag();
                totalWon3 += myTicket.getWinnings( winningTicket3 );
                if ( myTicket.getWinnings(winningTicket3 ) == 1000000000 )
                {
                    JOptionPane.showMessageDialog(null, "JACKPOT");
                }
            }
            
            long endTime3 = System.nanoTime();
            
            double totalTime3 = (endTime3 - startTime3) / 100000000.0;
            
            String message3 = String.format("Total Spent: %d - Total Won: %d - Net Loss: %d", 
                    totalSpent, totalWon3, totalWon3 - totalSpent );
            JOptionPane.showMessageDialog(null, message3);
            
            JOptionPane.showMessageDialog(null, String.format("Array Time: %f - ArrayBag Time: %f - LinkedBagTime: %f", totalTime, totalTime2, totalTime3));
            numberOfTicketsToPurchase = Integer.parseInt(
                JOptionPane.showInputDialog(
                "Please enter the number of tickets you want to buy, or 0 to quit") );
        }
    }
}