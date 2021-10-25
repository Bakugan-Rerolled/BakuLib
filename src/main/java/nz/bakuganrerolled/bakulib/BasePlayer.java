package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;

/**
 * Represents a base implementation of a Player.
 *
 * @author Matt Eden
 * @version 0.2.0
 * @since 0.1
 */
public class BasePlayer implements Player {
    private final String name;
    private final Deck deck;
    private Team team;

    public BasePlayer(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.team = null;
    }

    /**
     * Gets the player's name.
     *
     * @return the Player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets a short version of the player's name.
     *
     * For example, instead of "Dan Kuso", return "Dan".
     *
     * @return the first word in the Player's name
     * */
    public String getShortName() {
        return name.split(" ")[0];
    }

    /**
     * Gets the player's deck.
     *
     * @return the Player's deck.
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Gets the player's team.
     *
     * @return the Player's team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets the player's team.
     *
     * @throws PlayerNotInTeamException if a Team tries to assert ownership over a Player it does not have
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

    /**
     * Resets the Player's health and Deck.
     * */
    public void reset() {
        deck.reset();
    }
}
