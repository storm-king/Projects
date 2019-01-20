/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

/**
 *
 * @author storm
 */
public final class LinkedStack<T> implements StackInterface<T> {

    private Node firstItem;
    
    public LinkedStack()
    {
        firstItem = null;
    }
    
    @Override
    public T pop() {
        T item = peek();
            firstItem = firstItem.next;
        
            
        return item;
    }

    @Override
    public T peek() {
        return firstItem.data;
    }

    @Override
    public void push(T item) {
        Node newNode = new Node(item, firstItem);
        firstItem = newNode;
    }

    @Override
    public boolean isEmpty() {
        return firstItem == null;
    }

    @Override
    public void clear() {
        firstItem = null;
    }
   
    private class Node
    {
        private T data;
        private Node next;
        
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        
        private Node( T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
    }
}
