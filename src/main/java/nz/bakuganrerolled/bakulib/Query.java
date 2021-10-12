package nz.bakuganrerolled.bakulib;

/**
 * Represents a query, which is a requirement to activate an Effect.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public interface Query {
    boolean check(Player owner, Context context);
}
