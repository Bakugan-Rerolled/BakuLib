package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
class MatchTest {

    private static Player shun;
    private static Player alice;

    @BeforeAll
    static void setup() {
        shun = new Player("Shun", null);
        alice = new Player("Alice", null);
    }

    @Test
    void matchHasTeams() throws PlayerNotInTeamException {
        Team team1 = new Team(TeamColour.GREEN, shun);
        Team team2 = new Team(TeamColour.BROWN, alice);

        Match match = new Match(new ArrayList<>() {{
            add(team1);
            add(team2);
        }}, null);

        assertEquals(new ArrayList<>() {{
            add(team1);
            add(team2);
        }}, match.getTeams());
    }

    @Test
    void matchHasField() throws PlayerNotInTeamException {
        TestField testField = new TestField();
        Team team = new Team(TeamColour.RED);
        Match match = new Match(new ArrayList<>() {{
            add(team);
        }}, testField);
        assertEquals(testField, match.getField());
    }

    static class TestField implements Field {

        @Override
        public void setGateCard(GateCard gc) {
        }

    }
}
