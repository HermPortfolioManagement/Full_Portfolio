import java.util.Scanner;

public class Menu {


    public static boolean checkValid(String input) { // used in start function

        boolean isValid = false;
        switch (input.toLowerCase()) {

            case "helloworld":
            case "hello world":
            case "1":
            case "student":
            case "2":
            case "fortuneteller":
            case "fortune teller":
            case "3":
            case "repeat":
            case "4":
            case "teatime":
            case "tea time":
            case "5":
            case "mealprice":
            case "meal price":
            case "6":
            case "triangle":
            case "7":
           // case "tester": // test validation shutdown
            { // could possibly be condensed with list + for loop

                isValid = true;
                break;

            } // end case valid entries

            default: { // on invalid
                Handling.invalidInput();
                break;
            } // end default case

        } // end switch case

        return isValid;

    } // end method

    public static void start() { // class entry point -- comment added on github -- 5/17

        String choice = "";
        boolean isValid = false;

        while (!isValid) { // start validation loop -- comment added on github -- 5/17

            // display menu
            System.out.println("Hi, and welcome to my collection of mini programs made while following Kathryn Hodge's"
            + " \"Learning Java 17\" course! Which one would you like to access?\n");
            System.out.println("1. HelloWorld\n2. Student\n3. FortuneTeller\n4. repeat\n5. Teatime\n6. MealPrice\n7. Triangle\n");

            // get input
            Scanner input = new Scanner(System.in);
            choice = input.next();
            isValid = checkValid(choice);

        } // end validation loop

        switch (choice.toLowerCase()) {

            case "helloworld": case "hello world": case "1": { // on HelloWorld class
                HelloWorld.start();
                break;
            } // end case 1

            case "student": case "2": { // on Student class
                Student.start();
                break;
            } // end case 2

            case "fortuneteller": case "fortune teller": case "3": { // on FortuneTeller class
                FortuneTeller.start();
                break;
            } // end case 3

            case "repeat": case "4": { // on Repeat class
                Repeat.start();
                break;
            } // end case 4

            case "teatime": case "tea time": case "5": { // on Teatime class
                TeaTime.start();
                break;
            } // end case 5

            case "mealprice": case "meal price": case "6": { // on MealPrice class
                MealPrice.start();
                break;
            } // end case 6

            case "triangle": case "7": { // on Triangle class
                Triangle.start();
                break;
            } // end case 7

            default: { // on pass validation with improper input
                Handling.validationError();
                break;
            } // end default case

        } // end switch case

        Handling.restart();

    } // end method



} // end class def
