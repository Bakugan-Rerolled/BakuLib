package nz.bakuganrerolled.bakulib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CLI Implementation of UserSelection.
 *
 * @author Matt Eden
 * @version 0.2.0
 * @since 0.1
 */
public class UserSelectionCLI<T> extends UserSelection<T> {

    public UserSelectionCLI() {
        this.options = null;
        this.message = "";
        this.minSelection = 0;
        this.maxSelection = 0;
        this.enableQuit = false;
    }

    @Override
    public List<T> select() {

        /*
         * For when there's only one option available,
         * skip the selection logic and just return it
         * straight away
         * */
        if (this.options.size() == 1) return options;

        if (!message.isEmpty())
            System.out.println("# " + message);

        Scanner sc = new Scanner(System.in);
        List<T> selected = new ArrayList<>();
        int remaining = (this.maxSelection == 0) ? options.size() : maxSelection;
        int index;
        String selection;

        if (!enableQuit) minSelection = Math.max(minSelection, 1);

        while (remaining > 0) {
            index = 0;
            for (T option : options) {
                System.out.println(++index + ". " + option.toString());
            }
            if (enableQuit) System.out.println("(Q to quit)");

            System.out.print("Selection: ");
            selection = sc.next();

            /*
             * If user enters Q or similar for selection
             * check to ensure they have selected
             * the minimum number of targets/options
             * */
            if (selection.equalsIgnoreCase("q")) {
                if (selected.size() >= minSelection) {
                    return selected;
                } else {
                    System.out.printf("-- Must select %s more options%n", minSelection - selected.size());
                }
            } else {
                try {
                    int n = Integer.parseInt(selection);
                    selected.add(options.get(n - 1));
                    options.remove(n - 1);
                    remaining--;
                } catch (NumberFormatException e) {
                    System.out.println("-- Must input number");
                }
            }
            System.out.println(System.lineSeparator());
        }

        return selected;
    }


}
