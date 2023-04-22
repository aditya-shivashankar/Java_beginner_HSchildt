package Chapter6;

public class Test {
    int a;
    Test(int i){
        a=i;
    }
    static void swap(Test obj1, Test obj2){
        int i = obj1.a;
        obj1.a = obj2.a;
        obj2.a = i;
    }
}

class TestDemo{
    public static void main(String[] args) {
        Test object1 = new Test(1);
        Test object2 = new Test(2);
        System.out.println("Initial values");
        System.out.println("Object 1: " + object1.a);
        System.out.println("Object 2: " + object2.a);
        Test.swap(object1, object2);
        System.out.println("Final values");
        System.out.println("Object 1: " + object1.a);
        System.out.println("Object 2: " + object2.a);

    }

}
