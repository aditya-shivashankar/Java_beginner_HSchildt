package Chapter13;

// A generic queue interface
public interface IGenQ<T> {
    // Put an item in the queue
    void put(T ch) throws QueueFullException;

    // Get an item from the queue
    T get() throws QueueEmptyException;
}
