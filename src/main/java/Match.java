import java.util.List;

public class Match {
    private final Field field;
    private final List<Player> players;

    public Match(List<Player> players, Field field) {
        this.field = field;
        this.players = players;
    }

    public Field getField() {
        return field;
    }

    public List<Player> getPlayers() {
        return players;
    }
}