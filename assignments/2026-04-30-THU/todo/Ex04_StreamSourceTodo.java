package day0430.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04_StreamSourceTodo {
    public static void main(String[] args) throws Exception {
        List<String> categories = List.of("PC", "LIFE", "FOOD");
        String[] keywords = {"keyboard", "mouse", "monitor"};
        Path path = Path.of("src/day0430/student/resources/products.txt");

        // TODO 1: categories 컬렉션 스트림을 출력하세요.
        categories.stream()
                .forEach(category -> System.out.print(category + " "));

        System.out.println("\n");

        // TODO 2: keywords 배열 스트림을 출력하세요.
        Arrays.stream(keywords)
                .forEach(keyword -> System.out.print(keyword + " "));

        System.out.println("\n");

        // TODO 3: IntStream.rangeClosed(1, 7)로 1일부터 7일까지 출력하세요.
        IntStream.rangeClosed(1, 7)
                .forEach(day -> System.out.print(day + "일 "));

        System.out.println("\n");

        // TODO 4: Files.lines(path)를 try-with-resources로 열고 CSV 내용을 출력하세요.
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
