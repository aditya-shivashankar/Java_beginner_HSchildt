package Chapter10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Help {
    String helpfile; //name of help file

    Help(String fname) {
        helpfile = fname;
    }

    //display help on specific topic
    boolean helpOn(String what) {
        int ch;
        String topic, info;

        //Open the help file
        try (BufferedReader helpRdr = new BufferedReader(new FileReader(helpfile))) {
            do {
                //read characters until a # is found
                ch = helpRdr.read();

                // check if topics match
                if (ch == '#') {
                    topic = helpRdr.readLine();
                    if (what.compareTo(topic) == 0) { // found topic
                        do {
                            info = helpRdr.readLine();
                            if (info != null) System.out.println(info);
                        } while ((info != null) && info.compareTo("") != 0);
                        return true;
                    }
                }
            } while (ch != -1);
        } catch (IOException ex) {
            System.out.println("Error accessing helpfile.");
            return false;
        }
        return false; // topic not found
    }

    //Get a help topic
    String getSelection() {
        String topic = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter topic: ");

        try {
            topic = br.readLine();
        } catch (IOException ex) {
            System.out.println("Error reading console");
        }
        return topic;
    }
}

public class FileHelp {

    //Demonstrate the Help class
    public static void main(String[] args) {
        Help helpObj = new Help("C:\\Users\\adity\\github\\Java_beginner_HSchildt\\src\\Chapter10\\helpfile.txt");
        String topic;

        System.out.println("try the help system. " +
                "Enter 'stop' to end.");
        do {
            topic = helpObj.getSelection();
            if (!helpObj.helpOn(topic))
                System.out.println("Topic not found");
        } while (topic.compareTo("stop") != 0);
    }
}
