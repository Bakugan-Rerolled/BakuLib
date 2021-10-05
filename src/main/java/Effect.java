/**
 * Represents an effect which is activated by a card.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
public interface Effect {
    void activate(Player owner, BattleContext battleContext);
}
