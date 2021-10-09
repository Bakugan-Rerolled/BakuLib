package nz.bakuganrerolled.bakulib;

import java.util.List;
import java.util.stream.Collectors;

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

        for (Player player : players) player.setTeam(this);
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

    /**
     * Gets every bakugan from every player in the team
     *
     * @return List of bakugan in team
     */
    public List<Bakugan> getBakugan() {
        return players.stream().flatMap(p -> p.getDeck().getBakugan().stream()).collect(Collectors.toList());
    }

}
