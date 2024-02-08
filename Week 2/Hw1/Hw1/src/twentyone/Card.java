package twentyone;

public class Card
{
    public enum Rank
    {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        // numeric code associated with each Rank instance
        private final int value;

        Rank(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

    public enum Suit
    {
        SPADES, HEARTS, DIAMONDS, CLUBS
    }

    // TODO: add any needed private data fields here.
    private Rank rank;
    private Suit suit;
    private boolean isFaceUp;

    public Card(Rank theRank, Suit theSuit, boolean isTheCardFaceUp)
    {
        // TODO: write constructor here.
        rank = theRank;
        suit = theSuit;
        isFaceUp = isTheCardFaceUp;
    }

    public Rank getRank()
    {
        // TODO: write method body here.
        return rank; // Temporary return value. Replace this line.
    }

    public Suit getSuit()
    {
        // TODO: write method body here.
        return suit;
    }

    public boolean isFaceUp()
    {
        // TODO: write method body here.
        return isFaceUp; // Temporary return value. Replace this line.
    }

    public void setFaceUp(boolean newValue)
    {
        // TODO: write method body here.
        isFaceUp = newValue;
    }
}