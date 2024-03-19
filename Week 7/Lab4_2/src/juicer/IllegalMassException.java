package juicer;

public class IllegalMassException extends RuntimeException
{
    private final double invalidMassAmount;

    public IllegalMassException(double mass)
    {
        invalidMassAmount = mass;
    }

    public double getInvalidMassAmount()
    {
        return invalidMassAmount;
    }
}
