package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;
import nz.bakuganrerolled.bakulib.item.Bakugan;
import nz.bakuganrerolled.bakulib.item.BaseBakugan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void teamHasBakugan() throws PlayerNotInTeamException {

        Bakugan griffon = new BaseBakugan("Griffon", 210, Attribute.PYRUS);

        Deck danDeck = new Deck(List.of(griffon), null, null);

        Player dan = new BasePlayer("Dan", danDeck);

        Team team = new Team(TeamColour.GREEN, dan);

        assertEquals(List.of(griffon), team.getBakugan());
    }

    @Test
    void teamToString() throws PlayerNotInTeamException {
        Player dan = new BasePlayer("Dan", null);

        Team team = new Team(TeamColour.GREEN, dan);

        assertEquals("Team GREEN", team.toString());
    }

    @Test
    void teamThrowsPlayerNotInTeamException() throws PlayerNotInTeamException {
        Player marucho = new BasePlayer("Marucho", null);
        Team team = new Team(TeamColour.BLUE, marucho);
        Player julie = new BasePlayer("Julie", null);
        assertThrows(PlayerNotInTeamException.class, () -> {
            julie.setTeam(team);
        });
    }
}
