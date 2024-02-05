package twentyone;

import java.util.ArrayList;
import java.util.Random;

public class TwentyOneGame
{
    public static final int TARGET_SCORE = 21;

    private final Card[] deck;   // The deck of cards.
    private int topOfDeck; // Index to top of deck.
    // The bottom of the deck has index 0.

    private boolean isGameOver; // Indicates if the game is over.
    private final ArrayList<Card> houseCards;  // List of house's cards.
    private final ArrayList<Card> playerCards; // List of player's cards.
    private final Random generator;   // Used for generating random numbers.

    public TwentyOneGame()
    {
        deck = new Card[Card.Rank.values().length * Card.Suit.values().length];
        generator = new Random();
        houseCards = new ArrayList<>();
        playerCards = new ArrayList<>();
        newGame();
    }

    // seed the internal random number generator before creating a new game
    public void newGame(long seed)
    {
        generator.setSeed(seed);
        newGame();
    }

    public void newGame()
    {
        topOfDeck = deck.length - 1;

        int i = 0;

        for (Card.Rank rank : Card.Rank.values())
        {
            for (Card.Suit suit : Card.Suit.values())
            {
                deck[i++] = new Card(rank, suit, false);
            }
        }

        shuffleDeck();

        // Remove all cards from the house and the player.
        houseCards.clear();
        playerCards.clear();

        // deal the cards out to the player and the house.
        hit();
        houseHit(false);
        hit();
        houseHit(true);

        isGameOver = false;
    }

    public boolean isOver()
    {
        return isGameOver;
    }

    public final ArrayList<Card> getHouseCards()
    {
        return houseCards;
    }

    public final ArrayList<Card> getPlayerCards()
    {
        return playerCards;
    }

    private void shuffleDeck()
    {
        // TODO: Shuffle the array deck using the algorithm
        //   described in the instructions. Do NOT use any of
        //   the Java library utilities to do the shuffling
        //   except for the Random generator object in this class.
    }

    // Player takes a card from the deck.
    // Returns the new card from the deck or null if either
    // the deck is empty or the game is over.
    public Card hit()
    {
        if (isGameOver || topOfDeck < 0) return null;

        Card newCard = deck[topOfDeck--];
        newCard.setFaceUp(true);
        playerCards.add(newCard);

        if (getPlayerScore() > TARGET_SCORE)
        {
            isGameOver = true;
            houseCards.get(0).setFaceUp(true);
        }

        return newCard;
    }

    // House takes a card from the deck.
    // If parameter faceCardUp is true, then the card will be placed face up,
    // otherwise it will be placed face down.
    // Returns the new card from the deck or null if the deck is empty.
    private Card houseHit(boolean faceCardUp)
    {
        if (topOfDeck < 0) return null;

        Card newCard = deck[topOfDeck--];
        newCard.setFaceUp(faceCardUp);
        houseCards.add(newCard);

        return newCard;
    }

    private void housePlay()
    {
        // Turn house's face down card up.
        houseCards.get(0).setFaceUp(true);

        // The house takes a card until his score is 17 or greater.
        while (getHouseScore() < 17)
        {
            houseHit(true);
        }

        isGameOver = true; // The game is now over.
    }

    public void stand()
    {
        if (!isGameOver) housePlay();
    }

    private static int getScore(ArrayList<Card> hand)
    {
        // TODO: Compute the total score of the cards in the given hand.
        //   A card that is face down does not add to the score.
        //   A face card (Jack, Queen, or King) is worth 10 points.
        //   A numeric card (2 through 10) is worth the card's rank value.
        //   The rank value of a Card c is c.getRank().getValue()
        //   An Ace is worth either 11 points or 1 point. It is worth 11 points
        //   if this does not make the total score (the sum of the scores of
        //   the rest of the cards) go over TARGET_SCORE, otherwise it is
        //   worth 1 point.
        //   The returned score is the sum of the scores of all the cards
        //   in the ArrayList hand.
        //   Do NOT use the magic number 21 in your code. Instead,
        //   use the class constant TARGET_SCORE.
        return TARGET_SCORE; // Temporary return value. Replace this line.
    }

    public int getHouseScore()
    {
        return getScore(houseCards);
    }

    public int getPlayerScore()
    {
        return getScore(playerCards);
    }

    // Returns false if the player loses or the game is not over
    // otherwise return true.
    public boolean playerWins()
    {
        int houseScore = getHouseScore();
        int playerScore = getPlayerScore();

        return isGameOver && playerScore <= TARGET_SCORE &&
                (playerScore > houseScore || houseScore > TARGET_SCORE);
    }
}