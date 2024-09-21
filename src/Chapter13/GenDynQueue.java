package Chapter13;

public class GenDynQueue<T> implements IGenQ<T> {
    private T q[]; // Array that holds the queue
    private int putLoc, getLoc; // the put and get indices

    // Construct an empty queue with given size
    public GenDynQueue(T[] aRef){
        q = aRef;
        putLoc = getLoc = 0;
    }

    public void put(T obj) throws QueueFullException{
        if(putLoc==q.length -1){
            T t[] = (T[]) new Object[q.length*2];
            for(int i=0; i<q.length; i++)
                t[i] = q[i];

            q = t;
        }

        q[putLoc++] = obj;
        if(putLoc==q.length) putLoc =0;
    }


    public T get() throws QueueEmptyException{
        if(getLoc == putLoc){
            throw  new QueueEmptyException();
        }
        return q[getLoc++];
    }
}
