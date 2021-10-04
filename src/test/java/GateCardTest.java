import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GateCardTest {
    private static Effect increasePyrusGPower100;

    @BeforeAll
    static void setup() {

        increasePyrusGPower100 = (((owner, battleContext) -> {
            for (Bakugan b : battleContext.getBakugan()) {
                if (b.getAttributes().contains(Attribute.PYRUS)) {
                    b.changeGPower(100);
                }
            }
        }));

    }

    @Test
    public void gateCardHasName() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", increasePyrusGPower100);
        assertEquals(pyrusBoost.getName(), "Pyrus Boost");
    }

    @Test
    public void gateCardHasEffect() {
        GateCard pyrusBoost = new GateCard("Pyrus Boost", increasePyrusGPower100);
        assertNotNull(pyrusBoost.getEffect());
    }

    /*
    TODO: Implement
    @Test
    public void gateCardHasWorkingEffect() {}
     */

}
