package Chapter1;

// Java code for serialization and deserialization
// of a Java object
import java.io.*;

class Demo implements java.io.Serializable
{
    public int a;
    public String b;
    //comment below line
    public Boolean c;

    // Default constructor
    public Demo(int a, String b, Boolean c)
    {
        this.a = a;
        this.b = b;
        this.c = c;

    }
    public Demo(int a, String b)
    {
        this.a = a;
        this.b = b;
    }

}

class DemoSub extends Demo{
    private static final long serialVersionUID = 8164894761367544387L;
    // Boolean c;
    public DemoSub(int a, String b, Boolean c){
        super(a,b,c);
        // super(a,b);
        //this.c = c;
    }
}


