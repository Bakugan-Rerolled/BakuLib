package nz.bakuganrerolled.bakulib;

import java.util.List;

/**
 * Utility class which outlines how to obtain user input.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
public abstract class UserSelection<T> {
    protected List<T> options;
    protected String message;
    protected int minSelection;
    protected int maxSelection;

    public UserSelection<T> setOptions(List<T> options) {
        this.options = options;
        return this;
    }

    public UserSelection<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public UserSelection<T> setMinSelection(int minSelection) {
        this.minSelection = minSelection;
        return this;
    }

    public UserSelection<T> setMaxSelection(int maxSelection) {
        this.maxSelection = maxSelection;
        return this;
    }

    public abstract List<T> select();
}
