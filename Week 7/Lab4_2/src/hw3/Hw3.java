package hw3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import juicer.*;

public class Hw3
{
    private static final double MAX_FRUIT_MASS = 200.0;

    private final Random generator = new Random();
    private final Juicer sharedJuicer = new Juicer(1200.0);

    // Total amount of juice extracted from sharedJuicer
    private double juice = 0.0;

    private void addFruit(Fruit f)
    {
        try
        {
            synchronized (sharedJuicer)
            {
                System.out.println("Adding");
                System.out.println(f);
                sharedJuicer.add(f);
            }
        }
        catch (InterruptedException e)
        {
        }
    }

    private void addApples()
    {
        for (int i=0; i < 10; i++)
        {
            try
            {
                Thread.sleep(generator.nextInt(300));
            }
            catch (InterruptedException e)
            {
            }

            Apple a = new Apple(generator.nextDouble() * MAX_FRUIT_MASS);

            if (generator.nextDouble() < 0.4) a.dry();

            addFruit(a);
        }
    }

    private void addBananas()
    {
        for (int i=0; i < 10; i++)
        {
            try
            {
                Thread.sleep(generator.nextInt(300));
            }
            catch (InterruptedException e)
            {
            }

            addFruit(new Banana(generator.nextDouble() * MAX_FRUIT_MASS));
        }
    }

    private void addOranges()
    {
        for (int i=0; i < 10; i++)
        {
            try
            {
                Thread.sleep(generator.nextInt(300));
            }
            catch (InterruptedException e)
            {
            }

            addFruit(new Orange(generator.nextDouble() * MAX_FRUIT_MASS));
        }
    }

    private void addStrawberries()
    {
        for (int i=0; i < 10; i++)
        {
            try
            {
                Thread.sleep(generator.nextInt(300));
            }
            catch (InterruptedException e)
            {
            }

            addFruit(new Strawberry(generator.nextDouble() * MAX_FRUIT_MASS));
        }
    }

    private void extractJuice()
    {
        for (int i=0; i < 5; i++)
        {
            try
            {
                Thread.sleep(generator.nextInt(900));
            }
            catch (InterruptedException e)
            {
            }

            synchronized (sharedJuicer)
            {
                double amt = sharedJuicer.getJuice();
                juice += amt;
                System.out.println("Juice extracted from juicer.");
                System.out.println("\tAmount extracted: " + amt);
                System.out.println(
                        "\tCurrent total amount extracted: " + juice);
                System.out.println();
            }
        }
    }

    public void runApplication()
    {
        // create a new thread pool
        ExecutorService application = Executors.newCachedThreadPool();

        // Create a new thread that adds Apples to sharedJuicer
        application.execute(this::addApples);

        // Create a new thread that adds Bananas to sharedJuicer
        application.execute(this::addBananas);

        // Create a new thread that adds Oranges to sharedJuicer
        application.execute(this::addOranges);

        // Create a new thread that adds Strawberries to sharedJuicer
        application.execute(this::addStrawberries);

        // Create a new Thread to extract juice from sharedJuicer
        application.execute(this::extractJuice);

        application.shutdown();

        try
        {
            // wait 1 minute for all threads in application to finish
            boolean tasksEnded =
                    application.awaitTermination(1, TimeUnit.MINUTES);

            if (tasksEnded) // if all thread finished within 1 minute
            {
                System.out.print("Total amount of juice extracted: ");
                System.out.println(juice);
            }
            else // otherwise we timed out
            {
                System.out.println(
                        "Timed out while waiting for tasks to finish.");
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(
                    "Interrupted while waiting for tasks to finish.");
        }
    }

    public static void main(String[] args)
    {
        Hw3 application = new Hw3();
        application.runApplication();
    }
}