import java.util.List;

/**
 * Represents a Match of Bakugan.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 * */
public class Match {
    private final Field field;
    private final List<Player> players;

    public Match(List<Player> players, Field field) {
        this.field = field;
        this.players = players;
    }

    /**
     * Gets the field.
     *
     * @return The field.
     * */
    public Field getField() {
        return field;
    }

    /**
     * Gets the players in a match.
     *
     * @return The players in the match.
     * */
    public List<Player> getPlayers() {
        return players;
    }
}