/**
 * Represents a Player.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
public class Player {
    private final String name;
    private final Deck deck;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    /**
     * Gets the player's name.
     *
     * @return Player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's deck.
     *
     * @return Player's deck.
     */
    public Deck getDeck() {
        return deck;
    }
}
