package nz.bakuganrerolled;

public abstract class Card {

    protected final String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
