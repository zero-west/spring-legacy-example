package me.zw.container.polymorphism.step04;

import org.springframework.stereotype.Component;

@Component
@MainSpeaker
public class BOSESpeaker implements Speaker {

    public BOSESpeaker() {
        System.out.println("===> BOSESpeaker 객체 생성.");
    }

    @Override
    public void volumeUp() {
        System.out.println("BOSESpeaker---볼륨 올린다.");
    }

    @Override
    public void volumeDown() {
        System.out.println("BOSESpeaker---볼륨 내린다.");
    }
}
