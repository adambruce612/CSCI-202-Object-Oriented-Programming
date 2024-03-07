public class Boat
{
    private final int length;
    private final int maxOccupancy;

    public Boat(int length, int maxOccupancy)
    {
        this.length = length;
        this.maxOccupancy = maxOccupancy;
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
}
