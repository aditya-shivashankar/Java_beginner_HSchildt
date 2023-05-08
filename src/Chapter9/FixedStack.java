package Chapter9;

import Chapter6.Stack;

//Demonstrate stack of fixed size that throws exception
public class FixedStack {
    private final char[] s; // this array holds the stack
    private int putloc, getloc; // the put and get indices

    FixedStack(int size) {
        s = new char[size]; // allocate memory for stack
        putloc = 0;
        getloc = -1;
    }


    // put a character into the stack
    void put(char ch) throws StackFullException{
        if(putloc==s.length) {
            throw new StackFullException(s.length);
        }
        s[putloc++] = ch;
        getloc++;

    }

    // get a character from the stack
    char get() throws StackEmptyException{
        if(getloc == -1) {
            throw new StackEmptyException();
        }
        putloc--;
        return s[getloc--];
    }

}
