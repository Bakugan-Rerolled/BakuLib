package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;

/**
 * Represents a Player.
 *
 * @author Matt Eden
 * @version 0.1.0
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
     *
     * @throws PlayerNotInTeamException If a Team tries to assert ownership over a Player it does not have
     */
    public void setTeam(Team team) throws PlayerNotInTeamException {
        if (!team.getPlayers().contains(this))
            throw new PlayerNotInTeamException(String.format("Player %s is not in Team %s", name, team.getColour()));
        this.team = team;
    }

    @Override
    public String toString() {
        if (team != null)
            return String.format("%s (Team %s)", name, team.getColour());
        return name;
    }
}
