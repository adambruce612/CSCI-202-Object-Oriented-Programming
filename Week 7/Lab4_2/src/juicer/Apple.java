package juicer;

public class Apple extends Fruit
{
    // ratio of liquid in an undried apple
    private static final double UNDRIED_RATIO_LIQUID = 0.81;

    // ratio of liquid that does not evaporate when drying an apple
    private static final double NON_EVAPORATION_RATIO = 0.09;

    private double liquidMass; // amount of mass that is liquid
    private boolean isAppleDried;

    public Apple(double mass)
    {
        super(mass);
        liquidMass = mass * UNDRIED_RATIO_LIQUID;
        isAppleDried = false;
    }

    // copy constructor
    public Apple(Apple other)
    {
        super(other);
        liquidMass = other.liquidMass;
        isAppleDried = other.isAppleDried;
    }

    public boolean isDried()
    {
        return isAppleDried;
    }

    public void dry()
    {
        if (isAppleDried) return;

        double solidMass = getMass() - liquidMass;
        liquidMass *= NON_EVAPORATION_RATIO;
        setMass(liquidMass + solidMass);
        isAppleDried = true;
    }

    @Override
    protected double juiceRatio()
    {
        return liquidMass / getMass();
    }

    @Override
    public boolean equals(Object obj)
    {
        // Steps to override the equals() method():

        // Step 1: Test if obj is an instance of Apple.
        //         If it is not, then return false.
        if (!(obj instanceof Apple)) return false;

        // Step 2: Cast obj to an Apple.
        Apple rhs = (Apple)obj;

        // Step 3: Test if the data fields of the invoking object are
        //         equal to the ones in rhs using a deep comparison
        //         and return this result.
        return super.equals(obj) && // test for equality in the super class
                liquidMass == rhs.liquidMass &&
                isAppleDried == rhs.isAppleDried;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31*result + Double.hashCode(liquidMass);
        result = 31*result + Boolean.hashCode(isAppleDried);
        return result;
    }

    @Override
    public Object clone()
    {
        // Steps to override the clone() method to make a deep copy:

        // Step 1 is not needed: we do not need to add a try-catch block
        //    to handle a CloneNotSupportedException because the clone()
        //    method of class Fruit handles this for us.

        // Step 2: call super.clone() and cast what is returned to an Apple
        Apple objectClone = (Apple)super.clone();

        // Step 3: Deep copy the data fields from the invoking object
        //         to objectClone.
        objectClone.liquidMass = liquidMass;
        objectClone.isAppleDried = isAppleDried;

        // Step 4: return objectClone
        return objectClone;
    }

    @Override
    public Object copy()
    {
        return new Apple(this);
    }

    @Override
    public String toString()
    {
        return "Apple:\n" + super.toString() +
                "\tisDried = " + isAppleDried + "\n";
    }
}