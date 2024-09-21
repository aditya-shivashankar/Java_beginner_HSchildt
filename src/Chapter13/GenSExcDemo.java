package Chapter13;



//Demonstrate exception thrown by fixed stack
public class GenSExcDemo {
    public static void main(String[] args) {
        System.out.println("Example of integers");
        GenFixedStack<Integer> s = new GenFixedStack<>(10);

        try {
            //overrun the stack
            for (int i = 0; i < 11; i++) {
                System.out.println("Attempting to store: " + i);
               s.push(i);
                System.out.println("OK");
            }
            System.out.println();
        }
        catch(StackFullException exc){
            System.out.println(exc);
        }

        try{
            //over-empty the stack
            for(int i=0; i<11;i++){
                System.out.print("Getting next int: ");
                int val = s.pop();
                System.out.println(val);
            }
        }
        catch(StackEmptyException exc){
            System.out.println(exc);
        }

        System.out.println("Example of characters");
        GenFixedStack<Character> s1 = new GenFixedStack<>(10);


        try {
            //overrun the stack
            for (int i = 0; i < 11; i++) {
                System.out.println("Attempting to store: " + (char) ('A' + i));
                s1.push((char) ('A' + i));;
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
            for(int i=0; i<11;i++){
                System.out.print("Getting next char: ");
                char ch = s1.pop();
                System.out.println(ch);
            }
        }
        catch(StackEmptyException exc){
            System.out.println(exc);
        }
    }
}
