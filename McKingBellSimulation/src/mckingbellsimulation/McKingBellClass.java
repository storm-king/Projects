package mckingbellsimulation;

/**
 *
 * @author storm
 */

import java.util.ArrayList;

public class McKingBellClass 
{
    private final int TOTAL_TIME;
    private int numberOfDriveOffs = 0;
    private int burgersTossed = 0;
    private int burgerCookTimer = 0;
    private int fryCookTimer = 0;
    private int[] currentCarOrder = {-1, -1};
    ArrayList<Integer> carTotalWaitTimes = new ArrayList<>();
    ArrayList<Integer> waitTimesAtWindow = new ArrayList<>();
    ArrayList<Integer> orderTakenTime = new ArrayList<>();
    private static final int BURGER_PRICE = 2;
    private static final int FRY_PRICE = 1;
    private int totalProfit = 0;
    
    
    public McKingBellClass(int lengthOfSimulation)
    {
        TOTAL_TIME = lengthOfSimulation;
    }
        
    public void runSimulation() throws Exception
    {
        LinkedDeque<Car> driveThru = new LinkedDeque<>();
        LinkedDeque<Burger> heatChute = new LinkedDeque<>();
        LinkedStack<Boolean> fryBin = new LinkedStack<>();
        
        for(int time = 0; time < TOTAL_TIME; time++)
        {
            Cook kitchenHelp = new Cook(time, heatChute, fryBin);
            
            Car newCar = new Car(time);
            int probabilityOfArrival = newCar.getCarProbability();
            if(probabilityOfArrival == 0)
            {
                driveThru.addToBack(newCar);
            }
            
            if(driveThru.size() > 5 )
            {
                int currentWaitLastCar = time - driveThru.getBack().getCarArrivalTime();
                if(currentWaitLastCar > 1)
                {
                    driveThru.removeBack();
                    numberOfDriveOffs++;
                }  
            }
            
            if(!heatChute.isEmpty() && (time - heatChute.getFront().getBurgerMadeTime()) >= 10)
            {
                heatChute.removeFront();
                burgersTossed++;
            }
            
            if(heatChute.size() < 5)
            {
                if(burgerCookTimer == 1)
                {
                    heatChute = kitchenHelp.cookMoreBurgers();  
                    burgerCookTimer = 0;
                }
                else
                {
                    burgerCookTimer++;
                }
            }
            
            if(fryBin.size() < 5)
            {
                if(fryCookTimer == 1)
                {
                    fryBin = kitchenHelp.cookMoreFries();
                    fryCookTimer = 0;
                }
                else
                {
                    fryCookTimer++;
                }
            }
            
            if(!driveThru.isEmpty())
            {
                if(currentCarOrder[0] == 0 && currentCarOrder[1] == 0)
                {
                    Car carLeft = driveThru.removeFront();
                    carTotalWaitTimes.add((time - carLeft.getCarArrivalTime()));
                    waitTimesAtWindow.add((time - orderTakenTime.remove(0)));
                    currentCarOrder[0] = -1;
                    currentCarOrder[1] = -1;
                    
                    if(!driveThru.isEmpty())
                    {
                        currentCarOrder = driveThru.getFront().getCarOrder();
                        orderTakenTime.add(time);
                    }
                }
                else if(currentCarOrder[0] > 0 || currentCarOrder[1] > 0)
                {
                    while(currentCarOrder[0] > 0)
                    {
                        if(fryBin.size() > 0)
                        {    
                            fryBin.pop();
                            currentCarOrder[0]--;
                            totalProfit += FRY_PRICE;
                            
                            if(currentCarOrder[0] == 0 && currentCarOrder[1] == 0)
                            {
                                Car carLeft = driveThru.removeFront();
                                carTotalWaitTimes.add((time - carLeft.getCarArrivalTime()));
                                waitTimesAtWindow.add((time - orderTakenTime.remove(0)));
                                currentCarOrder[0] = -1;
                                currentCarOrder[1] = -1;

                                if(!driveThru.isEmpty())
                                {
                                    currentCarOrder = driveThru.getFront().getCarOrder();
                                    orderTakenTime.add(time);
                                }
                            }
                            
                        }
                        else
                        {
                            break;
                        }  
                    }
                    while(currentCarOrder[1] > 0)
                    {
                        if(heatChute.size() > 0)
                        {
                            heatChute.removeFront();
                            currentCarOrder[1]--;
                            totalProfit += BURGER_PRICE;
                            
                            if(currentCarOrder[0] == 0 && currentCarOrder[1] == 0)
                            {
                                Car carLeft = driveThru.removeFront();
                                carTotalWaitTimes.add((time - carLeft.getCarArrivalTime()));
                                waitTimesAtWindow.add((time - orderTakenTime.remove(0)));
                                currentCarOrder[0] = -1;
                                currentCarOrder[1] = -1;

                                if(!driveThru.isEmpty())
                                {
                                    currentCarOrder = driveThru.getFront().getCarOrder();
                                    orderTakenTime.add(time);
                                }
                            }
                            
                        }
                        else
                        {
                            break;   
                        }
                    }
                }
                else
                {
                    currentCarOrder = driveThru.getFront().getCarOrder();
                    orderTakenTime.add(time);
                }      
            }           
        }
       
        displayResults();
    }
    
    private void displayResults()
    {
        System.out.println("Burgers Wasted: " + burgersTossed + 
                            "\nDrive Offs: " + numberOfDriveOffs + 
                            "\nAverage Total Wait: " + averageTotalTimes() + " minutes " +
                            "\nAverage Window Wait: " + averageWindowTimes() + " minutes " +
                            "\nMax Total Wait Time: " + getMaxWait() + " minutes " +
                            "\nTotal Cars: " + getTotalCars() + 
                            "\nGross Profit: $" + totalProfit);
    }
    
    private int averageTotalTimes()
    {
        int totalOfTimes = 0;
        int totalCars = carTotalWaitTimes.size();
        int averageTime;
        
        for(Integer waitTime : carTotalWaitTimes)
        {
            totalOfTimes += waitTime.intValue();
        }
        averageTime = (totalOfTimes / totalCars);
        return averageTime;
    }
    
    private int averageWindowTimes()
    {
        int totalOfTimes = 0;
        int totalCars = waitTimesAtWindow.size();
        int averageTime;
        
        for(Integer waitTime : waitTimesAtWindow)
        {
            totalOfTimes += waitTime.intValue();
        }
        averageTime = (totalOfTimes / totalCars);
        return averageTime;
    }
    
    private int getMaxWait()
    {
        int maxWait = 0;
        for(Integer waitTime : carTotalWaitTimes)
        {
            if(maxWait < waitTime.intValue())
            {
                maxWait = waitTime.intValue();
            }
        }
        return maxWait;
    }
    
    private int getTotalCars()
    {
        return carTotalWaitTimes.size();
    }
}
