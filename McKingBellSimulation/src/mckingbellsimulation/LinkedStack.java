package mckingbellsimulation;

/**
 *
 * @author storm
 */

public class LinkedStack<T> implements StackInterface<T> {

    private Node firstItem;
    int size = 0;
    
    public LinkedStack()
    {
        firstItem = null;
    }
    
    @Override
    public T pop() throws Exception {
        T item = peek();
        firstItem = firstItem.next;
        size--;
        return item;
    }

    @Override
    public T peek() throws Exception {
        if ( isEmpty() )
        {
            throw new Exception("Nothing to peep at here!");
        }
        return firstItem.data;
    }

    @Override
    public void push(T item) {
        Node newNode = new Node(item, firstItem);
        firstItem = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return firstItem == null;
    }

    @Override
    public void clear() {
        firstItem = null;
        size = 0;
    }
    
    @Override
    public int size() {
       return size; 
    }
    
    private class Node
    {
        private T data;
        private Node next;
        
        Node(T data)
        {
            this(data, null);
        }
        Node( T data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
