package lab3_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lab3_1
{
    public static void main(String[] args)
    {
        // create a new thread pool
        ExecutorService application = Executors.newCachedThreadPool();

        // account shared among threads
        Account sharedAccount = new Account();

        // execute the Deposit and Withdraw threads
        for (int i = 0; i < 100; i++)
        {
            application.execute(new Deposit(sharedAccount, 1));
            application.execute(new Withdraw(sharedAccount, 1));
        }

        application.shutdown();

        try
        {
            // wait 1 minute for all threads in application to finish
            boolean tasksEnded =
                    application.awaitTermination(1, TimeUnit.MINUTES);

            if (tasksEnded) // if all thread finished within 1 minute
            {
                System.out.println("Expected account balance: 0");
                System.out.println("Actual account balance: " +
                        sharedAccount.getBalance());
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
}
