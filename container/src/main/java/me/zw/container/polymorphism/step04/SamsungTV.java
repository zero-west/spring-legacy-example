package me.zw.container.polymorphism.step04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SamsungTV implements TV {
    private final Speaker speaker;
    private int price;

    @Autowired
    public SamsungTV(@MainSpeaker Speaker speaker) {
        this.speaker = speaker;
        System.out.println("===> SamsungTV 객체 생성");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("SamsungTV 객체 초기화 작업 처리.");
    }

    @PreDestroy
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
