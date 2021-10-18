package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.item.AbilityCard;
import nz.bakuganrerolled.bakulib.item.Bakugan;
import nz.bakuganrerolled.bakulib.item.GateCard;

import java.util.List;

/**
 * Represents a player's deck, which contains Bakugan, Gate Cards and Ability Cards.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public class Deck {
    private final List<Bakugan> bakugan;
    private final List<GateCard> gateCards;
    private final List<AbilityCard> abilityCards;

    public Deck(List<Bakugan> bakugan, List<GateCard> gateCards, List<AbilityCard> abilityCards) {
        this.bakugan = bakugan;
        this.gateCards = gateCards;
        this.abilityCards = abilityCards;
    }

    /**
     * Gets the Bakugan in the deck.
     *
     * @return List of Bakugan in the deck.
     */
    public List<Bakugan> getBakugan() {
        return bakugan;
    }

    /**
     * Gets the Gate Cards in the deck.
     *
     * @return List of Gate Cards in the deck.
     */
    public List<GateCard> getGateCards() {
        return gateCards;
    }

    /**
     * Gets the Ability Cards in the deck.
     *
     * @return List of Ability Cards in the deck.
     */
    public List<AbilityCard> getAbilityCards() {
        return abilityCards;
    }
}
