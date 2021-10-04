import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AbilityCardTest {
    private static Query isPyrus;
    private static Effect transferGPower;

    @BeforeAll
    static void setup() {

        isPyrus = (((owner, battleContext) -> {
            // Collect all allied bakugan into a list
            List<Bakugan> alliedBakugan = battleContext.getBakugan().stream().filter(
                    (bakugan -> owner.getDeck().getBakugan().contains(bakugan))
            ).collect(Collectors.toList());

            // Check for presence of a Pyrus Bakugan
            for (Bakugan b : alliedBakugan) {
                if (b.getAttributes().contains(Attribute.PYRUS)) return true;
            }
            return false;
        }));

        transferGPower = (((owner, battleContext) -> {

            int GPOWER_TRANSFER_AMOUNT = 100;

            /*
             * Note: Assumption is made that Bakugan not owned
             * by the activator of the card are opponent's Bakugan.
             * TODO: Refactor to determine ally status using 'Team' instead of 'Player'
             * */

            // Collect all allied bakugan into a list
            List<Bakugan> alliedBakugan = battleContext.getBakugan().stream()
                    .filter(bakugan -> owner.getDeck().getBakugan().contains(bakugan))
                    .filter(bakugan -> bakugan.getAttributes().contains(Attribute.PYRUS))
                    .collect(Collectors.toList());

            // Collect all non-allied bakugan into a list
            List<Bakugan> enemyBakugan = battleContext.getBakugan().stream().filter(
                    (bakugan -> !owner.getDeck().getBakugan().contains(bakugan))
            ).collect(Collectors.toList());

            UserSelectionCLI<Bakugan> userSelectionCLI = new UserSelectionCLI<>();

            // Query player for which Bakugan to increase GPower of
            /*
            TODO: Implement
            List<Bakugan> bakuganToIncreaseGPower = userSelectionCLI
                    .setMessage("Pick a Bakugan for GPower increase")
                    .setOptions(alliedBakugan)
                    .setMaxSelection(1)
                    .select();

             */

            // Query player for which Bakugan to decrease GPower of
            /*
            TODO: Implement
            List<Bakugan> bakuganToDecreaseGPower = userSelectionCLI
                    .setMessage("Pick a Bakugan for GPower decrease")
                    .setOptions(enemyBakugan)
                    .select();

             */

            // Increase/decrease GPower of respective Bakugan selected above
            // bakuganToIncreaseGPower.get(0).changeGPower(GPOWER_TRANSFER_AMOUNT);
            // bakuganToDecreaseGPower.get(0).changeGPower(-1 * GPOWER_TRANSFER_AMOUNT);

        }));

    }

    @Test
    public void abilityCardHasName() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", transferGPower);
        assertEquals(powerTransfer.getName(), "Power Transfer");
    }

    @Test
    public void abilityCardHasEffect() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", transferGPower);
        assertNotNull(powerTransfer.getEffect());
    }

    @Test
    public void abilityCardHasQuery() {
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", transferGPower, isPyrus);
        assertNotNull(powerTransfer.getQuery());
    }

    /*
    TODO: Implement
    @Test
    public void abilityCardWithoutQueryHasWorkingEffect() {}

    @Test
    public void abilityCardWithQueryHasWorkingEffect() {}
     */
}
