package lab1_2;

import java.util.Scanner;

public class Lab1_2
{
    public static void main(String[] args)
    {
        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Get rectangle information from user
        System.out.println("Enter each rectangle in the format \nx y l w \nwhere (x,y) is the lower left corner, l is the length, and w is the width.");

        // Get rectangle 1
        System.out.print("Enter 1st rectangle: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double l1 = input.nextDouble();
        double w1 = input.nextDouble();

        Rectangle R1 = new Rectangle(x1, y1, l1, w1);

        // Get rectangle 2
        System.out.print("Enter 2nd rectangle: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double l2 = input.nextDouble();
        double w2 = input.nextDouble();

        Rectangle R2 = new Rectangle(x2, y2, l2, w2);

        System.out.println("The rectangles " + (R1.overlapsWith(R2) ? "overlap." : "do not overlap."));
    }
}
