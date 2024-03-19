package lab4_1;

import java.util.*;
import java.io.*;

public class Lab4_1
{
    private static final Scanner input = new Scanner(System.in);
    private static final File file = new File("name.txt");

    public static void main(String[] args)
    {
        try
        {
            Scanner in = new Scanner(file); // may throw a FileNotFoundException
            String name = in.nextLine();
            System.out.println("Hello " + name + ".");
            in.close(); // we are done reading from in, so close it
            // Section 1:
            System.out.print("Would you like to change your name (y/n)? ");
            String response = input.nextLine().toLowerCase();
            if (response.equals("y"))
            {
                try
                {
                    registerName();
                    System.out.println("Your name has been changed.");
                }
                catch (FileNotFoundException exs)
                {
                    System.out.println("Unable to change name.");
                }
            }

            System.out.print("Would you like to unregister your name (y/n)? ");
            response = input.nextLine().toLowerCase();
            if (response.equals("y"))
            {
                try
                {
                    boolean isDeleted = file.delete();
                    if (isDeleted) System.out.println("Your name has been unregistered.");
                    else System.out.println("There was an error while processing your request.");
                }
                catch (SecurityException e)
                {
                    System.out.println("There was an error while processing your request.");
                }
            }

        }
        catch (FileNotFoundException e)
        {
            // Section 2:
            System.out.println("Your name is not registered.");
            System.out.print("Would you like to register your name (y/n)? ");
            String response = input.nextLine().toLowerCase();
            if (response.equals("y"))
            {
                try
                {
                    registerName();
                    System.out.println("Your name has been registered.");
                }
                catch (FileNotFoundException ex)
                {
                    System.out.println("Unable to register your name.");
                }
            }
        }
    }

    private static void registerName() throws FileNotFoundException
    {
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        PrintWriter out = new PrintWriter(file);

        out.println(name);

        out.close();
    }
}
