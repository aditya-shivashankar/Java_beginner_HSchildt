package Chapter7;


abstract class TwoDShape {
    private double width;
    private double height;
    private String name;

    TwoDShape() {
        width = height = 0.0;
        name = "none";
    }

    TwoDShape(double w, double h, String n) {
        width = w;
        height = h;
        name = n;
    }

    TwoDShape(double x, String n) {
        width = height = x;
        name = n;
    }

    TwoDShape(TwoDShape ob) {
        width = ob.width;
        height = ob.height;
        name = ob.name;
    }

    double getWidth() {
        return width;
    }

    void setWidth(double width) {
        this.width = width;
    }

    double getHeight() {
        return height;
    }

    void setHeight(double height) {
        this.height = height;
    }

    String getName() {
        return name;
    }

    void showDim() {
        System.out.println("Width and height are " + width + " and " + height);
    }

    abstract double area();
}

class Triangle extends TwoDShape {
    private String style;

    Triangle() {
        super();
        style = "none";
    }

    Triangle(String s, double w, double h) {
        super(w, h, "triangle");
        style = s;
    }

    Triangle(double x) {
        super(x, "triangle");
        style = "filled";
    }

    Triangle(Triangle ob) {
        super(ob);
        style = ob.style;
    }

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

class Rectangle extends TwoDShape {
    Rectangle() {
        super();
    }

    Rectangle(double w, double h) {
        super(w, h, "rectangle");
    }

    Rectangle(double x) {
        super(x, "rectangle");
    }

    Rectangle(Rectangle ob) {
        super(ob);
    }

    boolean isSquare() {
        return getWidth() == getHeight();
    }

    double area() {
        return getWidth() * getHeight();
    }
}

class Circle extends TwoDShape {
    Circle() {
        super();
    }

    // width = height = diameter for circle
    Circle(double x) {
        super(x, "circle");
    }

    Circle(Circle ob) {
        super(ob);
    }


    double area() {
        return Math.PI * getWidth() * getWidth() / 4;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println("Area of circle with radius " + c.getWidth() / 2 + " is " + c.area());
    }
}
