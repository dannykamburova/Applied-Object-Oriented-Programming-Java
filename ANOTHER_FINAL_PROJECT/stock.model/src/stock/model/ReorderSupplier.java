package stock.model;

import java.util.List;

public record ReorderSupplier(int reorderQty, List<String> suppliers) {
}
