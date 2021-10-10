package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.UnsatisfiedQueryException;

/**
 * Represents a card, such as a Gate Card or Ability Card.
 *
 * @author Matt Eden
 * @version 0.1
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

    public abstract void activate(Player owner, Context battleContext) throws UnsatisfiedQueryException;
}
