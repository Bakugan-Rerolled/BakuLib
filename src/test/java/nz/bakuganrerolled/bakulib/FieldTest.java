package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.item.Bakugan;
import nz.bakuganrerolled.bakulib.item.GateCard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
public class FieldTest {

    private static GateCard pyrusBoost;
    private static Effect increasePyrusGPower100;

    @BeforeAll
    static void setup() {
        pyrusBoost = new GateCard("Pyrus Boost", "Add 100G to all Pyrus Bakugan", increasePyrusGPower100);
        increasePyrusGPower100 = (((owner, context) -> {
            for (Bakugan b : context.getBakugan()) {
                if (b.getAttributes().contains(Attribute.PYRUS)) {
                    b.changeGPower(100);
                }
            }
        }));
    }

    static class TestField implements Field {

        private GateCard gateCard;
        private final HashMap<Point, GateCard> gateCardMap;

        public TestField() {
            this.gateCardMap = new HashMap<>();
        }

        @Override
        public void setGateCard(Point point, GateCard gc) {
            gateCardMap.put(point, gc);
        }

        @Override
        public GateCard getGateCard() {
            return gateCard;
        }

        @Override
        public void setGateCard(GateCard gc) {
            this.gateCard = gc;
        }

        @Override
        public Map<Point, GateCard> getGateCards() {
            return gateCardMap;
        }
    }

    @Test
    void fieldHasGateCard() {
        TestField testField = new TestField();
        testField.setGateCard(pyrusBoost);
        assertEquals(pyrusBoost, testField.getGateCard());
    }

    @Test
    void fieldHasGateCardAtPoint() {
        TestField testField = new TestField();
        Point p = new Point(0,0);
        testField.setGateCard(p, pyrusBoost);

        HashMap<Point, GateCard> testMap = new HashMap<>();
        testMap.put(p, pyrusBoost);

        assertEquals(testMap.size(), testField.getGateCards().size());
        assertEquals(testMap.keySet(), testField.getGateCards().keySet());
    }
}
