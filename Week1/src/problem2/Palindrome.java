package problem2;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter five digit number: ");
        int number = input.nextInt();

        if (number < 0) {
            number *= -1;
        }

        if (number >= 10_000 && number <= 99_999) {
            int originalNumber = number;
            // 55555 / 10 = 5555 (remainder 5)
            // 55555 % 10 = 5
            int fifthDigit = number % 10;
            number /= 10;
            int fourthDigit = number % 10;
            number /= 10;
            int thirdDigit = number % 10;
            number /= 10;
            int secondDigit = number % 10;
            number /= 10;
            int firstDigit = number;

            String resultString;

            if (firstDigit == fifthDigit && secondDigit == fourthDigit) {
                resultString = String.format("%d is a palindrome.", originalNumber);
            } else {
                resultString = String.format("%d is not a palindrome.", originalNumber);
            }

            System.out.println(resultString);
        } else {
            System.out.println("The number is not five digits!");
        }
    }
}
