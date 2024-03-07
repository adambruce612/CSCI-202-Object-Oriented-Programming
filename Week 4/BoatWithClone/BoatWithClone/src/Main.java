import java.util.HashSet;

public class Main
{
    public static void main(String[] args)
    {
        HashSet<Boat> h = new HashSet<>();
        Boat b1 = new Boat(18, 10);
        Boat b2 = new Boat(18, 10);
        h.add(b1);

        // h.contains(b2) returns true since b1.hashCode() == b2.hashCode()
        // (behind the scenes HashSet uses hashCode()).
        // If we did not override hashCode in Boat then h.contains(b2) would
        // incorrectly return false.
        System.out.println(h.contains(b2));

        Boat b3 = (Boat)b1.clone();
        System.out.println(h.contains(b3));

        b3.setMaxOccupancy(9);
        System.out.println(h.contains(b3));
        System.out.println(h.contains(b1));

        Boat b4 = new Boat(b1);
        System.out.println(h.contains(b4));

        Boat b5 = b1.copy();
        System.out.println(h.contains(b5));
    }
}
