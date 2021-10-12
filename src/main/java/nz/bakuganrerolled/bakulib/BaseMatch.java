package nz.bakuganrerolled.bakulib;

import java.util.Collections;
import java.util.List;

/**
 * Represents a base implementation of a Match of Bakugan.
 *
 * @author Matt Eden
 * @version 0.2.0
 * @since 0.1
 */
public abstract class BaseMatch {
    private final Field field;
    private final List<Team> teams;

    protected BaseMatch(List<Team> teams, Field field) {
        this.field = field;
        this.teams = Collections.unmodifiableList(teams);
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

    /**
     * Plays the match.
     * <p>
     * Acts as an effective 'main' for BakuLib, as all
     * the core logic for an individual game between
     * two teams is contained in this method.
     *
     * <b>Must be implemented</b>
     */
    public abstract void play();

}