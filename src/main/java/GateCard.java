public class GateCard extends Card {

    public GateCard(String name, Effect effect) {
        this.name = name;
        this.effect = effect;
    }

    @Override
    public void activate(Player owner, BattleContext battleContext) {
        effect.activate(owner, battleContext);
    }
}
