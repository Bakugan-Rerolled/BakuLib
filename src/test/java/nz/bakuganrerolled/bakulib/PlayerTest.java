package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.exceptions.PlayerNotInTeamException;
import nz.bakuganrerolled.bakulib.item.AbilityCard;
import nz.bakuganrerolled.bakulib.item.Bakugan;
import nz.bakuganrerolled.bakulib.item.BaseBakugan;
import nz.bakuganrerolled.bakulib.item.GateCard;
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

        GateCard pyrusBoost = new GateCard("Pyrus Boost", "No description", blankEffect);
        AbilityCard powerTransfer = new AbilityCard("Power Transfer", "No description", blankEffect);

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
    void playerHasShortName() {
        Player dan = new BasePlayer("Dan Kuso", testDeck);
        assertEquals("Dan", dan.getShortName());
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
