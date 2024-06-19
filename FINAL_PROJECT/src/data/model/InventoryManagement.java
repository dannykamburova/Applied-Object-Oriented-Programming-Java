package data.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryManagement {
    private RandomCategorySupplier supplier;
    private List<Inventory> inventories;

    public InventoryManagement() {
        this.supplier = () -> new ArrayList<>();
        this.inventories = supplier.getRandomData(10, 50, 100);
    }
    public RandomCategorySupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(RandomCategorySupplier supplier) {
        this.supplier = supplier;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public String showInventory() {
        return inventories.stream()
                .map(Inventory::toString)
                .collect(Collectors.joining("\n"));
    }

    public double averagePrice() {
        return inventories.stream()
                .mapToDouble(Inventory::getPrice)
                .average()
                .orElse(0.0);
    }

    public List<Inventory> sortInventoryTypeAndID() {
        return inventories.stream()
                .sorted(Comparator.comparing(Inventory::getCategory).reversed()
                        .thenComparing(Inventory::getINV_NUMBER))
                .collect(Collectors.toList());
    }

    public String findLargestPricePerCategory() {
        Map<Category, Double> largestPricePerCategory = inventories.stream()
                .collect(Collectors.groupingBy(Inventory::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Inventory::getPrice)),
                                maxInventory -> maxInventory.map(Inventory::getPrice).orElse(0.0)
                        )
                ));
        return largestPricePerCategory.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
