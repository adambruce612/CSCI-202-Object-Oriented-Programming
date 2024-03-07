public class Boat implements Cloneable
{
    private int length;
    private int maxOccupancy;

    public Boat(int length, int maxOccupancy)
    {
        this.length = length;
        this.maxOccupancy = maxOccupancy;
    }

    // Copy constructor
    public Boat(Boat other)
    {
        length = other.length;
        maxOccupancy = other.maxOccupancy;
    }

    public void setMaxOccupancy(int newValue)
    {
        maxOccupancy = newValue;
    }

    // Follow these steps when overriding equals to do a deep comparison
    @Override
    public boolean equals(Object obj) // Parameter type must by Object
    {
        // Step 1: Test if obj is a Boat
        //         If not, then return false
        if (!(obj instanceof Boat)) return false;

        // Step 2: Cast obj to a Boat
        Boat rhs = (Boat)obj;

        // Step 3: Test if the data fields of the invoking object are equal to the ones in the rhs
        //         using a deep comparison and return this result. Use == for primitive types, use
        //         .equals for object (reference types). If the superclass overrides its version of
        //         equals to do a deep comparison, then insert
        //             super.equals(obj) &&
        //         just after return and before length == rhs.length &&
        return length == rhs.length &&
                maxOccupancy == rhs.maxOccupancy;
    }

    @Override
    public int hashCode()
    {
        int result = Integer.hashCode(length);
        result = 31 * result + Integer.hashCode(maxOccupancy);
        return result;
    }

    @Override
    public Object clone() // Note: method clone() is redeclared public (this allows the class user to call it)
    {
        // Step 1: Add a try-catch block to catch (handle) a CloneNotSupportedException (return null in
        //         its catch clause).
        //         This step is not needed if the superclass overrides clone() to not throw a
        //         CloneNotSupportedException.
        //         try-catch blocks will be explained in full when we talk about Exception in class.
        try
        {
            // Step 2: Call super.clone() and cast its returned object to a Boat
            Boat objClone = (Boat)super.clone();

            // Step 3: deep copy the data fields from the invoking object into objeClone
            objClone.length = length;
            objClone.maxOccupancy = maxOccupancy;

            // Step 4: return objClone
            return objClone;
        }
        catch (CloneNotSupportedException e) // Part of step 1
        {
            return null;
        }
    }

    // Only add if the class is not abstract and you want to allow polymorphism
    // with copying instances of the class.
    public Boat copy()
    {
        return new Boat(this); // call the copy constructor to make a deep
    }                               // copy of the invoking object.
}
