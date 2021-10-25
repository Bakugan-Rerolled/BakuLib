package nz.bakuganrerolled.bakulib.item;

import nz.bakuganrerolled.bakulib.Context;
import nz.bakuganrerolled.bakulib.Effect;
import nz.bakuganrerolled.bakulib.Player;
import nz.bakuganrerolled.bakulib.exceptions.UnsatisfiedQueryException;

/**
 * Represents a card, such as a Gate Card or Ability Card.
 *
 * @author Matt Eden
 * @version 0.1.2
 * @since 0.1
 */
public abstract class Card extends Item {
    protected Effect effect;
    protected String description;
    protected boolean played;

    protected Card(String description, Effect effect) {
        this.description = description;
        this.effect = effect;
        this.played = false;
    }

    /**
     * Gets the Card's effect.
     *
     * @return The card's effect.
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     * Gets the Card's description.
     *
     * @return The card's description.
     * */
    public String getDescription() {
        return description;
    }

    /**
     * Gets whether the card was played.
     *
     * @return 'True' if the card was played, 'false' otherwise.
     * */
    public boolean wasPlayed() {
        return played;
    }

    /**
     * Sets the card as played.
     * */
    public void setPlayed() {
        this.played = true;
    }

    public abstract void activate(Player owner, Context context) throws UnsatisfiedQueryException;

    @Override
    public void reset() {
        played = false;
    }
}
