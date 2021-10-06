package nz.bakuganrerolled.bakulib;

import java.util.List;

/**
 * Represents a Team.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
public class Team {
    List<Player> players;
    TeamColour colour;

    public Team(List<Player> players, TeamColour colour) {
        this.players = players;
        this.colour = colour;
    }

    /**
     * Get players in the team.
     *
     * @return List of Players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Get the colour of the team.
     *
     * @return Team Colour
     */
    public TeamColour getColour() {
        return colour;
    }

}
