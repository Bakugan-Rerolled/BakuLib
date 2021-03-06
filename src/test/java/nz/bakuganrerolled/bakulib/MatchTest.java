package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
class MatchTest {

    private static Player shun;
    private static Player alice;

    @BeforeAll
    static void setup() {
        shun = new BasePlayer("Shun", null);
        alice = new BasePlayer("Alice", null);
    }

    @Test
    void matchHasTeams() throws PlayerNotInTeamException {
        Team team1 = new Team(TeamColour.GREEN, shun);
        Team team2 = new Team(TeamColour.BROWN, alice);

        BaseMatch match = new Match(new ArrayList<>() {{
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
        Field testField = new Field() {
        };
        Team team = new Team(TeamColour.RED);
        Match match = new Match(new ArrayList<>() {{
            add(team);
        }}, testField);
        assertEquals(testField, match.getField());
    }

    static class Match extends BaseMatch {
        public Match(List<Team> teams, Field field) {
            super(teams, field);
        }

        @Override
        public void play() {
        }
    }

}
