/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedbag;

/**
 *
 * @author storm
 */
public class LinkedBag<T> implements BagInterface<T> 
{
    private Node firstNode;
    private int numberOfEntries;
    
    @Override
    public int getCurrentSize() 
    {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() 
    {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T item) 
    {
        Node newNode = new Node(item);
        newNode.next = firstNode;
        
        firstNode = newNode;
        numberOfEntries++;
        
        return true;
    }
    
    private Node getReferenceTo(T item)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode != null))
        {
            if (item.equals(currentNode.data))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }

    @Override
    public T remove() 
    {
        T result = null;
        if( firstNode != null)
        {
            result = firstNode.data;
            firstNode = firstNode.next;
            
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean remove(T item) 
    {
        boolean result = false;
        Node nodeN = getReferenceTo(item);
        if(nodeN != null)
        {
            nodeN.data = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    @Override
    public int getFrequencyOf(T item) 
    {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;
        while ((loopCounter < numberOfEntries) && (currentNode != null))
        {
            if (item.equals(currentNode.data))
            {
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }

    @Override
    public boolean contains(T item) 
    {
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode != null))
        {
            if (item.equals(currentNode.data))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   private class Node
   {
       private T data;
       private Node next;
       
       private Node(T dataPortion)
       {
           this(dataPortion, null);
       }
       
       private Node(T dataPortion, Node nextNode)
       {
           data = dataPortion;
           next = nextNode;
       }
   }
    
}
