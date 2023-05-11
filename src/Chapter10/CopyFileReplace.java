package Chapter10;

import java.io.*;

public class CopyFileReplace {
    public static void main(String[] args) throws IOException {
        int i;

        //Confirm both files are specified
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }


        //open and manage two files with try statement
        try (FileReader fin = new FileReader(args[0]);
             FileWriter fout = new FileWriter(args[1])) {
            do {
                i = fin.read();
                if (i != -1) { // not reached end of file
                    if((char)i == ' '){ //space detected
                        fout.write('-'); //write hyphen
                    }else{
                        fout.write(i); //write the same character
                    }
                }
            } while (i != -1);
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }
    }
}
