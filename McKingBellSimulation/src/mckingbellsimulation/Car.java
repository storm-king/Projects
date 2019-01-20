package mckingbellsimulation;

import java.util.Random;

/**
 *
 * @author storm
 */

public class Car 
{
    private int arrivalTime;
    
    public Car(int time)
    {
        arrivalTime = time;
    }
    
    public int getCarArrivalTime()
    {
        return arrivalTime;
    }
    
    public int getCarProbability()
    {
        Random chanceOfCar = new Random();
        int carProbability = chanceOfCar.nextInt(3);
        return carProbability;
    }
    
    public int[] getCarOrder()
    {
        Random fryAmount = new Random();
        Random burgerAmount = new Random();
        
        int fryOrder = fryAmount.nextInt(11);
        int burgerOrder = burgerAmount.nextInt(11);
        int[] order = {fryOrder, burgerOrder};
        
        return order;
    }
}
