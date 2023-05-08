package Chapter9;


//A fixed size queue class for characters that uses exceptions.
public class FixedQueue implements ICharQ {
    private char[] q; //array that holds the queue
    private int putloc, getloc; //the put and get indices

    //Construct an empty queue with given size
    public FixedQueue(int size) {
        q = new char[size];
        putloc = getloc = 0;
    }

    //Put a character into queue
    public void put(char ch) throws QueueFullException {
        if (putloc == q.length) {
            throw new QueueFullException(q.length);
        }
        q[putloc++] = ch;
    }

    //Get a character from the queue
    public char get() throws QueueEmptyException{
        if(getloc==putloc){
            throw new QueueEmptyException();
        }

        return q[getloc++];
    }

}
