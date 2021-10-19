package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;

/**
 * Represents a Player.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public interface Player {

    int MAX_HEALTH = 500;

    /**
     * Gets the player's name.
     *
     * @return the Player's name.
     */
    String getName();

    /**
     * Gets a short version of the player's name.
     *
     * For example, instead of "Dan Kuso", return "Dan".
     *
     * @return the first word in the Player's name
     * */
    String getShortName();

    /**
     * Gets the player's name.
     *
     * @return the Player's Deck.
     */
    Deck getDeck();

    /**
     * Gets the player's team.
     *
     * @return the Player's Team.
     */
    Team getTeam();

    /**
     * Sets the player's team.
     *
     * @throws PlayerNotInTeamException if a Team tries to assert ownership over a Player it does not have
     */
    void setTeam(Team team) throws PlayerNotInTeamException;

    /**
     * Gets the player's health.
     *
     * @return the Player's health.
     */
    default int getHealth() {
        return MAX_HEALTH;
    }

    /**
     * Decrease Player's health.
     * <p>
     * Should not decrease health below 0.
     */
    default void loseHealth(int health) {
        throw new UnsupportedOperationException();
    }

    /**
     * Reset Player's health to MAX_HEALTH
     */
    default void resetHealth() {
        throw new UnsupportedOperationException();
    }

}
