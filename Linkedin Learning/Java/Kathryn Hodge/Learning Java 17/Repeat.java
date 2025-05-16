import java.util.Scanner;

public class Repeat {

    static boolean isValid = false;
    static boolean isOnRepeat = true;

    static public boolean checkValid(String input) {

        isValid = "yes".equals(input) || "no".equals(input);
        return isValid;

    }  // end method

    public static boolean checkRepeat(String input) {

        if ("yes".equals(input) || "no".equals(input)) { // on valid input
            isOnRepeat = "yes".equals(input);
        } else { // on passed validation with invalid input
            Handling.validationError();
            isValid = false;
            isOnRepeat = true;
        } // end if
            return isOnRepeat;

    } // end method

    public static void start() { // class entry point

        while (isOnRepeat) { // decision loop

            while (!isValid) { // validation loop

                System.out.println("Would you like to repeat?");
                Scanner input = new Scanner(System.in);
                String choice = input.next().toLowerCase();

                isValid = checkValid(choice);

                if (!isValid) { // on invalid input
                    Handling.invalidInput();
                } else { // on yes or no
                    isOnRepeat = checkRepeat(choice);
                } // end if

            } // end validation loop

            if (isOnRepeat) { // on repeat
                System.out.println("The song will now repeat");
                isValid = false;
            } // end if

        } // end decision loop

        System.out.println("The song will stop repeating. Goodbye!");

    } // end method

} // end class def
