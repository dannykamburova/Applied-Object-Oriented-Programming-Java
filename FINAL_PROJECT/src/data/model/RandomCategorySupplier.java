package data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.Random;

import static data.model.CanRandomize.GENERATOR;

public interface RandomCategorySupplier extends Supplier<List<Inventory>> {
    private void updateType(Category type) {
        type.getSuppliers().clear();
        int numberOfSuppliers = GENERATOR.RAND.nextInt(5);
        List<String> newSuppliers = new ArrayList<>();
        for (int i = 1; i <= numberOfSuppliers; i++) {
            newSuppliers.add(type.name() + " Supplier No. " + i);
        }
        type.setSuppliers(newSuppliers);
        int reorderQty = GENERATOR.RAND.nextInt(1,10 * numberOfSuppliers);
        type.setReorderQty(reorderQty);
    }

    default List<Inventory> getRandomData(int howMany, int a, int b) {
        List<Inventory> inventories = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            Category category = Category.values()[GENERATOR.RAND.nextInt(Category.values().length)];
            double price = a + (b - a) * GENERATOR.RAND.nextDouble();
            Inventory inventory = new Inventory(category, price);
            updateType(category);
            inventories.add(inventory);
        }
        return inventories;
    }
}