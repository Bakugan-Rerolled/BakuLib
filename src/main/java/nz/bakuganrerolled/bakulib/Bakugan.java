package nz.bakuganrerolled.bakulib;

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

    default int getStamina() {
        return 0;
    }

    default int getAgility() {
        return 0;
    }

}
