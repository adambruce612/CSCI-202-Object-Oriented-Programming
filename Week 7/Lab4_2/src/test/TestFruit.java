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
        // Create new apple
        Apple a1 = new Apple(12);
        // Get mass test
        System.out.println(a1.getMass());
        // Is dried test
        System.out.println(a1.isDried());
        // Print string test
        System.out.println(a1);
        // Amount juice test
        System.out.println(a1.amountJuice());
        // Is juice extracted test
        System.out.println(a1.isJuiceExtracted());
        // Extract juice test
        System.out.println(a1.extractJuice());
        // Hash code test
        System.out.println(a1.hashCode());

        //Copy Test
        Apple a2 = new Apple(a1);
        // Get mass test
        System.out.println(a2.getMass());
        // Is dried test
        System.out.println(a2.isDried());
        // Print string test
        System.out.println(a2);
        // Amount juice test
        System.out.println(a2.amountJuice());
        // Is juice extracted test
        System.out.println(a2.isJuiceExtracted());
        // Extract juice test
        System.out.println(a2.extractJuice());
        // Hash code test
        System.out.println(a2.hashCode());

        // Clone test
        Apple a3 = (Apple) a2.clone();
        // Get mass test
        System.out.println(a3.getMass());
        // Is dried test
        System.out.println(a3.isDried());
        // Print string test
        System.out.println(a3);
        // Amount juice test
        System.out.println(a3.amountJuice());
        // Is juice extracted test
        System.out.println(a3.isJuiceExtracted());
        // Extract juice test
        System.out.println(a3.extractJuice());
        // Hash code test
        System.out.println(a3.hashCode());

        // Create new banana
        Banana b1 = new Banana(5);
        // Get mass test
        System.out.println(b1.getMass());
        // Print string test
        System.out.println(b1);
        // Amount juice test
        System.out.println(b1.amountJuice());
        // Is juice extracted test
        System.out.println(b1.isJuiceExtracted());
        // Extract juice test
        System.out.println(b1.extractJuice());
        // Hash code test
        System.out.println(b1.hashCode());

        //Copy Test
        Banana b2 = (Banana) b1.copy();
        // Get mass test
        System.out.println(b2.getMass());
        // Print string test
        System.out.println(b2);
        // Amount juice test
        System.out.println(b2.amountJuice());
        // Is juice extracted test
        System.out.println(b2.isJuiceExtracted());
        // Extract juice test
        System.out.println(b2.extractJuice());
        // Hash code test
        System.out.println(b2.hashCode());

        // Clone test
        Banana b3 = (Banana) b2.clone();
        // Get mass test
        System.out.println(b3.getMass());
        // Print string test
        System.out.println(b3);
        // Amount juice test
        System.out.println(b3.amountJuice());
        // Is juice extracted test
        System.out.println(b3.isJuiceExtracted());
        // Extract juice test
        System.out.println(b3.extractJuice());
        // Hash code test
        System.out.println(b3.hashCode());


        System.out.println();
        // Create new Orange
        Orange o1 = new Orange(10);
        // Get mass test
        System.out.println(o1.getMass());
        // Print string test
        System.out.println(o1);
        // Amount juice test
        System.out.println(+ o1.amountJuice());
        // Is juice extracted test
        System.out.println(o1.isJuiceExtracted());
        // Extract juice test
        //System.out.println(o1.extractJuice());
        // Hash code test
        System.out.println(o1.hashCode());

        //Copy Test
        Orange o2 = (Orange) o1.copy();
        // Get mass test
        System.out.println(o2.getMass());
        // Print string test
        System.out.println(o2);
        // Amount juice test
        System.out.println(o2.amountJuice());
        // Is juice extracted test
        System.out.println(o2.isJuiceExtracted());
        // Extract juice test
        //System.out.println(o2.extractJuice());
        // Hash code test
        System.out.println(o2.hashCode());

        // Clone test
        Orange o3 = (Orange) o1.clone();
        // Get mass test
        System.out.println(o3.getMass());
        // Print string test
        System.out.println(o3);
        // Amount juice test
        System.out.println(o3.amountJuice());
        // Is juice extracted test
        System.out.println(o3.isJuiceExtracted());
        // Extract juice test
        System.out.println(o3.extractJuice());
        // Hash code test
        System.out.println(o3.hashCode());

        // Create new Strawberry
        Strawberry s1 = new Strawberry(4);
        // Get mass test
        System.out.println(s1.getMass());
        // Print string test
        System.out.println(s1);
        // Amount juice test
        System.out.println(s1.amountJuice());
        // Is juice extracted test
        System.out.println(s1.isJuiceExtracted());
        // Extract juice test
        System.out.println(s1.extractJuice());
        // Hash code test
        System.out.println(s1.hashCode());

        //Copy Test
        Strawberry s2 = (Strawberry) s1.copy();
        // Get mass test
        System.out.println(s2.getMass());
        // Print string test
        System.out.println(s2);
        // Amount juice test
        System.out.println(s2.amountJuice());
        // Is juice extracted test
        System.out.println(s2.isJuiceExtracted());
        // Extract juice test
        System.out.println(s2.extractJuice());
        // Hash code test
        System.out.println(s2.hashCode());

        // Clone test
        Strawberry s3 = (Strawberry) s2.clone();
        // Get mass test
        System.out.println(s3.getMass());
        // Print string test
        System.out.println(s3);
        // Amount juice test
        System.out.println(s3.amountJuice());
        // Is juice extracted test
        System.out.println(s3.isJuiceExtracted());
        // Extract juice test
        System.out.println(s3.extractJuice());
        // Hash code test
        System.out.println(s3.hashCode());

        // Test illegal mass exception error for constructor and setMass
        Strawberry s4 = new Strawberry(0);
        a3.dry();
    }
}