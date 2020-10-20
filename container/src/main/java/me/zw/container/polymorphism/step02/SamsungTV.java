package me.zw.container.polymorphism.step02;

public class SamsungTV implements TV {

    private final JBLSpeaker speaker;

    public SamsungTV(JBLSpeaker speaker) {
        this.speaker = speaker;
        System.out.println("===> SamsungTV 객체 생성");
    }

    public void initMethod() {
        System.out.println("SamsungTV 객체 초기화 작업 처리.");
    }

    public void destroyMethod() {
        System.out.println("SamsungTV 객체 삭제 전 작업할 로직 처리.");
    }

    @Override
    public void powerOn() {
        System.out.println("SamsungTV---전원 켠다.");
    }

    @Override
    public void powerOff() {
        System.out.println("SamsungTV---전원 끈다.");
    }

    @Override
    public void volumeUp() {
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        speaker.volumeDown();
    }
}
