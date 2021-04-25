package nz.bakuganrerolled;

public class Player {
    private final String name;
    private Deck deck;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public Deck getDeck() {
        return deck;
    }
}
