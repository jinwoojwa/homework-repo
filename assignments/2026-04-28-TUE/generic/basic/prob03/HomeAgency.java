package day0428.generic.basic.prob03;

public class HomeAgency implements Rentable<Home> {

    @Override
    public Home rent() {
        return new Home();
    }
}
