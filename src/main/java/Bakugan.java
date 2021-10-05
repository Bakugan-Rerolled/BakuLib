import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

/**
 * Represents a Bakugan.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 * */
public class Bakugan extends Item {
    private int gpower;
    private final Set<Attribute> attributes;

    public Bakugan(String name, int gpower, Attribute... attributes) {
        this.name = name;
        this.gpower = gpower;
        this.attributes = EnumSet.copyOf(Arrays.asList(attributes));
    }

    /**
     * Gets the Bakugan's attribute(s).
     *
     * @return A set of attributes
     * */
    public Set<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Adds an attribute to the Bakugan.
     * */
    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    /**
     * Gets the Bakugan's GPower.
     *
     * @return Bakugan's GPower
     * */
    public int getGPower() {
        return gpower;
    }

    /**
     * Changes the Bakugan's GPower.
     * */
    public void changeGPower(int gpower) {
        this.gpower += gpower;
    }

}