import java.util.Scanner;

public class TeaTime {

    public static void announceTeatime() {

        System.out.println("type in anything and press enter to start teatime");
        Scanner input = new Scanner(System.in);
        input.next();
        System.out.println("It's teatime!");

    } // end method

    public static void welcome() {

        System.out.println("Welcome to your new job!");
        announceTeatime();

        System.out.println("\nWrite code!\nReview Code!\nLearn stuff!\n");
        announceTeatime();
        System.out.println("\nGet promoted!");

    } // end method

    public static void start() { // class entry point
        welcome();
    } // end method - method not necessary, but used to keep .start call convention

} // end class def
