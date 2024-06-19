package data.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Category {
    A(1, new ArrayList<>(Collections.singletonList("Supplier 1, Supplier 2"))),
    B(2, new ArrayList<>(Collections.singletonList("Supplier 2, Supplier 3"))),
    C(3, new ArrayList<>(Collections.singletonList("Supplier 3, Supplier 4"))),
    D(4, new ArrayList<>(Collections.singletonList("Supplier 4, Supplier 5")));

    private int reorderQty;
    private List<String> suppliers;

    Category(int reorderQty, List<String> suppliers) {
        setReorderQty(reorderQty);
        setSuppliers(suppliers);
    }

    public int getReorderQty() {
        return reorderQty;
    }

    public void setReorderQty(int reorderQty) {
        if (reorderQty > 0) {
            this.reorderQty = reorderQty;
        } else {
            this.reorderQty = 1;
        }
    }

    public List<String> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<String> suppliers) {
        if (suppliers != null) {
            this.suppliers = suppliers;
        } else {
            this.suppliers = new ArrayList<>(Collections.singletonList("No suppliers"));
        }
    }
}