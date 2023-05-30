package Chapter11;

public class TickTock {

    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }

        System.out.print("Tick ");
        state = "ticked";
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted while ticking");
        }

        notify();
        try {
            while (!state.equals("tocked"))
                wait();
        } catch (InterruptedException ex) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted while ticking");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify();
            return;
        }

        System.out.println("Tock ");
        state = "tocked";
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted while tocking");
        }

        notify();
        try {
            while (!state.equals("ticked"))
                wait();
        } catch (InterruptedException ex) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted while ticking");
        }
    }
}

class MyThreadTime implements Runnable {
    Thread thrd;
    TickTock ttob;

    MyThreadTime(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttob = tt;
    }

    public static MyThreadTime createAndStart(String name, TickTock tt) {
        MyThreadTime myThrd = new MyThreadTime(name, tt);
        myThrd.thrd.start();
        return myThrd;
    }

    public void run() {
        if (thrd.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 50; i++) ttob.tick(true);
            ttob.tick(false);
        } else {
            for (int i = 0; i < 50; i++) ttob.tock(true);
            ttob.tock(false);
        }
    }
}

class ThreadTime {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThreadTime mt1 = MyThreadTime.createAndStart("Tick", tt);
        MyThreadTime mt2 = MyThreadTime.createAndStart("Tock", tt);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted");
        }
    }
}
