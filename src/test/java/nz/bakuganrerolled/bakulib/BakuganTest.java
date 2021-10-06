package nz.bakuganrerolled.bakulib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(LoggingExtension.class)
public class BakuganTest {

    @Test
    void bakuganHasName() {
        Bakugan tuskor = new Bakugan("Tuskor", 270, Attribute.PYRUS);
        assertEquals(tuskor.getName(), "Tuskor");
    }

    @Test
    void bakuganHasGPower() {
        Bakugan tuskor = new Bakugan("Tuskor", 270, Attribute.PYRUS);
        assertEquals(tuskor.getGPower(), 270);
    }

    @Test
    void bakuganHasOneAttribute() {
        Bakugan tuskor = new Bakugan("Tuskor", 270, Attribute.PYRUS);
        assertEquals(tuskor.getAttributes(), EnumSet.of(Attribute.PYRUS));
    }

    @Test
    void bakuganHasMultipleAttributes() {
        Bakugan tuskor = new Bakugan("Tuskor", 270, Attribute.PYRUS, Attribute.SUBTERRA);
        assertEquals(tuskor.getAttributes(), EnumSet.of(Attribute.PYRUS, Attribute.SUBTERRA));
    }

    @Test
    void bakuganDoesNotHaveAttribute() {
        Bakugan tuskor = new Bakugan("Tuskor", 270, Attribute.PYRUS);
        assertFalse(tuskor.getAttributes().contains(Attribute.AQUOS));
    }
}
