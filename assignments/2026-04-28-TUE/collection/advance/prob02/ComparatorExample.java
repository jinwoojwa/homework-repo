package day0428.collection.advance.prob02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();

        list.add(new Fruit("포도", 3000));
        list.add(new Fruit("수박", 10000));
        list.add(new Fruit("딸기", 6000));

        Collections.sort(list, new FruitComparator());

        for (Fruit fruit : list) {
            System.out.println(fruit.getName() + " : " + fruit.getPrice() + "원");
        }
    }
}
