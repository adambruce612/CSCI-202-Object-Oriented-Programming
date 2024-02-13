package shape;

public class Test
{
    public static void sayMe(Object ob)
    {
        System.out.println("Object says: " + ob);
        // The above is the same as:
        //    System.out.println("Object says: " + ob.toString());
        // This is because when converting an object to a String
        // Java will automatically call toString() for us.
    }

    public static void main(String[] args)
    {
        Rectangle r = new Rectangle(2.1, 3.5, 8, 5);
        Triangle t = new Triangle(2, 4, 7, 4, 7 ,1);

        sayMe(r);
        sayMe(t);

        System.out.println("r's area: " + r.getArea());
        System.out.println("t's area: " + t.getArea());
    }
}
