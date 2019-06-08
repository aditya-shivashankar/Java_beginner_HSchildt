package Chapter1.SelfTest;

public class MoonWeight {
    public static void main(String[] args) {
        double inputWeight = Double.parseDouble(args[0]);
        double moonWeight = inputWeight * 0.17;
        System.out.println("Effective weight on moon for weight " + inputWeight + " is " + moonWeight);
    }
}
