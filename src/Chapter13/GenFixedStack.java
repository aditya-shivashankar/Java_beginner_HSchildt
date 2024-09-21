package Chapter13;

public class GenFixedStack<T> implements IGenStack<T> {

    private final T[] s; // this array holds the stack
    private int putloc, getloc; // the put and get indices

    GenFixedStack(int size) {
        s = (T[])new Object[size]; // allocate memory for stack
        putloc = 0;
        getloc = -1;
    }


    // put a object into the stack
    public void push(T obj) throws StackFullException {
        if(putloc==s.length) {
            throw new StackFullException(s.length);
        }
        s[putloc++] = obj;
        getloc++;

    }

    // get a character from the stack
    public T pop() throws StackEmptyException {
        if(getloc == -1) {
            throw new StackEmptyException();
        }
        putloc--;
        return s[getloc--];
    }
}
