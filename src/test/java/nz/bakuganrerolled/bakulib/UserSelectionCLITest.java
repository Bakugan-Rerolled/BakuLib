package nz.bakuganrerolled.bakulib;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(LoggingExtension.class)
class UserSelectionCLITest {

    private static List<String> strOptions;
    private static List<Bakugan> bakuOptions;

    @BeforeAll
    static void setup() {

        Bakugan baku1 = new BaseBakugan("First Bakugan", 290, Attribute.PYRUS);
        Bakugan baku2 = new BaseBakugan("Second Bakugan", 290, Attribute.SUBTERRA);
        Bakugan baku3 = new BaseBakugan("Third Bakugan", 290, Attribute.HAOS);
        Bakugan baku4 = new BaseBakugan("Fourth Bakugan", 290, Attribute.DARKUS);
        Bakugan baku5 = new BaseBakugan("Fifth Bakugan", 290, Attribute.AQUOS);
        Bakugan baku6 = new BaseBakugan("Sixth Bakugan", 290, Attribute.VENTUS);

        strOptions = new ArrayList<>() {{
            add("First Option");
            add("Second Option");
            add("Third Option");
            add("Fourth Option");
            add("Fifth Option");
        }};

        bakuOptions = new ArrayList<>() {{
            add(baku1);
            add(baku2);
            add(baku3);
            add(baku4);
            add(baku5);
            add(baku6);
        }};
    }

    @Test
    void userSelectionHasMinimum() throws Exception {
        UserSelectionCLI<String> selectionCLI = new UserSelectionCLI<>();

        withTextFromSystemIn("1", "Q", "1", "Q").execute(() -> {
            List<String> selected = selectionCLI
                    .setOptions(strOptions)
                    .setMinSelection(2)
                    .select();
            assertEquals(2, selected.size());
        });
    }

    @Test
    void userSelectionHasMaximum() throws Exception {
        UserSelectionCLI<String> selectionCLI = new UserSelectionCLI<>();

        withTextFromSystemIn("1", "1", "1", "1").execute(() -> {
            List<String> selected = selectionCLI
                    .setOptions(strOptions)
                    .setMaxSelection(3)
                    .select();
            assertEquals(3, selected.size());
        });
    }

    @Test
    void userSelectionHasShallowCopyOfOptions() throws Exception {
        UserSelectionCLI<Bakugan> selectionCLI = new UserSelectionCLI<>();

        withTextFromSystemIn("1").execute(() -> {

            List<Bakugan> selected = selectionCLI
                    .setOptions(bakuOptions)
                    .setMaxSelection(1)
                    .select();

            int originalGPower = bakuOptions.get(0).getGPower();
            int originalSize = bakuOptions.size();
            int newGPower = bakuOptions.get(0).getGPower() + 300;

            selected.get(0).changeGPower(300);

            assertNotEquals(originalGPower, bakuOptions.get(0).getGPower());
            assertEquals(newGPower, selected.get(0).getGPower());
            assertEquals(originalSize, bakuOptions.size());
        });
    }

    @Test
    void userSelectionAllowsExitEarly() throws Exception {
        UserSelectionCLI<Bakugan> selectionCLI = new UserSelectionCLI<>();

        withTextFromSystemIn("1", "1", "Q").execute(() -> {

            List<Bakugan> selected = selectionCLI
                    .setOptions(bakuOptions)
                    .setMinSelection(2)
                    .select();

            assertEquals(6, bakuOptions.size());
            assertEquals(2, selected.size());
            assertEquals(bakuOptions.subList(0, 2), selected);
        });
    }
}
