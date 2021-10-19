package nz.bakuganrerolled.bakulib;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class which outlines how to obtain user input.
 *
 * @author Matt Eden
 * @version 0.1.3
 * @since 0.1
 */
public abstract class UserSelection<T> {
    protected List<T> options = null;
    protected String message = "";
    protected int minSelection = 0;
    protected int maxSelection = 0;
    protected boolean enableQuit = false;
    protected boolean skipListingOptions = false;
    protected boolean removeOnSelection = false;

    public UserSelection<T> setOptions(List<T> options) {
        this.options = new ArrayList<>(options);
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

    public UserSelection<T> enableQuit() {
        this.enableQuit = true;
        return this;
    }

    public UserSelection<T> skipListingOptions() {
        this.skipListingOptions = true;
        return this;
    }

    public UserSelection<T> removeOnSelection () {
        this.removeOnSelection = true;
        return this;
    }

    public abstract List<T> select();
}
