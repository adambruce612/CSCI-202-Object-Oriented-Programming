package lab3_1;

import java.util.Random;

public class Deposit implements Runnable
{
    private static final Random generator = new Random();

    private final int depositAmount;
    private final Account sharedAccount;

    public Deposit(Account shared, int amount)
    {
        sharedAccount = shared;
        depositAmount = amount;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(generator.nextInt(300));
        }
        catch (InterruptedException e)
        {
        }

        sharedAccount.deposit(depositAmount);
    }
}
