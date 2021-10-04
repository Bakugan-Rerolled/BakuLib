import java.util.List;

public class Deck {
    private final List<Bakugan> bakugan;
    private final List<GateCard> gateCards;
    private final List<AbilityCard> abilityCards;

    public Deck(List<Bakugan> bakugan, List<GateCard> gateCards, List<AbilityCard> abilityCards) {
        this.bakugan = bakugan;
        this.gateCards = gateCards;
        this.abilityCards = abilityCards;
    }

    public List<Bakugan> getBakugan() {
        return bakugan;
    }

    public List<GateCard> getGateCards() {
        return gateCards;
    }

    public List<AbilityCard> getAbilityCards() {
        return abilityCards;
    }
}
