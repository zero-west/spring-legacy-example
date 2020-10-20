package me.zw.container.polymorphism.step04;

import org.springframework.stereotype.Component;

@Component
public class JBLSpeaker implements Speaker {
    public JBLSpeaker() {
        System.out.println("===> JBLSpeaker 객체 생성.");
    }

    public void volumeUp() {
        System.out.println("JBLSpeaker---볼륨 올린다.");
    }

    public void volumeDown() {
        System.out.println("JBLSpeaker---볼륨 내린다.");
    }
}
