package day0430.todo;


import day0430.todo.common.Product;

import java.util.List;

public class Ex05_FilteringTodo {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, "키보드", "PC", 45000, 12),
                new Product(2, "마우스", "PC", 25000, 0),
                new Product(3, "텀블러", "LIFE", 18000, 30),
                new Product(4, "키보드", "PC", 45000, 12)
        );
        // TODO 1: 재고가 1개 이상인 상품만 출력하세요.
        products.stream()
                .filter(product -> product.getStock() >= 1)
                .forEach(System.out::println);

        System.out.println("\n");

        // TODO 2: 카테고리가 PC인 상품만 출력하세요.
        products.stream()
                .filter(product -> product.getCategory().equals("PC"))
                .forEach(System.out::println);

        System.out.println("\n");

        // TODO 3: 상품명만 추출한 뒤 distinct()로 중복 이름을 제거해 출력하세요.
        products.stream()
                .map(Product::getName)
                .distinct()
                .forEach(System.out::println);
    }
}
