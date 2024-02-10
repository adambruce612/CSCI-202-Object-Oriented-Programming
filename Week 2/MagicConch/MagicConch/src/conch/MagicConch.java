package conch;

public class MagicConch
{
    private final String specialMessage;

    public MagicConch(String sm)
    {
        specialMessage = sm;
    }

    public MagicConch()
    {
        this("Not 4 U");
    }

    public String getSpecialMessage()
    {
        return specialMessage;
    }
}
