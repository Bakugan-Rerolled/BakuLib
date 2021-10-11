package nz.bakuganrerolled.bakulib;

/**
 * Represents an effect which is activated by a card.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public interface Effect {
    void activate(Player owner, Context battleContext);
}
