package nz.bakuganrerolled.bakulib;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * CLI Implementation of UserSelection.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 */
public class UserSelectionCLI<T> extends UserSelection<T> {

    public UserSelectionCLI() {
        this.options = null;
        this.message = "";
        this.minSelection = 1;
        this.maxSelection = 0;
    }

    @Override
    public List<T> select() {
        if (!message.isEmpty())
            System.out.println("# " + message);

        Scanner sc = new Scanner(System.in);
        List<T> selected = new ArrayList<>();
        int remaining = (this.maxSelection == 0) ? options.size() : maxSelection;
        int index;
        String selection;

        while (remaining > 0) {
            index = 0;
            for (T option : options) {
                System.out.println(++index + ". " + option.toString());
            }

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
                }
                else {
                    System.out.printf("-- Must select %s more options%n", minSelection - selected.size());
                }
            }
            else {
                try {
                    int n = Integer.parseInt(selection);
                    selected.add(options.get(n - 1));
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
