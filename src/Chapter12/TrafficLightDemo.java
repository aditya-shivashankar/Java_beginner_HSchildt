package Chapter12;

// An enumeration of the colors of a traffic light
enum TrafficLightColor{
    RED(12_000), GREEN(10_000), YELLOW(2_000);

    private final int delay;

    TrafficLightColor(int delay){
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }
}

class TrafficLightSimulator implements Runnable{
    private TrafficLightColor tlc;
    private boolean stop = false;
    private boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init){
        this.tlc = init;
    }

    TrafficLightSimulator(){
        this.tlc = TrafficLightColor.RED;
    }

    // change color
    synchronized void changeColor(){
        tlc = TrafficLightColor.values()[(tlc.ordinal() + 1) % 3];
        changed = true;
        notify(); // signal that light has changed
    }

    // wait for light change
    synchronized void waitForChange(){
        try{
            while(!changed)
                wait(); // wont return till changeColor() executes call to notify()
            changed = false;
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    // Return current color
    synchronized TrafficLightColor getColor(){
        return tlc;
    }

    // Stop the light
    synchronized void cancel(){
        stop = true;
    }

    // Start up the light
    public void run(){
        while(!stop){
            try{
                switch (tlc) {
                    case GREEN -> Thread.sleep(TrafficLightColor.GREEN.getDelay()); // green for 10 seconds
                    case YELLOW -> Thread.sleep(TrafficLightColor.YELLOW.getDelay()); // yellow for 2 seconds
                    case RED -> Thread.sleep(TrafficLightColor.RED.getDelay()); // red for 12 seconds
                }
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            changeColor();
        }
    }

}


public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLightSimulator t1 =  new TrafficLightSimulator(TrafficLightColor.GREEN);
        Thread thrd = new Thread(t1);
        thrd.start();

        for(int i = 0; i <9; i++){
            System.out.println(t1.getColor());
            t1.waitForChange();
        }

        t1.cancel();

    }
}
