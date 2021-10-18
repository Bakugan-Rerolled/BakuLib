package nz.bakuganrerolled.bakulib.item;

import nz.bakuganrerolled.bakulib.Context;
import nz.bakuganrerolled.bakulib.Effect;
import nz.bakuganrerolled.bakulib.Player;
import nz.bakuganrerolled.bakulib.exceptions.UnsatisfiedQueryException;

/**
 * Represents a card, such as a Gate Card or Ability Card.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public abstract class Card extends Item {
    protected Effect effect;

    /**
     * Gets the Card's effect.
     *
     * @return The card's effect.
     */
    public Effect getEffect() {
        return effect;
    }

    public abstract void activate(Player owner, Context context) throws UnsatisfiedQueryException;
}
