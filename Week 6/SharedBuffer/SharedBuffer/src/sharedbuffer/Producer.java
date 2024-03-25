package sharedbuffer;

import java.util.Random;

public class Producer implements Runnable
{
    private static final Random generator = new Random();
    private final Buffer sharedLocation; // reference to shared object

    public Producer(Buffer shared)
    {
        sharedLocation = shared;
    }

    @Override
    public void run()
    {
        int sum = 0;

        for (int i = 1; i <= 10; i++)
        {
            try
            {
                // sleep for random time between 0 and 3 seconds
                Thread.sleep(generator.nextInt(3000));

                // place value in buffer
                sharedLocation.set(i);
                sum += i;
                System.out.printf("Producer sum: %d\n\n", sum);
            }
            catch (InterruptedException e)
            {
            }
        }

        System.out.println("Producer done producing\nTerminating Producer");
    }
}