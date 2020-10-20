package me.zw.container.polymorphism.step04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext =
                new GenericXmlApplicationContext("step04/applicationContext.xml");

        TV tv = (TV) applicationContext.getBean(SamsungTV.class);
        tv.powerOn();
        tv.powerOff();
        tv.volumeUp();
        tv.volumeDown();

        applicationContext.close();
    }
}
