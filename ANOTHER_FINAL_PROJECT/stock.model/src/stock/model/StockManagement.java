package stock.model;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class StockManagement {
    private IRandomStockSupplier supplier;
    private List<Stock> stocks;

    public StockManagement(IRandomStockSupplier supplier) {
        this.supplier = supplier;
        this.stocks = supplier.get();
    }

    public String showStocks() {
        if (stocks.isEmpty()) {
            return "Empty list";
        } else {
            return stocks.stream()
                    .map(Stock::toString)
                    .collect(Collectors.joining("\n\n"));
        }
    }

    public double averagePrice() {
        return stocks.stream()
                .mapToDouble(Stock::getPrice)
                .average()
                .orElse(0.0);
    }

    public void writeSerializable(File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(stocks);
        }
    }

    public List<Stock> sortStockByReorderQtyAndID() {
        return stocks.stream()
                .sorted((s1, s2) -> {
                    int compareReorderQty = Integer.compare(s2.getReorderData().reorderQty(), s1.getReorderData().reorderQty());
                    if (compareReorderQty == 0) {
                        return s1.getID().compareTo(s2.getID());
                    } else {
                        return compareReorderQty;
                    }
                })
                .collect(Collectors.toList());
    }

    public String groupByReorderQtyAndNumberSuppliers() {
        return stocks.stream()
                .collect(Collectors.groupingBy(s -> s.getReorderData().reorderQty(),
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .map(s -> s.getReorderData().suppliers().size())
                                        .max(Integer::compareTo)
                                        .orElse(0))))
                .entrySet().stream()
                .map(entry -> "ReorderQty: " + entry.getKey() + ", Max Suppliers: " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
