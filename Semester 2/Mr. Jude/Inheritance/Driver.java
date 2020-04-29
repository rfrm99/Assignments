package Inheritance;

public class Driver {
    public static void main(String[] arg) {
        Shape s = new Shape();
        Shape s1 = new Shape("red",false);
        System.out.println(s.toString());
        System.out.println(s1.toString());
        s.setColor("blue");
        s.setFilled(false);
        System.out.println("s new Color: " + s.getColor());
        if (s.isFilled()){
            System.out.println("s is Filled");
        }else{
            System.out.println("s is Not Filled");
        }
        System.out.println("\n");


        Circle c = new Circle();
        Circle c1 = new Circle(2.0, "red", false);
        System.out.println(c.toString());
        System.out.println(c1.toString());
        c.setRadius(3.0);
        c.setColor("blue");
        c.setFilled(false);
        System.out.println("New c Radius: " + c.getRadius());
        System.out.println("New c Color: " + c.getColor());
        System.out.println("Area of c: " + c.getArea());
        System.out.println("Perimeter of c: " + c.getPerimeter());
        if (c.isFilled()){
            System.out.println("c is Filled");
        }else{
            System.out.println("c is Not Filled");
        }
        System.out.println("\n");


        Rectangle r = new Rectangle();
        Rectangle r1 = new Rectangle(2.0,3.0);
        Rectangle r2 = new Rectangle(3.0, 4.0, "blue", false);
        System.out.println(r.toString());
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        r.setLength(5.0);
        r.setWidth(3.0);
        r.setColor("red");
        r.setFilled(false);
        System.out.println("New r Length: " +r.getLength());
        System.out.println("New r Width: " +r.getWidth());
        System.out.println("New r Color: " +r.getColor());
        System.out.println("Area of r: " +r.getArea());
        System.out.println("Perimeter of r: " +r.getPerimeter());
        if (r.isFilled()){
            System.out.println("r is Filled");
        }else{
            System.out.println("r is Not Filled");
        }
        System.out.println("\n");


        Square sq = new Square();
        Square sq1 = new Square(2.0);
        Square sq2 = new Square(3.0, "red", false);
        System.out.println(sq.toString());
        System.out.println(sq1.toString());
        System.out.println(sq2.toString());
        sq.setSide(5.0);
        sq.setColor("blue");
        sq.setFilled(false);
        System.out.println("New sq Sides: " + sq.getSide());
        System.out.println("New sq Color: " + sq.getColor());
        System.out.println("Area of sq: " +sq.getArea());
        System.out.println("Perimeter of sq: " +sq.getPerimeter());
        if (sq.isFilled()){
            System.out.println("sq is Filled");
        }else{
            System.out.println("sq is Not Filled");
        }
        sq.setLength(3.0);
        System.out.println("New sq Sides with getLength: " + sq.getSide());
        sq.setWidth(2.0);
        System.out.println("New sq Sides with getWidth: " + sq.getSide());
    }
}
