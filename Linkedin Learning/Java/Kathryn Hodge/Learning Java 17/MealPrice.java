import java.util.Scanner;

public class MealPrice {

    static double total = 0;
    static double split = 1;

    public static double calculateTotal(double listedPrice, double tipRate, double taxRate) {

        double tip = tipRate * listedPrice;
        double tax = taxRate * listedPrice;
        double totalPrice = tip + tax + listedPrice; /* can be condensed into the return
                                                       statement, but I find this method more readable*/

        return totalPrice;

    } // end method

    public static void getRates() {

        // get base price
        System.out.println("What is the listed price of the item?");
        Scanner input = new Scanner(System.in);
        double listedPrice = input.nextDouble();

        // get tip rate
        System.out.println("What percent would you like to tip (in decimal)?");
        input = new Scanner(System.in);
        double tipRate = input.nextDouble();

        // get tax rate
        System.out.println("Finally, what is the tax rate (in decimal)?");
        input = new Scanner(System.in);
        double taxRate = input.nextDouble();

        // get split
        System.out.println("How many people are splitting the bill?");
        input = new Scanner(System.in);
        int people = input.nextInt();

        // Calculate totals
        total = Math.ceil((calculateTotal(listedPrice, tipRate, taxRate)) * 100) / 100; /* * 100 / 100 increases
                                                                                             math.ceil accuracy */
        if (people >= 2) { // on split - invalid numeric inputs are safely unused
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
