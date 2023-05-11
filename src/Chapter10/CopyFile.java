package Chapter10;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        int i;

        //Confirm both files are specified
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }

        //open and manage two files with try statement
        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])) {
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }
    }
}
