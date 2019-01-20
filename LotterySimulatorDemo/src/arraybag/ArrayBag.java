/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraybag;


/*
 *
 * @author storm
 */
public class ArrayBag<T> implements BagInterface<T> 
{

    public static final int DEFAULT_SIZE = 25;
    private T[] bag;
    private int currentSize;
    
    public ArrayBag()
    {
        this(DEFAULT_SIZE);
    }
    
    public ArrayBag(int initialSize )
    {
        bag = (T[])new Object[initialSize];
        currentSize = 0;
    }
    
    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean add(T item) {
        boolean added = false;
        if ( currentSize < bag.length )
        {
            bag[currentSize] = item;
            currentSize++;
            added =  true;
        }
        return added;
    }

    @Override
    public T remove() {
        T item = null;
        if ( !isEmpty() )
        {
            item = bag[currentSize - 1];
            bag[currentSize - 1] = null;
            currentSize--;
        }
        return item;
    }

    @Override
    public boolean remove(T item) {
        boolean removed = false;
        int currentIndex = 0;
        while ( !removed && currentIndex < currentSize)
        {
            if ( bag[currentIndex].equals( item ) )
                {
                    removed = true;
                    bag[currentIndex] = remove();
                }
            currentIndex++;
        }
        
        return removed;
    }

    @Override
    public int getFrequencyOf(T item) 
    {
        int counter = 0;
        for(int index = 0; index < currentSize; index++)
        {
            if(item.equals(bag[index]))
            {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean contains(T item) {
        boolean found = false;
        int index = 0;
        
        while (!found && (index < currentSize))
        {
            if( item.equals(bag[index]))
            {
                found = true;
            }
            index++;
        }
        return found;
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}