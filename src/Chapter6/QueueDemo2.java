package Chapter6;


class Queue {
    private final char[] q; // this array holds the queue
    private int putloc, getloc; // the put and get indices

    Queue(int size) {
        q = new char[size]; // allocate memory for queue
        putloc = getloc = 0;
    }

    Queue(Queue ob){
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length];
        // copy elements
        for(int i = getloc; i < putloc; i++){
            q[i] = ob.q[i];
        }
    }

    //Construct a queue with initial values
    Queue(char[] a){
        putloc = 0;
        getloc = 0;
        q = new char[a.length];

        for (char c : a) put(c);
    }

    // put a characer into the queue
    void put(char ch) {
        if(putloc==q.length) {
            System.out.println(" -- Queue is full.");
            return;
        }

        q[putloc++] = ch;
    }

    // get a character from the queue
    char get() {
        if(getloc == putloc) {
            System.out.println(" -- Queue is empty.");
            return (char) 0;
        }

        return q[getloc++];
    }
}

class QueueDemo2{
    public static void main(String[] args) {
        //construct 10 element empty queue
        Queue q1 = new Queue(10);
        char[] name = {'T', 'o', 'm'};
        //construct queue from array
        Queue q2 = new Queue(name);

        char ch;
        int i;

        //put some characters in q1
        for(i = 0; i < 10; i++){
            q1.put((char)('A' + i));
        }

        //construct queue from another queue
        Queue q3 = new Queue(q1);

        //Show the queues
        System.out.print("Contents of q1: ");
        for(i = 0; i < 10; i++){
            ch = q1.get();
            System.out.print(ch);
        }

        System.out.println("\n");
        System.out.print("Contents of q2: ");
        for(i = 0; i < 3; i++){
            ch = q2.get();
            System.out.print(ch);
        }

        System.out.println("\n");
        System.out.print("Contents of q3: ");
        for(i = 0; i < 10; i++){
            ch = q3.get();
            System.out.print(ch);
        }

        System.out.println("\n");
    }
}


