package day0429.lambda.prob04;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.action((x, y) -> x + y);

        // TODO: sum() 메서드 호출
        person.action(LambdaExample::sum);

        // Double 클래스의 sum() 사용
        person.action(Double::sum);
    }

    public static double sum(double x, double y) {
        return (x + y);
    }
}
