package sharedbuffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest
{
    public static void main(String[] args)
    {
        // create a new thread pool
        ExecutorService application = Executors.newCachedThreadPool();

        // create a SynchronizedBuffer to store a shared int
        Buffer sharedLocation = new SynchronizedBuffer();

        System.out.printf("%-40s%-12s\n%-40s%s\n\n", "Operation",
                "Buffer (after operation)", "---------", "------");

        // execute the Producer and Consumer threads
        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));

        application.shutdown();
    }
}