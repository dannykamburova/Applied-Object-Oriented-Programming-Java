package problem1;

import java.util.Scanner;

import static java.util.FormatProcessor.FMT;

public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //a)
//        System.out.println("Enter fahrenheit: ");
//        double fahrenheit = input.nextDouble();
//        double celsius = 5.0 / 9.0 * (fahrenheit - 32);

        // 1st variant
//        System.out.printf("Celsius: %.2f%n", celsius);

        // 2nd variant
//        String message = String.format("Celsius: %.2f", celsius);
//        System.out.println(message);

        // 3rd variant
//        String message = FMT."Celsius %.2f\{celsius}.";
//        System.out.println(message);

        // b)
//        System.out.println("Enter celsius: ");
//        double celsius = input.nextDouble();
//        double fahrenheit = 9.0 / 5.0 * celsius + 32;
//        String message = FMT."Fahrenheit %.2f\{fahrenheit}.";
//        System.out.println(message);

        // c)
        String menu = """
                1. Fahrenheit to Celsius
                2. Celsius to Fahrenheit
                Choose an option:
                """;
        // sout + Tab
        System.out.println(menu);
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("Enter fahrenheit: ");
            double fahrenheit = input.nextDouble();
            double celsius = 5.0 / 9.0 * (fahrenheit - 32);
            String message = FMT. "Celsius %.2f\{ celsius }." ;
            System.out.println(message);

        } else if (choice == 2) {
            System.out.println("Enter celsius: ");
            double celsius = input.nextDouble();
            double fahrenheit = 9.0 / 5.0 * celsius + 32;
            String message = FMT. "Fahrenheit %.2f\{ fahrenheit }." ;
            System.out.println(message);
        } else {
            System.out.println("Incorrect option.");
        }
    }
}
