package Chapter3.SelfTest;

import java.io.IOException;

public class NumSpaces {
    public static void main(String[] args)
    throws IOException {
        int spaceCount = 0;
        char choice, ignore;
        do{
            System.out.print("Enter '.' to exit:");
            choice = (char) System.in.read();
            if(choice == ' '){
                spaceCount++;
            }
            do {
                ignore = (char) System.in.read();
            } while(ignore != '\n');
        }while(choice != '.');

        System.out.println("The number of spaces entered is: "+ spaceCount);

    }
}
