package lab3_1;

public class Account
{
    private int balance;

    public Account(int startingBalance)
    {
        if (startingBalance < 0)
            throw new IllegalArgumentException("starting balance is negative");

        balance = startingBalance;
    }

    public Account()
    {
        this(0);
    }

    public int getBalance()
    {
        return balance;
    }

    // TODO: modify deposit() and withdraw() to make them thread safe.
    //   Only one thread is allowed to be executing code in either deposit()
    //   or withdraw() at any given time. A thread in withdraw() cannot
    //   proceed if it tries to withdraw more than the current balance.
    //   In this case place the thread in the waiting state by calling
    //   wait(). When the thread wakes up it must once again check if it
    //   can proceed by testing if there is enough money in the account to
    //   withdraw. Calling wait() might throw an InterruptedException.
    //   To account for this, either handle the exception here or declare it
    //   to be thrown in the method declaration. When a thread in deposit()
    //   finishes its task, it must notify any waiting threads to wake up
    //   by calling notifyAll().

    public synchronized void deposit(int amount)
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException("amount is negative");
        }

        balance += amount;

        notifyAll();
    }

    public synchronized void withdraw(int amount) throws InterruptedException
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException("amount is negative");
        }

        while (amount > balance) wait();

        balance -= amount;
    }
}
