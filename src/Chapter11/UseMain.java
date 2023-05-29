package Chapter11;

public class UseMain {
    public static void main(String[] args) {
        Thread thrd;

        //get main thread
        thrd = Thread.currentThread();

        System.out.println("Main thread is called: " + thrd.getName());
        System.out.println("Priority: " + thrd.getPriority());

        System.out.println();

        System.out.println("Setting the name and priority");
        thrd.setName("Thread #1");
        thrd.setPriority(Thread.NORM_PRIORITY + 3);

        System.out.println("Main thread is now called: " + thrd.getName());
        System.out.println("Main thread has priority: " + thrd.getPriority());
    }
}
