package nz.bakuganrerolled.bakulib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
class TeamTest {
    @Test
    void teamHasPlayers() {

        Player dan = new Player("Dan", null);
        Player shuji = new Player("Shuji", null);

        Team team = new Team(TeamColour.RED, dan, shuji);

        assertEquals(new ArrayList<>() {{
            add(dan);
            add(shuji);
        }}, team.getPlayers());
    }

    @Test
    void teamHasColour() {

        Player dan = new Player("Dan", null);

        Team team = new Team(TeamColour.GREEN, dan);

        assertEquals(TeamColour.GREEN, team.getColour());

    }
}
