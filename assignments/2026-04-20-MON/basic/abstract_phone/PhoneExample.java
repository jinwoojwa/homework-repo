package basic.abstract_phone;

public class PhoneExample {
    public static void main() {
        Phone phone = new SmartPhone("홍길동");

        SmartPhone smartPhone = new SmartPhone("홍길동");

        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
}
