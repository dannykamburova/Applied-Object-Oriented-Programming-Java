package problem3;

public class Probability {
    public static void main(String[] args) {
        // Creating counter of division and all possible numbers counter
        int counter = 0;
        int allProbCounter = 0;

        // Constructing all possible 5-digit numbers according to the task
        for(int firstD = 1; firstD <= 6; firstD++) {
            for(int secondD = 4; secondD <= 8; secondD++) {
                for(int thirdD = 3; thirdD <= 7; thirdD++) {
                    for(int fourthD = 1; fourthD <= 9; fourthD++) {
                        for(int fifthD = 1; fifthD <= 8; fifthD++) {
                            // Counting every possible number
                            allProbCounter++;
                            int number = 10000 * firstD + 1000 * secondD
                                    + 100 * thirdD + 10 * fourthD + fifthD;
                            // Counting all numbers divisible by 12
                            if(number % 12 == 0) {
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        // Calculating the probability just like in statistics
        double probability = counter / (double)allProbCounter * 100;
    }
}
