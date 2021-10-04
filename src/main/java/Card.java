public abstract class Card extends Item {
    protected Effect effect;
    public abstract void activate(Player owner, BattleContext battleContext);
}
