package basic.remotecontrol2;

public class Television implements RemoteControl {

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if (volume >= MAX_VOLUME) this.volume = MAX_VOLUME;
        else this.volume = Math.max(volume, MIN_VOLUME);

        System.out.printf("현재 TV 볼륨: %d\n", this.volume);
    }
}
