package Chapter9;

//Demonstrate exception thrown by fixed stack
public class SExcDemo {
    public static void main(String[] args) {
        FixedStack s = new FixedStack(10);
        char ch;
        int i;

        try {
            //overrun the stack
            for (i = 0; i < 11; i++) {
                System.out.println("Attempting to store: " + (char) ('A' + i));
                s.put((char) ('A' + i));;
                System.out.println("OK");
            }
            System.out.println();
        }
        catch(StackFullException exc){
            System.out.println(exc);
        }
        System.out.println();

        try{
            //over-empty the stack
            for(i=0; i<11;i++){
                System.out.print("Getting next char: ");
                ch = s.get();
                System.out.println(ch);
            }
        }
        catch(StackEmptyException exc){
            System.out.println(exc);
        }
    }
}
