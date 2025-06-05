import java.util.Scanner;

public class Handling {

    static int safeExit = 0;
    static int validationFailure = 1;

    public static void validationError() {

        System.out.println("Entry failed to validate. Shutting down.");
        System.exit(validationFailure);

    } // end method

    public static void invalidInput() {

        System.out.println("I'm sorry, I don't understand. please try again.");

    } // end method

    public static void exit() {
        System.out.println("Program ended successfully.");
        System.exit(safeExit);
    } // end method

    static boolean checkValid(String input) { // used in restart function

        boolean isValid = false;

        switch(input.toLowerCase()) {

            case "yes": case "no": { // valid inputs
                isValid = true;
                break;
            } // end valid inputs

            default: { // invalid inputs
                Handling.invalidInput();
                break;
            } // end invalid case

        } // end switch case statement

        return isValid;
    } // end method

    public static void restart() { // on class end

        String choice = "";
        boolean isValid = false;

        do { // start validation loop - while (!isValid);

            System.out.println("\nDo you want to go back to the main menu?");

            // get input
            Scanner input = new Scanner(System.in);
            choice = input.next();
            isValid = checkValid(choice);

        } while (!isValid); // end validation loop

        switch (choice.toLowerCase()) {

            case "yes": { // on restart
                Menu.start();
                break;
            } // end restart case

            case "no": { // on exit
                exit();
            } // end exit case

            default: { // on pass validation with improper input
                Handling.validationError();
                break;
            } // end default case

        } // end switch case statement

    } // end method

} // end class def
