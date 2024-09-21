package Chapter13;

// A generic fixed size queue class
public class GenQueue<T> implements IGenQ<T> {
    private T q[]; // Array that holds the queue
    private int putLoc, getLoc; // the put and get indices

    // Construct an empty queue with the given array
    public GenQueue(T[] aRef){
        q = aRef;
        putLoc = getLoc = 0;
    }

    // put an item in the queue
    public void put(T obj)
        throws QueueFullException{

        if (putLoc == q.length){
            throw new QueueFullException(q.length);
        }
        q[putLoc++] = obj;
    }

    // get a character from the queue
    public T get()
        throws QueueEmptyException{

        if(getLoc == putLoc)
            throw new QueueEmptyException();

        return q[getLoc++];
    }

}
