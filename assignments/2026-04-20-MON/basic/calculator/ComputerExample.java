package basic.calculator;

public class ComputerExample {
    public static void main() {
        Calculator cal = new Calculator();
        Computer com = new Computer();

        System.out.println("=========================================");
        System.out.println("Calculator 클래스의 areaCircle() 계산 값: " + cal.areaCircle(3));
        System.out.println("=========================================");
        System.out.println("Computer 클래스의 areaCircle() 계산 값: " + com.areaCircle(3));
    }
}
