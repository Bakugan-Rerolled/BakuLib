/**
 * Represents a card, such as a Gate Card or Ability Card.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 * */
public abstract class Card extends Item {
    protected Effect effect;
    public abstract void activate(Player owner, BattleContext battleContext);
}
