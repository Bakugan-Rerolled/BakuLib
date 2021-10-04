import java.util.List;

public class BattleContext {
    private final Match match;
    private final GateCard gateCard;
    private final List<Bakugan> bakugan;
    private final List<Player> playersInBattle;

    public BattleContext(Match match, GateCard gateCard, List<Bakugan> bakugan, List<Player> playersInBattle) {
        this.match = match;
        this.gateCard = gateCard;
        this.bakugan = bakugan;
        this.playersInBattle = playersInBattle;
    }

    public Match getMatch() {
        return match;
    }

    public GateCard getGateCard() {
        return gateCard;
    }

    public List<Bakugan> getBakugan() {
        return bakugan;
    }

    public List<Player> getPlayersInBattle() {
        return playersInBattle;
    }
}
