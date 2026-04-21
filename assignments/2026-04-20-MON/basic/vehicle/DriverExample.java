package basic.vehicle;

public class DriverExample {
    public static void main() {
        Driver driver = new Driver();

        Bus bus = new Bus();
        driver.drive(bus);

        Taxi taxi = new Taxi();
        driver.drive(taxi);
    }
}
