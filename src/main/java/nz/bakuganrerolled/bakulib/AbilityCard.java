package nz.bakuganrerolled.bakulib;

/**
 * Represents an Ability Card.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
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

    /**
     * Gets the Ability Card's query.
     *
     * @return The ability card's query.
     */
    public Query getQuery() {
        return query;
    }

    @Override
    public void activate(Player owner, Context context) {
        if (query.check(owner, context)) {
            effect.activate(owner, context);
        }
    }
}
