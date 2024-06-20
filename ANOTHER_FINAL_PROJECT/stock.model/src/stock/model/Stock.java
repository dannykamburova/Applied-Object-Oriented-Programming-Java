package stock.model;

public class Stock {
    private final String ID;
    private ReorderSupplier reorderData;
    private double price;
    private final String description;

    private static int count = 1;

    public Stock(ReorderSupplier reorderData, double price) {
        ID = String.valueOf(count);
        setReorderData(reorderData);
        setPrice(price);
        description = String.format("Stock ID: %s", ID);
        count++;
    }

    public String getID() {
        return ID;
    }

    public ReorderSupplier getReorderData() {
        return reorderData;
    }

    public void setReorderData(ReorderSupplier reorderData) {
        this.reorderData = reorderData;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            this.price = 100.00;
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                        "reorder quantity: %d\n" +
                        "suppliers: %s\n" +
                        "Price: %.2f",
                description, reorderData.reorderQty(), reorderData.suppliers(), price);
    }
}
