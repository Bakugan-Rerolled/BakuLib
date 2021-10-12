package nz.bakuganrerolled.bakulib.exceptions;

/**
 * Represents when an Effect attempts activation but
 * the prerequisite Query is not satisfied.
 *
 * @author Matt Eden
 * @version 0.1.0
 * @since 0.1
 */
public class UnsatisfiedQueryException extends Exception {
    public UnsatisfiedQueryException(String message) {
        super(message);
    }
}
