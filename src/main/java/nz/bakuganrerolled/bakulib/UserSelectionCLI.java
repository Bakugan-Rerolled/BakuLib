package nz.bakuganrerolled.bakulib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CLI Implementation of UserSelection.
 *
 * @author Matt Eden
 * @version 0.3.0
 * @since 0.1
 */
public class UserSelectionCLI<T> extends UserSelection<T> {

    private void listOptions() {
        int index = 0;
        for (T option : options) {
            System.out.println(++index + ". " + option.toString());
        }
        if (enableQuit) System.out.println("(Q to quit)");
    }

    @Override
    public List<T> select() {

        /*
         * For when there's only one option available,
         * skip the selection logic and just return it
         * straight away
         * */
        if (skipListingOptions && this.options.size() == 1) return options;

        if (!message.isEmpty())
            System.out.println("# " + message);

        Scanner sc = new Scanner(System.in);
        List<T> selected = new ArrayList<>();
        int remaining = (this.maxSelection == 0) ? options.size() : maxSelection;
        String selection;

        if (!enableQuit) minSelection = Math.max(minSelection, 1);

        while (remaining > 0) {

            listOptions();

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
