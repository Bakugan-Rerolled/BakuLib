package nz.bakuganrerolled.bakulib.item;

import nz.bakuganrerolled.bakulib.Context;
import nz.bakuganrerolled.bakulib.Effect;
import nz.bakuganrerolled.bakulib.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Gate Card.
 *
 * @author Matt Eden
 * @version 0.2.0
 * @since 0.1
 */
public class GateCard extends Card {

    private final List<Bakugan> bakuganOnCard;

    public GateCard(String name, String description, Effect effect) {
        super(description, effect);
        this.name = name;
        this.bakuganOnCard = new ArrayList<>();
    }

    @Override
    public void activate(Player owner, Context context) {
        effect.activate(owner, context);
    }

    /**
     * Get all Bakugan on the Gate Card
     *
     * @return List of Bakugan on Card
     */
    public List<Bakugan> getBakuganOnCard() {
        return bakuganOnCard;
    }

    /**
     * Places a Bakugan on the Gate Card
     */
    public void placeBakuganOnCard(Bakugan b) {
        bakuganOnCard.add(b);
    }
}
