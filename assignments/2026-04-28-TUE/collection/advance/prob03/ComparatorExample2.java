package day0428.collection.advance.prob03;

import day0428.collection.advance.prob02.Fruit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample2 {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();

        fruitList.add(new Fruit("포도", 3000));
        fruitList.add(new Fruit("수박", 10000));
        fruitList.add(new Fruit("딸기", 6000));

        fruitList.sort(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        });

        for (Fruit fruit : fruitList) {
            System.out.println(fruit.getName() + " : " + fruit.getPrice() + "원");
        }
    }
}
