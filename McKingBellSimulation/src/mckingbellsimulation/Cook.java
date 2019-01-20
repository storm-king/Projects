/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mckingbellsimulation;

/**
 *
 * @author storm
 */
public class Cook 
{
    private int currentTime;
    private LinkedDeque<Burger> heatChute;
    private LinkedStack<Boolean> fryBin;
    
    public Cook(int time, LinkedDeque<Burger> burgerDeque, LinkedStack<Boolean> fryStack)
    {
        currentTime = time;
        heatChute = burgerDeque;
        fryBin = fryStack;  
    }
    
    public LinkedDeque<Burger> cookMoreBurgers()
    {
        LinkedDeque<Burger> fullHeatChute = new LinkedDeque<>();
        fullHeatChute = heatChute;
        
        while(fullHeatChute.size() < 5)
        {
            Burger burger = new Burger(currentTime + 1);
            fullHeatChute.addToBack(burger);
        }
        
        return fullHeatChute;
    }
    
    public LinkedStack<Boolean> cookMoreFries()
    {
        LinkedStack<Boolean> fullFryBin;
        fullFryBin = fryBin;
        
        while(fullFryBin.size() < 5)
        {
            fullFryBin.push(Boolean.TRUE);
        }
        
        return fullFryBin;
    }
    
}
