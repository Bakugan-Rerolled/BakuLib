/**
 * Represents a query, which is a requirement to activate an effect.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
public interface Query {
    boolean check(Player owner, BattleContext battleContext);
}
