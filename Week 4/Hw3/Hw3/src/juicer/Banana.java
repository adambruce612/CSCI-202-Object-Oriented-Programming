package juicer;

public class Banana extends Fruit
{
    public Banana(double mass)
    {
        super(mass);
    }

    // copy constructor
    public Banana(Banana other)
    {
        super(other);
    }

    @Override
    protected double juiceRatio()
    {
        return 0.79;
    }

    @Override
    public boolean equals(Object obj)
    {
        // Steps to override the equals() method():

        // Step 1: Test if obj is an instance of Banana.
        //         If it is not, then return false.
        if (!(obj instanceof Banana)) return false;

        // Step 2: Cast obj to an Banana.
        // This step is not needed since the only data fields this
        // class has are the ones it inherits.

        // Step 3: Test if the data fields of the invoking object are
        //         equal to the ones in rhs using a deep comparison
        //         and return this result.
        return super.equals(obj);
    }

    // No need to override the hashCode() method because the only
    // data fields this class has are the ones it inherits.

    // No need to override the clone() method because the only
    // data fields this class has are the ones it inherits.

    @Override
    public Object copy()
    {
        return new Banana(this);
    }

    @Override
    public String toString()
    {
        return "Banana:\n" + super.toString();
    }
}