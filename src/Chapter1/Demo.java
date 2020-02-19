package Chapter1;

// Java code for serialization and deserialization
// of a Java object
import java.io.*;

class Demo implements java.io.Serializable
{
    public int a;
    public String b;
    public Boolean c;

    // Default constructor
    public Demo(int a, String b, Boolean c)
    {
        this.a = a;
        this.b = b;
        this.c = c;

    }

}

class DemoSub extends Demo{
    private static final long serialVersionUID = 8164894761367544387L;
    public DemoSub(int a, String b, Boolean c){
        super(a,b,c);
    }
}

class Test
{
    public static void main(String[] args)
    {
//        Demo object = new DemoSub(1, "geeksforgeeks", false);
        String filename = "file.ser";

        // Serialization
//        try
//        {
//            //Saving of object in a file
//            FileOutputStream file = new FileOutputStream(filename);
//            ObjectOutputStream out = new ObjectOutputStream(file);
//
//            // Method for serialization of object
//            out.writeObject(object);
//
//            out.close();
//            file.close();
//
//            System.out.println("Object has been serialized");
//
//        }
//
//        catch(IOException ex)
//        {
//            System.out.println("IOException is caught");
//        }


        Demo object1 = null;

        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);


            // Method for deserialization of object
            object1 = (Demo)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
            System.out.println("c = " + object1.c);
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}

