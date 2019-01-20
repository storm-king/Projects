/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotterysimulatordemo;

import java.util.Scanner;


/**
 *
 * @author storm
 */
import java.util.Scanner;
public class LotterySimulatorDemo {

    
   
    public static void main(String[] args) 
    {
        int userTickets;
        char input;
        System.out.println("****Welcome to the PowerBall Lottery Simulator!****");
        do
        {
        System.out.println("How many tickets would you like to buy?");
        Scanner keyboard = new Scanner(System.in);
        userTickets = keyboard.nextInt();
        long startTime = System.nanoTime();
        LotteryClass ticket = new LotteryClass(userTickets);
        int[] copy = ticket.moneyStats();
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000000;
        System.out.println("\n------------------------------------------");
        System.out.println(" Money Won      Money Lost      Net Money ");
        System.out.println("------------------------------------------");
        System.out.println("     " + copy[0] + "              " + copy[1] + "             " + copy[2] + "\n");
//        System.out.println(totalTime);
        System.out.println("Would you like to try again? Y/N");
        input = keyboard.next().charAt(0);
        }
        while(input != 'N' && input != 'n');  
        
        System.out.println("Have A Good Day!");
    }   
}
