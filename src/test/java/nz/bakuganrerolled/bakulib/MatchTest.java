package nz.bakuganrerolled.bakulib;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
public class MatchTest {

    private static Player shun;
    private static Player alice;

    class TestField implements Field {

        @Override
        public void setGateCard(GateCard gc) {
        }

    }

    @BeforeAll
    static void setup() {
        shun = new Player("Shun", null);
        alice = new Player("Alice", null);


    }

    @Test
    public void matchHasTeams() {
        Team team1 = new Team(new ArrayList<>(){{add(shun);}}, TeamColour.GREEN);
        Team team2 = new Team(new ArrayList<>(){{add(alice);}}, TeamColour.BROWN);

        Match match = new Match(new ArrayList<>(){{add(team1); add(team2); }}, null);

        assertEquals(new ArrayList<>(){{add(team1); add(team2); }}, match.getTeams());
    }

    @Test
    public void matchHasField() {
        TestField testField = new TestField();
        Match match = new Match(null, testField);
        assertEquals(testField, match.getField());
    }
}
