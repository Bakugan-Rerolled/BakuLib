package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
class TeamTest {
    @Test
    void teamHasPlayers() throws PlayerNotInTeamException {

        Player dan = new BasePlayer("Dan", null);
        Player shuji = new BasePlayer("Shuji", null);

        Team team = new Team(TeamColour.RED, dan, shuji);

        assertEquals(new ArrayList<>() {{
            add(dan);
            add(shuji);
        }}, team.getPlayers());
    }

    @Test
    void teamHasColour() throws PlayerNotInTeamException {

        Player dan = new BasePlayer("Dan", null);

        Team team = new Team(TeamColour.GREEN, dan);

        assertEquals(TeamColour.GREEN, team.getColour());

    }
}
