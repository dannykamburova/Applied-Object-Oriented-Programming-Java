package problem1;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    // Constructor of a stock
    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }

    // Default constructor
    public Stock() {

    }

    // Copy constructor
    public Stock(Stock stock) {
        this.symbol = stock.symbol;
        this.name = stock.name;
        this.previousClosingPrice = stock.previousClosingPrice;
        this.currentPrice = stock.currentPrice;
    }

    // Getters
    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    // Setters

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreviousClosingPrice(double price) {
        if(previousClosingPrice >= 0) {
            this.previousClosingPrice = price;
        } else {
            this.previousClosingPrice = 1.0;
        }
    }

    public void setCurrentPrice(double price) {
        if(currentPrice >= 0) {
            this.currentPrice = price;
        } else {
            this.currentPrice = 1.0;
        }
    }

    // Function that calculates the changes of the percentage
    public double changePercent() {
        if(previousClosingPrice > 0) {
            return((currentPrice - previousClosingPrice) / previousClosingPrice) * 100.0;
        } else {
            return 0.0;
        }
    }
}
