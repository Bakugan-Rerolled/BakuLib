package nz.bakuganrerolled.bakulib.item;

import nz.bakuganrerolled.bakulib.Attribute;

import java.util.Set;

/**
 * Represents a Bakugan.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public interface Bakugan {

    /**
     * Gets the Bakugan's name.
     *
     * @return Bakugan's name
     */
    String getName();

    /**
     * Gets the Bakugan's attribute(s).
     *
     * @return A set of attributes
     */
    Set<Attribute> getAttributes();

    /**
     * Adds an attribute to the Bakugan.
     */
    void addAttribute(Attribute attribute);

    /**
     * Removes an attribute from the Bakugan.
     */
    void removeAttribute(Attribute attribute);

    /**
     * Gets the Bakugan's GPower.
     *
     * @return Bakugan's GPower
     */
    int getGPower();

    /**
     * Changes the Bakugan's GPower.
     */
    void changeGPower(int gpower);

    /**
     * Reset the Bakugan back to its original state.
     */
    void reset();

    default int getStamina() {
        throw new UnsupportedOperationException();
    }

    default int getAgility() {
        throw new UnsupportedOperationException();
    }

}
