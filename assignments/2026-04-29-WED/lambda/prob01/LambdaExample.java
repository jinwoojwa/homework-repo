package day0429.lambda.prob01;

public class LambdaExample {
    public static void main(String[] args) {
        // TODO: x + y
        LambdaExample.action(((x, y) -> System.out.println(x + y)));

        // TODO: x - y
        LambdaExample.action((x, y) -> System.out.println(x - y));
    }

    public static void action(Calculable calculable) {
        int x = 10;
        int y = 4;

        calculable.calculate(x, y);
    }
}
