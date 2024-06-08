package task9;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%.2f%n", recursiveSum(i));
        }
    }

    private static double recursiveSum(int i) {
        if (i <= 0) {
            return 0;
        }

        return (i / (2.0 * i + 1.0)) + recursiveSum(i - 1);
    }
}
