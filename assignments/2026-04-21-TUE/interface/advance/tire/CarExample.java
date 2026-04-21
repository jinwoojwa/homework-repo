package advance.tire;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();

        myCar.setTire1(new KumhoTire());
        myCar.setTire2(new KumhoTire());

        myCar.run();
    }
}
