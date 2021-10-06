package nz.bakuganrerolled.bakulib;

import nz.bakuganrerolled.bakulib.UserSelection;

import java.util.ArrayList;
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
        System.out.println("# " + message);

        Scanner sc = new Scanner(System.in);
        List<T> selected = new ArrayList<>();
        int remaining = this.maxSelection;
        int index;
        int selection;

        while (remaining > 0) {
            index = 0;
            for (T option : options) {
                System.out.println(++index + ". " + option.toString());
            }
            /*
             * if user enters Q or similar for selection
             * check maxSelection - remaining against minSelection
             * to ensure they have selected the minimum number of
             * targets/options
             * */
            System.out.print("Selection: ");
            selection = sc.nextInt();
            System.out.println(System.lineSeparator());
            selected.add(options.get(selection - 1));
            remaining--;
        }

        return selected;
    }


}
