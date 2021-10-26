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
            DisplayCLI.displayMessage(++index + ". " + option.toString());
        }
        if (enableQuit) DisplayCLI.displayMessage("(Q to quit)");
    }

    private void addSelectedOption(List<T> selected, int n) {
        selected.add(options.get(n - 1));
        if (removeOnSelection) options.remove(n - 1);
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
            DisplayCLI.displayMessage("# " + message);

        Scanner sc = new Scanner(System.in);
        List<T> selected = new ArrayList<>();
        int remaining = (this.maxSelection == 0) ? options.size() : maxSelection;
        String selection;

        if (!enableQuit) minSelection = Math.max(minSelection, 1);

        while (remaining > 0) {

            listOptions();

            DisplayCLI.displayMessage("Selection: ");
            selection = sc.next();

            /*
             * If user enters Q or similar for selection
             * check to ensure they have selected
             * the minimum number of targets/options
             * */
            try {
                if (selection.equalsIgnoreCase("q")) {
                    if (selected.size() >= minSelection) {
                        break;
                    } else {
                        DisplayCLI.displayError(String.format("Must select %s more options",
                                minSelection - selected.size()));
                    }
                } else {
                    int n = Integer.parseInt(selection);
                    addSelectedOption(selected, n);
                    remaining--;
                }
            } catch (NumberFormatException e) {
                DisplayCLI.displayError("Must input number");
            } catch (IndexOutOfBoundsException e) {
                DisplayCLI.displayError("Option specified does not exist");
            }
        }

        return selected;
    }


}
