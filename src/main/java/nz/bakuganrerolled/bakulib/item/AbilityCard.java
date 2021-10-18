package nz.bakuganrerolled.bakulib.item;

import nz.bakuganrerolled.bakulib.Context;
import nz.bakuganrerolled.bakulib.Effect;
import nz.bakuganrerolled.bakulib.Player;
import nz.bakuganrerolled.bakulib.Query;
import nz.bakuganrerolled.bakulib.exceptions.UnsatisfiedQueryException;

/**
 * Represents an Ability Card.
 *
 * @author Matt Eden
 * @version 0.2.0
 * @since 0.1
 */
public class AbilityCard extends Card {
    private final Query query;

    public AbilityCard(String name, String description, Effect effect) {
        super(description, effect);
        this.name = name;
        this.query = ((owner, context) -> true);
    }

    public AbilityCard(String name, String description, Effect effect, Query query) {
        super(description, effect);
        this.name = name;
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
    public void activate(Player owner, Context context) throws UnsatisfiedQueryException {
        if (query.check(owner, context)) {
            effect.activate(owner, context);
        } else throw new UnsatisfiedQueryException("Query required for Effect not satisfied");
    }
}
