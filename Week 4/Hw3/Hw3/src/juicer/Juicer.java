package juicer;

public class Juicer
{
    // max amount of juice mass this object can hold
    private final double juiceCapacity;

    // amount of juice currently in this object
    private double juiceMass = 0.0;

    public Juicer(double capacity)
    {
        juiceCapacity = capacity;
    }

    public synchronized void add(Fruit f) throws InterruptedException
    {
        // TODO: Hw3 Part 2, assigned in week 5.
        //   Extract the juice from f and add it to juceMass.
        //   If doing this would cause juiceMass to exceed juiceCapacity,
        //   then the current thread must release the monitor lock
        //   and wait. Whenever the thread wakes up it must check this
        //   condition again to see if we can proceed. If it cannot
        //   proceed, then it waits again. Otherwise, extract and add
        //   the juice to juiceMass.
        //   Hints:
        //      You can call f.amountJuice() to get the amount of juice
        //         in f without extracting it.
        //      To extract the juice, call f.extractJuice(). This will
        //         return the mass of the extracted juice as a double.
        if ((f.amountJuice() + juiceMass) > juiceCapacity)
        {
            wait();
        }
        else
        {
            juiceMass += f.extractJuice();
        }
    }

    public double getCapacity()
    {
        return juiceCapacity;
    }

    // Get the mass of the juice in the Juicer without
    // removing the juice.
    public synchronized double getJuiceMass()
    {
        return juiceMass;
    }

    // Extract the juice from the Juicer,
    // returning the mass of the extracted juice.
    public synchronized double getJuice()
    {
        // TODO: Hw3 Part 2, assigned in week 5.
        //   Then reset juiceMass to 0.0.
        //   Next, call notifyAll() to wake up all
        //   sleeping threads that are waiting in the add() method.
        //   Finally, return the extracted juice.


    }
}