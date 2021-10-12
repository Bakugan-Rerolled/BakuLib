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

    /**
     * Gets the player's name.
     *
     * @return the Player's name.
     */
    String getName();

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
        return 0;
    }

}
