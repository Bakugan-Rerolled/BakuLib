package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
class PlayerTest {

    private static Deck testDeck;

    @BeforeAll
    static void setup() {
        Bakugan tuskor = new BaseBakugan("Tuskor", 250, Attribute.PYRUS);

        Effect blankEffect = (((owner, battleContext) -> {
        }));

        GateCard pyrusBoost = new GateCard("Pyrus Boost", blankEffect);
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", blankEffect);

        testDeck = new Deck(
                new ArrayList<>() {{
                    add(tuskor);
                }},
                new ArrayList<>() {{
                    add(pyrusBoost);
                }},
                new ArrayList<>() {{
                    add(powerTransfer);
                }}
        );
    }

    @Test
    void playerHasName() {
        Player dan = new BasePlayer("Dan", testDeck);
        assertEquals("Dan", dan.getName());
    }

    @Test
    void playerHasDeck() {
        Player dan = new BasePlayer("Dan", testDeck);
        Deck deck = dan.getDeck();

        assertEquals("Tuskor [PYRUS] (250G)", deck.getBakugan().get(0).toString());
        assertEquals("Pyrus Boost", deck.getGateCards().get(0).toString());
        assertEquals("Power Transfer", deck.getAbilityCards().get(0).toString());
    }

    @Test
    void playerToString() throws PlayerNotInTeamException {
        Player dan = new BasePlayer("Dan", testDeck);
        assertEquals("Dan", dan.toString());

        Team team = new Team(TeamColour.RED, dan);

        assertEquals("Dan (Team RED)", dan.toString());
    }
}
