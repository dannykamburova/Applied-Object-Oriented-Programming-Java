package data.model;

public class Inventory {
    private final String INV_NUMBER;
    private Category category;
    private double price;
    private final String description;

    public Inventory(Category category, double price) {
        this.INV_NUMBER = "1";
        setCategory(category);
        setPrice(price);
        this.description = "Product: " + INV_NUMBER;

//        this.INV_NUMBER = INV_NUMBER;
//        setCategory(category);
//        setPrice(price);
//        this.description = description;
    }

    public String getINV_NUMBER() {
        return INV_NUMBER;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category != null) {
            this.category = category;
        } else {
            this.category = Category.A;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        } else {
            this.price = 15.00;
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "category: %s\n" +
                "price: %.2f\n" +
                "suppliers: %s\n",
                description, category, price , category.getSuppliers()) ;
    }
}
