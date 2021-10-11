package nz.bakuganrerolled.bakulib;

import java.awt.Point;
import java.util.Map;

/**
 * Represents a field on which Gate Cards are set.
 *
 * @author Matt Eden
 * @version 0.2.0
 * @since 0.1
 */
public interface Field {

    default void setGateCard(GateCard gc) {
        throw new UnsupportedOperationException();
    }

    default void setGateCard(Point point, GateCard gc) {
        throw new UnsupportedOperationException();
    }

    default GateCard getGateCard() {
        throw new UnsupportedOperationException();
    }

    default Map<Point, GateCard> getGateCards() {
        throw new UnsupportedOperationException();
    }

}
