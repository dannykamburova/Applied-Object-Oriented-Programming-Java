package test;

import selector.Selector;

import java.util.Random;

public class Sequence { // outer class
    // Holds a sequence of Objects.
    private Object[] obs;
    private int next = 0;
    public Sequence(int size) {
        obs = new Object[size];
    }
    public void add(Object x) {
        if(next < obs.length) {
            obs[next] = x;
            next++;
        }
    }
    private class Sselector implements Selector {
        // inner class манипулира преместване от първия към последния
        int i = 0;
        public boolean end() {
            return i == obs.length;
        }
        public Object current() {
            return obs[i];
        }
        public void next() {
            if(i < obs.length) i++;
        }
    } // end of inner class

    private class Rselector implements Selector {
        // inner class манипулира преместване от първия към последния
        int i = obs.length - 1;
        public boolean end() {
            return i == -1;
        }
        public Object current() {
            return obs[i];
        }
        public void next() {
            if(i > -1) i--;
        }
    } // end of inner class
    public Selector getSelector() {
        return new Sselector();
    }

    public Selector getRSelector() {
        return new Rselector();
    }

    public static void main(String[] args) {
// (1)създайте Sequence последователност от 8 елемента
        final int SIZE = 8;
        Sequence seq = new Sequence(SIZE);

// (2)инициализирайте Sequence елементите
// със случайни цели числа от интервала [10, 100]
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            seq.add(random.nextInt(10, 101));
        }
// (3)използвайте метода getSelector(),за да разпечатате
// тези числа на конзолата
// от първия до последния елемент на последователността
        Selector selector = seq.getSelector();
        System.out.println("First to last: ");
        while(!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }

// (4)използвайте метода getRSelector(),за да разпечатате
// на конзолата тези числа
// от последния елемент до първия на последователността
        Selector rSelector = seq.getRSelector();
        System.out.println("Last to first: ");
        while(!rSelector.end()) {
            System.out.println(rSelector.current());
            rSelector.next();
        }
    }
} // end of Sequence.java