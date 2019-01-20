package mckingbellsimulation;

import java.util.Scanner;

/**
 *
 * @author storm
 */

public class McKingBellSimulation 
{

    public static void main(String[] args) throws Exception
    {
        int lengthOfSimulation;
        System.out.println("**************************************************");
        System.out.println("\tWELCOME TO THE MCKINGBELL SIMULATOR!");
        System.out.println("**************************************************\n");
        
        System.out.println("How many minutes would you like to run the simulation?"
                            + "\n\t(MINIMUM OF 120 MINUTES)");
        Scanner keyboard = new Scanner(System.in);
        lengthOfSimulation = keyboard.nextInt();
        while(lengthOfSimulation < 120)
        {
            System.out.println("ERROR, Enter Number Greater Than 120.");
            lengthOfSimulation = keyboard.nextInt();
        }
        System.out.println("\nRESULTS: ");
        McKingBellClass simulator = new McKingBellClass(lengthOfSimulation);
        simulator.runSimulation();
    }
    
}
