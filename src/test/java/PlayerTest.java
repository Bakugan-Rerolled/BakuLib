import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
public class PlayerTest {

    private static Deck testDeck;

    @BeforeAll
    static void setup() {
        Bakugan tuskor = new Bakugan("Tuskor", 250, Attribute.PYRUS);

        Effect blankEffect = (((owner, battleContext) -> {
        }));

        GateCard pyrusBoost = new GateCard("Pyrus Boost", blankEffect);
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", blankEffect);

        testDeck = new Deck(
                new ArrayList<>() {{
                    add(tuskor);
                }},
                new ArrayList<>() {{
                    add(pyrusBoost);
                }},
                new ArrayList<>() {{
                    add(powerTransfer);
                }}
        );
    }

    @Test
    public void playerHasName() {
        Player dan = new Player("Dan", testDeck);
        assertEquals(dan.getName(), "Dan");
    }

    @Test
    public void playerHasDeck() {
        Player dan = new Player("Dan", testDeck);
        Deck deck = dan.getDeck();

        assertEquals(deck.getBakugan().get(0).toString(), "Tuskor");
        assertEquals(deck.getGateCards().get(0).toString(), "Pyrus Boost");
        assertEquals(deck.getAbilityCards().get(0).toString(), "Power Transfer");
    }
}
