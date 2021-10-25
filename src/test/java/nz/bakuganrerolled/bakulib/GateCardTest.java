package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.item.Bakugan;
import nz.bakuganrerolled.bakulib.item.BaseBakugan;
import nz.bakuganrerolled.bakulib.item.GateCard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        GateCard pyrusBoost = new GateCard("Pyrus Boost", "Add 100G to all Pyrus Bakugan", increasePyrusGPower100);
        assertEquals("Pyrus Boost", pyrusBoost.getName());
    }

    @Test
    void gateCardHasEffect() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", "Add 100G to all Pyrus Bakugan", increasePyrusGPower100);
        assertNotNull(pyrusBoost.getEffect());
    }

    @Test
    void gateCardWasPlayed() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", "Add 100G to all Pyrus Bakugan", increasePyrusGPower100);

        assertFalse(pyrusBoost.wasPlayed());

        Bakugan warius = new BaseBakugan("Warius", 280, Attribute.PYRUS);
        Bakugan robotallion = new BaseBakugan("Robotallion", 300, Attribute.HAOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(warius);
        }}, null, null);
        Deck runoDeck = new Deck(new ArrayList<>() {{
            add(robotallion);
        }}, null, null);

        Player dan = new BasePlayer("Dan", danDeck);
        Player runo = new BasePlayer("Runo", runoDeck);

        Context context = new Context(null, pyrusBoost, new ArrayList<>() {{
            add(warius);
            add(robotallion);
        }}, new ArrayList<>() {{
            add(dan);
            add(runo);
        }});

        pyrusBoost.activate(dan, context);

        assertTrue(pyrusBoost.wasPlayed());

    }

    @Test
    void gateCardHasWorkingEffect() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", "Add 100G to all Pyrus Bakugan", increasePyrusGPower100);

        Bakugan warius = new BaseBakugan("Warius", 280, Attribute.PYRUS);
        Bakugan robotallion = new BaseBakugan("Robotallion", 300, Attribute.HAOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(warius);
        }}, null, null);
        Deck runoDeck = new Deck(new ArrayList<>() {{
            add(robotallion);
        }}, null, null);

        Player dan = new BasePlayer("Dan", danDeck);
        Player runo = new BasePlayer("Runo", runoDeck);

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

    @Test
    void gateCardHasBakugan() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", "Add 100G to all Pyrus Bakugan", increasePyrusGPower100);

        Bakugan warius = new BaseBakugan("Warius", 280, Attribute.PYRUS);
        Bakugan robotallion = new BaseBakugan("Robotallion", 300, Attribute.HAOS);

        List<Bakugan> expectedBakugan = new ArrayList<>();

        pyrusBoost.placeBakuganOnCard(warius);
        expectedBakugan.add(warius);
        assertEquals(expectedBakugan, pyrusBoost.getBakuganOnCard());

        pyrusBoost.placeBakuganOnCard(robotallion);
        expectedBakugan.add(robotallion);
        assertEquals(expectedBakugan, pyrusBoost.getBakuganOnCard());
    }

    @Test
    void gateCardCanReset() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", "Add 100G to all Pyrus Bakugan", increasePyrusGPower100);

        Bakugan warius = new BaseBakugan("Warius", 280, Attribute.PYRUS);
        Bakugan robotallion = new BaseBakugan("Robotallion", 300, Attribute.HAOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(warius);
        }}, null, null);
        Deck runoDeck = new Deck(new ArrayList<>() {{
            add(robotallion);
        }}, null, null);

        Player dan = new BasePlayer("Dan", danDeck);
        Player runo = new BasePlayer("Runo", runoDeck);

        Context context = new Context(null, pyrusBoost, new ArrayList<>() {{
            add(warius);
            add(robotallion);
        }}, new ArrayList<>() {{
            add(dan);
            add(runo);
        }});

        pyrusBoost.activate(dan, context);

        pyrusBoost.reset();

        assertFalse(pyrusBoost.wasPlayed());
    }
}
