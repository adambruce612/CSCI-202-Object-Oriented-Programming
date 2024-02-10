package conch;

public class NonMagicConch
{
    private static int count = 0; // Shared by all instances of NonMagicConch
    private String boringMessage; // Each NonMagicConch will have one of these

    public NonMagicConch(String msg)
    {
        boringMessage = msg;
        count++;
    }

    public String getBoringMessage()
    {
        return boringMessage;
    }

    public static int getCount()
    {
        return count;
    }

    public String speech()
    {
        return boringMessage + " Amen.";
    }

    public String multiSpeech()
    {
        return speech() + " x " + count;
    }
}
