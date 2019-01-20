package mckingbellsimulation;

/**
 *
 * @author storm
 */

public interface StackInterface<T> {
    T pop() throws Exception;
    T peek() throws Exception;
    void push(T item);
    boolean isEmpty();
    void clear();
    int size();
}
