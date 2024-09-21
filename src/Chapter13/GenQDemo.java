package Chapter13;

/*
    Try this 13-1

    Demonstrate a generic queue class

*/
public class GenQDemo {
    public static void main(String[] args) {
        // Create an Integer queue
        Integer iStore[] = new Integer[10];
        GenQueue<Integer> q = new GenQueue<>(iStore);

        Integer iVal;

        System.out.println("Demonstrate a queue of Integers");
        try{
            for(int i =0; i<5;i++){
                System.out.println("Adding "+ i + " to q");
                q.put(i); // add integer to queue
            }
        } catch (QueueFullException ex){
            System.out.println(ex);
        }
        System.out.println();

        try{
            for (int i =0; i<5;i++){
                System.out.print("Getting next Integer from q:  ");
                iVal = q.get();
                System.out.println(iVal);
            }
        }catch (QueueEmptyException ex){
            System.out.println(ex);
        }

        System.out.println();

        // Create a Double queue
        Double dStore[] = new Double[10];
        GenQueue<Double> q2 = new GenQueue<>(dStore);

        Double dVal;

        System.out.println("Demonstrate a queue of Doubles");
        try{
            for(int i =0; i<5;i++){
                dVal = (double)i/2;
                System.out.println("Adding "+ dVal + " to q2");
                q2.put(dVal); // add double to queue
            }
        } catch (QueueFullException ex){
            System.out.println(ex);
        }
        System.out.println();

        try{
            for (int i =0; i<5;i++){
                System.out.print("Getting next Double from q:  ");
                dVal = q2.get();
                System.out.println(dVal);
            }
        }catch (QueueEmptyException ex){
            System.out.println(ex);
        }
    }
}
