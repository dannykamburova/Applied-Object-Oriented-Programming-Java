package problem3;

import java.text.NumberFormat;
import java.util.Random;

public class Probability {

    public static int drawRandomNumber(Random rand) {
        double randomNum = rand.nextDouble();

        if (randomNum < 0.2) {
            return 1;
        } else if (randomNum < 0.5) {
            return 2;
        } else {
            return 3;
        }
    }
    public static void main(String[] args) {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;

        // NumberFormat for percentages
        NumberFormat percentFormat = NumberFormat.getPercentInstance();

        Random random = new Random();

        for(int i = 0; i < 10000; i++)
        {
            int result = drawRandomNumber(random);
            if (result == 1) {
                counter1++;
            } else if (result == 2) {
                counter2++;
            } else if (result == 3) {
                counter3++;
            }
        }

        //Print results
        System.out.println("The possibilities after 10 000 runs:");
        System.out.println("P(1) = " + percentFormat.format((double) counter1 / 10000));
        System.out.println("P(2) = " + percentFormat.format((double) counter2 / 10000));
        System.out.println("P(3) = " + percentFormat.format((double) counter3 / 10000));

        // Reset counters
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;

        Random random2 = new Random();

        for(int i = 0; i < 60000; i++){
            int result2 = drawRandomNumber(random2);
            if (result2 == 1) {
                counter1++;
            } else if (result2 == 2) {
                counter2++;
            } else if (result2 == 3) {
                counter3++;
            }
        }

        //Print results
        System.out.println("The possibilities after 60 000 runs:");
        System.out.println("P(1) = " + percentFormat.format((double) counter1 / 60000));
        System.out.println("P(2) = " + percentFormat.format((double) counter2 / 60000));
        System.out.println("P(3) = " + percentFormat.format((double) counter3 / 60000));
    }
}