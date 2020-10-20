package me.zw.container.polymorphism.step03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext =
                new GenericXmlApplicationContext("step03/applicationContext.xml");

        TV tv = (TV) applicationContext.getBean("samsungTV");
        tv.powerOn();
        tv.powerOff();
        tv.volumeUp();
        tv.volumeDown();

        applicationContext.close();
    }
}
