package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a Team.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public class Team {
    List<Player> players;
    TeamColour colour;

    public Team(TeamColour colour, Player... players) throws PlayerNotInTeamException {
        this.players = Arrays.asList(players);
        this.colour = colour;

        for (Player player : players) player.setTeam(this);
    }

    /**
     * Get players in the team.
     *
     * @return the List of Players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Get the colour of the team.
     *
     * @return the Team Colour
     */
    public TeamColour getColour() {
        return colour;
    }

    /**
     * Gets every bakugan from every player in the team
     *
     * @return a list of all Bakugan in the team
     */
    public List<Bakugan> getBakugan() {
        return players.stream().flatMap(p -> p.getDeck().getBakugan().stream()).collect(Collectors.toList());
    }

}
