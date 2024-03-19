package juicer;

import copy.Copyable;

// TODO:  Hw3 Part 1: Add the Fruit class here
public abstract class Fruit implements Cloneable, Copyable
{
    private double mass;
    private boolean isJuiceRemoved;

    protected Fruit(double theMass)
    {
        mass = theMass;
        isJuiceRemoved = false;

        if (theMass <= 0) throw new IllegalMassException(theMass);
    }

    // Copy constructor
    protected Fruit(Fruit other)
    {
        mass = other.mass;
        isJuiceRemoved = other.isJuiceRemoved;
    }

    public double getMass()
    {
        return mass;
    }

    public String use()
    {
        return "Bang";
    }

    protected void setMass(double value)
    {
        mass = value;

        if (mass <= 0) throw new IllegalMassException(mass);
    }

    public boolean isJuiceExtracted()
    {
        return isJuiceRemoved;
    }

    protected abstract double juiceRatio();

    public double extractJuice()
    {
        double liquidMass = amountJuice();

        if (!isJuiceRemoved)
        {
            isJuiceRemoved = true;
            mass -= liquidMass;
        }

        return liquidMass;
    }

    public double amountJuice()
    {
        if (isJuiceRemoved) return 0.0;

        return mass * juiceRatio();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Fruit)) return false;

        Fruit rhs = (Fruit)obj;

        return mass == rhs.mass && isJuiceRemoved == rhs.isJuiceRemoved;
    }

    @Override
    public int hashCode()
    {
        int result = Double.hashCode(mass);
        result = 31 * result + Boolean.hashCode(isJuiceRemoved);
        return result;
    }

    @Override
    public Object clone()
    {
        try
        {
            Fruit objClone = (Fruit)super.clone();

            objClone.mass = mass;
            objClone.isJuiceRemoved = isJuiceRemoved;

            return objClone;
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }

    @Override
    public String toString()
    {
        return "\tmass = " + mass  +
                "\n\tisJuiceExtracted = " + isJuiceRemoved + "\n";
    }
}