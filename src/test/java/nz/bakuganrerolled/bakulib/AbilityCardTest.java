package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.UnsatisfiedQueryException;
import nz.bakuganrerolled.bakulib.item.AbilityCard;
import nz.bakuganrerolled.bakulib.item.Bakugan;
import nz.bakuganrerolled.bakulib.item.BaseBakugan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(LoggingExtension.class)
class AbilityCardTest {
    private static Query isPyrus;
    private static Effect transferGPowerPyrus;

    @BeforeAll
    static void setup() {

        isPyrus = (((owner, context) -> {
            // Collect all allied bakugan into a list
            List<Bakugan> alliedBakugan = context.getBakugan().stream().filter(
                    (bakugan -> owner.getDeck().getBakugan().contains(bakugan))
            ).collect(Collectors.toList());

            // Check for presence of a Pyrus Bakugan
            for (Bakugan b : alliedBakugan) {
                if (b.getAttributes().contains(Attribute.PYRUS)) return true;
            }
            return false;
        }));

        transferGPowerPyrus = (((owner, context) -> {

            int GPOWER_TRANSFER_AMOUNT = 100;

            // Collect all allied bakugan into a list
            List<Bakugan> alliedBakugan = context.getBakugan().stream()
                    .filter(bakugan -> owner.getDeck().getBakugan().contains(bakugan))
                    .filter(bakugan -> bakugan.getAttributes().contains(Attribute.PYRUS))
                    .collect(Collectors.toList());

            // Collect all non-allied bakugan into a list
            List<Bakugan> enemyBakugan = context.getBakugan().stream().filter(
                    (bakugan -> !owner.getDeck().getBakugan().contains(bakugan))
            ).collect(Collectors.toList());

            UserSelectionCLI<Bakugan> userSelectionCLI = new UserSelectionCLI<>();

            // Query player for which Bakugan to increase GPower of
            List<Bakugan> bakuganToIncreaseGPower = userSelectionCLI
                    .setMessage("Pick a Bakugan for GPower increase")
                    .setOptions(alliedBakugan)
                    .setMaxSelection(1)
                    .select();

            // Query player for which Bakugan to decrease GPower of
            List<Bakugan> bakuganToDecreaseGPower = userSelectionCLI
                    .setMessage("Pick a Bakugan for GPower decrease")
                    .setOptions(enemyBakugan)
                    .setMaxSelection(1)
                    .select();

            // Increase/decrease GPower of respective Bakugan selected above
            bakuganToIncreaseGPower.get(0).changeGPower(GPOWER_TRANSFER_AMOUNT);
            bakuganToDecreaseGPower.get(0).changeGPower(-1 * GPOWER_TRANSFER_AMOUNT);

        }));

    }

    @Test
    void abilityCardHasName() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "Transfer 100G from one Bakugan to another", transferGPowerPyrus);
        assertEquals("Power Transfer", powerTransfer.getName());
    }

    @Test
    void abilityCardHasDescription() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "Transfer 100G from one Bakugan to another", transferGPowerPyrus);
        assertEquals("Transfer 100G from one Bakugan to another", powerTransfer.getDescription());
    }

    @Test
    void abilityCardHasEffect() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "Transfer 100G from one Bakugan to another", transferGPowerPyrus);
        assertNotNull(powerTransfer.getEffect());
    }

    @Test
    void abilityCardHasQuery() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "Transfer 100G from one Bakugan to another", transferGPowerPyrus);
        assertNotNull(powerTransfer.getQuery());
    }

    @Test
    void abilityCardWasPlayed() throws Exception {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "Transfer 100G from one Bakugan to another", transferGPowerPyrus);
        assertFalse(powerTransfer.wasPlayed());

        Bakugan tuskor = new BaseBakugan("Tuskor", 250, Attribute.PYRUS);
        Bakugan limulus = new BaseBakugan("Limulus", 260, Attribute.AQUOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(tuskor);
        }}, null, null);
        Deck maruchoDeck = new Deck(new ArrayList<>() {{
            add(limulus);
        }}, null, null);

        Player dan = new BasePlayer("Dan", danDeck);
        Player marucho = new BasePlayer("Marucho", maruchoDeck);

        Context battleContext = new Context(null, null,
                new ArrayList<>() {{
                    add(tuskor);
                    add(limulus);
                }},
                new ArrayList<>() {{
                    add(dan);
                    add(marucho);
                }});

        withTextFromSystemIn("1", "1").execute(() -> {
            powerTransfer.activate(dan, battleContext);
        });

        assertTrue(powerTransfer.wasPlayed());
    }


    @Test
    void abilityCardWithoutQueryHasWorkingEffect() throws Exception {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "Transfer 100G from one Bakugan to another", transferGPowerPyrus);

        Bakugan tuskor = new BaseBakugan("Tuskor", 250, Attribute.PYRUS);
        Bakugan limulus = new BaseBakugan("Limulus", 260, Attribute.AQUOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(tuskor);
        }}, null, null);
        Deck maruchoDeck = new Deck(new ArrayList<>() {{
            add(limulus);
        }}, null, null);

        Player dan = new BasePlayer("Dan", danDeck);
        Player marucho = new BasePlayer("Marucho", maruchoDeck);

        Context battleContext = new Context(null, null,
                new ArrayList<>() {{
                    add(tuskor);
                    add(limulus);
                }},
                new ArrayList<>() {{
                    add(dan);
                    add(marucho);
                }});

        withTextFromSystemIn("1", "1").execute(() -> {
            powerTransfer.activate(dan, battleContext);
            assertEquals(350, tuskor.getGPower());
            assertEquals(160, limulus.getGPower());
        });

    }

    @Test
    void abilityCardWithQueryHasWorkingEffect() throws Exception {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "Transfer 100G from one Bakugan to another", transferGPowerPyrus, isPyrus);

        Bakugan tuskor = new BaseBakugan("Tuskor", 250, Attribute.PYRUS);
        Bakugan limulus = new BaseBakugan("Limulus", 260, Attribute.AQUOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(tuskor);
        }}, null, null);
        Deck maruchoDeck = new Deck(new ArrayList<>() {{
            add(limulus);
        }}, null, null);

        Player dan = new BasePlayer("Dan", danDeck);
        Player marucho = new BasePlayer("Marucho", maruchoDeck);

        Context battleContext = new Context(null, null,
                new ArrayList<>() {{
                    add(tuskor);
                    add(limulus);
                }},
                new ArrayList<>() {{
                    add(dan);
                    add(marucho);
                }});

        withTextFromSystemIn("1", "1").execute(() -> {
            powerTransfer.activate(dan, battleContext);
            assertEquals(350, tuskor.getGPower());
            assertEquals(160, limulus.getGPower());
        });

    }

    @Test
    void abilityCardWithFailedQueryThrowsException() {
        AbilityCard boostedDragon = new AbilityCard("Boosted Dragon", "Permanently add 100G to Dragonoid", null, (p, context) -> false);

        Player dan = new BasePlayer("Dan", null);

        Context context = new Context(null, null, null, null);

        assertThrows(UnsatisfiedQueryException.class, () -> boostedDragon.activate(dan, context));
    }

    @Test
    void abilityCardCanReset() throws Exception {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "Transfer 100G from one Bakugan to another", transferGPowerPyrus, isPyrus);

        Bakugan tuskor = new BaseBakugan("Tuskor", 250, Attribute.PYRUS);
        Bakugan limulus = new BaseBakugan("Limulus", 260, Attribute.AQUOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(tuskor);
        }}, null, null);
        Deck maruchoDeck = new Deck(new ArrayList<>() {{
            add(limulus);
        }}, null, null);

        Player dan = new BasePlayer("Dan", danDeck);
        Player marucho = new BasePlayer("Marucho", maruchoDeck);

        Context battleContext = new Context(null, null,
                new ArrayList<>() {{
                    add(tuskor);
                    add(limulus);
                }},
                new ArrayList<>() {{
                    add(dan);
                    add(marucho);
                }});

        withTextFromSystemIn("1", "1").execute(() -> {
            powerTransfer.activate(dan, battleContext);
        });

        powerTransfer.reset();

        assertFalse(powerTransfer.wasPlayed());
    }

}
