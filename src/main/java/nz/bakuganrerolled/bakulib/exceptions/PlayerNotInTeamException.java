package nz.bakuganrerolled.bakulib.exceptions;

/**
 * Represents when a Team attempts privileged
 * interaction with a Player it does not contain.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 * */
public class PlayerNotInTeamException extends Exception {
    public PlayerNotInTeamException(String message) {
        super(message);
    }
}
