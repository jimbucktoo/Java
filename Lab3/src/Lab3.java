import java.util.Scanner;
public class Lab3 {
    public static void main(String[ ] args) {
        Scanner scnr = new Scanner(System.in);
        double radius;
        double area;
        double circum;
        char choice;

        System.out.println("Please enter a radius (feet):");
        radius = scnr.nextDouble();
        System.out.println("Enter A (Area) or C (Circumference):");
        choice = scnr.next().charAt(0);
        System.out.println(radius + " " + choice);

        area = Math.PI * (radius * radius);
        circum = Math.PI * 2 * radius;

        if (choice == 'a' || choice == 'A') {
            System.out.println("Area: " + area + " square feet");
        } else if (choice == 'c' || choice == 'C') {
            System.out.println("Circumference: " + circum + " feet");
        } else {
            System.out.println("I'm sorry, I did not understand your choice.");
        }
    }
}