package nz.bakuganrerolled.bakulib;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DisplayCLI {

    private static final Level GAME = Level.forName("GAME", 400);
    private static final Logger LOG = LogManager.getLogger();
    private DisplayCLI() {
        throw new IllegalStateException("DisplayCLI is a utility class, and should not be instantiated");
    }

    public static void displayInfo(String msg) {
        LOG.log(GAME, "%%% {}", msg);
    }

    public static void displayDialogue(String msg) {
        LOG.log(GAME, "%!% {}", msg);
    }

    public static void displayError(String msg) {
        LOG.log(GAME, "!!! {}", msg);
    }

    public static void displayMessage(String msg) {
        LOG.log(GAME, msg);
    }

    public static void displayState(String msg) {
        LOG.log(GAME, "#!# {}", msg);
    }
}
