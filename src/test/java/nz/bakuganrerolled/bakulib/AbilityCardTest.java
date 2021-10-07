package nz.bakuganrerolled.bakulib;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(LoggingExtension.class)
public class AbilityCardTest {
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

            /*
             * Note: Assumption is made that Bakugan not owned
             * by the activator of the card are opponent's Bakugan.
             * TODO: Refactor to determine ally status using 'Team' instead of 'Player'
             * */

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
    public void abilityCardHasName() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", transferGPowerPyrus);
        assertEquals(powerTransfer.getName(), "Power Transfer");
    }

    @Test
    public void abilityCardHasEffect() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", transferGPowerPyrus);
        assertNotNull(powerTransfer.getEffect());
    }

    @Test
    public void abilityCardHasQuery() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", transferGPowerPyrus, isPyrus);
        assertNotNull(powerTransfer.getQuery());
    }


    @Test
    public void abilityCardWithoutQueryHasWorkingEffect() throws Exception {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", transferGPowerPyrus);

        Bakugan tuskor = new Bakugan("Tuskor", 250, Attribute.PYRUS);
        Bakugan limulus = new Bakugan("Limulus", 260, Attribute.AQUOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(tuskor);
        }}, null, null);
        Deck maruchoDeck = new Deck(new ArrayList<>() {{
            add(limulus);
        }}, null, null);

        Player dan = new Player("Dan", danDeck);
        Player marucho = new Player("Marucho", maruchoDeck);

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
    public void abilityCardWithQueryHasWorkingEffect() throws Exception {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", transferGPowerPyrus, isPyrus);

        Bakugan tuskor = new Bakugan("Tuskor", 250, Attribute.PYRUS);
        Bakugan limulus = new Bakugan("Limulus", 260, Attribute.AQUOS);

        Deck danDeck = new Deck(new ArrayList<>() {{
            add(tuskor);
        }}, null, null);
        Deck maruchoDeck = new Deck(new ArrayList<>() {{
            add(limulus);
        }}, null, null);

        Player dan = new Player("Dan", danDeck);
        Player marucho = new Player("Marucho", maruchoDeck);

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

}
