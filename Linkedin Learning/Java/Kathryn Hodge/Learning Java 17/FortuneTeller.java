import java.util.Scanner;

public class FortuneTeller {

    static String fortune = "";
    static int number = 0;
    

    public static boolean checkValid(int number) {
        boolean isValid = false;
        isValid = number >= 1 && number <= 10;
        return isValid;
    } // end method

    public static void getFortune(int number) {

            if (number >= 1 && number < 5) {
                fortune = "You think too little of yourself.";

            } else if (number >= 5 && number < 8) {
                fortune = "You're building to greater things.";

            } else if (number >= 9 && number <= 10) {
                fortune = "Confidence looks good on you.";

            }  else { // on pass validation but out of range
                Handling.validationError();
            } // end if
    } // end method

    public static void start() { // Class entry point

        boolean isValid = false;
         do { // validation loop

            System.out.println("Pick a number between 1 and 10.");
            Scanner input = new Scanner(System.in);
            number = input.nextInt();

            isValid = checkValid(number);
            if (!isValid) {
                Handling.invalidInput();
            }  // end if

        } while (!isValid); // end validation loop

        getFortune(number);
        System.out.println(fortune);
    } // end method

} // end class def
