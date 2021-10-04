public class AbilityCard extends Card {
    private final Query query;

    public AbilityCard(String name, Effect effect) {
        this.name = name;
        this.effect = effect;
        this.query = (((owner, battleContext) -> true));
    }

    public AbilityCard(String name, Effect effect, Query query) {
        this.name = name;
        this.effect = effect;
        this.query = query;
    }

    @Override
    public void activate(Player owner, BattleContext battleContext) {
        if (query.check(owner, battleContext)) {
            effect.activate(owner, battleContext);
        }
    }
}
