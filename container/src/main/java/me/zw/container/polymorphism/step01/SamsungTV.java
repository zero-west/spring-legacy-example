package me.zw.container.polymorphism.step01;

public class SamsungTV implements TV {

    private JBLSpeaker speaker;
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
        speaker = new JBLSpeaker();
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        speaker = new JBLSpeaker();
        speaker.volumeDown();
    }
}
