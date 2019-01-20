package linkedbag;


/**
 *
 * @author etcharn1
 * @author storm
 */
public interface BagInterface<T> {
    
    public int getCurrentSize();
    public boolean isEmpty();
    
    public boolean add( T item );
    public T remove();
    public boolean remove( T item );
    
    public int getFrequencyOf( T item );
    public boolean contains( T item );
    public T[] toArray();
    
}
