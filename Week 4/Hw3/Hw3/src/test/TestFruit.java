package test;

import juicer.*;

public class TestFruit
{
    public static void main(String[] args)
    {
        // TODO: Hw3 Part 1:
        //   Add code here to test the various fruit classes
        //   (Apple, Orange, Banana and Strawberry).
        //   Creating several instances of these classes and test
        //   out each of their methods. Make sure these methods
        //   work as expected.
        Apple a1 = new Apple(12);
        System.out.println(a1.isDried());
    }
}