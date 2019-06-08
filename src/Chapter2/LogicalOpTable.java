package Chapter2;

public class LogicalOpTable {
    public static void main(String[] args) {
        boolean p, q;

        System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");

        p = true; q = true;
        System.out.print(eval(p) + "\t" + eval(q) +"\t");
        System.out.print(eval((p&q)) + "\t" + eval((p|q)) + "\t");
        System.out.println(eval((p^q)) + "\t" + eval(!p));

        p = true; q = false;
        System.out.print(eval(p) + "\t" + eval(q) +"\t");
        System.out.print(eval((p&q)) + "\t" + eval((p|q)) + "\t");
        System.out.println(eval((p^q)) + "\t" + eval(!p));

        p = false; q = true;
        System.out.print(eval(p) + "\t" + eval(q) +"\t");
        System.out.print(eval((p&q)) + "\t" + eval((p|q)) + "\t");
        System.out.println(eval((p^q)) + "\t" + eval(!p));

        p = false; q = false;
        System.out.print(eval(p) + "\t" + eval(q) +"\t");
        System.out.print(eval((p&q)) + "\t" + eval((p|q)) + "\t");
        System.out.println(eval((p^q)) + "\t" + eval(!p));
    }

    private static int eval(boolean p) {
        if(p){
            return 1;
        }
        else{
            return 0;
        }
    }
}

