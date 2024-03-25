package sharedbuffer;

import java.util.Random;

public class Consumer implements Runnable
{
    private static final Random generator = new Random();
    private final Buffer sharedLocation; // reference to shared object

    public Consumer(Buffer shared)
    {
        sharedLocation = shared;
    }

    @Override
    public void run()
    {
        int sum = 0;

        {
            try
            {
                // sleep for random time between 0 and 3 seconds
                Thread.sleep(generator.nextInt(3000));

                // read value from buffer and add it to sum
                sum += sharedLocation.get();
                System.out.printf("Consumer sum: %d\n\n", sum);
            }
            catch (InterruptedException e)
            {
            }
        }

        System.out.printf(
                "%s %d\n%s\n",
                "Consumer read values totaling",
                sum,
                "Terminating Consumer");
    }
}