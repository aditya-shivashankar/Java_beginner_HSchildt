package Chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileReplaceClose {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;


        //Confirm both files are specified
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            do {
                i = fin.read();
                if (i != -1) { // not reached end of file
                    if (i == ' ') { //space detected
                        fout.write('-'); //write hyphen
                    } else {
                        fout.write(i); //write the same character
                    }
                }
            } while (i != -1);
        } catch (IOException ex) {
            System.out.println("IOException occured");
        } finally {
            if (fin != null) fin.close();
            if (fout != null) fout.close();
        }

    }
}
