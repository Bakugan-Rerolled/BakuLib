package nz.bakuganrerolled.bakulib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(LoggingExtension.class)
class BakuganTest {

    @Test
    void bakuganHasName() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS);
        assertEquals("Tuskor", tuskor.getName());
    }

    @Test
    void bakuganHasGPower() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS);
        assertEquals(270, tuskor.getGPower());
    }

    @Test
    void bakuganHasOneAttribute() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS);
        assertEquals(EnumSet.of(Attribute.PYRUS), tuskor.getAttributes());
    }

    @Test
    void bakuganHasMultipleAttributes() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS, Attribute.SUBTERRA);
        assertEquals(EnumSet.of(Attribute.PYRUS, Attribute.SUBTERRA), tuskor.getAttributes());
    }

    @Test
    void bakuganGainsAttribute() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS);
        tuskor.addAttribute(Attribute.SUBTERRA);
        assertEquals(EnumSet.of(Attribute.PYRUS, Attribute.SUBTERRA), tuskor.getAttributes());
    }

    @Test
    void bakuganChangesAttribute() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS);
        tuskor.addAttribute(Attribute.SUBTERRA);
        tuskor.removeAttribute(Attribute.PYRUS);
        assertEquals(EnumSet.of(Attribute.SUBTERRA), tuskor.getAttributes());
    }

    @Test
    void bakuganDoesNotHaveAttribute() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS);
        assertFalse(tuskor.getAttributes().contains(Attribute.AQUOS));
    }

    @Test
    void bakuganStringRepresentation() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS);
        String expectedString = "Tuskor [PYRUS] (270G)";
        assertEquals(expectedString, tuskor.toString());
    }

    @Test
    void bakuganStringRepresentationWithMultipleAttributes() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 270, Attribute.PYRUS, Attribute.SUBTERRA);
        String expectedString = "Tuskor [PYRUS, SUBTERRA] (270G)";
        assertEquals(expectedString, tuskor.toString());
    }

}
