package nz.bakuganrerolled.bakulib.item;

/**
 * Represents an Item, such as a Bakugan or Card.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public abstract class Item {
    protected String name;

    /**
     * Gets the item's name.
     *
     * @return item's name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract void reset();
}
