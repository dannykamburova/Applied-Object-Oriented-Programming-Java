package data.model;

import java.util.Random;
public enum CanRandomize {
//    RAND;
//    public final Random GENERATOR;
//
//    CanRandomize() {
//        this.GENERATOR = new Random();
//    }

    GENERATOR(new Random());

    public final Random RAND;

    CanRandomize(Random value) {
        this.RAND = value;
    }
}