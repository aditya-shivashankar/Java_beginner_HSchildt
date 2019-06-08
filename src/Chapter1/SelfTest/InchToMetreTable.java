package Chapter1.SelfTest;

public class InchToMetreTable {
    public static void main(String[] args) {
        double inches, metres;
        int counter;

        counter = 0;
        for(inches = 1; inches <= 144; inches++) {
            metres = inches * (1/39.37); // convert to liters
            System.out.println(inches + " inches is " +
                    metres + " metres.");

            counter++;
            // every 10th line, print a blank line
            if(counter == 12) {
                System.out.println();
                counter = 0; // reset the line counter
            }
        }
    }
}
