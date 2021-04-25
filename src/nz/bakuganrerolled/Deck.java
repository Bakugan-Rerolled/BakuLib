package nz.bakuganrerolled;

import java.util.List;

public class Deck {

    private List<Bakugan> bakugan;
    private List<GateCard> gateCards;
    private List<AbilityCard> abilityCards;

    public List<Bakugan> getBakugan() {
        return bakugan;
    }

    public void addBakugan(Bakugan b) {
        bakugan.add(b);
    }

    public List<GateCard> getGateCards() {
        return gateCards;
    }

    public void addGateCard(GateCard gc) {
        gateCards.add(gc);
    }

    public List<AbilityCard> getAbilityCards() {
        return abilityCards;
    }

    public void addAbilityCard(AbilityCard ac) {
        abilityCards.add(ac);
    }
}
