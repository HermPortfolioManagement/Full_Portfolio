import java.util.Scanner;

public class Triangle {

    static int numberOfSides = 3;
    double base = 0;
    double height = 0;
    double sideALength = 0;
    double sideBLength = 0;
    double sideCLength = 0;


        // constructor
    public Triangle(double base, double height, double sideALength, double sideBLength, double sideCLength){

        this.base = base;
        this.height = height;
        this.sideALength = sideALength;
        this.sideBLength = sideBLength;
        this.sideCLength = sideCLength;

    } // end constructor

    public static boolean checkValid(double input) {

        boolean isValid = false;

        if (input > 0) { // on valid input
            isValid = true;
        } else { // on invalid input
            Handling.invalidInput();
        } // end if-else

        return isValid;

    } // end method

    public void displayValues() {
        System.out.println("This triangle's base is " + this.base + " with a height of " + this.height +
                ", with sidelengths of " + sideALength + ", " + sideBLength + ", and " + sideCLength);
    } // end method

    public void calculateArea() {

        double area = Math.ceil(((this.base * this.height) / 2) * 100) / 100; // *100 / 100 increases math.ceil accuracy
        System.out.println("The area is " + area);

    } // end method

    public void calculateTriangleType() {

        String type = "";

        if ((this.sideALength == this.sideBLength) && (this.sideALength == this.sideCLength)) { // when all equal

            type = "equilateral";

        } else if ((this.sideALength == this.sideBLength) || (this.sideALength == this.sideCLength) ||
                   (this.sideBLength == this.sideCLength)) { // when two equal sides

            type = "isosceles";

        } else { // when all sides different

            type = "scalene";

        } // end if-else

        // grammatical decisions
        if ("scalene".equals(type)) { // on "a"
            System.out.println("It is a " + type + " triangle\n");
        } else { // on "an"
            System.out.println("It is an " + type + " triangle\n");
        } // end if-else

    } // end method

    public static void getInput() {

        double baseInput = 1;
        double heightInput = 1;
        double sideALengthInput = 1;
        double sideBLengthInput = 1;
        double sideCLengthInput = 1;
        boolean isValid = false;

            // get base
        do { // start validation loop - while (!isValid);

            System.out.println("Please enter the triangle's base.");
            Scanner input = new Scanner(System.in);
            baseInput = input.nextDouble();
            isValid = checkValid(baseInput);

        } while (!isValid); // end validation loop

            // get height
        do { // start validation loop - while (!isValid);

            System.out.println("Now enter the triangle's height.");
            Scanner input = new Scanner(System.in);
            heightInput = input.nextDouble();
            isValid = checkValid(heightInput);

        } while (!isValid); // end validation loop

            // get Side A Length
        do { // start validation loop - while (!isValid);

            System.out.println("Now enter the length of the first side.");
            Scanner input = new Scanner(System.in);
            sideALengthInput = input.nextDouble();
            isValid = checkValid(sideALengthInput);

        } while (!isValid); // end validation loop

        isValid = false;

            // get Side B Length
        do { // start validation loop - while (!isValid);

            System.out.println("Now enter the length of the second side.");
            Scanner input = new Scanner(System.in);
            sideBLengthInput = input.nextDouble();
            isValid = checkValid(sideBLengthInput);

        } while (!isValid); // end validation loop

            // get side C Length
        do { // start validation loop - while (!isValid);

            System.out.println("Finally, enter the length of the third side.");
            Scanner input = new Scanner(System.in);
            sideCLengthInput = input.nextDouble();
            isValid = checkValid(sideCLengthInput);

        } while (!isValid); // end validation loop

        if ((baseInput <= 0) || (heightInput <= 0) || (sideALengthInput <= 0) || (sideBLengthInput <= 0)
                || (sideCLengthInput <= 0)) { // on pass validation with improper inputs

            Handling.validationError();

        } else { // on good validation

            // construct triangle
            Triangle triangleA = new Triangle(baseInput, heightInput, sideALengthInput, sideBLengthInput, sideCLengthInput);
            triangleA.displayValues();
            triangleA.calculateArea();
            triangleA.calculateTriangleType();

        } // end if-else

    } // end method

    public static void start() { // class entry point

        System.out.println("Welcome to triangle creation. First, we'll ask you to create a triangle; then, we'll show" +
                " a premade triangle from the computer. Both triangles should have " + Triangle.numberOfSides + " sides.\n");
        getInput();

        System.out.println("This is the premade triangle.\n");
        Triangle triangleB = new Triangle(3.7, 3.8, 5, 5, 5);
        triangleB.displayValues();
        triangleB.calculateArea();
        triangleB.calculateTriangleType();

    } // end method


} // end class def
