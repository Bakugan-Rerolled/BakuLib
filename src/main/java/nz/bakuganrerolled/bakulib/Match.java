package nz.bakuganrerolled.bakulib;

import java.util.List;

/**
 * Represents a Match of Bakugan.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
public class Match {
    private final Field field;
    private final List<Team> teams;

    public Match(List<Team> teams, Field field) {
        this.field = field;
        this.teams = teams;
    }

    /**
     * Gets the field.
     *
     * @return The field.
     */
    public Field getField() {
        return field;
    }

    /**
     * Gets the teams in a match.
     *
     * @return The teams in the match.
     */
    public List<Team> getTeams() {
        return teams;
    }
}