package stock.model;

import java.util.Random;
import java.util.function.IntSupplier;

public class Wrap {

    public static final Random rand = new Random();
    public interface ICanRandomize{
        default IntSupplier randGenerator(double... args) {
            return () -> {
                if (args.length == 1) {
                    return rand.nextInt((int) args[0] + 1);
                } else if (args.length == 2) {
                    return (int) args[0] + rand.nextInt((int) (args[1] - args[0] + 1));
                } else {
                    return rand.nextInt(Integer.MAX_VALUE);
                }
            };
        }

    }
}
