package day0428.collection.advance.prob01;

import lombok.Getter;

@Getter
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.age, p.age);
    }
}
