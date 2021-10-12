package nz.bakuganrerolled.bakulib;

/**
 * Represents an Effect which is activated by a Card.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public interface Effect {
    void activate(Player owner, Context context);
}
