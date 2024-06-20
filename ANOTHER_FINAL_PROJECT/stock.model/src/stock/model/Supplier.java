package stock.model;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}
