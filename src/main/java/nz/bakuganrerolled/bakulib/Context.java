package nz.bakuganrerolled.bakulib;

import java.util.List;

/**
 * Encapsulates several important elements of a battle.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public class Context {
    private final Match match;
    private final GateCard gateCard;
    private final List<Bakugan> bakugan;
    private final List<Player> players;

    public Context(Match match, GateCard gateCard, List<Bakugan> bakugan, List<Player> players) {
        this.match = match;
        this.gateCard = gateCard;
        this.bakugan = bakugan;
        this.players = players;
    }

    /**
     * Gets the Match the battle exists within.
     *
     * @return The Match.
     */
    public Match getMatch() {
        return match;
    }

    /**
     * Gets the Gate Card the battle takes place on.
     *
     * @return The Gate Card.
     */
    public GateCard getGateCard() {
        return gateCard;
    }

    /**
     * Gets the Bakugan in the battle.
     *
     * @return List of Bakugan in the battle.
     */
    public List<Bakugan> getBakugan() {
        return bakugan;
    }

    /**
     * Gets the Players in the battle.
     *
     * @return List of players in the battle.
     */
    public List<Player> getPlayers() {
        return players;
    }
}
