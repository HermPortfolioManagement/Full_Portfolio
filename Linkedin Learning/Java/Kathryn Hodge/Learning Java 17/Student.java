import java.util.Scanner;

public class Student {

//    static int age = 27;
    static double gpa = 3.72;
//    static boolean hasPerfectAttendance = false;
    static String firstName = "Thomas";
    static String lastName = "Herm";
    static String suffix = "Jr";
    static String fullName = firstName + " " + lastName + " " + suffix;
//    static char firstInitial = firstName.charAt(0);
//    static char lastInitial = lastName.charAt(0);

    public static void printMessage(String message) {

//        System.out.println(fullName);
//        System.out.println(firstName);
//        System.out.println(lastName);
//        System.out.println(suffix);
//        System.out.println(firstInitial);
//        System.out.println(lastInitial);
//        System.out.println(age);
//        System.out.println(hasPerfectAttendance);
        System.out.println(message);
    } // end method

    public static void start() { // Class entry point

        System.out.println("What is this student's GPA?\n");
        Scanner input = new Scanner(System.in);
        gpa = input.nextDouble();

        String message = fullName + " has a GPA of " + gpa;

        printMessage(message);
    } // end method

} // end class def
