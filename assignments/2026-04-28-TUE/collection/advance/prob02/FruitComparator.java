package day0428.collection.advance.prob02;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
