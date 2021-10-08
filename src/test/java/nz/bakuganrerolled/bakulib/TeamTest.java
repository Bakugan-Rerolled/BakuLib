package nz.bakuganrerolled.bakulib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
public class TeamTest {
    @Test
    public void teamHasPlayers() {

        Player dan = new Player("Dan", null);
        Player shuji = new Player("Shuji", null);

        Team team = new Team(new ArrayList<>() {{
            add(dan);
            add(shuji);
        }}, TeamColour.RED);

        assertEquals(new ArrayList<>() {{
            add(dan);
            add(shuji);
        }}, team.getPlayers());
    }

    @Test
    public void teamHasColour() {

        Player dan = new Player("Dan", null);

        Team team = new Team(new ArrayList<>(){{add(dan);}}, TeamColour.GREEN);

        assertEquals(TeamColour.GREEN, team.getColour());

    }
}
