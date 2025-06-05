import java.util.Scanner;

public class MealPrice {

    static double total = 0;
    static double split = 1;

    static boolean checkValid(double input) { // start validation method

        boolean isValid = false;

        if (input > 0) { // on valid numeric entry
            isValid = true;
        } else {
            Handling.invalidInput();
        }

        return isValid;

    } // end method

    static double calculateTotal(double listedPrice, double tipRate, double taxRate) {

        double tip = tipRate * listedPrice;
        double tax = taxRate * listedPrice;
        double totalPrice = tip + tax + listedPrice; /* can be condensed into the return
                                                       statement, but I find this method more readable*/

        return totalPrice;

    } // end method

    static void getRates() {

        double listedPrice = 0;
        double tipRate = 0;
        double taxRate = 0;
        boolean isValid = false;

        // get base price
        do { // start validation loop -- while (!isValid);
            System.out.println("What is the listed price of the item?");
            Scanner input = new Scanner(System.in);
            listedPrice = input.nextDouble();
            isValid = checkValid(listedPrice);
        } while (!isValid); // end validation loop

        // get tip rate
        do { // start validation loop -- while (!isValid);
            System.out.println("What percent would you like to tip (in decimal)?");
            Scanner input = new Scanner(System.in);
            tipRate = input.nextDouble();
            isValid = checkValid(tipRate);
        } while (!isValid); // end validation loop

        // get tax rate
        do { // start validation loop - while (!isValid);
            System.out.println("Finally, what is the tax rate (in decimal)?");
            Scanner input = new Scanner(System.in);
            taxRate = input.nextDouble();
            isValid = checkValid(taxRate);
        } while (!isValid); // end validation loop

        // get split -- entries under 2 are ignored
            System.out.println("How many people are splitting the bill?");
            Scanner input = new Scanner(System.in);
            int people = input.nextInt();

        // Calculate totals
        total = Math.ceil((calculateTotal(listedPrice, tipRate, taxRate)) * 100) / 100; /* * 100 / 100 increases
                                                                                             math.ceil accuracy */
        if (people >= 2) { // anything less than 2 is considered no split
            split = Math.ceil((total / people) * 100) / 100;
        } // end if

        // print bill
        System.out.print("The total is: $" + total);
        if (people > 1) { // on split
            System.out.println(", and everyone pays: $" + split + ".");
        } // end if

    } // end method

    public static void start() { // class entry point
        getRates();
    } // end method -- method not needed, but used to keep .start call convention

} // end class def
