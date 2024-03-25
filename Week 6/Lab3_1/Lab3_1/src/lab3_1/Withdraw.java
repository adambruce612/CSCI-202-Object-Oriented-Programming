package lab3_1;

import java.util.Random;

public class Withdraw implements Runnable
{
    private static final Random generator = new Random();

    private final int withdrawAmount;
    private final Account sharedAccount;

    public Withdraw(Account shared, int amount)
    {
        sharedAccount = shared;
        withdrawAmount = amount;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(generator.nextInt(300));
            sharedAccount.withdraw(withdrawAmount);
        }
        catch (InterruptedException e)
        {
        }
    }
}
