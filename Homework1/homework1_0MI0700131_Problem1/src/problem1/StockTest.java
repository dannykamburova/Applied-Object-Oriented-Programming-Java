package problem1;

import java.util.Scanner;

public class StockTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Initialising the variables
        String symbol;
        String name;
        double previousClosingPrice;
        double currentPrice;

        // Entering the data
        System.out.print("Enter stock symbol: ");
        symbol = input.next();

        System.out.print("Enter stock name: ");
        name = input.next();

        System.out.print("Enter previous closing price: ");
        previousClosingPrice = input.nextDouble();

        System.out.print("Enter current price: ");
        currentPrice = input.nextDouble();

        // Creating stocks using the three different types of constructors
        Stock s1 = new Stock(symbol, name, previousClosingPrice, currentPrice);
        Stock defaultS = new Stock();
        Stock stock = new Stock(s1);
        stock.setSymbol("Symbol");
        stock.setName("Stock name");
        stock.setPreviousClosingPrice(150.3);
        stock.setCurrentPrice(120.3);

        // Outputting the result
        System.out.println("Print using parameterized constructor");
        System.out.println("Stock symbol: " + s1.getSymbol());
        System.out.println("Stock name: " + s1.getName());
        System.out.println("Stock previous closing price: " + s1.getPreviousClosingPrice());
        System.out.println("Stock current price: " + s1.getCurrentPrice());
        System.out.println("Change of the percentage: " + s1.changePercent());

        System.out.println("Print using default constructor");
        System.out.println("Stock symbol: " + defaultS.getSymbol());
        System.out.println("Stock name: " + defaultS.getName());
        System.out.println("Stock previous closing price: " + defaultS.getPreviousClosingPrice());
        System.out.println("Stock current price: " + defaultS.getCurrentPrice());
        System.out.println("Change of the percentage: " + defaultS.changePercent());

        System.out.println("Print using copy constructor");
        System.out.println("Stock symbol: " + stock.getSymbol());
        System.out.println("Stock name: " + stock.getName());
        System.out.println("Stock previous closing price: " + stock.getPreviousClosingPrice());
        System.out.println("Stock current price: " + stock.getCurrentPrice());
        System.out.println("Change of the percentage: " + stock.changePercent());
    }
}
