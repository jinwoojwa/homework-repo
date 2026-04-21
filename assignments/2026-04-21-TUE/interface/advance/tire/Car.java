package advance.tire;

public class Car {

    private Tire tire1 = new HankookTire();
    private Tire tire2 = new HankookTire();

    public void run() {
        tire1.roll();
        tire2.roll();
    }

    public void setTire1(Tire tire1) {
        this.tire1 = tire1;
    }

    public void setTire2(Tire tire2) {
        this.tire2 = tire2;
    }
}
