package Chapter13;

public class GenCircularQueue<T> implements IGenQ<T> {
    private T q[]; // Array that holds the queue
    private int putLoc, getLoc; // the put and get indices

    // Construct an empty queue one larger than given size and add the input q
    public GenCircularQueue(T[] aRef){
        q = (T[]) new Object[aRef.length+1];
        for(int i=0; i<aRef.length; i++)
            q[i] = aRef[i];
        putLoc = getLoc = 0;
    }

    public void put(T obj) throws QueueFullException{
        if((putLoc+1==getLoc) | ((putLoc==q.length-1)&(getLoc==0))){
            throw new QueueFullException(q.length -1);
        }
        q[putLoc++] = obj;
        if(putLoc==q.length) putLoc =0;
    }

    public T get() throws QueueEmptyException{
        if(getLoc == putLoc){
            throw new QueueEmptyException();
        }

        T obj = q[getLoc++];
        if (getLoc==q.length) getLoc=0;
        return obj;
    }
}
