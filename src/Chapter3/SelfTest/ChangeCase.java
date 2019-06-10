package Chapter3.SelfTest;

public class ChangeCase {
    public static void main(String[] args)
            throws java.io.IOException {
        char ch, ignore;
        int changes = 0;

        do {
            System.out.println("Enter period to stop.");
            ch = (char) System.in.read();
            if(ch >= 'a' & ch <= 'z') {
                ch -= 32;
                changes++;
                System.out.println(ch);
            }
            else if(ch >= 'A' & ch <= 'Z') {
                ch += 32;
                changes++;
                System.out.println(ch);
            }
            do {
                ignore = (char) System.in.read();
            } while(ignore != '\n');
        } while(ch != '.');
        System.out.println("Case changes: " + changes);
    }
}
