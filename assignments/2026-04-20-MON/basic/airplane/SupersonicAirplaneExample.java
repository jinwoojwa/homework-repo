package basic.airplane;

public class SupersonicAirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff(); // Airplane의 takeOff() 호출
        sa.fly(); // 기본 flyMode = NORMAL -> super.fly() 호출 == Airplane의 fly() 호출 (일반 비행)
        sa.flyMode = SupersonicAirplane.SUPERSONIC; // 모드 변환
        sa.fly(); // flyMode = SUPERSONIC -> SupersonicAirplane의 fly() 호출
        sa.flyMode = SupersonicAirplane.NORMAL; // 모드 변환
        sa.fly(); // 다시 Airplane의 fly() 호출
        sa.land(); // Airplane의 land() 호출
    }
}
