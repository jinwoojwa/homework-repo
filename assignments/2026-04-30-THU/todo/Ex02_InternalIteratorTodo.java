package day0430.todo;

import java.util.List;

public class Ex02_InternalIteratorTodo {
    public static void main(String[] args) {
        List<Integer> orderAmounts = List.of(12000, 35000, 8000, 64000, 17000);
        // TODO 1: stream()으로 주문 금액과 현재 스레드명을 출력하세요.
        orderAmounts.stream()
                .forEach(price -> System.out.println("스레드명: " + Thread.currentThread().getName() +
                        " 주문 금액: " + price + "원"));

        System.out.println();

        // TODO 2: parallelStream()으로 주문 금액과 현재 스레드명을 출력하세요.
        orderAmounts.parallelStream()
                .forEach(price -> System.out.println("스레드명: " + Thread.currentThread().getName() +
                        " 주문 금액: " + price + "원"));

        System.out.println();

        // TODO 3: 출력 순서가 항상 같지 않을 수 있는 이유를 주석으로 설명하세요.
        // 2번에서 parallelStream()으로 병렬 처리를 했기 때문에 단일 스레드에서 스트림을 처리하지 않고
        // 여러 쓰레드에서 작업을 처리하게 된다. 따라서, 출력 순서가 1번과 같지 않을 수 있다.
    }
}
