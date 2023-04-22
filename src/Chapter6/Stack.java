package Chapter6;

public class Stack {
    private final char[] s; // this array holds the stack
    private int putloc, getloc; // the put and get indices

    Stack(int size) {
        s = new char[size]; // allocate memory for stack
        putloc = 0;
        getloc = -1;
    }

    Stack(Stack ob){
        putloc = ob.putloc;
        getloc = ob.getloc;
        s = new char[ob.s.length];
        // copy elements
        for(int i = 0; i < putloc; i++){
            s[i] = ob.s[i];
        }
    }

    //Construct a stack with initial values
    Stack(char[] a){
        putloc = 0;
        getloc = -1;
        s = new char[a.length];

        for (char c : a) put(c);
    }

    // put a character into the stack
    void put(char ch) {
        if(putloc==s.length) {
            System.out.println(" -- Queue is full.");
            return;
        }

        s[putloc++] = ch;
        getloc++;

    }

    // get a character from the stack
    char get() {
        if(getloc == -1) {
            System.out.println(" -- Queue is empty.");
            return (char) 0;
        }
        putloc--;
        return s[getloc--];
    }
}

class StackDemo{
    public static void main(String[] args) {
        //construct 10 element empty stack
        Stack s1 = new Stack(10);
        char[] name = {'T', 'o', 'm'};
        //construct stack from array
        Stack s2 = new Stack(name);

        char ch;
        int i;

        //put some characters in s1
        for(i = 0; i < 10; i++){
            s1.put((char)('A' + i));
        }

        //construct stack from another stack
        Stack s3 = new Stack(s1);

        //Show the stacks
        System.out.print("Contents of s1: ");
        for(i = 0; i < 10; i++){
            ch = s1.get();
            System.out.print(ch);
        }

        System.out.println("\n");
        System.out.print("Contents of s2: ");
        for(i = 0; i < 3; i++){
            ch = s2.get();
            System.out.print(ch);
        }

        System.out.println("\n");
        System.out.print("Contents of s3: ");
        for(i = 0; i < 10; i++){
            ch = s3.get();
            System.out.print(ch);
        }

        System.out.println("\n");
    }
}
