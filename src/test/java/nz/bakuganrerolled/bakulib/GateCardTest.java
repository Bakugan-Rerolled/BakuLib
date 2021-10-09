package nz.bakuganrerolled.bakulib;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(LoggingExtension.class)
class GateCardTest {
    private static Effect increasePyrusGPower100;

    @BeforeAll
    static void setup() {

        increasePyrusGPower100 = (((owner, context) -> {
            for (Bakugan b : context.getBakugan()) {
                if (b.getAttributes().contains(Attribute.PYRUS)) {
                    b.changeGPower(100);
                }
            }
        }));

    }

    @Test
    void gateCardHasName() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", increasePyrusGPower100);
        assertEquals("Pyrus Boost", pyrusBoost.getName());
    }

    @Test
    void gateCardHasEffect() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", increasePyrusGPower100);
        assertNotNull(pyrusBoost.getEffect());
    }

    @Test
    void gateCardHasWorkingEffect() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", increasePyrusGPower100);

        Bakugan warius = new Bakugan("Warius", 280, Attribute.PYRUS);
        Bakugan robotallion = new Bakugan("Robotallion", 300, Attribute.HAOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(warius);
        }}, null, null);
        Deck runoDeck = new Deck(new ArrayList<>() {{
            add(robotallion);
        }}, null, null);

        Player dan = new Player("Dan", danDeck);
        Player runo = new Player("Runo", runoDeck);

        Context context = new Context(null, pyrusBoost, new ArrayList<>() {{
            add(warius);
            add(robotallion);
        }}, new ArrayList<>() {{
            add(dan);
            add(runo);
        }});

        pyrusBoost.activate(dan, context);

        assertEquals(380, warius.getGPower());

    }

}
