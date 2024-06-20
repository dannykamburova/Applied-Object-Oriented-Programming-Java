package stock.model;

import java.util.ArrayList;
import java.util.List;

public interface IRandomStockSupplier extends Wrap.ICanRandomize, Supplier<List<Stock>> {

    default List<Stock> loadStock(int howMany, int priceLower, int priceUpper) {
        List<Stock> stocks = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            int numSuppliers = randGenerator(4).getAsInt();
            List<String> suppliers = generateSuppliers(numSuppliers);

            int reorderQty = randGenerator(1, 6).getAsInt();

            double price = randGenerator(priceLower, priceUpper).getAsInt();

            Stock stock = new Stock(new ReorderSupplier(reorderQty, suppliers), price);
            stocks.add(stock);
        }
        return stocks;
    }

    default List<String> generateSuppliers(int numSuppliers) {
        List<String> suppliers = new ArrayList<>();
        for (int i = 1; i <= numSuppliers; i++) {
            suppliers.add("Supplier " + i);
        }
        return suppliers;
    }
}