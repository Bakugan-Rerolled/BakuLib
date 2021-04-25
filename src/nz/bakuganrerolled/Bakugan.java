package nz.bakuganrerolled;

public class Bakugan {

    private final String name;
    private Attribute attribute;
    private int gpower;
    private final int baseGpower;
    private boolean alive;

    public Bakugan(String name, Attribute attribute, int gpower) {
        this.name = name;
        this.attribute = attribute;
        this.gpower = gpower;
        this.baseGpower = gpower;
        this.alive = true;
    }

    public String getName() {
        return name;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void changeAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public int getGpower() {
        return gpower;
    }

    public void resetGpower() {
        this.gpower = this.baseGpower;
    }

    public void increaseGpower(int gpower) {
        this.gpower += gpower;
    }

    public void decreaseGpower(int gpower) {
        this.gpower -= gpower;
    }

    public void die() {
        this.alive = false;
    }
}
