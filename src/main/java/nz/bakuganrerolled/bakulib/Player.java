package nz.bakuganrerolled.bakulib;

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
    private Team team;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.team = null;
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

    /**
     * Gets the player's team.
     *
     * @return Player's team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets the player's team.
     */
    public void setTeam(Team team) {
        this.team = team;
    }
}
