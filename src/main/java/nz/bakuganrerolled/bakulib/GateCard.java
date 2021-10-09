package nz.bakuganrerolled.bakulib;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Gate Card.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
public class GateCard extends Card {

    private final List<Bakugan> bakuganOnCard;

    public GateCard(String name, Effect effect) {
        this.name = name;
        this.effect = effect;
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
