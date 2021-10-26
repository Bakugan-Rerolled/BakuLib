package nz.bakuganrerolled.bakulib.item;

import nz.bakuganrerolled.bakulib.Attribute;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

/**
 * Represents a base implementation of a Bakugan.
 *
 * @author Matt Eden
 * @version 0.2.0
 * @since 0.1
 */
public class BaseBakugan extends Item implements Bakugan {
    private final Set<Attribute> BASE_ATTRIBUTES;
    private final int BASE_GPOWER;
    private Set<Attribute> attributes;
    private int gpower;

    public BaseBakugan(String name, int gpower, Attribute... attributes) {
        this.name = name;
        this.gpower = gpower;
        this.attributes = EnumSet.copyOf(Arrays.asList(attributes));

        BASE_ATTRIBUTES = EnumSet.copyOf(Arrays.asList(attributes));
        BASE_GPOWER = gpower;
    }

    /**
     * Gets the Bakugan's attribute(s).
     *
     * @return A set of attributes
     */
    public Set<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Adds an attribute to the Bakugan.
     */
    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    /**
     * Removes an attribute from the Bakugan.
     */
    public void removeAttribute(Attribute attribute) {
        attributes.remove(attribute);
    }

    /**
     * Gets the Bakugan's GPower.
     *
     * @return Bakugan's GPower
     */
    public int getGPower() {
        return gpower;
    }

    /**
     * Changes the Bakugan's GPower.
     */
    public void changeGPower(int gpower) {
        this.gpower += gpower;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%sG)", name, attributes.toString(), gpower);
    }

    @Override
    public void reset() {
        gpower = BASE_GPOWER;
        attributes = BASE_ATTRIBUTES;
    }
}
