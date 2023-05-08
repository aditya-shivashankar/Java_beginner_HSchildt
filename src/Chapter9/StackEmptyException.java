package Chapter9;

//An exception for stack-empty errors
public class StackEmptyException extends Exception{

    public String toString(){
        return "\nStack is empty.";
    }
}
